using Ragib_television5.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ragib_television5.TransactionData
{
    public class FacadeTransaction : ITransaction
    {
        private List<Transaction> transactions = new List<Transaction>()
        {
            new Transaction()
            {
                TransactionId = "10005",
                Firstname = "Tester",
     Lastname = "TesterLastname",
        Email  = "Tester@gmail.com",
        Address = "smth address",
        Suburb = "smth suburb",
        State = "VIC",
        Postcode = "3123",
        Phone = "0123456789",
        Product = "Stark",
        Quantity = "10",
        Comment = "smth comment",
        Credit_card_name = "TesterCardName",
        Credit_card_number = "01234567890123456",
        Credit_card_expiry_date = "01/21",
        Credit_card_CVV = "021"
            }
        };
        public Transaction AddTransaction(Transaction transaction)
        {
            transactions.Add(transaction);
            return transaction;
        }

        public Transaction GetTransaction(string transactionId)
        {
            return transactions.SingleOrDefault(x => x.TransactionId == transactionId);
        }

        public List<Transaction> GetTransactions()
        {
            return transactions;
        }
    }
}
