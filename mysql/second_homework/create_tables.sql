use travel;
create table FLIGHTS(
  flightNum numeric(10) primary key not null,
  fromCity char(20) not null,
  toCity char(20) not null,
  price numeric(10) not null check (price > 0)
);

create table HOTELS(
  location char(20) not null primary key,
  price numeric(10) not null check (price > 0)
);

create table BUS(
  location char(20) not null primary key,
  price numeric(10) not null check (price > 0)
);

create table CUSTOMER(
  custName char(20) not null,
  custId numeric(18) not null primary key
);

create table RESERVATIONS(
  custName char(20) not null,
  custId numeric(18) not null,
  foreign key (custID) references CUSTOMER(custID),
  type char(10) not null check (type in ("FLIGHTS","HOTELS","BUS")),
  fromCity char(20) not null,
  toCity char(20) not null
);
