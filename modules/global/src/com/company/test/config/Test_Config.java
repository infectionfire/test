package com.company.test.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.DefaultInt;

@Source(type = SourceType.DATABASE)
public interface Test_Config extends Config {

    /**
     * @return maximum distance to create and show ContainerYard
     */
    @Property("rtneo.containerYard.maximumDistanceInMeters")
    @DefaultInt(100)
    int getTimeSchedulingAutomaticDeparture();
}
