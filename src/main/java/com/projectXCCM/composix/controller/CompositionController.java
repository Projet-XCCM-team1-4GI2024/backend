package com.projectXCCM.composix.controller;

import com.projectXCCM.composix.model.Composition;
import com.projectXCCM.composix.service.CompositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/composition")
@CrossOrigin
@RequiredArgsConstructor
public class CompositionController {

    private final CompositionService service;

    @PostMapping("/save")
    public void saveComposition(@RequestBody Composition composition){
        service.saveComposition(composition); ;
    }
    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<List<Composition>> getAll(){
        System.out.println("He went here");
        return ResponseEntity.ok(service.getAllCompositions());
    }

    @GetMapping("/{author}")
    public ResponseEntity<List<Composition>> getAllByAuthor(@PathVariable String author){
        return ResponseEntity.ok(service.getByAuthor(author));
    }
    
}
