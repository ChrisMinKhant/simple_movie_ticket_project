-- Create users Table --
CREATE TABLE IF NOT EXISTS users(
    name varchar(255) NOT NULL,
    age varchar(3) NOT NULL,
    phone varchar(20) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    enabled boolean DEFAULT true,
    address varchar(255) NOT NULL,
    PRIMARY KEY(email)
);

-- Create roles table --
CREATE TABLE IF NOT EXISTS roles(
    id int NOT NULL AUTO_INCREMENT,
    email varchar(255) NOT NULL,
    role varchar(255) NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_user_email FOREIGN KEY(email) REFERENCES users(email)
);

-- Create movies Table --
CREATE TABLE IF NOT EXISTS movies(
    id int NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    description varchar(255) NOT NULL,
    pg varchar(255) NOT NULL,
    rating varchar(255) NOT NULL,
    PRIMARY KEY(id)
);

-- Create theaters Table --
CREATE TABLE IF NOT EXISTS theaters(
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    phone varchar(20) NOT NULL,
    email varchar(255) NOT NULL,
    PRIMARY KEY(id)
);

-- Create show_times Table --
CREATE TABLE IF NOT EXISTS show_times(
    id int NOT NULL AUTO_INCREMENT,
    times varchar(255) NOT NULL,
    PRIMARY KEY(id)
);

-- Create prices Table --
CREATE TABLE IF NOT EXISTS prices(
    id int NOT NULL AUTO_INCREMENT,
    prices varchar(255) NOT NULL,
    PRIMARY KEY(id)
);

-- Create tickets Table --
CREATE TABLE IF NOT EXISTS tickets(
    id int NOT NULL AUTO_INCREMENT,
    movie_id int NOT NULL,
    theater_id int NOT NULL,
    show_times_id int NOT NULL,
    prices_id int NOT NULL,
    PRIMARY KEY(id),
    CONSTRAINT FK_movie_id FOREIGN KEY(movie_id) REFERENCES movies(id),
    CONSTRAINT FK_theater_id FOREIGN KEY(theater_id) REFERENCES theaters(id),
    CONSTRAINT FK_show_times_id FOREIGN KEY(show_times_id) REFERENCES show_times(id),
    CONSTRAINT FK_prices_id FOREIGN KEY(prices_id) REFERENCES prices(id)
);