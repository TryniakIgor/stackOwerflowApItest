package com.example.stackOwerflowAPItest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class Users {
    private List<User> items;
}
