DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS planet;

CREATE TABLE IF NOT EXISTS Client (
    id SERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3),
    CONSTRAINT name_length_check CHECK (LENGTH(name) <= 200)
);

CREATE TABLE IF NOT EXISTS Planet (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(500) NOT NULL CHECK (LENGTH(name) >= 1),
    CONSTRAINT id_format_check CHECK (id ~ '^[A-Z0-9]+$'),
    CONSTRAINT name_length_check CHECK (LENGTH(name) <= 500)
);

CREATE TABLE IF NOT EXISTS Ticket (
    id SERIAL PRIMARY KEY,
    created_at TIMESTAMP WITHOUT TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    client_id INT NOT NULL,
    from_planet_id VARCHAR(10) NOT NULL,
    to_planet_id VARCHAR(10) NOT NULL,
    CONSTRAINT fk_client FOREIGN KEY (client_id) REFERENCES Client(id),
    CONSTRAINT fk_from_planet FOREIGN KEY (from_planet_id) REFERENCES Planet(id),
    CONSTRAINT fk_to_planet FOREIGN KEY (to_planet_id) REFERENCES Planet(id)
);