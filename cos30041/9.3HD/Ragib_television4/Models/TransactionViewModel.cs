using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Ragib_television4.Models
{
    public class TransactionViewModel
    {
         
        public string TransactionId { get; set; }
        [Required(ErrorMessage = "Please enter Transaction ID.")]
        public string Firstname { get; set; }
        [Required(ErrorMessage = "Please enter First Name.")]
        public string Lastname { get; set; }
        public string Email { get; set; }
        public string Address { get; set; }
        public string Suburb { get; set; }
        public string State { get; set; }
        public string Postcode { get; set; }
        public string Phone { get; set; }
        public string Product { get; set; }
        public string Quantity { get; set; }
        public string Comment { get; set; }
        public string Credit_card_name { get; set; }
        public string Credit_card_number { get; set; }
        public string Credit_card_expiry_date { get; set; }
        public string Credit_card_CVV { get; set; }
    }
}