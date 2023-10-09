package com.company.test.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.DefaultInt;

@Source(type = SourceType.DATABASE)
public interface Test_Config extends Config {

    /**
     * @return время, которое плюсуется к времени убытия автомобиля при проверке на то, что он уехал
     */
    @Property("test.schedulingAutomaticDepartureTime")
    @DefaultInt(1000)
    int getTimeSchedulingAutomaticDeparture();
}
