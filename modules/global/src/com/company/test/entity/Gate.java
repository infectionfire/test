package com.company.test.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;

@Table(name = "TEST_GATE")
@Entity(name = "test_Gate")
public class Gate extends StandardEntity {
    private static final long serialVersionUID = 8040379283752784077L;

    @Column(name = "NUMBER_", unique = true, length = 5)
    private String number;

    @Column(name = "WORKING_WITH")
    private LocalTime workingWith;

    @Column(name = "WORKING_UP_TO")
    private LocalTime workingUpTo;

    public void setWorkingWith(LocalTime workingWith) {
        this.workingWith = workingWith;
    }

    public LocalTime getWorkingWith() {
        return workingWith;
    }

    public void setWorkingUpTo(LocalTime workingUpTo) {
        this.workingUpTo = workingUpTo;
    }

    public LocalTime getWorkingUpTo() {
        return workingUpTo;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}