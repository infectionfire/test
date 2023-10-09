package com.company.test.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "TEST_CLIENT")
@Entity(name = "test_Client")
@NamePattern("%s|name")
public class Client extends StandardEntity {
    private static final long serialVersionUID = -4137816580239782603L;

    @Column(name = "CODE")
    private Integer code;

    @Column(name = "NAME", length = 200)
    private String name;

    @Column(name = "ADDRESS", length = 200)
    private String address;

    @Column(name = "CONTACT_PERSON", length = 100)
    private String contactPerson;

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}