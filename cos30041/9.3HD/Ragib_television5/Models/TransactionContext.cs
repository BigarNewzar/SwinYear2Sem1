using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ragib_television5.Models
{
    public class TransactionContext: DbContext
    {
        public TransactionContext(DbContextOptions<TransactionContext> options):base(options)
        {
            
        }

        //ie the table transaction will be created by this
        public DbSet<Transaction> Transactions { get; set; }
    }
}
