CREATE TABLE [dbo].[Transactions] (
    [TransactionId]           VARCHAR (5)   NOT NULL,
    [Firstname]               VARCHAR (20)  NOT NULL,
    [Lastname]                VARCHAR (20)  NOT NULL,
    [Email]                   VARCHAR (30)  NOT NULL,
    [Address]                 VARCHAR (30)  NOT NULL,
    [Suburb]                  VARCHAR (30)  NOT NULL,
    [Postcode]                VARCHAR (4)   NOT NULL,
    [Phone]                   VARCHAR (10)  NOT NULL,
    [Price]                   VARCHAR (10)  NOT NULL,
    [Quantity]                VARCHAR (10)  NOT NULL,
    [Comment]                 VARCHAR (100) NOT NULL,
    [Credit_card_name]        VARCHAR (40)  NOT NULL,
    [Credit_card_number]      VARCHAR (16)  NOT NULL,
    [Credit_card_expiry_date] VARCHAR (4)   NOT NULL,
    [Credit_card_CVV]         VARCHAR (3)   NOT NULL,
    PRIMARY KEY CLUSTERED ([TransactionId] ASC)
);

