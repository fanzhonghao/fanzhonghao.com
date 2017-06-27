use travel_and_book_sys;
select custName,resvFromCity as FromCity,resvArivCity as ArivCity/*旅游线路*/
from RESERVATIONS
where resvType = 1
order by custName;

select distinct a.custName  /*路线完整*/
from RESERVATIONS as a inner join RESERVATIONS as b
where a.custName = b.custName and a.resvType = b.resvType and a.resvType = 1
and a.resvFromCity = b.resvArivCity and a.resvArivCity = b.resvFromCity;

select CUSTOMERS.custName/*路线不完整*/
from CUSTOMERS
where CUSTOMERS.custName not in(
  select distinct a.custName
  from RESERVATIONS as a inner join RESERVATIONS as b
  where a.custName = b.custName and a.resvType = b.resvType and a.resvType = 1
  and a.resvFromCity = b.resvArivCity and a.resvArivCity = b.resvFromCity
);
