package com.company.test.web.screens.client;

import com.haulmont.cuba.gui.screen.*;
import com.company.test.entity.Client;

@UiController("test_Client.browse")
@UiDescriptor("client-browse.xml")
@LookupComponent("clientsTable")
@LoadDataBeforeShow
public class ClientBrowse extends StandardLookup<Client> {
}