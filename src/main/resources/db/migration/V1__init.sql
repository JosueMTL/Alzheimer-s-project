CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    gmail VARCHAR(255),
    password VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS configurations (
    id SERIAL PRIMARY KEY,
    users_id INT,
    volume INT,
    alert_tones VARCHAR(255),
    FOREIGN KEY (users_id) REFERENCES users(id)
    );

CREATE TABLE IF NOT EXISTS patienteInfo (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    date_birth DATE,
    date_diagnosis DATE,
    stage INT
    );

CREATE TABLE IF NOT EXISTS reminders (
    id SERIAL PRIMARY KEY,
    users_id INT,
    patientInfo_id INT,
    title VARCHAR(255),
    description TEXT,
    date DATE,
    time TIME,
    status VARCHAR (500),
    active BOOLEAN,
    FOREIGN KEY (users_id) REFERENCES users(id),
    FOREIGN KEY (patientInfo_id) REFERENCES patienteInfo(id)
    );

CREATE TABLE IF NOT EXISTS interactions (
    id SERIAL PRIMARY KEY,
    patienteInfo_id INT,
    users_message VARCHAR (200),
    assistant_response VARCHAR (200),
    date_time_interaction TIMESTAMP,
    request BOOLEAN,
    FOREIGN KEY (patienteInfo_id) REFERENCES patienteInfo(id)
    );

CREATE TABLE IF NOT EXISTS rfid_tags (
    id SERIAL PRIMARY KEY,
    interaction_id INT,ccccc
    users_id INT,
    read_date DATE,
    location VARCHAR(255),
    FOREIGN KEY (interaction_id) REFERENCES interactions(id),
    FOREIGN KEY (users_id) REFERENCES users(id)
    );