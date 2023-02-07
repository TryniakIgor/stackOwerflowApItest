package com.example.stackOwerflowAPItest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collective {

    private List<String> tags;

    /**
     * check for null without
     * @Builder
     *
     */
        public List<String> getTags() {
        if (tags.isEmpty() || tags.equals(null))
            return List.of("user didn't add tags ");
        else return tags;
    }

}
