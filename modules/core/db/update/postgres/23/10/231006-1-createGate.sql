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
    WORKING_WITH date,
    WORKING_UP_TO date,
    --
    primary key (ID)
);