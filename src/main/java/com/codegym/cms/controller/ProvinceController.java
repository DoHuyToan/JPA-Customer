package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Provinces;
import com.codegym.cms.service.CustomerService;
import com.codegym.cms.service.ICustomerService;
import com.codegym.cms.service.IProvinceService;
import com.codegym.cms.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProvinceController {

    @Autowired
    private IProvinceService provinceService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/view-provinces/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Provinces> provinceOptional = provinceService.findById(id);
        if(!provinceOptional.isPresent()){
            return new ModelAndView("/error.404");
        }

        Iterable<Customer> customers = customerService.findAllByProvinces(provinceOptional.get());

        ModelAndView modelAndView = new ModelAndView("/province/view");
        modelAndView.addObject("province", provinceOptional.get());
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/provinces")
    public ModelAndView listProvinces(){
        Iterable<Provinces> provinces = provinceService.findAll();
        ModelAndView modelAndView = new ModelAndView("/province/list");
        modelAndView.addObject("provinces", provinces);
        return modelAndView;
    }

    @GetMapping("/create-province")
    public ModelAndView showCreatForm(){
        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Provinces());
        return modelAndView;
    }

    @PostMapping("/create-province")
    public ModelAndView saveProvince(@ModelAttribute("province") Provinces provinces){
        provinceService.save(provinces);

        ModelAndView modelAndView = new ModelAndView("/province/create");
        modelAndView.addObject("province", new Provinces());
        modelAndView.addObject("message", "New province created successfully!");
        return modelAndView;
    }

    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<Provinces> province = provinceService.findById(id);
        if (province.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/province/edit");
            modelAndView.addObject("province", province);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-province")
    public ModelAndView updateProvince(@ModelAttribute("province") Provinces provinces){
        provinceService.save(provinces);
        ModelAndView modelAndView = new ModelAndView("/province/edit");
        modelAndView.addObject("province", provinces);
        modelAndView.addObject("message", "Province update successful!");
        return modelAndView;
    }

    @GetMapping("/delete-province/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<Provinces> province = provinceService.findById(id);
        if(province.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/province/delete");
            modelAndView.addObject("province", province.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-province")
    public String deleteProvince(@ModelAttribute("province") Provinces provinces){
        provinceService.remove(provinces.getId());
        return "redirect:provinces";
    }


}
