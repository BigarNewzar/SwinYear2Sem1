begin transaction
INSERT INTO [dbo].[Transactions] 
([TransactionId], [Firstname], [Lastname], [Email], [Address], [Suburb], [Postcode], [Phone], [Product], [Quantity], [Comment], [Credit_card_name], [Credit_card_number], [Credit_card_expiry_date], [Credit_card_CVV]) VALUES ('10005',	'TestData',	'TestData',	'smth@gmail.com',	'blah',	'blah',	'3123',	'0123456789',	'Stark',	'10',	'smth',	'blahblah',	'0123456789012345',	'0347',	'576')
commit