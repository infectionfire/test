package com.company.test.core;

import com.company.test.entity.Planin;
import com.company.test.enums.VehicleStatus;
import com.company.test.service.PlaninService;
import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.security.app.Authenticated;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Component
@EnableScheduling
public class LeftStatusUpdateScheduler {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LeftStatusUpdateScheduler.class);
    @Inject
    private PlaninService planinService;
    @Inject
    private DataManager dataManager;

    @Authenticated
    @Scheduled(cron = "0 0/30 10-18 * * *")
//    @Scheduled(initialDelay = 10000L,fixedDelay = 10000L)
    public void run() {
        List<Planin> planins = planinService.findCandidatesToLeft();
        if (!planins.isEmpty()) {
            CommitContext ctx = new CommitContext();
            planins.forEach(planin -> {
                planin.setStatus(VehicleStatus.LEFT);
                planin.setCondition(null);
                planin.setDepartureDate(new Date());
                ctx.addInstanceToCommit(planin);
            });
            log.info("вызван шедулер, обновлено " + ctx.getCommitInstances().size() + " объектов");
            dataManager.commit(ctx);
        }
    }
}
