using Ragib_television5.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ragib_television5.TransactionData
{
    public class SqlTransactionData : ITransaction
    {
        private TransactionContext _transactionContext;
        public SqlTransactionData(TransactionContext transactionContext) {
            _transactionContext = transactionContext;
        }
        public Transaction AddTransaction(Transaction transaction)
        {
            _transactionContext.Transactions.Add(transaction);
            _transactionContext.SaveChanges();
            return transaction;
        }

        public Transaction GetTransaction(string transactionId)
        {
            var transaction = _transactionContext.Transactions.Find(transactionId);

            return transaction;
        }

        public List<Transaction> GetTransactions()
        {
           return _transactionContext.Transactions.ToList();
        }
    }
}
