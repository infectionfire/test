create table TEST_PLANIN (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    REGISTER_NUMBER varchar(10),
    ORDER_NUMBER varchar(255),
    PLANNED_ARRIVAL_DATE date,
    CAR_NUMBER varchar(20),
    LOAD_CAPACITY integer,
    NAME varchar(100),
    PHONE_NUMBER varchar(20),
    STATUS integer,
    CONDITION_ integer,
    GATE varchar(5),
    REGISTER_DATE date,
    INSTALLATION_DATE_ON_GATE date,
    DEPARTURE_IS_ALLOWED_DATE date,
    DEPARTURE_DATE date,
    --
    primary key (ID)
);