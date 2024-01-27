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

    private String title;
    private String content;
    private String owner;

    public Notion(String title, String content, String owner) {
        this.title = title;
        this.content = content;
        this.owner = owner;
    }
}
