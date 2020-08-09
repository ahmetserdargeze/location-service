CREATE EXTENSION IF NOT EXISTS postgis;
CREATE EXTENSION IF NOT EXISTS postgis_topology;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

create table stores_cordinates
(
    store_id   uuid      not null
        constraint stores_cordinates_pk
            primary key,
    store_name varchar(255),
    location   geography not null
);

alter table stores_cordinates
    owner to postgres;


create table courier
(
    courier_id   bigint not null
        constraint courier_pkey
            primary key,
    courier_name varchar(255)
);

alter table courier
    owner to postgres;

create table courier_log
(
    courier_log_id uuid      default uuid_generate_v4() not null
        constraint courier_log_pkey
            primary key,
    courier_id     bigint
        constraint courier_log_courier_courier_id_fk
            references courier,
    geom_location  geometry                             not null,
    activate_date  timestamp default now()              not null
);

alter table courier_log
    owner to postgres;
