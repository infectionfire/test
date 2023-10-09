package com.company.test.core;

import com.company.test.entity.Planin;
import com.company.test.enums.VehicleStatus;
import com.company.test.service.PlaninService;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Component
public class AutomaticDepartureScheduler {
    @Inject
    private PlaninService planinService;
    @Inject
    private DataManager dataManager;

    public AutomaticDepartureScheduler() {
    }

    private void processClientEvents() {
        List<Planin> planins = planinService.findCandidatesToLeft();
        if (!planins.isEmpty()) {
            CommitContext ctx = new CommitContext();
            planins.forEach(planin -> {
                planin.setStatus(VehicleStatus.LEFT);
                planin.setCondition(null);
                planin.setDepartureDate(new Date());
                ctx.addInstanceToCommit(planin);
            });
            dataManager.commit(ctx);
            System.out.println("вызван шедулер");
        }
    }
}
