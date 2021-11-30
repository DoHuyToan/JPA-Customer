package com.codegym.cms.repository;

import com.codegym.cms.model.Provinces;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends PagingAndSortingRepository<Provinces, Long> {
}
