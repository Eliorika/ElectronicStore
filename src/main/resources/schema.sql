create table IF NOT EXISTS questions
(
    id       bigserial
        primary key,
    answer   varchar,
    question varchar
);

alter table questions
    owner to arina;

create table IF NOT EXISTS users
(
    id       bigserial
        primary key,
    email varchar(255) unique,
    login    varchar(255) unique,
    password varchar(255)
);

create table IF NOT EXISTS answers_logs
(
    id          bigserial
        primary key,
    answer      varchar(255),
    answered_at timestamp(6),
    question_id bigint not null
        constraint fk_questions
            references questions on DELETE cascade ,
    user_id     bigint not null
        constraint fk_users
            references users on DELETE cascade
);
