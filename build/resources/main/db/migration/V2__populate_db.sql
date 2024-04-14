INSERT INTO Client (name) VALUES
    ('Client 1'),
    ('Client 2'),
    ('Client 3'),
    ('Client 4'),
    ('Client 5'),
    ('Client 6'),
    ('Client 7'),
    ('Client 8'),
    ('Client 9'),
    ('Client 10');

INSERT INTO Planet (id, name) VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('EARTH', 'Earth'),
    ('JUP', 'Jupiter'),
    ('SAT', 'Saturn');

INSERT INTO Ticket (client_id, from_planet_id, to_planet_id) VALUES
    (1, 'MARS', 'VEN'),
    (2, 'EARTH', 'JUP'),
    (3, 'VEN', 'MARS'),
    (4, 'MARS', 'SAT'),
    (5, 'SAT', 'EARTH'),
    (6, 'JUP', 'MARS'),
    (7, 'VEN', 'SAT'),
    (8, 'EARTH', 'MARS'),
    (9, 'JUP', 'SAT'),
    (10, 'SAT', 'VEN');