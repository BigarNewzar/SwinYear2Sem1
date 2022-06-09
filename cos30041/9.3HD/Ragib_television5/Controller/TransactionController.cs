using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Ragib_television5.Models;
using Ragib_television5.TransactionData;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Ragib_television5.Controller
{
    [Route("api/[controller]")]
    [ApiController]
    public class TransactionController : ControllerBase
    {
        private ITransaction _transaction;
        public TransactionController(ITransaction transaction)
        {
            _transaction = transaction;
        
        }

        [HttpGet]
        [Route("api/[controller]/{id}")]
        public IActionResult GetTransaction(string transactionId)
        {
            var transaction = _transaction.GetTransaction(transactionId);
            if(transaction != null)
            {
                return Ok(_transaction.GetTransactions());
            }

            return NotFound($"Transaction with id {transactionId} was not found");
        }

        [HttpPost]
        [Route("api/[controller]")]
        public IActionResult AddTransaction(Transaction transaction)
        {
           _transaction.AddTransaction(transaction);


            return Created(HttpContext.Request.Scheme + "://" + HttpContext.Request.Host + HttpContext.Request.Path + "/" + transaction.TransactionId, transaction);
        }
    }
}
