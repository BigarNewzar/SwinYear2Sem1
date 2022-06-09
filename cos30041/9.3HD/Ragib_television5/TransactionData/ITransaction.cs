using Ragib_television5.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ragib_television5.TransactionData
{
    public interface ITransaction
    {
        

        List<Transaction> GetTransactions();

        Transaction GetTransaction(string transactionId);

        Transaction AddTransaction(Transaction transaction);

    }
}
