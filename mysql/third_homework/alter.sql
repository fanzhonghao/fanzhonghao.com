use travel_and_book_sys;
update FLIGHTS
set numAvail = numAvail - 1
where FromCity = 'beijing' and ArivCity = 'shanghai';

update FLIGHTS
set numAvail = numAvail - 1
where FromCity = 'shanghai' and ArivCity = 'beijing';

update FLIGHTS
set numAvail = numAvail - 1
where FromCity = "shanghai" and ArivCity = "beijing";

update FLIGHTS
set numAvail = numAvail - 1
where FromCity = "beijing" and ArivCity = "wuhan";

update FLIGHTS
set numAvail = numAvail - 1
where FromCity = "wuhan" and ArivCity = "beijing";

update FLIGHTS
set numAvail = numAvail - 1
where FromCity = "beijing" and ArivCity = "shanghai";

update FLIGHTS
set numAvail = numAvail - 1
where FromCity = "wuhan" and ArivCity = "beijing";

update FLIGHTS
set numAvail = numAvail - 1
where FromCity = "beijing" and ArivCity = "wuhan";

update FLIGHTS
set numAvail = numAvail - 1
where FromCity = "tianjing" and ArivCity = "xian";

update FLIGHTS
set numAvail = numAvail - 1
where FromCity = "xian" and ArivCity = "tianjing";

update FLIGHTS
set numAvail = numAvail - 1
where FromCity = "xian" and ArivCity = "tianjing";
