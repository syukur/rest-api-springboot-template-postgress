package com.lylastudio.pos.controller;

import com.lylastudio.pos.Util.Constant;
import com.lylastudio.pos.dao.MManufacturersDao;
import com.lylastudio.pos.entity.MManufacturers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ManufacturersController {

    @Autowired
    MManufacturersDao dao;

    @RequestMapping( value = "/manufacturers/add", method = RequestMethod.POST )
    @ResponseStatus( HttpStatus.CREATED )
    public void add( @RequestBody @Valid MManufacturers m ){
        dao.save( m );
    }

    @RequestMapping( value = "manufacturers/update/{id}", method =  RequestMethod.PUT )
    @ResponseStatus( HttpStatus.OK )
    public void update( @RequestBody @Valid MManufacturers m, @PathVariable( "id" ) String id ){
        m.setId( id );
        dao.save( m );
    }

    @RequestMapping( value = "manufacturers/delete/{id}", method = RequestMethod.DELETE )
    @ResponseStatus( HttpStatus.OK )
    public void delete( @PathVariable( "id" ) String id ){
        dao.deleteById( id );
    }

    @RequestMapping( value = "manufacturers/findByid/{id}")
    public ResponseEntity<MManufacturers> getById(@PathVariable( "id" ) String id ){
        Optional<MManufacturers> optional = dao.findById( id );
        if( optional.isPresent() ){
            return new ResponseEntity<MManufacturers>( optional.get(), HttpStatus.OK );
        }else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }


    @RequestMapping( value = "manufacturers/findByName/{pageNo}/{name}")
    public ResponseEntity<List<MManufacturers>> findByName( @PathVariable( "pageNo" ) int pageNo, @PathVariable( "name" ) String name ){
        Pageable pageable = PageRequest.of( pageNo, Constant.PAGEABLE_SIZE );
        List<MManufacturers> m = dao.findByNameLike( "%" + name + "%", pageable );

        if( m.isEmpty() ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<List<MManufacturers>>( m, HttpStatus.OK );
        }

    }
}