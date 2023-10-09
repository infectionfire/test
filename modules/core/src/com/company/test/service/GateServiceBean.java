package com.company.test.service;

import com.company.test.entity.Gate;
import com.company.test.entity.Planin;
import com.company.test.enums.VehicleCondition;
import com.company.test.enums.VehicleStatus;
import com.company.test.repository.GateRepository;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Service(GateService.NAME)
public class GateServiceBean implements GateService {

    @Inject
    private DataManager dataManager;
    @Inject
    private GateRepository gateRepository;

    @Override
    public List<String> findAvailableGateNumbers() {
        return gateRepository.findAvailableGateNumbers();
    }

    @Override
    public void postRegistredGate(Planin planin, String gateNumber) {
        planin.setStatus(VehicleStatus.ON_GATE);
        planin.setCondition(VehicleCondition.GATE_ASSIGNED);
        planin.setInstallationDateOnGate(new Date());
        planin.setGate(gateNumber);
        dataManager.commit(planin);
    }
}