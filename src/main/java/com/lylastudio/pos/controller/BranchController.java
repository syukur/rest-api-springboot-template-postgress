package com.lylastudio.pos.controller;

import com.lylastudio.pos.dao.MBranchDao;
import com.lylastudio.pos.entity.MBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

@RestController
@RequestMapping( value = "branch" )
public class BranchController {

    @Autowired
    MBranchDao dao;

    @RequestMapping( value = "/add", method = RequestMethod.POST )
    @ResponseStatus( HttpStatus.CREATED )
    public void add( @RequestBody @Valid MBranch branch ){
        Date now = new Date();
        branch.setCreatedDate( now );
        branch.setUpdatedDate( now );
        dao.save( branch );
    }

    @RequestMapping( value = "/update", method = RequestMethod.PUT )
    public void update(  @RequestBody @Valid MBranch branch ){
        Date now = new Date();
        branch.setUpdatedDate( now );
        dao.save( branch );
    }
}
