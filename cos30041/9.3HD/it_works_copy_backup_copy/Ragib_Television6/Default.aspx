<%@ Page Title="Home Page" Language="C#" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="Ragib_Television6._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">

    <div>
        <div style="font-size:x-large" align ="center"> Enquiry</div>
        
        <table cellpadding="2" style="width: 100%; border: 1px solid #000000">
            <tr>
                <td style="width: 247px">TransactionId</td>
                <td>
                    <asp:TextBox ID="TextBox1" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">Firstname</td>
                <td>
                    <asp:TextBox ID="TextBox2" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">Lastname</td>
                <td>
                    <asp:TextBox ID="TextBox3" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">Email</td>
                <td>
                    <asp:TextBox ID="TextBox4" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">Address</td>
                <td>
                    <asp:TextBox ID="TextBox5" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">Suburb</td>
                <td>
                    <asp:TextBox ID="TextBox6" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>                           
            <tr>
                <td style="width: 247px">Postcode</td>
                <td>
                    <asp:TextBox ID="TextBox7" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">Phone</td>
                <td>
                    <asp:TextBox ID="TextBox8" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="height: 20px; width: 247px">Product</td>
                <td style="height: 20px">
                    <asp:TextBox ID="TextBox9" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">Quantity</td>
                <td>
                    <asp:TextBox ID="TextBox10" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">Comment</td>
                <td>
                    <asp:TextBox ID="TextBox11" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">Credit_card_name</td>
                <td>
                    <asp:TextBox ID="TextBox12" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">Credit_card_number</td>
                <td>
                    <asp:TextBox ID="TextBox13" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">Credit_card_expiry_date</td>
                <td>
                    <asp:TextBox ID="TextBox14" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">Credit_card_CVV</td>
                <td>
                    <asp:TextBox ID="TextBox15" runat="server" Font-Size="Small"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td style="width: 247px">&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td style="width: 247px">&nbsp;</td>
                <td>
                    <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Submit" />
                </td>
            </tr>
        </table>


    </div>

</asp:Content>
