CREATE TABLE IF NOT EXISTS Person(
	uid NUMERIC AUTO_INCREMENT PRIMARY KEY NOT NULL,
	name VARCHAR(255),
	occupation VARCHAR(255),
	description VARCHAR(255),
	age numeric
);