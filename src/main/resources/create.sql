CREATE SCHEMA IF NOT EXISTS lab4;
USE lab4;

DROP TABLE IF EXISTS weather_weekly_forecast;
DROP TABLE IF EXISTS forecast;
DROP TABLE IF EXISTS weather_status;
DROP TABLE IF EXISTS weather_warning;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS country;
DROP TABLE IF EXISTS days;

CREATE TABLE IF NOT EXISTS weather_status (
	id INT NOT NULL AUTO_INCREMENT,
	weather_st VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS weather_warning (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(45) NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS city (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(45) NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS country (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(45) NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS days (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(45) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS forecast (
	id INT NOT NULL AUTO_INCREMENT,
	weather_status_id INT NOT NULL,
	weather_warning_id INT NOT NULL,
	day_id INT NOT NULL,
	temperature FLOAT NOT NULL,
	feels_like_temperature FLOAT NOT NULL,
	humidity_in_percentage FLOAT NOT NULL,
	wind_speed_in_mph FLOAT NOT NULL,
	wind_direction VARCHAR NOT NULL,
	date DATE NOT NULL,
	week_date DATE NOT NULL,
	PRIMARY KEY (id),
	INDEX weather_status_id_idx (weather_status_id ASC),
  	INDEX weather_warning_id_idx (weather_warning_id ASC),
  	INDEX day_id_idx (day_id ASC) ,
	CONSTRAINT weather_status_id
		FOREIGN KEY (weather_status_id)
		REFERENCES weather_status (id),
	CONSTRAINT weather_warning_id
		FOREIGN KEY (weather_warning_id)
		REFERENCES weather_warning (id),
	CONSTRAINT day_id
		FOREIGN KEY (day_id)
    		REFERENCES days (id)
);

CREATE TABLE IF NOT EXISTS weather_weekly_forecast (
	id INT NOT NULL AUTO_INCREMENT,
	country_weakly_id INT NOT NULL,
	city_weakly_id INT NOT NULL,
	forecast_id INT NOT NULL,
	week_date DATE NOT NULL,
	source_system VARCHAR(45) NOT NULL,
	PRIMARY KEY (id),
	INDEX country_id_idx (country_weakly_id ASC),
	INDEX city_id_idx (city_weakly_id ASC),
	INDEX forecast_id_idx (forecast_id ASC),
	CONSTRAINT country_weakly_id
		FOREIGN KEY (country_weakly_id)
		REFERENCES country (id),
	CONSTRAINT city_weakly_id
		FOREIGN KEY (city_weakly_id)
		REFERENCES city (id),
	CONSTRAINT forecast_id
		FOREIGN KEY (forecast_id)
		REFERENCES forecast (id)
);

INSERT INTO weather_status (weather_st) VALUES
    ('Sunny'),
    ('Cloudy'),
    ('Windy'),
    ('Rainy'),
    ('Snowy'),
    ('Foggy'),
    ('Stormy');

INSERT INTO country (name) VALUES
    ('Ukraine'),
    ('Germany'),
    ('Poland'),
    ('USA');

INSERT INTO weather_warning (name) VALUES
    ('Blizzard Warning !'),
    ('Winter Storm Warring !'),
    ('Ice Storm Warning !'),
    ('High Wind Warning !'),
    ('Severe Thunderstorm Warning !'),
    ('Tornado Warning !'),
    ('Storm Warning !'),
    ('Special Marine Warning !'),
    ('Coastal Flood Warning !'),
    ('Flash Flood Warning !'),
    ('Excessive Heat Warning !'),
    (' ');

INSERT INTO city (name) VALUES
    ('Lviv'),
    ('Kyiv'),
    ('Odessa'),
    ('Hamburg'),
    ('Berlin'),
    ('Frankfurt'),
    ('Warsaw'),
    ('Krakow'),
    ('Gdansk'),
    ('New York'),
    ('Los Angeles'),
    ('San Francisco');

INSERT INTO days (name) VALUES
    ('Monday'),
    ('Tuesday'),
    ('Wednesday'),
    ('Thursday'),
    ('Friday'),
    ('Saturday'),
    ('Sunday');

INSERT INTO forecast (weather_status_id, weather_warning_id, day_id, temperature, feels_like_temperature, humidity_in_percentage, wind_speed_in_mph, wind_direction, date, week_date) VALUES
    (1, 12, 1, '13', '11', '51', '26', 'W', '2021-10-11', '2021-10-11'),
    (2, 12, 2, '12', '10', '45', '26', 'S', '2021-10-12', '2021-10-11'),
    (3, 12, 3, '7', '8', '68', '26', 'E', '2021-10-13', '2021-10-11'),
    (4, 7, 4, '4', '3', '52', '26', 'N', '2021-10-14', '2021-10-11'),
    (5, 2, 5, '0', '-1', '48', '26', 'W', '2021-10-15', '2021-10-11'),
    (6, 12, 6, '13', '11', '53', '26', 'E', '2021-10-16', '2021-10-11'),
    (7, 1, 7, '13', '11', '49', '26', 'S', '2021-10-17', '2021-10-11'),
    (1, 12, 1, '13', '11', '51', '26', 'W', '2021-10-18', '2021-10-18'),
    (2, 12, 2, '12', '10', '45', '26', 'S', '2021-10-19', '2021-10-18'),
    (3, 12, 3, '7', '8', '68', '26', 'E', '2021-10-20', '2021-10-18'),
    (4, 7, 4, '4', '3', '52', '26', 'N', '2021-10-21', '2021-10-18'),
    (5, 2, 5, '0', '-1', '48', '26', 'W', '2021-10-22', '2021-10-18'),
    (6, 12, 6, '13', '11', '53', '26', 'E', '2021-10-23', '2021-10-18'),
    (7, 1, 7, '13', '11', '49', '26', 'S', '2021-10-24', '2021-10-18');

INSERT INTO weather_weekly_forecast (country_weakly_id, city_weakly_id, forecast_id, week_date, source_system) VALUES
    (3, 6, 1, '2021-10-11', 'AccuWeather'),
    (3, 6, 14, '2021-10-18', 'AccuWeather');