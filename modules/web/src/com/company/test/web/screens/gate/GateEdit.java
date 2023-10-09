package com.company.test.web.screens.gate;

import com.haulmont.cuba.gui.screen.*;
import com.company.test.entity.Gate;

@UiController("test_Gate.edit")
@UiDescriptor("gate-edit.xml")
@EditedEntityContainer("gateDc")
@LoadDataBeforeShow
public class GateEdit extends StandardEditor<Gate> {
}