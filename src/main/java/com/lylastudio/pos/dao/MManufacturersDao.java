package com.lylastudio.pos.dao;

import com.lylastudio.pos.entity.MManufacturers;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface MManufacturersDao extends PagingAndSortingRepository<MManufacturers, String> {
    public List<MManufacturers> findByNameLike( String name, Pageable pageable);
}
