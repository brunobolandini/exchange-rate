DROP TABLE IF EXISTS RATE_DETAILS;

create table RATE_DETAILS (
    ID            bigint identity not null primary key,
    SUCCESS       BOOLEAN,
    BASE          nvarchar(50) not null unique,
    DATE          nvarchar(50),
    TIMESTAMP     TIMESTAMP,
    UPDATED_ON    TIMESTAMP
);
