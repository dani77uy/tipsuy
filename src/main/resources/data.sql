create sequence element_seq;
create sequence post_seq;

create table country
(
    id      bigint default element_seq.nextval,
    name    varchar2(50 char) unique not null,
    alias   varchar2(10 char) unique  not null,
    iso     varchar2(3 char) unique  null,
    hashtag varchar2(15 char) unique not null,
    constraint pk_country primary key (id)
);

create table tournament
(
    id                bigint  default element_seq.nextval,
    name              varchar2(25 char)        not null,
    hashtag           varchar2(15 char)        not null,
    twitter_account   varchar2(50 char) unique null,
    instagram_account varchar2(50 char) unique null,
    is_international  boolean default false    not null,
    country_id        bigint                   null,
    constraint pk_tournament primary key (id),
    constraint fk_tourn_count foreign key (country_id) references country (id)
);

create table team
(
    id                bigint  default element_seq.nextval,
    name              varchar2(25 char)        not null,
    twitter_account   varchar2(50 char) unique null,
    instagram_account varchar2(50 char) unique null,
    hashtag_1         varchar2(15 char)        not null,
    hashtag_2         varchar2(15 char)        null,
    hashtag_3         varchar2(15 char)        null,
    country_id        bigint                   not null,
    is_national_team  boolean default false    not null,
    constraint pk_team primary key (id),
    constraint fk_team_count foreign key (country_id) references country (id)
);

create table player
(
    id                bigint default element_seq.nextval,
    name              varchar2(30 char)        not null,
    alias             varchar2(30 char)        null,
    twitter_account   varchar2(50 char) unique null,
    instagram_account varchar2(50 char) unique null,
    nationality_id    bigint                   not null,
    constraint pk_player primary key (id),
    constraint fk_play_count foreign key (nationality_id) references country (id)
);

create table twitter_post
(
    id            bigint   default post_seq.nextval,
    tournament_id bigint            not null,
    home_team     bigint            not null,
    away_team     bigint            not null,
    goals_home    smallint default 0,
    goals_away    smallint default 0,
    start_date    integer           not null,
    start_time    integer           not null,
    timezone      varchar2(10 char) null,
    venue         varchar2(60 char) null,
    style         smallint default 1,
    constraint pk_twitter_post primary key (id),
    constraint fk_twpo_tourn foreign key (tournament_id) references tournament (id),
    constraint fk_twpo_hteam foreign key (home_team) references team (id),
    constraint fk_twpo_ateam foreign key (away_team) references team (id)
);

insert into country(name, alias, iso, hashtag) values ('Argentina','ar','ARG','Argentina');
insert into country(name, alias, iso, hashtag) values ('Bolivia','bo','BOL','Bolivia');
insert into country(name, alias, iso, hashtag) values ('Brazil','br','BRA','Brasil');
insert into country(name, alias, iso, hashtag) values ('Chile','cl_flag','CHL','Chile');
insert into country(name, alias, iso, hashtag) values ('Colombia','co','COL','Colombia');
insert into country(name, alias, iso, hashtag) values ('Costa Rica','cr','CRI','CostaRica');
insert into country(name, alias, iso, hashtag) values ('Ecuador','ec','ECU','Ecuador');
insert into country(name, alias, iso, hashtag) values ('England','en','ENG','England');
insert into country(name, alias, iso, hashtag) values ('El Salvador','sv','SLV','ElSalvador');
insert into country(name, alias, iso, hashtag) values ('France','fr','FRA','France');
insert into country(name, alias, iso, hashtag) values ('Germany','de','DEU','Deutschland');
insert into country(name, alias, iso, hashtag) values ('Guatemala','gt','GTM','Guatemala');
insert into country(name, alias, iso, hashtag) values ('Honduras','hn','HND','Honduras');
insert into country(name, alias, iso, hashtag) values ('Italy','it','ITA','Italia');
insert into country(name, alias, iso, hashtag) values ('Mexico','mx','MEX','Mexico');
insert into country(name, alias, iso, hashtag) values ('Netherlands','nl','NLD','Nederlanden');
insert into country(name, alias, iso, hashtag) values ('Panama','pa','PAN','Panama');
insert into country(name, alias, iso, hashtag) values ('Paraguay','py','PRY','Paraguay');
insert into country(name, alias, iso, hashtag) values ('Peru','pe','PER','Peru');
insert into country(name, alias, iso, hashtag) values ('Spain','es','ESP','Espana');
insert into country(name, alias, iso, hashtag) values ('Switzerland','ch','CHE','Swiss');
insert into country(name, alias, iso, hashtag) values ('USA','us','USA','USA');
insert into country(name, alias, iso, hashtag) values ('Uruguay','uy','URY','Uruguay');
insert into country(name, alias, iso, hashtag) values ('Venezuela','ve','VEN','Venezuela');
