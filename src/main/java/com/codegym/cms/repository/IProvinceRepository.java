package com.codegym.cms.repository;

import com.codegym.cms.model.Provinces;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

// @Repository để đánh dấu đây là tầng Repository thao tác với CSDL
@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Provinces, Long> {
}
