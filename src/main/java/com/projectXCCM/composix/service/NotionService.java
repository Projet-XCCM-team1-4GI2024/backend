package com.projectXCCM.composix.service;

import com.projectXCCM.composix.model.Notion;
import com.projectXCCM.composix.repository.NotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotionService {

    private final NotionRepository repository;

    public Notion saveNotion(String xmlString, String author){

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            ByteArrayInputStream input = new ByteArrayInputStream(xmlString.getBytes("UTF-8"));
            doc = builder.parse(input);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }

        // Get the root element
        Element rootElement = doc.getDocumentElement();
        String content = "";
        String title = "";

        NodeList titleList = rootElement.getElementsByTagName("type");
        Node TitleNode = titleList.item(0);
        if (TitleNode.getNodeType() == Node.ELEMENT_NODE) {
            Element elementTitle = (Element) TitleNode;
            title += elementTitle.getTextContent();
        }

        // Get all elements by tag name and print their content
        NodeList list = rootElement.getElementsByTagName("content"); // replace with your tag name
        for (int i = 0; i < list.getLength(); i++) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                content += element.getTextContent();
            }
        }

        return repository.save(new Notion(title, content, author));}


    public List<Notion> getAllNotions(){ return repository.findAll();}

//    public List<Notion> getNotionsByOwner(String owner){ return repository.findAllByOwner(owner);}
//
//    public List<Notion> getNotionsByChapter(String chapter){ return repository.findAllByChapter(chapter);}
//
//    public List<Notion> getNotionsByPart(String part){ return repository.findAllByPart(part);}
//
//    public List<Notion> getNotionsByParagraph(String paragraph){ return repository.findAllByParagraph(paragraph);}

//    public void updateNotion(String id, String chapter, String part, String paragraph, String notion, String content){
//        Notion notionToUpdate = repository.findById(id)
//                .orElse(null);
//
//        if (chapter != null && chapter != notionToUpdate.getChapter()) {
//            notionToUpdate.setChapter(chapter);
//        }
//
//        if (part != null && part != notionToUpdate.getPart()) {
//            notionToUpdate.setPart(part);
//        }
//
//        if (paragraph != null && paragraph != notionToUpdate.getParagraph()) {
//            notionToUpdate.setParagraph(paragraph);
//        }
//
//        if(notion != null && notion != notionToUpdate.getNotion()){
//            notionToUpdate.setNotion(notion);
//        }
//
//        if (content != null && chapter != notionToUpdate.getContent()) {
//            notionToUpdate.setContent(content);
//        }
//    }
}
