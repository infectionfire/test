package com.company.test.web.screens.client;

import com.haulmont.cuba.gui.screen.*;
import com.company.test.entity.Client;

@UiController("test_Client.edit")
@UiDescriptor("client-edit.xml")
@EditedEntityContainer("clientDc")
@LoadDataBeforeShow
public class ClientEdit extends StandardEditor<Client> {
}