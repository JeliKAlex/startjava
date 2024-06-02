\c robots;

DROP TABLE  IF EXISTS Jaegers;

CREATE TABLE Jaegers (
    id SERIAL PRIMARY KEY,
    model_name TEXT,
    mark CHAR(6),
    height NUMERIC,
    weight NUMERIC,
    status TEXT,
    origin TEXT,
    launch DATE,
    kaiju_kill INTEGER
);

\ir populate.sql;
\ir queries.sql;

