using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace Ragib_television5.Models
{
    public class Transaction
    {
        [Key]
        public string TransactionId { get; set; }
        [Required(ErrorMessage = "Please Enter the TransactionId")]
        [MaxLength(5, ErrorMessage = "TransactionId can only be 5 characters in length")]
        [RegularExpression(@"^\d{5}$",
         ErrorMessage = "5 digits only.")]

        public string Firstname { get; set; }
        [Required(ErrorMessage = "Please Enter the Firstname")]
        [MaxLength(20, ErrorMessage = "Firstname can only be 20 characters in length")]
        [RegularExpression(@"^[a-zA-Z\s]{1,20}$",
         ErrorMessage = "alphabet entry only.")]
        public string Lastname { get; set; }
        [Required(ErrorMessage = "Please Enter the Lastname")]
        [MaxLength(20, ErrorMessage = "Lastname can only be 20 characters in length")]
        [RegularExpression(@"^[a-zA-Z\s]{1,20}$",
         ErrorMessage = "alphabet entry only.")]
        public string Email { get; set; }
        [Required(ErrorMessage = "Please Enter the Email")]
        [MaxLength(100, ErrorMessage = "Email cant be more than 50 characters in length")]
        [RegularExpression(@"^[a-zA-Z''-'\s]{3}$",
         ErrorMessage = "Please give a valid email")]
        public string Address { get; set; }
        [Required(ErrorMessage = "Please Enter the Address")]
        [MaxLength(100, ErrorMessage = "Address cant be more than 50 characters in length")]
        public string Suburb { get; set; }
        [Required(ErrorMessage = "Please Enter the suburb")]
        [MaxLength(100, ErrorMessage = "Suburb cant be more than 50 characters in length")]
        public string State { get; set; }
        [Required(ErrorMessage = "Please Enter the State")]
        [MaxLength(3, ErrorMessage = "State cant be more than 3 characters in length")]
        [RegularExpression(@"^[A-Z]{3}$",
         ErrorMessage = "Please give only 3 capital letters")]
        public string Postcode { get; set; }
        [Required(ErrorMessage = "Please Enter the Postcode")]
        [MaxLength(4, ErrorMessage = "Postcode cant be more than 4 digits in length")]
        public string Phone { get; set; }
        [Required(ErrorMessage = "Please Enter the Phone number")]
        [MaxLength(10, ErrorMessage = "Phone cant be more than 10 digits in length")]
        [RegularExpression(@"^\d{10}$",
         ErrorMessage = "10 digits only.")]
        public string Product { get; set; }
        [Required(ErrorMessage = "Please Enter the Product name")]
        [RegularExpression(@"^Stark|Vibranium|Pubg$",
         ErrorMessage = "Stark Vibranium or Pubg with proper case only.")]

        public string Quantity { get; set; }
        [Required(ErrorMessage = "Please Enter the Quantity")]
        [MaxLength(10, ErrorMessage = "Quantity can't be more than 10 digits")]
        [RegularExpression(@"^\d+$",
         ErrorMessage = "digits only.")]
        public string Comment { get; set; }
        [Required]

        public string Credit_card_name { get; set; }
        [Required(ErrorMessage = "Please Enter the card name")]
        [MaxLength(40, ErrorMessage = "Card name can't be more than 40 characters")]
        [RegularExpression(@"^[a-zA-Z]{1,40}$",
         ErrorMessage = "alphabet entry only.")]
        public string Credit_card_number { get; set; }
        [Required(ErrorMessage = "Please Enter the Credit card number")]
        [MaxLength(16, ErrorMessage = "Card number can't be more than 16 digits")]
        [RegularExpression(@"^\d{16}$",
         ErrorMessage = "16 digits only.")]
        public string Credit_card_expiry_date { get; set; }
        [Required(ErrorMessage = "Please Enter the Expiry date")]
        [MaxLength(4, ErrorMessage = "Card Expiry date must be in mmyy format")]
        [RegularExpression(@"^(0[1-9]|1[0-2])\d{2}$",
         ErrorMessage = "mmyy format only.")]
        public string Credit_card_CVV { get; set; }
        


    

    }
}
