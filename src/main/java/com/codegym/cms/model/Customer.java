package com.codegym.cms.model;

import javax.persistence.*;

// đánh dấu Class này là 1 Entity, Mỗi Entity sẽ mô tả một bảng trong DB
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "province_id")
    private Provinces provinces;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName, Provinces provinces) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.provinces = provinces;
    }

    public Customer(Long id, String firstName, String lastName, Provinces provinces) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.provinces = provinces;
    }

    public Provinces getProvinces() {
        return provinces;
    }

    public void setProvinces(Provinces provinces) {
        this.provinces = provinces;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
    }
}
