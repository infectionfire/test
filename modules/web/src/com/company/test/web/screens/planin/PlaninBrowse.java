package com.company.test.web.screens.planin;

import com.company.test.entity.Client;
import com.company.test.entity.Planin;
import com.company.test.enums.LoadCapacity;
import com.company.test.enums.VehicleStatus;
import com.company.test.service.GateService;
import com.company.test.service.PlaninService;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.Dialogs;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.app.core.inputdialog.DialogActions;
import com.haulmont.cuba.gui.app.core.inputdialog.InputDialog;
import com.haulmont.cuba.gui.app.core.inputdialog.InputParameter;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.*;
import com.sun.tools.javac.util.List;

import javax.inject.Inject;
import java.util.stream.Collectors;

@UiController("test_Planin.browse")
@UiDescriptor("planin-browse.xml")
@LoadDataBeforeShow
public class PlaninBrowse extends StandardLookup<Planin> {
    @Inject
    private UiComponents uiComponents;
    @Inject
    private Dialogs dialogs;
    @Inject
    private PlaninService planinService;
    @Inject
    private Notifications notifications;
    @Inject
    private GroupTable<Planin> registredTable;
    @Inject
    private Button assignGate;
    @Inject
    private GateService gateService;
    @Inject
    private Button loadCompleted;
    @Inject
    private GroupTable<Planin> on_gate_Table;

    @Install(to = "registredTable.provider", subject = "columnGenerator")
    private Component registredTableProviderColumnGenerator(Planin planin) {
        return buildProviderLabel(planin);
    }

    @Install(to = "on_gate_Table.provider", subject = "columnGenerator")
    private Component plannedTableProviderColumnGenerator(Planin planin) {
        return buildProviderLabel(planin);
    }

    @Subscribe
    public void onInit(InitEvent event) {
        registredTable.addSelectionListener(selectionEvent -> {
            assignGate.setEnabled(!selectionEvent.getSelected().isEmpty());
        });
        on_gate_Table.addSelectionListener(planinSelectionEvent -> {
            loadCompleted.setEnabled(!planinSelectionEvent.getSelected().isEmpty());
        });
    }

    private Label buildProviderLabel(Planin planin) {
        Label label = uiComponents.create(Label.class);
        if (!planin.getProviders().isEmpty()) {
            label.setValue(planin.getProviders()
                    .stream()
                    .map(Client::getName)
                    .collect(Collectors.joining(", ")));
        } else label.setValue("");

        return label;
    }

    public void pickStatus() {
        dialogs.createInputDialog(this)
                .withCaption("Окно регистрации")
                .withParameters(
                        InputParameter.parameter("carNumber")
                                .withField(() -> {
                                    MaskedField maskedField = uiComponents.create(MaskedField.class);
                                    maskedField.setCaption("Номер ТС");
                                    maskedField.setWidthFull();
                                    //сделал маску с высоким регистром
                                    maskedField.setMask("#UUU##");
                                    maskedField.setValueMode(MaskedField.ValueMode.MASKED);
                                    maskedField.setRequired(true);
                                    return maskedField;
                                }),
                        InputParameter.parameter("name")
                                .withField(() -> {
                                    TextField textField = uiComponents.create(TextField.class);
                                    textField.setCaption("ФИО");
                                    textField.setWidthFull();
                                    textField.setRequired(true);
                                    return textField;
                                }),
                        InputParameter.parameter("phoneNumber")
                                .withField(() -> {
                                    MaskedField maskedField = uiComponents.create(MaskedField.class);
                                    maskedField.setCaption("Номер телефона ");
                                    maskedField.setWidthFull();
                                    maskedField.setMask("+7(###)###-##-##");
                                    maskedField.setValueMode(MaskedField.ValueMode.MASKED);
                                    maskedField.setRequired(true);
                                    return maskedField;
                                }),
                        InputParameter.parameter("loadCapacity")
                                .withField(() -> {
                                    LookupField lookupField = uiComponents.create(LookupField.class);
                                    lookupField.setCaption("Грузоподъемность");
                                    lookupField.setOptionsList(List.of(LoadCapacity.GAZELLE, LoadCapacity.TRUCK));
                                    lookupField.setRequired(true);
                                    return lookupField;
                                })
                )
                .withActions(DialogActions.OK_CANCEL)
                .withCloseListener(closeEvent -> {
                    if (closeEvent.getCloseAction().equals(InputDialog.INPUT_DIALOG_OK_ACTION)) {
                        planinService.createNewPlaninByRegisterField(closeEvent.getValue("carNumber"),
                                closeEvent.getValue("name"),
                                closeEvent.getValue("phoneNumber"),
                                closeEvent.getValue("loadCapacity"));
                        registredTable.repaint();
                    }
                }).show();
    }

    public void assignGate() {
        Planin planin = registredTable.getSingleSelected();
        if (planin != null && checkStatusIsRegistred(planin)) {
            dialogs.createInputDialog(this)
                    .withCaption("Выбор ворот")
                    .withParameters(
                            InputParameter.parameter("gate")
                                    .withField(() -> {
                                        LookupField lookupField = uiComponents.create(LookupField.class);
                                        lookupField.setCaption("Ворота");
                                        lookupField.setOptionsList(gateService.findAvailableGateNumbers());
                                        lookupField.setRequired(true);
                                        return lookupField;
                                    }))
                    .withActions(DialogActions.OK_CANCEL)
                    .withCloseListener(closeEvent -> {
                        if (closeEvent.getCloseAction().equals(InputDialog.INPUT_DIALOG_OK_ACTION)) {
                            gateService.postRegistredGate(planin, closeEvent.getValue("gate"));
                            registredTable.repaint();
                        }
                    }).show();
        } else {
            notifications.create(Notifications.NotificationType.ERROR).withCaption("Ворота не могут быть назначены");
        }
    }


    private boolean checkStatusIsRegistred(Planin planin) {
        return planin.getStatus().equals(VehicleStatus.REGISTERED);
    }

    public void loadCompleted() {
        Planin planin = on_gate_Table.getSingleSelected();
        if (planin != null) {
            dialogs.createOptionDialog(Dialogs.MessageType.CONFIRMATION)
                    .withCaption("Завершить загрузку?")
                    .withActions(
                            new DialogAction(DialogAction.Type.YES, Action.Status.PRIMARY).withHandler(e -> {
                                planinService.postLoadUpdate(planin);
                                on_gate_Table.repaint();
                            }),
                            new DialogAction(DialogAction.Type.NO)
                    ).show();
        }
    }
}