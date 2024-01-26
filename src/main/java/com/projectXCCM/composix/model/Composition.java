package com.projectXCCM.composix.model;

import com.projectXCCM.composix.structure.Part;
import com.projectXCCM.composix.structure.SimpleNotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "compositions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Composition {

    @Id
    private String id;
    private String course;
    private List<Part> parts;
    private List<SimpleNotion> independentNotions;
    private String author;

    public Composition(String course, List<Part> parts, List<SimpleNotion> independentNotions, String author) {
        this.course = course;
        this.parts = parts;
        this.independentNotions = independentNotions;
        this.author = author;
    }

}
