use travel;
insert into FLIGHTS
  values (1,"shanghai","beijing",300),
  (2,"beijing","shanghai",400),
  (3,"beijing","wuhan",200),
  (4,"wuhan","beijing",100);

insert into HOTELS
  values ("shanghai",100),
  ("beijing",90),
  ("wuhan",80);

insert into BUS
  values ("shanghai",50),
  ("beijing",40),
  ("wuhan",30);

insert into CUSTOMER
  values ("Liming",1234),
  ("Hanmeimei",1235),
  ("Xiaohong",1236);

insert into RESERVATIONS
  values ("Liming",1234,"FLIGHTS","beijing","shanghai"),
  ("Liming",1234,"FLIGHTS","shanghai","beijing"),
  ("Hanmeimei",1235,"FLIGHTS","shanghai","beijing"),
  ("Hanmeimei",1235,"FLIGHTS","beijing","wuhan"),
  ("Hanmeimei",1235,"FLIGHTS","wuhan","beijing"),
  ("Hanmeimei",1235,"FLIGHTS","beijing","shanghai"),
  ("Xiaohong",1236,"FLIGHTS","wuhan","beijing"),
  ("Liming",1234,"HOTELS","shanghai","shanghai"),
  ("Liming",1234,"BUS","shanghai","shanghai"),
  ("Liming",1234,"HOTELS","beijing","beijing"),
  ("Hanmeimei",1235,"HOTELS","wuhan","wuhan"),
  ("Hanmeimei",1235,"BUS","wuhan","wuhan"),
  ("Xiaohong",1236,"HOTELS","beijing","beijing");
