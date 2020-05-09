package com.lylastudio.pos.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
* m_company : tabel untuk menyimpan data perusahaan / laundry
* */
@Entity @Table( name = "m_company" )
public class MCompany {

    @Id @GeneratedValue( generator = "uuid" )
    @GenericGenerator( name = "uuid", strategy = "uuid2")
    private String id;

    @Column( length = 50 )
    @NotNull
    @NotEmpty
    @Size( min = 1, max = 50 )
    private String name;

    @Column( length = 255 )
    @NotNull
    @NotEmpty
    @Size( min = 1, max = 255 )
    private String address;

    @Column( length = 25 )
    @NotNull
    @NotEmpty
    @Size( min = 5, max =  25 )
    private String phone;

    @Column( name = "created_date" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date createdDate;

    @Column( name = "updated_date" )
    @Temporal( TemporalType.TIMESTAMP )
    private Date updatedDate;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "mcompany"
    )
    private List<MBranch> branchList = new ArrayList<>();

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public List<MBranch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<MBranch> branchList) {
        this.branchList = branchList;
    }
}
