Create Table Transactions(
TransactionId Varchar(5) Not Null Primary Key,
Firstname Varchar(20) Not Null,
Lastname VARCHAR(20) Not Null,
Email VARCHAR(30) Not Null,
Address VARCHAR(30) Not Null, 
Suburb VARCHAR(30) Not Null, 
Postcode VARCHAR(4) Not Null, 
Phone VARCHAR(10) Not Null, 
Price VARCHAR(10) Not Null,       
Quantity VARCHAR(10) Not Null,         
Comment VARCHAR(100) Not Null,  
Credit_card_name VARCHAR(40) Not Null, 
Credit_card_number VARCHAR(16) Not Null, 
Credit_card_expiry_date VARCHAR(4) Not Null,
Credit_card_CVV VARCHAR(3) Not Null
)
