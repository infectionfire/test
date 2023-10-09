package com.company.test.service;

import com.company.test.entity.Gate;
import com.company.test.entity.Planin;

import java.util.List;

public interface GateService {
    String NAME = "test_GateService";

    List<String> findAvailableGateNumbers();

    void postRegistredGate(Planin planin, String gateNumber);
}