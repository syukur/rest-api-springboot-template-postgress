package com.lylastudio.pos.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
* m_branch : menyimpan data cabang
* satu m_company bisa punya banyak cabang
* */
@Entity @Table( name = "m_branch" )
public class MBranch {

    @Id @GeneratedValue( generator = "uuid" )
    @GenericGenerator( name = "uuid", strategy = "uuid2")
    String id;

    @Column( length = 30 )
    @NotEmpty
    @NotNull
    @Size( min = 3, max = 30 )
    String name;

    @Column( length = 255 )
    @NotEmpty
    @NotNull
    @Size( min = 3, max = 255 )
    String address;

    @ManyToOne
    @JoinColumn( name = "m_company_id", nullable = false )
    MCompany mcompany;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MCompany getMcompany() {
        return mcompany;
    }

    public void setMcompany(MCompany mcompany) {
        this.mcompany = mcompany;
    }
}
