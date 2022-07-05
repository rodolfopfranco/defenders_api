create table defender (
    id bigserial not null,
    alias varchar(128),
    name varchar(128),
    powers text,
    backstory text,
    primary key (id)
);

alter table defender add constraint UK_5r88eemotwgru6k0ilqb2ledh unique (alias);