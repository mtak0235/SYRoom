CREATE TABLE IF NOT EXISTS payment (
                                       id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS storage_request (
                                               id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS storage (
                                       id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY
);
