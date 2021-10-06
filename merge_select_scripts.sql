SELECT * FROM Classes WHERE `country`='Japan' ORDER BY type ;

SELECT * FROM Outcome_o WHERE date like '%-14 %';

SELECT Passenger.ID_psg, Passenger.name,Pass_in_trip.date FROM Passenger 
INNER JOIN Pass_in_trip ON Pass_in_trip.ID_psg=Passenger.ID_psg;

SELECT distinct maker FROM Product WHERE type='PC' AND NOT maker=Any
(SELECT distinct maker FROM product where type = 'Laptop');

SELECT distinct maker FROM Product WHERE type = "Laptop" AND maker != ALL 
(SELECT distinct maker FROM Product WHERE type='Printer');

SELECT DATE_FORMAT(date, '%d.%m.%Y') FROM Income;

SELECT Product.maker, Printer.price FROM Product 
INNER JOIN Printer ON Printer.model=Product.model 
WHERE Printer.color='n'
AND Printer.price<ANY(SELECT Printer.price FROM Printer);

SELECT CONCAT('Average hd',AVG(hd)) AS AverangeHD FROM PC
INNER JOIN Product
ON PC.model=Product.model
WHERE type='PC' AND  NOT maker=ANY(SELECT maker FROM product WHERE type='Laptop');

SELECT * FROM 
(SELECT `name`, numGuns, bore, displacement, type, country, launched, classes.class, 
(numGuns=8) + (bore=15) + (displacement=32000) + (type='bb') + (country='USA') + 
(launched=1915) + (classes.class='Kon') AS n
FROM ships JOIN classes ON ships.class  = classes.class) T WHERE n >= 4;

SELECT
Product.type,
Product.model,
min(selecion.price)
FROM Product
JOIN (SELECT model, price FROM PC
UNION
SELECT model, price FROM Printer
UNION
SELECT model, price FROM Laptop
) AS selecion ON product.model = selecion.model
GROUP BY 2;