using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Ragib_Television6
{
    public class ExecuteCommands
    {
        private SqlParts _sqlStuff;
        public ExecuteCommands()
        {
            _sqlStuff = new SqlParts();
        }

        public void ExecuteInsert(string a1, string a2, string a3, string a4, string a5, string a6, string a7, string a8, string a9, string a10, string a11, string a12, string a13, string a14, string a15)
        {
            _sqlStuff.Insert(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);

            
        }
    }
}