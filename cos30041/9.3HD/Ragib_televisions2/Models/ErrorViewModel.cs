using System;

namespace Ragib_televisions2.Models
{
    public class TransactionDatabaseDAO
    {
        public string RequestId { get; set; }

        public bool ShowRequestId => !string.IsNullOrEmpty(RequestId);
    }
}
