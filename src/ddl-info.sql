create table people (
  id integer primary key generated always as identity,
  username character varying,
  password character varying,
  role character varying not null
);




create table public.items (
  id integer primary key generated always as identity,
  person_id int,
  name varchar,
  rarity character varying,
  foreign key (person_id) references public.people (id)
  match simple on update no action on delete cascade
);

