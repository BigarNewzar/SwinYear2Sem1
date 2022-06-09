using Microsoft.EntityFrameworkCore.Migrations;

namespace Ragib_television5.Migrations
{
    public partial class InitialMigratio : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Transactions",
                columns: table => new
                {
                    TransactionId = table.Column<string>(nullable: false),
                    Firstname = table.Column<string>(maxLength: 5, nullable: false),
                    Lastname = table.Column<string>(maxLength: 20, nullable: false),
                    Email = table.Column<string>(maxLength: 20, nullable: false),
                    Address = table.Column<string>(maxLength: 100, nullable: false),
                    Suburb = table.Column<string>(maxLength: 100, nullable: false),
                    State = table.Column<string>(maxLength: 100, nullable: false),
                    Postcode = table.Column<string>(maxLength: 3, nullable: false),
                    Phone = table.Column<string>(maxLength: 4, nullable: false),
                    Product = table.Column<string>(maxLength: 10, nullable: false),
                    Quantity = table.Column<string>(nullable: false),
                    Comment = table.Column<string>(maxLength: 10, nullable: false),
                    Credit_card_name = table.Column<string>(nullable: false),
                    Credit_card_number = table.Column<string>(maxLength: 40, nullable: false),
                    Credit_card_expiry_date = table.Column<string>(maxLength: 16, nullable: false),
                    Credit_card_CVV = table.Column<string>(maxLength: 4, nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Transactions", x => x.TransactionId);
                });
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropTable(
                name: "Transactions");
        }
    }
}
