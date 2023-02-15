drop table if exists posts_t;

create table posts_t (
    id bigint not null primary key,
    create_time timestamp not null,
    edit_time timestamp not null,
    title varchar(100),
    content text
);
