package com.lylastudio.pos.dao;

import com.lylastudio.pos.entity.MCompany;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MCompanyDao extends PagingAndSortingRepository<MCompany, String> {

    public List<MCompany> findByNameLike(String name, Pageable pageable );

}
