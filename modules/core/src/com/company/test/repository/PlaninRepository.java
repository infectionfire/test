package com.company.test.repository;

import com.company.test.entity.Planin;
import com.company.test.enums.LoadCapacity;
import com.company.test.enums.VehicleCondition;
import com.company.test.enums.VehicleStatus;
import com.haulmont.bali.util.Preconditions;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Date;
import java.util.UUID;

@Component
public class PlaninRepository implements BaseRepository<Planin> {
    @Inject
    DataManager dataManager;

    @Override
    public Planin loadExtendedEntityView(Planin entity, String view) {
        preconditions(entity);
        if (view == null)
            view = "_local";
        return dataManager.reload(entity, view);
    }

    @Override
    public Planin loadExtendedEntityView(Planin entity, View view) {
        Preconditions.checkNotNullArgument(entity);
        Preconditions.checkNotNullArgument(view);

        return dataManager.reload(entity, view);
    }


    public void createPlaninByDefaultParams(String carNumber, String name, String phoneNumber, LoadCapacity loadCapacity) {
        Planin planin = dataManager.create(Planin.class);
        planin.setId(UUID.randomUUID());
        planin.setCarNumber(carNumber);
        planin.setName(name);
        planin.setPhoneNumber(phoneNumber);
        planin.setLoadCapacity(loadCapacity);
        planin.setStatus(VehicleStatus.REGISTERED);
        planin.setCondition(VehicleCondition.AWAITING_GATE_ASSIGNMENT);
        planin.setRegisterDate(new Date());
        dataManager.commit(planin);
    }
}
