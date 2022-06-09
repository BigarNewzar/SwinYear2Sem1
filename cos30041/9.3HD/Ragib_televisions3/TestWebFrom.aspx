<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="TestWebFrom.aspx.cs" Inherits="Ragib_televisions3.TestWebFrom" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
       
<p><label for="sFname"> First Name </label>
	<input type="text" name=" pFn" id="sFname" />
</p>
<p>
	<label for="sLname"> Last Name </label>
	<input type="text" name=" pLn" id="sLname" /> 
</p>
	<label for="sEmail">Email Address:</label>
	<input type="email" name="pEl" id="sEmail" />


<fieldset><legend>Address </legend>
	<p><label for="sSA"> Street address:</label>
	<input type="text" name=" pSA" id="sSA" /> 
	</p>
	
	<p><label for="sSoT"> Suburb/town: </label>
	<input type="text" name=" pSoT" id="sSoT" /> 
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
		<input type="text" name=" pPC" id="sPC" placeholder="####"/> 
	</p>
</fieldset>


<p><label for="sPN"> Phone Number: </label>
		<input type="text" name=" pPN" id="sPN" placeholder="##########"/> 
</p>
<p><label> Preferred Contact: </label>
	<label for="email">
	<input type="radio" id="email" name="sPContact" value="email"/>Email </label>
	
	<label for="post">
	<input type="radio" id="post" name="sPContact" value="post"/>Post </label>
	
	<label for="phone">
	<input type="radio" id="phone" name="sPContact" value="phone"/>Phone </label>	
</p>

<section class="fixit">
		<table class="Product_Prices">
			<caption> Product Prices: ($) </caption>
			
			<thead>
			<tr>
			
				<th> Stark</th>
				<th> Vibranium</th>
				<th> PUBG Mania</th>
				
			</tr>
			</thead>
			
			<tbody>
				<tr>
					<td> 10,000</td>
					<td> 12,000</td>
					<td> 8,000</td>
					
				
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
<p>




<section class="fixit">
		<table class="Product_Prices">
			<caption> Extra Feature Prices: ($) </caption>
			
			<thead>
			<tr>
			
				<th> Wired Speaker</th>
				<th> Bluetooth Speaker</th>
				<th> Wireless Speaker</th>
				
			</tr>
			</thead>
			
			<tbody>
				<tr>
					<td> 300</td>
					<td> 500</td>
					<td> 600</td>
					
				
				</tr>
				
			</tbody>			
		</table>

	</section>



<p>
<label> Product features:</label>
	<label for="wired"><input type="checkbox" id="wired" name="Product_features[]" value="wired" /> Wired Speakers</label>
	
	<label for="Bluetooth"><input type="checkbox" id="Bluetooth" name="Product_features[]" value="Bluetooth" /> Bluetooth Speakers</label>
	
	<label for="Wifi"><input type="checkbox" id="Wifi" name="Product_features[]" value="Wifi" /> Wifi Speakers</label>
	
</p>

<p><label for="sQuantity">Quantity of product: </label> <br/>
<input type="text" name="pQuantity" id="sQuantity" size="5">
</p>

<p><label for="sComment"> Comment 	</label> <br/>
	<textarea name="pComment" rows="4" cols="25" id="sComment" placeholder="Which aspect are you interested in?"></textarea>
</p>

<p><input id="submit" type="submit" value="Pay Now"/>
<!--When clicked, sends data to the payment webpage-->
<input id="reset" type="reset" value="Reset"/>
<!--When clicked, resets all the data-->
</p>


    </form>
    <p>
        Somehing</p>
</body>
</html>
