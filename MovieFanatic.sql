CREATE TABLE "USERS" 
(   "USER_ID" NUMBER NOT NULL, 
	"USER_NAME" VARCHAR2(20) NOT NULL UNIQUE, 
	"PASSWORD" VARCHAR2(20 BYTE) NOT NULL, 
	"FIRST_NAME" VARCHAR2(20 BYTE), 
	"LAST_NAME" VARCHAR2(20 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE), 
	"BIO" VARCHAR2(256 BYTE), 
    "IS_ADMIN" number(1,0) not null,
    "JOIN_DATE" timestamp not null,
    "IS_VERIFIED" number(1,0) not null,
    CONSTRAINT "USERS_PK" PRIMARY KEY ("USER_ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
  NOCOMPRESS LOGGING;
/
create sequence USER_ID_SEQ  minvalue 1 maxvalue 9999999999999999999999999999 
increment by 1 start with 1 cache 20 noorder  nocycle  nopartition;
/
create or replace trigger USER_ID_TRIG 
before insert on USERS
for each row 
begin
  select USER_ID_SEQ.nextval into :new.USER_ID from dual;
  select current_timestamp into :new.JOIN_DATE from dual;
  select 0 into :new.is_verified from dual;
  select 0 into :new.is_admin from dual;
end;
/  

CREATE TABLE "REVIEWS" 
(	"REVIEW_ID" NUMBER NOT NULL,
    "USER_ID" NUMBER NOT NULL,
    "MOVIE_ID" NUMBER NOT NULL,
	"REVIEW" VARCHAR2(1800 BYTE) NOT NULL, 
	"RATING" NUMBER(1,0) NOT NULL, 
    "REVIEW_DATE" timestamp not null,
    "REVIEW_EXPIRE_DATE" timestamp not null,
    CONSTRAINT "REVIEWS_PK" PRIMARY KEY ("REVIEW_ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255,
    constraint FK_REVIEWS_USER_ID foreign key (USER_ID)
    references USERS (USER_ID) enable
) SEGMENT CREATION DEFERRED 
     PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
     NOCOMPRESS LOGGING; 
/ 
create sequence REVIEW_ID_SEQ  minvalue 1 maxvalue 9999999999999999999999999999 
increment by 1 start with 1 cache 20 noorder  nocycle  nopartition;
/
create or replace trigger REVIEW_ID_TRIG 
before insert on REVIEWS
for each row 
begin
  select REVIEW_ID_SEQ.nextval into :new.REVIEW_ID from dual;
  select current_timestamp into :new.REVIEW_DATE from dual;
  select add_months( current_timestamp, 24 ) into :new.REVIEW_EXPIRE_DATE from dual;
end;
/  

CREATE TABLE "APPROVALS" 
(	"APPROVAL_ID" NUMBER NOT NULL,
    "REVIEW_ID" NUMBER NOT NULL,
	"THUMBS_UP" NUMBER(1,0) NOT NULL, 
	"SOURCE_ID" NUMBER NOT NULL, 
    CONSTRAINT "APPROVALS_PK" PRIMARY KEY ("APPROVAL_ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255,
    constraint FK_APPROVALS_SOURCE_ID foreign key (SOURCE_ID)
    references USERS (USER_ID) enable,
    constraint FK_APPROVALS_REVIEW_ID foreign key (REVIEW_ID)
    references REVIEWS (REVIEW_ID) enable
) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
  NOCOMPRESS LOGGING; 
/
create sequence APPROVAL_ID_SEQ  minvalue 1 maxvalue 9999999999999999999999999999 
increment by 1 start with 1 cache 20 noorder  nocycle  nopartition;
/
create or replace trigger APPROVAL_ID_TRIG 
before insert on APPROVALS
for each row 
begin
  select APPROVAL_ID_SEQ.nextval into :new.APPROVAL_ID from dual;
end;
/

CREATE TABLE "FAVORITES" 
(	"FAVORITE_ID" NUMBER NOT NULL, 
	"USER_ID" NUMBER NOT NULL, 
	"MOVIE_ID" NUMBER NOT NULL, 
    CONSTRAINT "FAVORITES_PK" PRIMARY KEY ("FAVORITE_ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255,
    constraint FK_FAVORITES_USER_ID foreign key (USER_ID)
    references USERS (USER_ID) enable

) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
  NOCOMPRESS LOGGING;
/
create sequence FAVORITES_ID_SEQ  minvalue 1 maxvalue 9999999999999999999999999999 
increment by 1 start with 1 cache 20 noorder  nocycle  nopartition;
/
create or replace trigger FAVORITES_ID_TRIG 
before insert on FAVORITES
for each row 
begin
  select FAVORITES_ID_SEQ.nextval into :new.FAVORITE_ID from dual;
end;
/