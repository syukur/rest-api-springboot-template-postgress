package com.lylastudio.pos.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity @Table( name = "m_manufacturers" )
public class MManufacturers {

    @Id @GeneratedValue( generator = "uuid")
    @GenericGenerator( name = "uuid", strategy = "uuid2" )
    private String id;

    @Column( length = 50 )
    @NotNull
    @NotEmpty
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
