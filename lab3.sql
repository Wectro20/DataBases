CREATE SCHEMA IF NOT EXISTS lab3;
USE lab3 ;

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
	wind_direction CHAR NOT NULL,
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
