<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Enquire.aspx.cs" Inherits="Ragib_televisions3.Enquire" %>

<!DOCTYPE html>





<h:html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core">

    <h:head>
        <h:meta charset="utf-8"  />
        <h:meta name="viewport" content="width=device-width, initial-scale=1.0"/> 
        <!--refernece: https://www.w3schools.com/html/html_responsive.asp-->
        <!--it makes it appropriate for mobile and tablet use-->

        <h:meta name="description"  content="Tv purchase, Enquire" />
        <h:meta name="keywords"  content="Tv purchase, Enquire" />
        <h:meta name="author"  content="S M Ragib Rezwan" />

        <h:link href="cssStyle/cssMain.css" rel="stylesheet"/>
        <h:link rel="icon" href="/Ragib-war/images/logoMain.png" type="image/x-icon"/>
        <!--refernece: https://www.w3schools.com/tags/att_link_sizes.asp -->
        <!--it adds a logo beside tab bar-->
        <title>Ragib Televisions Ragib Televisions (Enquire)</title> 
    </h:head>
    
    <style type="text/css">
        .auto-style1 {
            width: 169px;
        }
        .auto-style2 {
            width: 111px;
        }
        .auto-style3 {
            width: 183px;
        }
        .auto-style4 {
            width: 453px;
            height: 32px;
        }
    </style>

    

    
    <h:body>
        <h:nav>
            <a href="index.xhtml"> Home </a> |
            <a href="product.xhtml">Products</a> |
            <a href="enquire.aspx">Enquire</a> |
            <a href="about.xhtml"> Owner Details</a>|
            <a href="admin/managerLogin.xhtml"> Manager</a>
            <hr/>
        </h:nav>
        <aside id="right"> <!--put advert here to right of page-->
            <figure>

                <a href="https://www.primevideo.com/region/eu" >
                    <img class="img" src="images/stream.png" alt="amazon stream advert" align="right"/>
                </a>

                <p>
                    <a href="  https://www.pinterest.com/pin/561964859746504753/"> pic reference </a>
                </p>
                <!-- advert 1 src = https://www.pinterest.com/pin/561964859746504753/-->

            </figure>
        </aside>

        <h1 id="bring_down">Fill up the form and get it now!</h1>

		<form id="form1" runat="server">   

			<p><label for="sTransactionId"> Transaction ID </label>
	
	<input type="text" name=" pTID" id="sTransactionId" maxlength="5" min="5" /></p>

<p><label for="sFname"> First Name </label>
	<input type="text" name=" pFn" id="sFname" maxlength="20" min="1" /></p>
	
               
                 
	
               
<p>
	<label for="sLname"> Last Name </label>
	<input type="text" name=" pLn" id="sLname" maxlength="20" min="1" /> 
</p>
	<p>
	<label for="sEmail">Email Address:</label>
	<input type="email" name="pEl" id="sEmail" maxlength="30" min="1" />
		</p>


<fieldset><legend>Address  </legend>

	<p><label for="sSoT"> Address:</label>
	<input type="text" name=" pSA" id="sSA" maxlength="100" min="1" /> 
	</p>
	
	<p><label for="sSoT"> Suburb/town:</label>
		<input type="text" name=" pSoT" id="sSoT" maxlength="100" min="1" />
	</p>
	
	<p><label for="sST"> State: </label>
		<select name=" pST" id="sST" >
			<option value="" > Please Select</option>
			<option value="VIC" >VIC</option>
			<option value="NSW" >NSW</option>
			<option value="QLD" >QLD</option>
			<option value="NT" >NT</option>
			<option value="WA" >WA</option>
			<option value="SA" >SA</option>
			<option value="TAS" >TAS</option>
			<option value="ACT" >ACT</option>
		</select>
	</p>
	
	<p><label for="sPC"> Postcode: </label>
		<input type="text" name=" pPC" id="sPC" placeholder="####" maxlength="4" min="4"/> 
	</p>
</fieldset>


<p><label for="sPN"> Phone Number: </label>
		<input type="text" name=" pPN" id="sPN" placeholder="##########" maxlength="10" min="10"/> 
</p>

<section class="fixit">
		<table class="Product_Prices">
			<caption> Product Prices: ($) </caption>
			
			<thead>
			<tr>
			
				<th class="auto-style2"> Stark</th>
				<th class="auto-style1"> Vibranium</th>
				<th class="auto-style3"> PUBG Mania</th>
				
			</tr>
			</thead>
			
			<tbody>
				<tr>
					<td class="auto-style2"> &nbsp;&nbsp;&nbsp; 10,000</td>
					<td class="auto-style1"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 12,000</td>
					<td class="auto-style3"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 8,000</td>
					
				
				</tr>
				
			</tbody>			
		</table>

	</section>




<p><label for="sProduct"> Product: </label>
		<select name=" pProduct" id="sProduct">
			<option value="" selected="selected"> Please Select</option>
			<option value="Stark">Stark</option>
			<option value="Vibranium">Vibranium</option>
			<option value="PUBGMania">PUBG Mania</option>
			
		</select>
</p>


<p><label for="sQuantity">Quantity of product: </label>
	
	<input type="text" name="pEl0" id="sQuantity" draggable="auto" maxlength="10" min="1" /><br/>
&nbsp;</p>

<p><label for="sComment"> Comment </label>	
	<textarea name="pComment" rows="4" cols="25" id="sComment" placeholder="Which aspect are you interested in?"></textarea>
</p>

<p><input id="submit" type="submit" value="Pay Now"/>
<!--When clicked, sends data to the payment webpage-->
<input id="reset" type="reset" value="Reset"/>
<!--When clicked, resets all the data-->
</p>


            </form>
       

        <footer> <hr/>
            <h4>Contact me: Using  <h:a href="mailto:103172423@student.swin.edu.au" >Email</h:a>
                or through<h:a href="hhtp://www.swinburne.edu.au"> Swinburne University</h:a> and searching Name: <a href="about.xhtml"> SM RAGIB REZWAN</a>  (ID:103172423) 
            </p>

            <p><a href="enquire.aspx">Want buy Television ASAP?</a></p>
        </footer>
    </h:body>
</h:html>
