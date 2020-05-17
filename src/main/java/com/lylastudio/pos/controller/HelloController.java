package com.lylastudio.pos.controller;

import com.lylastudio.pos.dao.MCompanyDao;
import com.lylastudio.pos.entity.MBranch;
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

        MCompany m = new MCompany();
        m.setCreatedDate( new Date() );
        m.setUpdatedDate( new Date() );
        m.setName( "Laundry Lyla 123" );
        m.setAddress( "Banjaran" );
        m.setPhone("082111111");


        MBranch b1 = new MBranch();
        b1.setCreatedDate( new Date() );
        b1.setUpdatedDate( new Date() );
        b1.setAddress( "Cabang Soreang" );
        b1.setName( "Cabang Soreang" );

       m.addBranch( b1 );

        dao.save( m );

        Map<String, Object> response = new HashMap<>();
        response.put("UNI", new Date());
        return response;
    }

}
