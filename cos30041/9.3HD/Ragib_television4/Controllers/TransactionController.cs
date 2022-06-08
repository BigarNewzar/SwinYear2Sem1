using Ragib_television4.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Mvc;

namespace Ragib_television4
{
    public class TransactionController : Controller
    {
        public ActionResult Index()
        {
            //consume Web API Get method here.. 

            return View();
        }

        public ActionResult create()
        {
            return View();
        }

        [System.Web.Mvc.HttpPost]
        public ActionResult create(TransactionViewModel transaction)
        {
            using (var client = new HttpClient())
            {
                client.BaseAddress = new Uri("http://localhost:44361/api/transaction");

                //HTTP POST
                var postTask = client.PostAsJsonAsync<TransactionViewModel>("transaction", transaction);
                //postTask.Wait();
                if (postTask == null) { ModelState.AddModelError(string.Empty, "Server Error. Please contact administrator."); }

                var result = postTask.Result;
                if (result.IsSuccessStatusCode)
                {
                    return RedirectToAction("Index");
                }
               
            }

            ModelState.AddModelError(string.Empty, "Server Error. Please contact administrator.");

            return View(transaction);
        }
    }
}
