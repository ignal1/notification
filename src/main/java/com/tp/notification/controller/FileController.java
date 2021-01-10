package com.tp.notification.controller;

import com.tp.notification.entity.FileInf;
import com.tp.notification.entity.User;
import com.tp.notification.repository.FileInfRepository;
import com.tp.notification.repository.UserRepository;
import com.tp.notification.service.FileService;
import com.tp.notification.service.Unzipper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.*;

@Controller
@RequestMapping("/file")
public class FileController {

    @Autowired
    Unzipper unzipper;

    @Autowired
    private FileService fileService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FileInfRepository fileInfRepository;

    @GetMapping("{directory}")
    public String listUploadedFiles(@PathVariable String directory,
                                    @AuthenticationPrincipal User user,
                                    Model model) throws Exception {

        List<String[]> list = fileService.fileList(directory, fileService).orElse(Collections.emptyList());
        if(directory.equals("template") && list.size() > 0){
            list = list.subList(0, 1);
        }
        if(!directory.equals("template") && list.size() > 5){
            list = list.subList(0, 5);
        }
        model.addAttribute("list", list);
        boolean b1 = directory.equals("template");
        int n = list.size();
        boolean b2 = (!directory.equals("template") && (list.size() > 5));
        if((directory.equals("template") && (list.size() > 0)) ||
                (!directory.equals("template") && (list.size() > 4))) {
            model.addAttribute("disabled", true);
        }
        else{
            model.addAttribute("disabled", false);
        }
        return directory.equals("template") ? "editTemplate" : "fileList";
    }

    @PostMapping("uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("dir") String dir,
                             @AuthenticationPrincipal User user,
                             RedirectAttributes redirectAttributes) throws Exception {

        Path directory = fileService.setPath(dir);
        String uuidFileName =  fileService.store(file, directory, redirectAttributes);
        if(!dir.equals("template") && !dir.equals("template_old")){
            FileInf fileInf = new FileInf();
            fileInf.setRealFileName(uuidFileName);
            fileInf.setUserFileName("Τΰιλ");

            Path path = directory.resolve(uuidFileName);
            FileTime fileTime = Files.readAttributes(path.toAbsolutePath(), BasicFileAttributes.class).creationTime();
            Date date = new Date(fileTime.toMillis());

            fileInf.setDateOfUpload(date);
            fileInf.setUser(user);
            fileInfRepository.save(fileInf);
        }
        if(dir.equals("template_old")){
            return "redirect:/uploadOldTemplate";
        }
        return "redirect:/file/" + dir;
    }

    @GetMapping("/download/{directory}/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> downloadFile(@PathVariable String directory,
                                                 @PathVariable String filename) throws Exception {

        Path path = fileService.setPath(directory);
        Resource file = fileService.loadAsResource(path, filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }



    @GetMapping("/delete/{directory}/{filename:.+}")
    public String deleteFile(@PathVariable String directory,
                             @PathVariable String filename) throws Exception {
        fileService.deleteFile(directory, filename);
        return "redirect:/file/" + directory;
    }

    @GetMapping("/delete/{directory}")
    public String deleteFilesInDirectory(@PathVariable String directory) throws Exception {
        FileUtils.cleanDirectory(fileService.setPath(directory).toFile());
        if(directory.equals("template_old")){
            return "redirect:/uploadOldTemplate";
        }
        else if(directory.equals("common")){
            return "redirect:/settings";
        }
        return "redirect:/";
    }

    @GetMapping("/convert/{directory}/{filename:.+}")
    public ResponseEntity<Resource> convertFile(@PathVariable String directory,
                                                @PathVariable String filename,
                                                @AuthenticationPrincipal User user) throws Exception {
        Path unzipDirectory = fileService.setPath(directory + "/unzip");
        if(Files.exists(unzipDirectory)){
            FileUtils.cleanDirectory(unzipDirectory.toFile());
        }
        else{
            Files.createDirectories(unzipDirectory);
        }
        fileService.convertFile(unzipDirectory, filename, user != null && user.isApproved());
        Resource file = fileService.loadAsResource(unzipDirectory, "resultDocument.xml");
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }


    @PostMapping("convert/common")
    public ResponseEntity<Resource> conversionCommonLink(@RequestParam("file") MultipartFile file,
                                                                           @AuthenticationPrincipal User user,
                                                                           RedirectAttributes redirectAttributes) throws Exception {

        String tmpDirName = UUID.randomUUID().toString();
        FileService.getTemporaryDirName().set(tmpDirName);
        Path unzipDirectory = fileService.setPath("common/" + tmpDirName + "/unzip");
        if(!Files.exists(unzipDirectory)){
            Files.createDirectories(unzipDirectory);
        }
        String fileName;
        redirectAttributes.addFlashAttribute("message", fileName = fileService.store(file, unzipDirectory.getParent(), null));
        fileService.convertFile(unzipDirectory, fileName, user != null && user.isApproved());
        Resource fileToDownload = fileService.loadAsResource(unzipDirectory, "resultDocument.xml");
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + fileToDownload.getFilename() + "\"").body(fileToDownload);
    }

    @GetMapping("editFileName/{directory}/{filename:.+}")
    public String editFileName(@PathVariable String directory, @PathVariable String filename, Model model){
        FileInf fileInf = fileInfRepository.findByRealFileName(filename);
        model.addAttribute("fileInf", fileInf);
        model.addAttribute("directory", directory);
        return "editFileName";
    }

    @PostMapping("editFileName/{directory}/{filename:.+}")
    public String editFileNamePost(FileInf newfileInf, String directory){

        FileInf oldFileInf = fileInfRepository.findById(newfileInf.getId()).get();
        oldFileInf.setUserFileName(newfileInf.getUserFileName());
        oldFileInf.setCommentary(newfileInf.getCommentary());
        fileInfRepository.save(oldFileInf);

        return "redirect:/file/" + directory;
    }

}
