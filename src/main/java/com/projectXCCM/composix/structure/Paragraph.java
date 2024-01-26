package com.projectXCCM.composix.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paragraph {

    private String paragraph;
    private List<SimpleNotion> notions;

}
