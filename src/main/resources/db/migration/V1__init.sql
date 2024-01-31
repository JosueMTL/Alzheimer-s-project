CREATE TABLE IF NOT EXISTS caregivers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    last_name VARCHAR(50),
    user_name VARCHAR(50),
    gmail VARCHAR(70),
    password VARCHAR(50),
    relationship VARCHAR(55)
    );

CREATE TABLE IF NOT EXISTS alarm (
    id SERIAL PRIMARY KEY,
    title VARCHAR(75),
    time TIME,
    repeat BOOLEAN,
    date DATE,
    caregivers_id INT,
    FOREIGN KEY (caregivers_id) REFERENCES caregivers(id)
    );

CREATE TABLE IF NOT EXISTS patient (
    id SERIAL PRIMARY KEY,
    name VARCHAR(55),
    last_name VARCHAR (55),
    age INTEGER,
    date_diagnosis DATE,
    address VARCHAR(55),
    stage VARCHAR(55),
    alarm_id INT,
    FOREIGN KEY (alarm_id) REFERENCES alarm(id)
    );

CREATE TABLE IF NOT EXISTS interactions (
    id SERIAL PRIMARY KEY,
    message VARCHAR (200),
    response VARCHAR (100),
    date_time_interaction TIMESTAMP,
    request BOOLEAN,
    patient_id INT,
    FOREIGN KEY (patient_id) REFERENCES patient(id)
    );

CREATE TABLE IF NOT EXISTS card (
    id SERIAL PRIMARY KEY,
    date_time TIMESTAMP,
    location VARCHAR(55),
    interactions_id INT,
    patient_id INT,
    FOREIGN KEY (interactions_id) REFERENCES interactions(id),
    FOREIGN KEY (patient_id) REFERENCES patient(id)
    );

CREATE TABLE IF NOT EXISTS reminders (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50),
    description VARCHAR(75),
    date DATE,
    time TIME,
    status VARCHAR (75),
    repeat BOOLEAN,
    patiente VARCHAR(75),
    caregivers_id INT,
    patient_id INT,
    FOREIGN KEY (caregivers_id) REFERENCES caregivers(id),
    FOREIGN KEY (patient_id) REFERENCES patient(id)
    );

CREATE TABLE IF NOT EXISTS configurations (
    id SERIAL PRIMARY KEY,
    volume INT,
    alert_tones VARCHAR(55),
    caregivers_id INT,
    FOREIGN KEY (caregivers_id) REFERENCES caregivers(id)
    );

CREATE TABLE IF NOT EXISTS users (
    id SERIAL,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(80) NOT NULL,
    email VARCHAR(60) NOT NULL,
    locked BOOLEAN NOT NULL,
    disabled BOOLEAN NOT NULL,
    UNIQUE (username),
    UNIQUE (email),
    PRIMARY KEY (id),
    caregivers_id INT,
    patient_id INT,
    FOREIGN KEY (caregivers_id) REFERENCES caregivers(id),
    FOREIGN KEY (patient_id) REFERENCES patient(id)
    );

CREATE TABLE IF NOT EXISTS role (
    id SERIAL,
    role VARCHAR(25) NOT NULL,
    user_id INTEGER NOT NULL,
    UNIQUE (role, user_id),
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
    );