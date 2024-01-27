package com.projectXCCM.composix.service;

import com.projectXCCM.composix.model.Composition;
import com.projectXCCM.composix.repository.CompositionRepository;
import com.projectXCCM.composix.repository.NotionRepository;
import com.projectXCCM.composix.structure.SimpleNotion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompositionService {

    private final CompositionRepository repository;
    private final NotionRepository notionRepository;

    public void saveComposition(Composition composition){ repository.save(composition);}

    public List<Composition> getAllCompositions(){
        List<Composition> list =  repository.findAll();
        list.add(new Composition(notionRepository.findAll()
                .stream().map(s -> new SimpleNotion(s.getContent())).toList()));
        return list;}

    public List<Composition> getByAuthor(String author){
        return repository.findAllByAuthor(author);}

    public List<String> getAllCompositionsNames(){
        return repository.findAll().stream().map(s -> s.getCourse()).toList();}

    public List<String> getNamesByAuthor(String author){
        return repository.findAllByAuthor(author).stream().map(s -> s.getCourse()).toList();}

}
