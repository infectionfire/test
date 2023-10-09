package com.company.test.service;

import com.company.test.entity.Planin;
import com.company.test.enums.LoadCapacity;

import java.util.List;

public interface PlaninService {
    String NAME = "test_PlaninService";


    void createNewPlaninByRegisterField(String carNumber, String name, String phoneNumber, LoadCapacity loadCapacity);

    void postLoadUpdate(Planin planin);

    List<Planin> findCandidatesToLeft();
}