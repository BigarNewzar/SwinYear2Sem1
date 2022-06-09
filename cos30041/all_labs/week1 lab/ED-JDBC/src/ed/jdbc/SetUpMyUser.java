/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.jdbc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class SetUpMyUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MyDB mydb = new MyDB();
        /*
* drop table first for a clean start
* may cause error if table does not exist
         */
        mydb.dropMyuserTable();
        mydb.createMyuserTable();
        ArrayList<Myuser> aList = prepareMyuserData();
        mydb.addRecords(aList);

        Menu(mydb);

    }
    
//move it out of here and into the main part, it will take less hassle
    //but still try to keep it like this as it looks more elegant

    public static void Menu(MyDB mydb) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        System.out.println("Type the number to perform the desired action:");
        while (option != 5) {
            System.out.println("1: Create a new Record for a User");
            System.out.println("2: Get a record for a certain UserID");
            System.out.println("3: Update a Record");
            System.out.println("4: Delete a Record");
            System.out.println("5: Exit");
            System.out.print("\nPlease select an option (1-5): ");
            option = sc.nextInt();
            sc.nextLine(); //skip ‘\n

// fix this part for all cases 1 to 4 so that it can do the task
//take help from your copy and lab notes for that
//..............................
            switch (option) {
                case 1:
                    System.out.println("Enter the new UserID:");
                    Scanner userID = new Scanner(System.in);
                    String userID1 = userID.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the new User Name:");
                    Scanner userName = new Scanner(System.in);
                    String userName1 = userName.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the new Password:");
                    Scanner password = new Scanner(System.in);
                    String password1 = password.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the new Email:");
                    Scanner email = new Scanner(System.in);
                    String email1 = email.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the new Phone:");
                    Scanner phone = new Scanner(System.in);
                    String phone1 = phone.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the new Address:");
                    Scanner address = new Scanner(System.in);
                    String address1 = address.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the new SecQn:");
                    Scanner SecQn = new Scanner(System.in);
                    String SecQn1 = SecQn.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the new SecAns:");
                    Scanner SecAns = new Scanner(System.in);
                    String SecAns1 = SecAns.nextLine();    //see if it actually reads in the line

                    Myuser newUser = new Myuser(userID1, userName1, password1, email1, phone1, address1, SecQn1, SecAns1);

                     boolean outcome = mydb.createRecord(newUser);

                    if (outcome == true) {
                        System.out.println("New User Created Successfully");
                    } else {
                        System.out.println("UserID Already Exists");
                    }

                    break;
                case 2:
                    System.out.println("Enter the UserID:");
                    Scanner newUserID = new Scanner(System.in);
                    String newUserID1 = newUserID.nextLine();
                    //mydb.getRecord(newUserID1.toString()); //may cause it to run twice

                    if (mydb.getRecord(newUserID1.toString()) != null) {
                        //try to see if you can call it to print the lines of userid and stuff from here by calling that record itself hereas it returns a myuser type object
                        Myuser myuser2 = mydb.getRecord(newUserID1.toString());
                        //not sure if this is ok to do like this, ask it to him during lab

                        System.out.println(myuser2.getUserid().toString());
                        System.out.println(myuser2.getName().toString());
                        System.out.println(myuser2.getPhone().toString());
                        System.out.println(myuser2.getPassword().toString());
                        System.out.println(myuser2.getAddress().toString());
                        System.out.println(myuser2.getEmail().toString());
                        System.out.println(myuser2.getSecQn().toString());
                        System.out.println(myuser2.getSecAns().toString());

                    }
                    else{
                        System.out.println("UserID is not found");

                    }

                    break;
                case 3:
                    System.out.println("Enter the UserID:");
                    Scanner userIDOld = new Scanner(System.in);
                    String userIDOld1 = userIDOld.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the User Name:");
                    Scanner userNameOld = new Scanner(System.in);
                    String userNameOld1 = userNameOld.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the Password:");
                    Scanner passwordOld = new Scanner(System.in);
                    String passwordOld1 = passwordOld.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the Email:");
                    Scanner emailOld = new Scanner(System.in);
                    String emailOld1 = emailOld.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the Phone:");
                    Scanner phoneOld = new Scanner(System.in);
                    String phoneOld1 = phoneOld.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the Address:");
                    Scanner addressOld = new Scanner(System.in);
                    String addressOld1 = addressOld.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the SecQn:");
                    Scanner SecQnOld = new Scanner(System.in);
                    String SecQnOld1 = SecQnOld.nextLine();    //see if it actually reads in the line

                    System.out.println("Enter the SecAns:");
                    Scanner SecAnsOld = new Scanner(System.in);
                    String SecAnsOld1 = SecAnsOld.nextLine();    //see if it actually reads in the line

                    Myuser oldUser = new Myuser(userIDOld1, userNameOld1, passwordOld1, emailOld1, phoneOld1, addressOld1, SecQnOld1, SecAnsOld1);

                     boolean outcome3 = mydb.updateRecord(oldUser);
                    if (outcome3 == true) {
                        System.out.println("Update has been accepted");
                    } else {
                        System.out.println("Update has been rejected due to new userID");
                    }

                    break;
                case 4:
                    System.out.println("Enter the UserID:");
                    Scanner oldUserID = new Scanner(System.in);
                    String oldUserID1 = oldUserID.nextLine();
                    boolean outcome4 = mydb.deleteRecord(oldUserID1);
                    
                    if (outcome4 == true) {
                        System.out.println("Deleted Successfully");
                    } else {
                        System.out.println("Failed to delete");
                    }

                    break;
            }
        }//end while

    }

    public static ArrayList<Myuser> prepareMyuserData() {
        ArrayList<Myuser> myList = new ArrayList<Myuser>();
        Myuser myuser1 = new Myuser("000001", "Peter Smith", "123456",
                "psmith@swin.edu.au", "9876543210", "Swinburne EN510f",
                "What is my name?", "Peter");
        Myuser myuser2 = new Myuser("000002", "James T. Kirk", "234567",
                "jkirk@swin.edu.au", "8765432109", "Swinburne EN511a",
                "What is my name?", "James");
        Myuser myuser3 = new Myuser("000003", "Sheldon Cooper", "345678",
                "scooper@swin.edu.au", "7654321098", "Swinburne EN512a",
                "What is my last name?", "Cooper");
        Myuser myuser4 = new Myuser("000004", "Clark Kent", "456789",
                "ckent@swin.edu.au", "6543210987", "Swinburne EN513a",
                "What is my last name?", "Kent");
        Myuser myuser5 = new Myuser("000005", "Harry Potter", "567890",
                "hpotter@swin.edu.au", "6543210987", "Swinburne EN514a",
                "What is my last name?", "Potter");
        myList.add(myuser1);
        myList.add(myuser2);
        myList.add(myuser3);
        myList.add(myuser4);
        myList.add(myuser5);
        return myList;
    }

}
