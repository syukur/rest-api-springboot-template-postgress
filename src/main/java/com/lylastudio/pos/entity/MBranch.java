package com.lylastudio.pos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/*
* m_branch : menyimpan data cabang
* satu m_company bisa punya banyak cabang
* */
@Entity @Table( name = "m_branch" )
public class MBranch {

    @Id @GeneratedValue( generator = "uuid" )
    @GenericGenerator( name = "uuid", strategy = "uuid2")
    private String id;

    @Column( length = 30 )
    @NotEmpty
    @NotNull
    @Size( min = 3, max = 30 )
    private String name;

    @Column( length = 255 )
    @NotEmpty
    @NotNull
    @Size( min = 3, max = 255 )
    private String address;

    @Column( name = "created_date" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date createdDate;

    @Column( name = "updated_date" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date updatedDate;

    @ManyToOne
    @JoinColumn( name = "m_company_id" )
    @JsonBackReference
    private MCompany mcompany;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public MCompany getMcompany() {
        return mcompany;
    }

    public void setMcompany(MCompany mcompany) {
        this.mcompany = mcompany;
    }
}
