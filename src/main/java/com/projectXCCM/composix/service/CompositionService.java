package com.projectXCCM.composix.service;

import com.projectXCCM.composix.model.Composition;
import com.projectXCCM.composix.repository.CompositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompositionService {

    private final CompositionRepository repository;

    public void saveComposition(Composition composition){ repository.save(composition);}

    public List<Composition> getAllCompositions(){ return repository.findAll();}

    public List<Composition> getByAuthor(String author){ return repository.findAllByAuthor(author);}

}
