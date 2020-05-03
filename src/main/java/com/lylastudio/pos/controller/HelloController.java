package com.lylastudio.pos.controller;

import com.lylastudio.pos.dao.MCompanyDao;
import com.lylastudio.pos.entity.MCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @Autowired
    MCompanyDao dao;

    @GetMapping("/pos/hello1")
    public Map<String, Object> hello() {

        MCompany mCompany = new MCompany();
        mCompany.setName("Nama");
        dao.save(mCompany);

        Map<String, Object> response = new HashMap<>();
        response.put("UNI", new Date());
        return response;
    }

}
