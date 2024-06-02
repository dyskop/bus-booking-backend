create table if not exists bus
(
    id                  bigserial primary key,
    registration_number varchar(255) not null unique,
    model               varchar(255) not null,
    capacity            integer      not null
);

create table if not exists amenity
(
    id   bigserial primary key,
    name varchar(255) not null unique
);

create table if not exists bus_amenity
(
    bus_id     bigint not null references bus,
    amenity_id bigint not null references amenity,
    primary key (bus_id, amenity_id)
);

create sequence if not exists bus_id_seq;
create sequence if not exists amenity_id_seq;

insert into amenity (name)
values ('free WI-FI'),
       ('conditioner'),
       ('USB charger');

insert into bus (registration_number, model, capacity)
values ('1111 AA-1', 'Mercedes-Benz Sprinter', 15),
       ('2222 BB-2', 'Volkswagen Crafter', 22),
       ('3333 CC-3', 'Citroen Jumper', 20);

insert into bus_amenity (bus_id, amenity_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (2, 1),
       (2, 2),
       (3, 3);