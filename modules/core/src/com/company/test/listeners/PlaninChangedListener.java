package com.company.test.listeners;

import com.company.test.entity.Planin;
import com.haulmont.cuba.core.app.events.AttributeChanges;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.core.global.ViewRepository;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.UUID;

@Component("test_PlaninChangedListener")
public class PlaninChangedListener {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(PlaninChangedListener.class);
    @Inject
    private DataManager dataManager;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void afterCommit(EntityChangedEvent<Planin, UUID> event) {
        AttributeChanges changes = event.getChanges();
        if (changes.isChanged("status") || changes.isChanged("condition")) {
            Planin planin = dataManager
                    .load(event.getEntityId())
                    .view("planin-view").softDeletion(false).one();
            log.info(planin.getRegisterNumber() + " " + planin.getCarNumber() + " " + planin.getStatus() + " " + planin.getCondition() + " " + planin.getUpdateTs());
        }
    }
}