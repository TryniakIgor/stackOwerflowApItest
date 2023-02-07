package com.example.stackOwerflowAPItest.mapper;

import com.example.stackOwerflowAPItest.dto.UserDTO;
import com.example.stackOwerflowAPItest.model.User;


public class UserMapper {

    public static UserDTO toDTO(User user) {
        return UserDTO.builder()
                .name(user.getDisplay_name())
                .location(user.getLocation())
                .answerCount(user.getAnswer_count())
                .questionCount(user.getQuestion_count())
                .tags(user.getCollectives().get(0).getCollective().getTags())
                .linkToProfile(user.getLink())
                .linkToAvatar(user.getProfile_image())
                .build();

    }
}
