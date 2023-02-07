package com.example.stackOwerflowAPItest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String name;
    private String location;
    private Integer answerCount;
    private Integer questionCount;
    private List<String> tags;
    private String linkToProfile;
    private String linkToAvatar;
}
