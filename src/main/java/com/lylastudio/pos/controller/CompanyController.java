package com.lylastudio.pos.controller;

import com.lylastudio.pos.Util.Constant;
import com.lylastudio.pos.dao.MCompanyDao;
import com.lylastudio.pos.entity.MCompany;
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
public class CompanyController {

    @Autowired
    private MCompanyDao dao;

    @RequestMapping( value = "/company/findById/{id}", method = RequestMethod.GET )
    public ResponseEntity<MCompany> findById( @PathVariable("id") String id ){
        Optional<MCompany> optionalMCompany = dao.findById( id );
        if ( optionalMCompany.isPresent() ){
            return new ResponseEntity<MCompany>(  optionalMCompany.get(), HttpStatus.OK );
        }else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
    }

    @RequestMapping( value = "/company/findByName/{pageNo}/{name}", method = RequestMethod.GET )
    public ResponseEntity<List<MCompany>> findByName( @PathVariable( "pageNo" ) int pageNo, @PathVariable( "name" ) String name ){
        Pageable pageable = PageRequest.of( pageNo, Constant.PAGEABLE_SIZE );
        List<MCompany> list = dao.findByNameLike(  "%" + name + "%", pageable );
        if ( list.isEmpty() ){
            return  new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }else{
            return new ResponseEntity<>( list, HttpStatus.OK );
        }
    }

    @RequestMapping( value = "/company/add", method = RequestMethod.POST )
    @ResponseStatus( HttpStatus.CREATED )
    public void add( @RequestBody @Valid MCompany c ){
        dao.save( c );
    }

    @RequestMapping( value = "/company/update/{id}", method = RequestMethod.PUT )
    @ResponseStatus( HttpStatus.OK )
    public void update( @PathVariable( "id" ) String id, @RequestBody @Valid MCompany c){
        c.setId(id);
        dao.save( c );
    }

    @RequestMapping( value = "/company/delete/{id}", method = RequestMethod.DELETE)
    @ResponseStatus( HttpStatus.OK )
    public void delete ( @PathVariable("id") String id ){
        dao.deleteById( id );
    }

    /*
    @RequestMapping( value = "/company/showAll", method = RequestMethod.POST )
    @ResponseStatus( HttpStatus.OK )
    public Page<MCompany> showAll( Pageable page ){

        return dao.findAll(page);
    }


  */
}
