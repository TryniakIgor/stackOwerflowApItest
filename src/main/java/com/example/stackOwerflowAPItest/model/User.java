package com.example.stackOwerflowAPItest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer answer_count;
    private Integer question_count;
    private String link;
    private String profile_image;
    private String display_name;
    @Builder.Default
    private String location = "location is not specified";
    private Integer reputation;
    @Builder.Default
    private List<Collectives> collectives = List.of(new Collectives(new Collective(List.of("user didn't add tags "))));

}

