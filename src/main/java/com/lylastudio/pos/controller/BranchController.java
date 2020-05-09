package com.lylastudio.pos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "branch" )
public class BranchController {

    @RequestMapping( value = "/add", method = RequestMethod.GET )
    public String add(){
        return "data was added";
    }

    @RequestMapping( value = "/update", method = RequestMethod.GET )
    public String update(){
        return  "data was UPDATED";
    }
}
