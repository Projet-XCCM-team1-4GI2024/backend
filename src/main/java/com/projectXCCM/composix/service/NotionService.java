package com.projectXCCM.composix.service;

import com.projectXCCM.composix.model.Notion;
import com.projectXCCM.composix.repository.NotionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotionService {

    private final NotionRepository repository;

    public Notion saveNotion(Notion notion){ return repository.save(notion);}

    public List<Notion> getAllNotions(){ return repository.findAll();}

    public List<Notion> getNotionsByChapter(String chapter){ return repository.findAllByChapter(chapter);}

    public List<Notion> getNotionsByPart(String part){ return repository.findAllByPart(part);}

    public List<Notion> getNotionsByParagraph(String paragraph){ return repository.findAllByParagraph(paragraph);}

    public void updateNotion(String id, String chapter, String part, String paragraph, String notion, String content){
        Notion notionToUpdate = repository.findById(id)
                .orElse(null);

        if (chapter != null && chapter != notionToUpdate.getChapter()) {
            notionToUpdate.setChapter(chapter);
        }

        if (part != null && part != notionToUpdate.getPart()) {
            notionToUpdate.setPart(part);
        }

        if (paragraph != null && paragraph != notionToUpdate.getParagraph()) {
            notionToUpdate.setParagraph(paragraph);
        }

        if(notion != null && notion != notionToUpdate.getNotion()){
            notionToUpdate.setNotion(notion);
        }

        if (content != null && chapter != notionToUpdate.getContent()) {
            notionToUpdate.setContent(content);
        }
    }
}
