use travel;
select distinct a.custName
from RESERVATIONS as a inner join RESERVATIONS as b
where a.type = b.type and a.type = "FLIGHTS" and b.type = "FLIGHTS"
and a.custId = b.custId
and (a.fromCity = b.toCity and a.toCity = b.fromCity);

select CUSTOMER.custName
from CUSTOMER
where CUSTOMER.custName not in(
  select distinct a.custName
  from RESERVATIONS as a inner join RESERVATIONS as b
  where a.type = b.type and a.type = "FLIGHTS" and b.type = "FLIGHTS"
  and a.custId = b.custId
  and (a.fromCity = b.toCity and a.toCity = b.fromCity)
);
