create table product
(
    id          serial not null primary key,
    name        varchar(255),
    description varchar(255),
    sku         varchar(32)
);
