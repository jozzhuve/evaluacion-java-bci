CREATE TABLE client
(
    id         UUID PRIMARY KEY,
    name       VARCHAR(250),
    email      VARCHAR(250),
    password   VARCHAR(250),
    created    DATE,
    modified   DATE,
    last_Login DATE,
    is_Active  BOOLEAN
);

CREATE TABLE phone
(
    id          UUID PRIMARY KEY,
    id_client   UUID,
    number      VARCHAR(250),
    cityCode    VARCHAR(250),
    countryCode VARCHAR(250),
);

ALTER TABLE phone
    ADD FOREIGN KEY (id_client)
        REFERENCES client (id);
