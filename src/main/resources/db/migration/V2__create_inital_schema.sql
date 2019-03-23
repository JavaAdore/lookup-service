CREATE SEQUENCE locale_pk_seq START WITH 50;
create table product_locale (
   id int8 not null,
   is_active int4,
    code varchar(255),
    name varchar(255),
    primary key (id)
);


CREATE SEQUENCE resource_bundle_pk_seq START WITH 50;
create table resource_bundle (
   id int8 not null,
    is_active int4,
    key varchar(255),
    value varchar(255),
    product_locale_id int8,
    primary key (id)
);

alter table resource_bundle
add constraint resource_bndl_locale_id_fk 
foreign key (product_locale_id) 
references product_locale;

