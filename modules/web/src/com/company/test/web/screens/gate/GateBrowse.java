package com.company.test.web.screens.gate;

import com.haulmont.cuba.gui.screen.*;
import com.company.test.entity.Gate;

@UiController("test_Gate.browse")
@UiDescriptor("gate-browse.xml")
@LookupComponent("gatesTable")
@LoadDataBeforeShow
public class GateBrowse extends StandardLookup<Gate> {
}