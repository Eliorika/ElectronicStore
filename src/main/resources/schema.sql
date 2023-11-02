create table if not exists answers_logs(
    id identity,
    answeredAt timestamp not null,
    questionId long not null,
    answer varchar not null
);

create table if not exists questions(
    id identity,
    question varchar not null,
    answer varchar not null
);

alter table answers_logs add foreign key (questionId) references questions(id);