package com.company.test.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum VehicleCondition implements EnumClass<Integer> {

    AWAITING_GATE_ASSIGNMENT(5),
    ON_GATE(20),
    GATE_ASSIGNED(30),
    DEPARTURE_ALLOWED(50);

    private Integer id;

    VehicleCondition(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static VehicleCondition fromId(Integer id) {
        for (VehicleCondition at : VehicleCondition.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}