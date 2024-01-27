package com.projectXCCM.composix.controller;

import com.projectXCCM.composix.model.Composition;
import com.projectXCCM.composix.model.Notion;
import com.projectXCCM.composix.service.CompositionService;
import com.projectXCCM.composix.service.NotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/composition")
@CrossOrigin
@RequiredArgsConstructor
public class CompositionController {

    private final CompositionService service;
    private final NotionService notionService;

    @PostMapping("/save")
    public void saveComposition(@RequestBody Composition composition){
        service.saveComposition(composition); ;
    }
    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<List<String>> getAllNames(){
        System.out.println("He went here");
        return ResponseEntity.ok(service.getAllCompositionsNames());
    }

    @GetMapping("/{author}")
    public ResponseEntity<List<String>> getAllNamesByAuthor(@PathVariable String author){
        return ResponseEntity.ok(service.getNamesByAuthor(author));
    }

    @CrossOrigin
    @GetMapping("/all")
    public ResponseEntity<List<Composition>> getNames(){
        System.out.println("He went here");
        return ResponseEntity.ok(service.getAllCompositions());
    }

    @GetMapping("/all/{author}")
    public ResponseEntity<List<Composition>> getAllByAuthor(@PathVariable String author){
        return ResponseEntity.ok(service.getByAuthor(author));
    }

    @PostMapping("/upload/{author}")
    public Notion uploadXml(@RequestParam("file") MultipartFile xml, @PathVariable("author") String author) throws IOException {
        return notionService.saveNotion(new String(xml.getBytes(), "UTF-8"), author) ;
    }
    
}
