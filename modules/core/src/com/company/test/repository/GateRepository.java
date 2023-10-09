package com.company.test.repository;

import com.company.test.entity.Gate;
import com.haulmont.bali.util.Preconditions;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.View;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GateRepository implements BaseRepository<Gate> {

    @Inject
    DataManager dataManager;

    @Override
    public Gate loadExtendedEntityView(Gate entity, String view) {
        preconditions(entity);
        if (view == null)
            view = "_local";
        return dataManager.reload(entity, view);
    }

    @Override
    public Gate loadExtendedEntityView(Gate entity, View view) {
        Preconditions.checkNotNullArgument(entity);
        Preconditions.checkNotNullArgument(view);

        return dataManager.reload(entity, view);
    }

    public List<String> findAvailableGateNumbers() {
        List<Gate> gates= dataManager.load(Gate.class)
                .query("select e from test_Gate e where (select count(p) from test_Planin p where p.gate = e.number and p.status<>90) = 0 and e.workingWith <:time and e.workingUpTo>:time")
                .view(View.LOCAL)
                .parameter("time", LocalTime.now())
                .list();
        if(gates.isEmpty()){
            return Collections.emptyList();
        }else {
            return gates.stream().map(Gate::getNumber).collect(Collectors.toList());
        }
    }
}
