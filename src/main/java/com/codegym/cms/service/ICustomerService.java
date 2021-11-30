package com.codegym.cms.service;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Provinces;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvinces(Provinces provinces);
}
