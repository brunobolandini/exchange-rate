DROP TABLE IF EXISTS RATE_DETAILS;

create table RATE_DETAILS (
    ID            bigint identity not null primary key,
    SUCCESS       nvarchar,
    BASE          nvarchar(50),
    DATE          nvarchar(50),
    TIMESTAMP     nvarchar(50),
    UPDATED_ON    TIMESTAMP
);
