create table users
(
    id         serial primary key,
    name       varchar not null,
    login      varchar not null,
    created_at timestamp

);

create table posts(
    id serial primary key,
    description varchar,
    author_id int references users(id) not null,
    created_at timestamp,
    photo_url varchar

    )

