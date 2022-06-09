/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.jpa;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class MyuserApp {

    /**
     * @param args the command line arguments
     */
    private MyuserDB mydb;

    public MyuserApp() {
        mydb = new MyuserDB();
    }

    public static void main(String[] args) {
        MyuserApp client = new MyuserApp();
        // assuming inputs from keyboard or any GUI
        MyuserDTO myuserDTO = new MyuserDTO("000001", "Peter Smith", "123456",
                "psmith@swin.edu.au", "9876543210", "Swinburne EN510f",
                "What is my name?", "Peter");
        boolean result = client.createRecord(myuserDTO);
        client.showCreateResult(result, myuserDTO);

        // assuming inputs from keyboard or any GUI
        MyuserDTO myuserDTO2 = new MyuserDTO("000006", "David Lee", "654321",
                "dlee@swin.edu.au", "0123456789", "Swinburne EN510g",
                "What is my name?", "David");
        result = client.createRecord(myuserDTO2);
        client.showCreateResult(result, myuserDTO2);
        
        
       Menu(client);
    }
    
    public static void Menu(MyuserApp client) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        System.out.println("Type the number to perform the desired action:");
        while (option != 4) {
            System.out.println("1: Get a record for a certain UserID");
            System.out.println("2: Update a Record");
            System.out.println("3: Delete a Record");
            System.out.println("4: Exit");
            System.out.print("\nPlease select an option (1-4): ");
            option = sc.nextInt();
            sc.nextLine(); //skip ‘\n

// fix this part for all cases 1 to 4 so that it can do the task
//take help from your copy and lab notes for that
//..............................
            switch (option) {
                
                case 1:
                    System.out.println("Enter the UserID:");
                    Scanner newUserID = new Scanner(System.in);
                    String newUserID1 = newUserID.nextLine();
                    
                    
                    
                    MyuserDTO myuser = client.getRecord(newUserID1);

                    if (myuser != null) {
                       
                        System.out.println(myuser.getUserid().toString());
                        System.out.println(myuser.getName().toString());
                        System.out.println(myuser.getPhone().toString());
                        System.out.println(myuser.getPassword().toString());
                        System.out.println(myuser.getAddress().toString());
                        System.out.println(myuser.getEmail().toString());
                        System.out.println(myuser.getSecQn().toString());
                        System.out.println(myuser.getSecAns().toString());

                    }
                    else{
                        System.out.println("UserID is not found");

                    }

                    break;
                    
                    case 2:
                    System.out.println("Enter record details to be updated:");
                    Scanner newData = new Scanner(System.in);
                    
                    System.out.println("UserId:");
                    String newUserId2 = newData.nextLine();
                    
                    System.out.println("Name:");
                    String newName = newData.nextLine();
                    System.out.println("Password:");
                    String newPassword = newData.nextLine();
                    System.out.println("Email:");
                    String newEmail = newData.nextLine();
                    System.out.println("Phone:");
                    String newPhone = newData.nextLine();
                    System.out.println("Address:");
                    String newAddress = newData.nextLine();
                    System.out.println("SECQN:");
                    String newSecQn = newData.nextLine();
                    System.out.println("SECAns:");
                    String newSecAns = newData.nextLine();
                    
                    
                    
                    
                    MyuserDTO myuserNew = new MyuserDTO(newUserId2, newName,newPassword,newEmail,newPhone,newAddress,newSecQn,newSecAns);
                    
                    
                     boolean outcome2 = client.updateRecord(myuserNew);
                    
                    if (outcome2 == true) {
                        System.out.println("Updated Successfully");
                    } else {
                        System.out.println("Failed to update");
                    }

                    break;
                case 3:
                    System.out.println("Enter the UserID:");
                    Scanner deleteUserID = new Scanner(System.in);
                    String deleteUserID1 = deleteUserID.nextLine();
                    
                                       
                    boolean outcome3 = client.deleteRecord(deleteUserID1);
                    
                    if (outcome3 == true) {
                        System.out.println("Deleted Successfully");
                    } else {
                        System.out.println("Failed to delete");
                    }

                    break;
            }
        }//end while

    }

    public void showCreateResult(boolean result, MyuserDTO myuserDTO) {
        if (result) {
            System.out.println("Record with primary key " + myuserDTO.getUserid()
                    + " has been created in the database table.");
        } else {
            System.out.println("Record with primary key " + myuserDTO.getUserid()
                    + " could not be created in the database table!");
        }
    }

    public boolean createRecord(MyuserDTO myuserDTO) {
        return mydb.createRecord(myuserDTO);
    }
    
    //can also directly call it with client in the main code, but doing it like this to follow the format given in createRecord for good practise:
    public MyuserDTO getRecord(String userid) {
        return mydb.getRecord(userid);
    }
    
    public boolean updateRecord(MyuserDTO myuserDTO) {
        return mydb.updateRecord(myuserDTO);
    }
    
    public boolean deleteRecord(String userid) {
        return mydb.deleteRecord(userid);
    }
}
