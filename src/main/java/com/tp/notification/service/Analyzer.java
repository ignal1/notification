package com.tp.notification.service;

import com.tp.notification.Settings;
import org.springframework.stereotype.Service;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Analyzer {

    private String[] sharedStringsArray;
    public void parseSharedStrings(Path path) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        List<String> list = new ArrayList<>();
        Map<Document, XPath> map = initializer(path);
        XPathExpression xPathExpression = null;
        NodeList nodes = null;
        for(Map.Entry<Document, XPath> entry : map.entrySet()){
            xPathExpression = entry.getValue().compile("/sst/si/t");
            nodes = (NodeList) xPathExpression.evaluate(entry.getKey(), XPathConstants.NODESET);
        }
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                list.add(((Text) node.getFirstChild()).getData());
            }
        }
        sharedStringsArray = list.toArray(new String[0]);
    }

    public List<String> parseSheet1(Path path) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        List<String> list = new ArrayList<>();
        Map<Document, XPath> map = initializer(path);
        XPathExpression xPathExpression = null;
        NodeList nodes = null;
        for(Map.Entry<Document, XPath> entry : map.entrySet()){
            xPathExpression = entry.getValue().compile("/worksheet/sheetData/row/c[last()]");
            nodes = (NodeList) xPathExpression.evaluate(entry.getKey(), XPathConstants.NODESET);
        }
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node instanceof Element) {
                String attributeT = ((Element) node).getAttribute("t");
                NodeList childNodes = node.getChildNodes();
                if (childNodes.getLength() == 0) {
                    list.add(null);
                } else {
                    for (int j = 0; j < childNodes.getLength(); j++) {
                        Node child = childNodes.item(j);
                        if (child.getNodeName().equals("v")) {
                            if (attributeT.equals("")) {
                                list.add(((Text) child.getFirstChild()).getData());
                            } else {
                                Integer n = Integer.parseInt(((Text) child.getFirstChild()).getData());
                                String str = sharedStringsArray[n];
                                list.add(str);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }


    public List<String[]> parseSheet2to5(Path path, int numOfRowsToSkip, int lengthOfArray, boolean approved) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        List<String[]> list = new ArrayList<>();
        String[] array;
        int counter = 0;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        xmlInputFactory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE , false);
        xmlInputFactory.setProperty(XMLInputFactory.IS_VALIDATING, false);
        xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        try {
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(Files.newInputStream(path));
            while (reader.hasNext()) {
                reader.next();
                if (reader.isStartElement() && reader.getLocalName().equals("row")) {
                    String attributeR = reader.getAttributeValue(null, "r");
                    if(attributeR != null && Integer.parseInt(attributeR) > numOfRowsToSkip) {

                        array = new String[lengthOfArray];
                        boolean endOfRow;
                        boolean endElementEqualsRow = false;
                        do {
                            reader.next();
                            if (reader.isStartElement() && reader.getLocalName().equals("c")) {
                                String attributeT = reader.getAttributeValue(null, "t");
                                reader.next();
                                if (reader.isEndElement()) {
                                    array[counter] = null;
                                    counter++;
                                } else {
                                    while (reader.hasNext()) {
                                        if (reader.isStartElement() && reader.getLocalName().equals("v") && attributeT != null) {
                                            reader.next();
                                            Integer n = Integer.parseInt(reader.getText());
                                            String str = sharedStringsArray[n];
                                            array[counter] = str;
                                            counter++;
                                            break;
                                        } else if (reader.isStartElement() && reader.getLocalName().equals("v") && attributeT == null) {
                                            reader.next();
                                            array[counter] = reader.getText();
                                            counter++;
                                            break;
                                        } else {
                                            reader.next();
                                        }
                                    }
                                }
                            }
                            endOfRow = reader.isEndElement();
                            if (endOfRow) {
                                endElementEqualsRow = reader.getLocalName().equals("row");
                            }
                        } while (!endElementEqualsRow);
                        list.add(array);
                        counter = 0;
                        if(Settings.limitation_is_on){
                            if(!approved){
                                if(list.size() > 4){
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Map<Document, XPath> initializer(Path path) throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = path.toFile();
        Map<Document, XPath> map = new HashMap<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        map.put(document, xpath);
        return map;
    }
}
