CREATE TABLE IF NOT EXISTS task (
    task_id SERIAL PRIMARY KEY,
    task_type VARCHAR(255),
    task_title VARCHAR(255),
    task_content VARCHAR(255),
    created_time TIMESTAMP,
    completed BOOLEAN
);

INSERT INTO task (task_type, task_title, task_content, created_time, completed)
VALUES
    ('Programowanie', 'Aplikacja TODO', 'Wykonanie szkieletu aplikacji', NOW(), false),
    ('Sport', 'Trening', 'Pompki', NOW(), false),
    ('Hobby', 'Szachy', 'Poćwiczyć gambit hetmański', NOW(), false);