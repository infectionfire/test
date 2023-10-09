-- begin TEST_GATE
create unique index IDX_TEST_GATE_UK_NUMBER_ on TEST_GATE (NUMBER_) where DELETE_TS is null ^
-- end TEST_GATE
-- begin TEST_PLANIN_CLIENT_LINK
alter table TEST_PLANIN_CLIENT_LINK add constraint FK_PLACLI_ON_PLANIN foreign key (PLANIN_ID) references TEST_PLANIN(ID)^
alter table TEST_PLANIN_CLIENT_LINK add constraint FK_PLACLI_ON_CLIENT foreign key (CLIENT_ID) references TEST_CLIENT(ID)^
-- end TEST_PLANIN_CLIENT_LINK
