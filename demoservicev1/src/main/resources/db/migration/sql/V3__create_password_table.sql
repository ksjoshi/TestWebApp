create table pwd (
  id bigint(20),
  pwd varchar(60),
  foreign key (id)
  references users (id)
);