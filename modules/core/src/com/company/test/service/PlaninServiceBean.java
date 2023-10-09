package com.company.test.service;

import com.company.test.config.Test_Config;
import com.company.test.entity.Planin;
import com.company.test.enums.LoadCapacity;
import com.company.test.enums.VehicleCondition;
import com.company.test.enums.VehicleStatus;
import com.company.test.repository.PlaninRepository;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service(PlaninService.NAME)
public class PlaninServiceBean implements PlaninService {
    @Inject
    private PlaninRepository planinRepository;
    @Inject
    private DataManager dataManager;
    @Inject
    private Test_Config test_Config;

    @Override
    public void createNewPlaninByRegisterField(String carNumber, String name, String phoneNumber, LoadCapacity loadCapacity) {
        planinRepository.createPlaninByDefaultParams(carNumber,name,phoneNumber,loadCapacity);
    }

    @Override
    public void postLoadUpdate(Planin planin) {
        planin.setStatus(VehicleStatus.DEPARTURE_ALLOWED);
        planin.setCondition(VehicleCondition.DEPARTURE_ALLOWED);
        planin.setDepartureIsAllowedDate(new Date());
        dataManager.commit(planin);
    }

    @Override
    public List<Planin> findCandidatesToLeft() {
        test_Config.getTimeSchedulingAutomaticDeparture();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND, -1000);

        return dataManager.load(Planin.class).query("select e from test_Planin e where e.status = 50 and e.departureIsAllowedDate  >=:autoDepartureTime ")
                .parameter("autoDepartureTime",calendar.getTime())
                .view(View.LOCAL).list();
    }
}