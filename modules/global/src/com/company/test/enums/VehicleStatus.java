package com.company.test.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum VehicleStatus implements EnumClass<Integer> {

    PLANNED(10),
    REGISTERED(20),
    ON_GATE(30),
    DEPARTURE_ALLOWED(50),
    LEFT(90);

    private Integer id;

    VehicleStatus(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static VehicleStatus fromId(Integer id) {
        for (VehicleStatus at : VehicleStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}