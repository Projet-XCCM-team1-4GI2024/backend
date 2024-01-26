package com.projectXCCM.composix.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notion {

    @Id
    private Integer id;
    private String part;
    private String chapter;
    private String paragraph;
    private String notion;
    private String content;

    public Notion(String chapter, String part, String paragraph, String notion, String content) {
        this.chapter = chapter;
        this.part = part;
        this.paragraph = paragraph;
        this.notion = notion;
        this.content = content;
    }
}
