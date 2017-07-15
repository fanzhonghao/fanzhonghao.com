use travel_and_book_sys;
select custName,sum(price) as flight_cost
from FLIGHTS as a inner join RESERVATIONS as b
on a.FromCity = b.resvFromCity and a.ArivCity = b.resvArivCity
group by custName;

select custName,sum(price) as hotel_cost
from HOTELS as a inner join RESERVATIONS as b
on a.location = b.resvFromCity and a.location = b.resvArivCity and resvType  = 2
group by custName;

select custName,sum(price) as bus_cost
from BUS as a inner join RESERVATIONS as b
on a.location = b.resvFromCity and a.location = b.resvArivCity and resvType  = 3
group by custName;
