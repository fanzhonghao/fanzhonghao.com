use travel;
select custName,sum(price) as flight_cost
from FLIGHTS as a inner join RESERVATIONS as b
on a.fromCity = b.fromCity and a.toCity = b.toCity
group by custName;

select custName,sum(price) as hotel_cost
from HOTELS as a inner join RESERVATIONS as b
on a.location = b.fromCity and a.location = b.toCity
group by custName;

select custName,sum(price) as bus_cost
from BUS as a inner join RESERVATIONS as b
on a.location = b.fromCity and a.location = b.toCity
group by custName;
