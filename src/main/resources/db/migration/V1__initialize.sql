create table students (
    id                      bigserial,
    name                    varchar(255) not null,
    age                     int,
    primary key (id)
);

insert into students (name, age)
values
('Bob', 18),
('Alice', 19),
('John', 19);