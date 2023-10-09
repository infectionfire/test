package com.company.test.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum LoadCapacity implements EnumClass<Integer> {

    GAZELLE(1),
    TRUCK(2);

    private Integer id;

    LoadCapacity(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static LoadCapacity fromId(Integer id) {
        for (LoadCapacity at : LoadCapacity.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}