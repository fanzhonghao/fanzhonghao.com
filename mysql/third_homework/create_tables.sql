use  travel_and_book_sys;
create table FLIGHTS(
  flightNum char(30) not null primary key,
  price int not null,
  numSeats int not null,
  numAvail int not null,
  FromCity char(30) not null,
  ArivCity char(30) not null
  check (numAvail >= 0)
);
create table HOTELS(
  location char(30) not null primary key,
  price int not null check(price >= 0),
  numRooms int not null,
  numAvail int not null
  check (numAvail >= 0)
);
create table BUS(
  location char(30) not null primary key,
  price int not null check(price >= 0),
  numBus int not null,
  numAvail int not null
  check (numAvail >= 0)
);
create table CUSTOMERS(
  custName char(30) not null primary key,
  custID char(30) not null,
  custLocation char(30) not null
);
create table RESERVATIONS(
  custName char(30) not null,
  resvType int not null check (resvType in (1,2,3)),
  resvKey char(30) not null primary key,
  resvFromCity char(30) not null,
  resvArivCity char(30) not null,
  check (resvType > 0 and resvType < 4),
  foreign key (custName) references CUSTOMERS(custName)
);
show tables;
