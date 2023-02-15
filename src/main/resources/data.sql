drop table if exists posts_t;
drop table if exists users_t;

create table users_t
(
    id        bigint       not null primary key,
    name      varchar(100) not null,
    info      text,
    join_time timestamp
);

create table posts_t
(
    id          bigint    not null primary key,
    user_id     bigint,
    create_time timestamp not null,
    edit_time   timestamp not null,
    title       varchar(100),
    content     text,
    foreign key (user_id) references users_t (id)
);