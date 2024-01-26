package com.projectXCCM.composix.structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Part {

    private String part;
    private List<Chapter> chapters;
    private List<SimpleNotion> independentNotions;

}
