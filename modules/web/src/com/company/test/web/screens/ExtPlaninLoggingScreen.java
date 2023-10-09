package com.company.test.web.screens;

import com.company.test.entity.Planin;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("test_ExtPlaninLoggingScreen")
@UiDescriptor("ext-planin-logging-screen.xml")
@EditedEntityContainer("planinDc")

public class ExtPlaninLoggingScreen extends Screen {

    @Inject
    private CollectionLoader<Planin> planinDl;

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        planinDl.load();
    }
}