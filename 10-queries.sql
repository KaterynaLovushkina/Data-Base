
use Labor_SQL;

-- SQL query 1
SELECT model, speed, hd, price
FROM Laptop
WHERE screen >=12
ORDER BY price ;

-- SQL query 2
SELECT * 
FROM Outcome
where MONTH(date) = 3;

-- SQL query 3
SELECT Pc.model, Product.maker
FROM Pc JOIN Product ON Pc.model = Product.model
WHERE Pc.price < 600
GROUP BY Pc.model;

-- SQL query 4
SELECT DISTINCT maker
FROM Product 
WHERE type = 'Pc' and not maker <> ALL(SELECT maker FROM Product WHERE type = 'Laptop');

-- SQL query 5
SELECT maker 
FROM Product 
where type ='Laptop' and 
      maker not in (SELECT maker FROM Product where type ='Printer');

-- SQL query 6
SELECT 'Average price = ',round(avg(price), 2)
FROM Laptop

-- SQL query 7
SELECT maker, price
FROM Product JOIN Printer ON Product.model = Printer.model
WHERE color ='n' and price = (SELECT min(price) FROM Printer WHERE color ='n')

-- SQL query 8
select * 
From Laptop JOIN Product on Laptop.model = Product.model;
SELECT maker,
       (SELECT Count(model) FROM Laptop WHERE model in (SELECT model FROM Product WHERE maker = pr.maker))laptop,
	   (SELECT Count(model) FROM Printer WHERE model in (SELECT model FROM Product WHERE maker = pr.maker)) printer,
       (SELECT Count(model) FROM Pc WHERE model in (SELECT model FROM Product WHERE maker = pr.maker)) pc
FROM Product  as pr
GROUP BY maker;

-- SQL query 9
select point, date, round(sum(case when incs is null then 0 else incs end)) sum_income,
                    round(sum(case when outs is null then 0 else outs end)) sum_outcome
from(
SELECT Income.point, Income.date, sum(inc) incs, null outs
  FROM Income 
  Group by point,  date
union
SELECT point, date, null incs, sum(oc.out)
  FROM Outcome as oc
  Group by point, date) tab
Group by point, date;

-- SQL query 10
SELECT maker, Printer.model, Product.type, price
FROM Product JOIN Printer ON Product.model = Printer.model WHERE Product.maker = 'B'
UNION
SELECT maker, Laptop.model, type, price
FROM Product JOIN Laptop ON Product.model = Laptop.model WHERE Product.maker = 'B'
UNION
SELECT maker, Pc.model, type, price
FROM Product JOIN Pc ON Product.model = Pc.model WHERE Product.maker = 'B';
