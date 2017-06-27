use travel_and_book_sys;
select custName,resvFromCity as FromCity,resvArivCity as ArivCity
from RESERVATIONS
where custName = "Liming" and resvType = 1;

select custName,resvFromCity as FromCity,resvArivCity as ArivCity
from RESERVATIONS
where custName = "Hanmeimei" and resvType = 1;

select custName,resvFromCity as FromCity,resvArivCity as ArivCity
from RESERVATIONS
where custName = "Xiaohong" and resvType = 1;

select custName,resvFromCity as FromCity,resvArivCity as ArivCity
from RESERVATIONS
where custName = "Lihua" and resvType = 1;

select custName,resvFromCity as FromCity,resvArivCity as  ArivCity
from RESERVATIONS
where custName = "Lilei" and resvType = 1;

select custName,resvFromCity as FromCity,resvArivCity as ArivCity
from RESERVATIONS
where resvType = 1
order by custName;
