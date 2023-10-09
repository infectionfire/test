package com.company.test.entity;

import com.company.test.enums.LoadCapacity;
import com.company.test.enums.VehicleCondition;
import com.company.test.enums.VehicleStatus;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@PublishEntityChangedEvents
@Table(name = "TEST_PLANIN")
@Entity(name = "test_Planin")
@NamePattern("%s|name")
public class Planin extends StandardEntity {
    private static final long serialVersionUID = -1176277805975827076L;

    @Column(name = "REGISTER_NUMBER", length = 10)
    private String registerNumber;

    @Column(name = "ORDER_NUMBER")
    private String orderNumber;

    @JoinTable(name = "TEST_PLANIN_CLIENT_LINK",
            joinColumns = @JoinColumn(name = "PLANIN_ID"),
            inverseJoinColumns = @JoinColumn(name = "CLIENT_ID"))
    @ManyToMany
    private List<Client> providers;

    @Temporal(TemporalType.DATE)
    @Column(name = "PLANNED_ARRIVAL_DATE")
    private Date plannedArrivalDate;

    @Column(name = "CAR_NUMBER", length = 20)
    private String carNumber;

    @Column(name = "LOAD_CAPACITY")
    private Integer loadCapacity;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "PHONE_NUMBER", length = 20)
    private String phoneNumber;

    @Column(name = "STATUS")
    private Integer status;

    @Column(name = "CONDITION_")
    private Integer condition;

    @Column(name = "GATE", length = 5)
    private String gate;

    @Temporal(TemporalType.DATE)
    @Column(name = "REGISTER_DATE")
    private Date registerDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "INSTALLATION_DATE_ON_GATE")
    private Date installationDateOnGate;

    @Temporal(TemporalType.DATE)
    @Column(name = "DEPARTURE_IS_ALLOWED_DATE")
    private Date departureIsAllowedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "DEPARTURE_DATE")
    private Date departureDate;

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Date getDepartureIsAllowedDate() {
        return departureIsAllowedDate;
    }

    public void setDepartureIsAllowedDate(Date departureIsAllowedDate) {
        this.departureIsAllowedDate = departureIsAllowedDate;
    }

    public Date getInstallationDateOnGate() {
        return installationDateOnGate;
    }

    public void setInstallationDateOnGate(Date installationDateOnGate) {
        this.installationDateOnGate = installationDateOnGate;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public VehicleCondition getCondition() {
        return condition == null ? null : VehicleCondition.fromId(condition);
    }

    public void setCondition(VehicleCondition condition) {
        this.condition = condition == null ? null : condition.getId();
    }

    public VehicleStatus getStatus() {
        return status == null ? null : VehicleStatus.fromId(status);
    }

    public void setStatus(VehicleStatus status) {
        this.status = status == null ? null : status.getId();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoadCapacity getLoadCapacity() {
        return loadCapacity == null ? null : LoadCapacity.fromId(loadCapacity);
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = loadCapacity == null ? null : loadCapacity.getId();
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Date getPlannedArrivalDate() {
        return plannedArrivalDate;
    }

    public void setPlannedArrivalDate(Date plannedArrivalDate) {
        this.plannedArrivalDate = plannedArrivalDate;
    }

    public List<Client> getProviders() {
        return providers;
    }

    public void setProviders(List<Client> providers) {
        this.providers = providers;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }
}