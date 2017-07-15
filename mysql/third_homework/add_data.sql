/*该系统假定旅客只能通过飞机进行城市间的转移，大巴车只供城市内游玩*/
use travel_and_book_sys;
insert into FLIGHTS/*flightNum,price,numSeats,numAvail,FromCity,ArivCity*/
  values (1,300,40,30,"shanghai","beijing"),
  (2,300,40,30,"beijing","shanghai"),
  (3,300,40,30,"beijing","wuhan"),
  (4,300,40,30,"wuhan","beijing"),
  (5,300,40,30,"wuhan","tianjing"),
  (6,300,40,30,"tianjing","wuhan"),
  (7,300,40,30,"tianjing","xian"),
  (8,300,40,30,"xian","tianjing");

insert into HOTELS/*location,price,numRooms,numAvail*/
  values ("shanghai",100,30,20),
  ("beijing",100,30,20),
  ("tianjing",100,30,20),
  ("wuhan",100,20,10),
  ("xian",100,20,10);

insert into BUS /*location,price,numBus,numAvail*/
  values ("shanghai",50,20,12),
  ("beijing",50,20,14),
  ("tianjing",50,20,13),
  ("wuhan",50,20,15),
  ("xian",50,20,15);

insert into CUSTOMERS/*custName,custID,custLocation*/
  values ("Liming",1234,"beijing"),
  ("Hanmeimei",1235,"shanghai"),
  ("Lihua",1236,"tianjing"),
  ("Xiaohong",1237,"wuhan"),
  ("Lilei",1238,"xian");

insert into RESERVATIONS/*custName,resvType,resvKey,resvFromCity,resvArivCity*/
  values ("Liming",1,1,"beijing","shanghai"),
  ("Liming",1,2,"shanghai","beijing"),
  ("Hanmeimei",1,3,"shanghai","beijing"),
  ("Hanmeimei",1,4,"beijing","wuhan"),
  ("Hanmeimei",1,5,"wuhan","beijing"),
  ("Hanmeimei",1,6,"beijing","shanghai"),
  ("Xiaohong",1,7,"wuhan","beijing"),
  ("Xiaohong",1,8,"beijing","wuhan"),
  ("Lihua",1,9,"tianjing","xian"),
  ("Lihua",1,10,"xian","tianjing"),
  ("Lilei",1,11,"xian","tianjing"),
  ("Liming",2,12,"shanghai","shanghai"),
  ("Hanmeimei",2,13,"wuhan","wuhan"),
  ("Xiaohong",2,14,"beijing","beijing"),
  ("Lihua",2,15,"xian","xian"),
  ("Liming",3,16,"shanghai","shanghai"),
  ("Hanmeimei",3,17,"beijing","beijing"),
  ("Xiaohong",3,18,"beijing","beijing"),
  ("Lihua",3,19,"tianjing","tianjing"),
  ("Lihua",3,20,"xian","xian"),
  ("Lilei",3,21,"tianjing","tianjing");
