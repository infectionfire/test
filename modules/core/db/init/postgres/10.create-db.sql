-- begin TEST_PLANIN
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
)^
-- end TEST_PLANIN
-- begin TEST_GATE
create table TEST_GATE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(5),
    WORKING_WITH time,
    WORKING_UP_TO time,
    --
    primary key (ID)
)^
-- end TEST_GATE
-- begin TEST_CLIENT
create table TEST_CLIENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE integer,
    NAME varchar(200),
    ADDRESS varchar(200),
    CONTACT_PERSON varchar(100),
    --
    primary key (ID)
)^
-- end TEST_CLIENT
-- begin TEST_PLANIN_CLIENT_LINK
create table TEST_PLANIN_CLIENT_LINK (
    PLANIN_ID uuid,
    CLIENT_ID uuid,
    primary key (PLANIN_ID, CLIENT_ID)
)^
-- end TEST_PLANIN_CLIENT_LINK
