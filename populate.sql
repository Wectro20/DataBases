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

INSERT INTO weather_daily_forecast (country_daily_id, city_daily_id, weather_daily_status_id, weather_daily_warning_id, start_timestamp, end_timestamp, temperature, feels_like_temperature, humidity_in_percentage, wind_speed_in_mph, wind_direction, day) VALUES
(1, 1, 1, 12, '2021-10-15 5:30:00.00', '2021-10-15 23:30:00.00', '13', '11', '51', '26', 'W', 'MON'),
(2, 4, 2, 12, '2021-10-15 5:30:00.00', '2021-10-15 23:30:00.00', '12', '10', '45', '26', 'S', 'TUE'),
(3, 7, 3, 12, '2021-10-15 5:30:00.00', '2021-10-15 23:30:00.00', '7', '8', '68', '26', 'E', 'WED'),
(4, 12, 4, 7, '2021-11-15 5:30:00.00', '2021-11-15 23:30:00.00', '4', '3', '52', '26', 'N', 'THU'),
(1, 2, 5, 2, '2021-12-15 5:30:00.00', '2021-12-15 23:30:00.00', '0', '-1', '48', '26', 'W', 'FRI'),
(2, 5, 6, 12, '2021-10-15 5:30:00.00', '2021-10-15 23:30:00.00', '13', '11', '53', '26', 'E', 'SAT'),
(3, 6, 7, 1, '2021-10-15 5:30:00.00', '2021-10-15 23:30:00.00', '13', '11', '49', '26', 'S', 'SUN');

INSERT INTO weather_weekly_forecast (country_weakly_id, city_weakly_id, weather_weakly_status_id, weather_weakly_warning_id, calendar_date, min_temperature, max_temperature, avg_humidity_in_parcentage, sunrise_time, sunset_time, last_updated_at, source_system) VALUES
(3, 6, 7, 1, '2021-10-15', '5', '15', '50', '2021-10-15 5:30:00.00', '2021-10-15 20:30:00.00', '2021-10-16 5:30:00.00', 'AccuWeather'),
(4, 12, 4, 7, '2021-10-15','7', '16', '51', '2021-10-15 5:30:00.00', '2021-10-15 20:30:00.00', '2021-10-16 5:30:00.00', 'AccuWeather'),
(1, 2, 5, 2, '2021-10-15','6', '13', '46', '2021-10-15 5:30:00.00', '2021-10-15 20:30:00.00', '2021-10-16 5:30:00.00', 'AccuWeather'),
(2, 5, 6, 12,'2021-10-15' ,'5', '12', '48', '2021-10-15 5:30:00.00', '2021-10-15 20:30:00.00', '2021-10-16 5:30:00.00', 'AccuWeather'),
(3, 6, 7, 1, '2021-10-15','8', '17', '49', '2021-10-15 5:30:00.00', '2021-10-15 20:30:00.00', '2021-10-16 5:30:00.00', 'AccuWeather'),
(1, 1, 1, 12, '2021-10-15','2', '8', '47', '2021-10-15 5:30:00.00', '2021-10-15 20:30:00.00', '2021-10-16 5:30:00.00', 'AccuWeather'),
(2, 4, 2, 12, '2021-10-15','3', '9', '36', '2021-10-15 5:30:00.00', '2021-10-15 20:30:00.00', '2021-10-16 5:30:00.00', 'AccuWeather'),
(3, 7, 3, 12, '2021-10-15','4', '10', '72', '2021-10-15 5:30:00.00', '2021-10-15 20:30:00.00', '2021-10-16 5:30:00.00', 'AccuWeather'),
(4, 12, 4, 7, '2021-10-15','2', '7', '65', '2021-10-15 5:30:00.00', '2021-10-15 20:30:00.00', '2021-10-16 5:30:00.00', 'AccuWeather');