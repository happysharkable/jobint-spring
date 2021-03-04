create table students (
    id                      bigserial primary key,
    name                    varchar(255) not null,
    age                     int
);

create table users (
    id                      bigserial primary key,
    username                varchar(255) not null,
    password                varchar(255) not null
);

create table roles (
    id                      bigserial primary key,
    name                    varchar(255) not null
);

create table authorities (
    id                      bigserial primary key,
    name                    varchar(255) not null
);

create table users_roles (
    user_id                 bigint not null,
    role_id                 bigint not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);

create table roles_authorities (
    role_id                 bigint not null,
    authority_id            bigint not null,
    primary key (role_id, authority_id),
    foreign key (role_id) references roles(id),
    foreign key (authority_id) references authorities(id)
);

insert into students (name, age)
values
('Bob', 18),
('Alice', 19),
('John', 19);

insert into users (username, password)
values
-- password = 'password'
('UserUser', '$2y$12$TaySmHpgN.SvhoAkR5Obr.l3dJlD2aXfdyugDekvKK/4mtAGcAIYy'),
('UserAdmin', '$2y$12$TaySmHpgN.SvhoAkR5Obr.l3dJlD2aXfdyugDekvKK/4mtAGcAIYy');

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN');

insert into authorities (name)
values
('CAN_MODIFY'), ('CAN_ADD');

insert into roles_authorities (role_id, authority_id)
values
(1, 1),
(2, 1), (2, 2);

insert into users_roles (user_id, role_id)
values
(1, 1), (2, 2);



