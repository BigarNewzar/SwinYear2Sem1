using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace Ragib_Television6
{
    public class SqlParts
    {
        SqlConnection _con = new SqlConnection("Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=TransactionDb2;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=False;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");

        SqlCommand _comm;
        public SqlParts()
        {
            _con.Open();
        }

        public void Insert(string a1, string a2, string a3, string a4, string a5, string a6, string a7, string a8, string a9, string a10, string a11, string a12, string a13, string a14, string a15) {
           
            _comm = new SqlCommand("Insert into Transactions values ('" + a1 + "','" + a2 + "',	'" + a3 + "',	'" + a4 + "',	'" + a5 + "',	'" + a6 + "',	'" + a7 + "',	'" + a8 + "',	'" + a9 + "',	'" + a10 + "',	'" + a11 + "',	'" + a12 + "',	'" + a13 + "',	'" + a14 + "',	'" + a15 + "')", _con);
            _comm.ExecuteNonQuery();
            _con.Close();

        }

       
    }
}