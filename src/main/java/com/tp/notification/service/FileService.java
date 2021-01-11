package com.tp.notification.service;

import com.tp.notification.component._2012.Файл2012;
import com.tp.notification.component._2018.Файл2018;
import com.tp.notification.component._2019.Файл;
import com.tp.notification.controller.FileController;
import com.tp.notification.entity.FileInf;
import com.tp.notification.exception.NotificationException;
import com.tp.notification.repository.FileInfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.tp.notification.Settings;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.xml.sax.SAXException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

@Service
public class FileService {

    private final Path rootLocation;

    private static final ThreadLocal<String> temporaryDirName = new ThreadLocal<String>();

    public static ThreadLocal<String> getTemporaryDirName() {
        return temporaryDirName;
    }

    @Autowired
    public FileService() {
        this.rootLocation = Paths.get(Settings.LOCATION);
    }

    @Autowired
    Unzipper unzipper;

    @Autowired
    NotificationFactory2019 notificationFactory2019;

    @Autowired
    NotificationFactory2018 notificationFactory2018;

    @Autowired
    NotificationFactory2012 notificationFactory2012;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    FileInfRepository fileInfRepository;

    @Autowired
    Analyzer analyzer;

    private List<String[]> transactions;
    private List<String[]> partiesOrganizations;
    private List<String[]> partiesPersons;
    private List<String[]> subjects;
    private List<String> taxpayer;

    public Path setPath(String path){
        return rootLocation.resolve(path);
    }

    public String store(MultipartFile file, Path directory, RedirectAttributes redirectAttributes) throws NotificationException, IOException {
        String uuidFileName = null;
        Path destinationFile;
        if(!Files.exists(directory)){
            Files.createDirectories(directory);
        }
        String pathString = directory.toString();
        String directoryName = pathString.substring(pathString.lastIndexOf("/") + 1);
        if(directoryName.equals("template") &&
                !file.getOriginalFilename().equals("template.xlsx") && redirectAttributes != null){
            redirectAttributes.addFlashAttribute("message", "shouldHaveNameTemplate");
            return null;
        }
        else if((directoryName.equals("template") && file.getOriginalFilename().equals("template.xlsx"))
                || directoryName.equals("template_old")){
            destinationFile = directory.resolve(
                    Paths.get(file.getOriginalFilename()))
                    .normalize().toAbsolutePath();
        }
        else {
            uuidFileName = UUID.randomUUID().toString() + ".xlsx";
            destinationFile = directory.resolve(uuidFileName).normalize().toAbsolutePath();
        }
        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (Exception e) {
            throw new NotificationException("Невозможно загрузить файл.", e);
        }
        return uuidFileName;
    }

    private String convertFileTimeToDate(Path path){
        FileTime fileTime = null;
        try {
            fileTime = Files.readAttributes(path.toAbsolutePath(), BasicFileAttributes.class).creationTime();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return sdf.format(fileTime.toMillis());
    }

    private static int counter = 1;

    public Optional<List<String[]>> fileList(String directory, FileService fileService) throws IOException {

        Optional<List<String[]>> list = Optional.of(fileService.loadAll(directory).map(
                path -> {
                    String number = "" + counter++;

                    String userFileName = null;
                    String commentary = null;
                    String editFileName = null;
                    String stringDate;
                    String convert = null;
                    String download = MvcUriComponentsBuilder
                            .fromMethodName(FileController.class, "downloadFile", directory, path.getFileName().toString())
                            .build().toUri().toString();
                    stringDate = convertFileTimeToDate(path);
                    if(!directory.equals("template")){
                        userFileName = fileInfRepository.findByRealFileName(path.getFileName().toString()).getUserFileName();
                        commentary = fileInfRepository.findByRealFileName(path.getFileName().toString()).getCommentary();
                        editFileName = MvcUriComponentsBuilder
                                .fromMethodName(FileController.class, "editFileName", directory, path.getFileName().toString(), null)
                                .build().toUri().toString();
                        Date date = fileInfRepository.findByRealFileName(path.getFileName().toString()).getDateOfUpload();
                        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                        stringDate = sdf.format(date.getTime());
                        convert = MvcUriComponentsBuilder
                                .fromMethodName(FileController.class, "convertFile", directory, path.getFileName().toString(), null)
                                .build().toUri().toString();
                    }
                    String delete = MvcUriComponentsBuilder
                            .fromMethodName(FileController.class, "deleteFile", directory, path.getFileName().toString())
                            .build().toUri().toString();
                    return new String[]{number, download, userFileName, commentary, editFileName, stringDate, convert, delete};
                }).collect(Collectors.toList()));
        counter = 1;
        return list;
    }

    public Stream<Path> loadAll(String directory) throws IOException {
        Path path = rootLocation.resolve(directory);
        return Files.walk(path, 1)
                .filter(p -> !p.equals(path))
                .filter(p -> !Files.isDirectory(p));
    }

    public List<String> listOfFilesInDirectory(String directory) throws IOException {
        Path path = rootLocation.resolve(directory);
        if(Files.exists(path)){
            return Files
                    .walk(path, 1)
                    .filter(p->!Files.isDirectory(p))
                    .map(p->p.getFileName().toString())
                    .collect(Collectors.toList());
        } else{
            return Collections.emptyList();
        }
    }

    public void init() throws IOException {
        if(!Files.exists(rootLocation)){
            Files.createDirectories(rootLocation);
        }
        Path template = rootLocation.resolve("template");
        if(!Files.exists(template)){
            Files.createDirectories(template);
        }
        Path template_old = rootLocation.resolve("template_old");
        if(!Files.exists(template_old)){
            Files.createDirectories(template_old);
        }
        Path common = rootLocation.resolve("common");
        if(!Files.exists(common)){
            Files.createDirectories(common);
        }
        Path a = rootLocation.resolve("a");
        if(!Files.exists(a)){
            Files.createDirectories(a);
        }
    }

    public Resource loadAsResource(Path path, String filename) throws Exception {
        try {
            Path file = path.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new NotificationException("Невозможно загрузить файл");
            }
        }
        catch (NotificationException e) {
            throw new NotificationException("Невозможно загрузить файл");
        }
    }

    public void deleteFile(String directory, String filename) throws IOException {
        Path file = rootLocation.resolve(directory + "//" + filename);
        if(Files.exists(file)){
            Files.delete(file);
        }
        if(!directory.equals("template")){
            FileInf fileInf = fileInfRepository.findByRealFileName(filename);
            fileInfRepository.delete(fileInf);
        }
    }

    public void convertFile(Path unzipDirectory, String filename, boolean approved) throws Exception {
        Файл файл = null;
        Файл2018 файл2018 = null;
        Файл2012 файл2012 = null;
        try{
            Path file = unzipDirectory.getParent().resolve(filename);
            unzipper.unpzip(file, unzipDirectory);
            analyzer.parseSharedStrings(unzipDirectory.resolve("sharedStrings.xml"));
            taxpayer = analyzer.parseSheet1(unzipDirectory.resolve("sheet1.xml"));
            if(taxpayer.get(3).equals("5.04")){
                parseSheets(unzipDirectory, approved, 4);
                notificationFactory2019.setFields();
                файл = notificationFactory2019.populateClasses();
            } else if(taxpayer.get(3).equals("5.03")){
                parseSheets(unzipDirectory, approved, 3);
                notificationFactory2018.setFields();
                файл2018 = notificationFactory2018.populateClasses();
            } else{
                parseSheets(unzipDirectory, approved, 1);
                notificationFactory2012.setFields();
                файл2012 = notificationFactory2012.populateClasses();
            }
        } catch (Exception e){
            throw new NotificationException("Ошибка шаблона. Проверьте заполнение шаблона. Если эта ошибка будет возникать в дальнейшем, свяжитесь с администратором.");
        }
        JAXBContext context = null;
        if(taxpayer.get(3).equals("5.04")){
            context = JAXBContext.newInstance(Файл.class);
        } else if(taxpayer.get(3).equals("5.03")){
            context = JAXBContext.newInstance(Файл2018.class);
        } else{
            context = JAXBContext.newInstance(Файл2012.class);
        }
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "windows-1251");
        if(taxpayer.get(3).equals("5.04")){
            marshaller.marshal(файл, unzipDirectory.resolve("resultDocument.xml").toFile());
        } else if(taxpayer.get(3).equals("5.03")){
            marshaller.marshal(файл2018, unzipDirectory.resolve("resultDocument.xml").toFile());
        } else{
            marshaller.marshal(файл2012, unzipDirectory.resolve("resultDocument.xml").toFile());
        }
    }

    private void parseSheets(Path path, boolean approved, int version) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        int transactionsLengthOfArray;
        int partiesOrganizationsLengthOfArray;
        int partiesPersonsNumOfRowsToSkip;
        int partiesPersonsLengthOfArray;
        if(version == 4){
            transactionsLengthOfArray = 39;
            partiesOrganizationsLengthOfArray = 12;
            partiesPersonsNumOfRowsToSkip = 5;
            partiesPersonsLengthOfArray = 18;
        } else if(version == 3){
            transactionsLengthOfArray = 41;
            partiesOrganizationsLengthOfArray = 12;
            partiesPersonsNumOfRowsToSkip = 5;
            partiesPersonsLengthOfArray = 18;
        } else{
            transactionsLengthOfArray = 35;
            partiesOrganizationsLengthOfArray = 10;
            partiesPersonsNumOfRowsToSkip = 6;
            partiesPersonsLengthOfArray = 27;
        }
        transactions = analyzer.parseSheet2to5(path.resolve("sheet2.xml"), 4, transactionsLengthOfArray, approved);
        partiesOrganizations = analyzer.parseSheet2to5(path.resolve("sheet4.xml"), 3, partiesOrganizationsLengthOfArray, approved);
        partiesPersons = analyzer.parseSheet2to5(path.resolve("sheet5.xml"), partiesPersonsNumOfRowsToSkip, partiesPersonsLengthOfArray, approved);
        subjects = analyzer.parseSheet2to5(path.resolve("sheet3.xml"), 5, 24, approved);
    }
    List<String[]> getTransactions() {
        return transactions;
    }
    List<String[]> getPartiesOrganizations() {
        return partiesOrganizations;
    }
    List<String[]> getPartiesPersons() {
        return partiesPersons;
    }
    List<String[]> getSubjects() {
        return subjects;
    }
    List<String> getTaxpayer() {
        return taxpayer;
    }
}



















