package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Provinces;
import com.codegym.cms.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

    // tiêm customerRepository vào class CustomerService mà ko cần tạo đối tượng
    @Autowired
    private ICustomerRepository customerRepository;

   @Override
    public Iterable<Customer> findAllByProvinces(Provinces province) {
        return customerRepository.findAllByProvinces(province);
    }

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
}
