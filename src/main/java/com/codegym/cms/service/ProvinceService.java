package com.codegym.cms.service;

import com.codegym.cms.model.Provinces;
import com.codegym.cms.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceService implements IProvinceService{

    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public Iterable<Provinces> findAll(){
        return provinceRepository.findAll();
    }

    @Override
    public Optional<Provinces> findById(Long id){
        return provinceRepository.findById(id);
    }

    @Override
    public void save(Provinces provinces){
        provinceRepository.save(provinces);
    }

    @Override
    public void remove(Long id){
        provinceRepository.deleteById(id);
    }
}
