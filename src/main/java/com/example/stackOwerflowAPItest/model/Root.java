package com.example.stackOwerflowAPItest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root{
    private ArrayList<User> items;
    private boolean has_more;

}
