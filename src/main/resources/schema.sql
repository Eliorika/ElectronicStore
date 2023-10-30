create table if not exists answers_log(
    id identity,
    answeredAt timestamp not null,
    question long not null,
    answer varchar(70) not null
);

create table if not exists questions(
    id identity,
    question varchar(70) not null,
    answer varchar(30) not null
);

alter table answers_log add foreign key (question) references questions(id);