package com.company.test.web.screens.planin;

import com.haulmont.cuba.gui.screen.*;
import com.company.test.entity.Planin;

@UiController("test_Planin.edit")
@UiDescriptor("planin-edit.xml")
@EditedEntityContainer("planinDc")
@LoadDataBeforeShow
public class PlaninEdit extends StandardEditor<Planin> {
}