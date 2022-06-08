using Ragib_television4.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Ragib_television4.Controllers
{
    public class TransactionController : ApiController
    {
        public IHttpActionResult PostNewTransactions(TransactionViewModel t)
        {
            if (!ModelState.IsValid)
                return BadRequest("Invalid data.");

            using (var ctx = new CustomerTransactionEntities())
            {
                ctx.Transactions.Add(new Transaction()
                {
                    TransactionId = t.TransactionId,
                    Firstname = t.Firstname,
                    Lastname = t.Lastname,
                    Email = t.Email,
                    Address = t.Address,
                    Suburb = t.Suburb,
                    State = t.State,
                    Postcode = t.Postcode,
                    Phone = t.Phone,
                    Product = t.Product,
                    Quantity = t.Quantity,
                    Comment = t.Comment,
                    Credit_card_name = t.Credit_card_name,
                    Credit_card_number = t.Credit_card_number,
                    Credit_card_expiry_date = t.Credit_card_expiry_date,
                    Credit_card_CVV = t.Credit_card_CVV
                });

                ctx.SaveChanges();


                return Ok();
            }
        }
    }
}
