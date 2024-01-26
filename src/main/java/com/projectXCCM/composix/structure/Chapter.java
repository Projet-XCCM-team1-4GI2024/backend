package com.projectXCCM.composix.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter {

    private String chapter;
    private List<Paragraph> paragraphs;
    private List<SimpleNotion> independentNotions;

}
