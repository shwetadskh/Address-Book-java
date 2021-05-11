package com.tts.addressBook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Menu {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        int userOption  ;
        int searchOpt ;
        String searchKey ;
        // these variables are the variables of Menu class and used to store the user's entry
        String FName ;
        String LName ;
        String Number ;
        String email ;

        //create a hashmap aBook
        Map<String ,AddressRow> aBook = new HashMap<>() ;

        do {

            System.out.println("1) Add an entry\n" +
                    "2) Remove an entry\n" +
                    "3) Search for a specific entry\n" +
                    "4) Print Address Book\n" +
                    "5) Delete Book\n" +
                    "6) Quit\n" +
                    "Please choose what you'd like to do with the Address Book database: ");
            userOption = scanner.nextInt();


            switch (userOption) {
                //("1) Add an entry
                case 1:
                    System.out.println("Option 1 ");
                    System.out.println("First Name: ");
                    FName = scanner.next();
                    System.out.println("Last Name: ");
                    LName = scanner.next() ;
                    System.out.println("Number: ");
                    //regex pattern where d is digit and 10 is number of digit required
                    String PhonePattern = "\\d{10}" ;

                    //do the do while until the user enters correct value
                    do {
                        Number = scanner.next() ;
                        // this if statement is for displaying error message to the user
                        if(!Number.matches(PhonePattern)){
                            System.out.println("Please enter all numbers and number should be 10 digit");
                        }

                    } while(!Number.matches(PhonePattern)) ; // this is for the do while loop so that it asks for the entry until user enters correct

                    System.out.println("Email: ");
                    String emailPattern = "^[a-zA-Z0-9_.]+@[a-zA-Z.]+?\\.[a-zA-Z]{2,3}$";
                    do {
                        email = scanner.next();
                        if(!email.matches(emailPattern)){
                            System.out.println("Please enter valid email id!");
                        }
                    } while(!email.matches(emailPattern)) ;

                    // created aRow entry object for adding a new row in the existing addressBook hashmap
                    AddressRow aRow =new AddressRow(FName ,LName ,Number,email);

                    // email is key ,aRow is an object of class AddressRow which contain all 4 value
                    aBook.put(email, aRow);
                    System.out.println("Added new entry!\n");
                    break;

                //2) Remove an entry
                case 2:
                    System.out.println("Enter an entry's email to remove: ");
                    email = scanner.next() ;

                    //aBook is hashmap object & containsKey Returns true if this specified email is in the hashmap
                    if(aBook.containsKey(email)){
                        //creating temp object of class AddressRow , get method will return the value of the key(email key) from the hashmap
                        AddressRow temp = aBook.get(email) ;
                        //remove method will remove the key/value pair from the hashmap ABook
                        aBook.remove(email) ;

                        System.out.println("Deleted the following entry:\n");
                        System.out.print("************\n");
                        //Getter methods will fetch the FNAME, LNAME, NUMBER and EMAIL from the temp object which is value of the key we deleted
                        System.out.print("First Name: " + temp.getFName() + "\n");
                        System.out.print("Last Name: " + temp.getLName() + "\n");
                        System.out.print("Phone Number: " + temp.getNumber() + "\n");
                        System.out.print("Email: " + temp.getEmail() + "\n");
                        System.out.print("************\n");

                    } else{
                        // if there is not key found in the hashmap, alert the user that email that was entered is in the addressbook
                        System.out.println(" The email key is not in the Address book");
                    }
                    break;

                    //3) Search for a specific entry
                    case 3:
                    System.out.println("1) First Name\n" +
                            "2) Last Name\n" +
                            "3) Phone Number\n" +
                            "4) Email Address\n\n " +
                            "Chose a search type:");
                    searchOpt = scanner.nextInt() ;
                    System.out.println("Enter your search: ");
                    switch (searchOpt) {
                        case 1:
                            // this variable is required to check if search value is found in the hashmap
                            Boolean bFound = false ;
                            searchKey = scanner.next() ;
                            //the map.entry objects are valid only through the duration of the iteration
                            // on every loop, row variable will contain one key-value set/pair on each iteration
                            for (Map.Entry row : aBook.entrySet()) {
                                //get the value of the key in the temp variable of Address row type
                                //row is one entry (both key-value pair) of the hashmap
                                AddressRow temp = (AddressRow) row.getValue();

                                if(temp.getFName().equalsIgnoreCase(searchKey)){
                                    //set the value to true
                                    bFound = true ;
                                    System.out.print("************\n");
                                    System.out.print("First Name: " + temp.getFName() + "\n");
                                    System.out.print("Last Name: " + temp.getLName() + "\n");
                                    System.out.print("Phone Number: " + temp.getNumber() + "\n");
                                    System.out.print("Email: " + temp.getEmail() + "\n");
                                    System.out.print("************\n");
                                }
                            }
                            if(!bFound){
                                System.out.print("Oops, the entry is not found\n");
                            }
                            break ;
                        case 2:
                            bFound = false ;
                            searchKey = scanner.next() ;
                            for (Map.Entry row : aBook.entrySet()) {
                                AddressRow temp =(AddressRow)  row.getValue();

                                if(temp.getLName().equalsIgnoreCase(searchKey)){
                                    bFound = true ;
                                    System.out.print("************\n");
                                    System.out.print("First Name: " + temp.getFName() + "\n");
                                    System.out.print("Last Name: " + temp.getLName() + "\n");
                                    System.out.print("Phone Number: " + temp.getNumber() + "\n");
                                    System.out.print("Email: " + temp.getEmail() + "\n");
                                    System.out.print("************\n");
                                }
                            }
                            if(!bFound){
                                System.out.print("Oops, the entry is not found\n");
                            }
                            break ;

                        case 3:
                            bFound = false ;
                            searchKey = scanner.next() ;
                            for (Map.Entry row : aBook.entrySet()) {

                                AddressRow temp =(AddressRow) row.getValue();

                                if(temp.getNumber().equalsIgnoreCase(searchKey)){
                                    bFound = true ;
                                    System.out.print("************\n");
                                    System.out.print("First Name: " + temp.getFName() + "\n");
                                    System.out.print("Last Name: " + temp.getLName() + "\n");
                                    System.out.print("Phone Number: " + temp.getNumber() + "\n");
                                    System.out.print("Email: " + temp.getEmail() + "\n");
                                    System.out.print("************\n");
                                }
                            }
                            if(!bFound){
                                System.out.print("Oops, the entry is not found!!!\n");
                            }
                            break ;
                        case 4:
                            bFound = false ;
                            searchKey = scanner.next() ;
                            for (Map.Entry row : aBook.entrySet()) {

                                AddressRow temp = (AddressRow)row.getValue();
                                //com.tts.phonebook.AddressRow temp = (AddressRow) row.getValue();
                                if(temp.getEmail().equalsIgnoreCase(searchKey)){
                                    bFound = true ;
                                    System.out.print("************\n");
                                    System.out.print("First Name: " + temp.getFName() + "\n");
                                    System.out.print("Last Name: " + temp.getLName() + "\n");
                                    System.out.print("Phone Number: " + temp.getNumber() + "\n");
                                    System.out.print("Email: " + temp.getEmail() + "\n");
                                    System.out.print("************\n");
                                }
                            }
                            if(!bFound){
                                System.out.print("Oops, the entry is not found!!!!\n");
                            }
                            break ;

                        default:
                            System.out.println("Invalid input!!!!");
                    }
                            break ;
                //4) Print Address Book
                case 4:
                    Boolean rowFound = false ;
                    //This is special for loop for hashmap
                    // row variable is the value of the key in the hashmap in every iteration, so if there are 4 entries in hashmap, the for loop
                    // will put the key in row variable in every loop
                    for (Map.Entry row : aBook.entrySet()) {
                        AddressRow temp = (AddressRow)row.getValue();
                        rowFound = true ;
                       // com.tts.phonebook.AddressRow temp = (AddressRow) row.getValue();

                        System.out.print("********************\n");
                        System.out.print("First Name: " + temp.getFName() + "\n");
                        System.out.print("Last Name: " + temp.getLName() + "\n");
                        System.out.print("Phone Number: " + temp.getNumber() + "\n");
                        System.out.print("Email: " + temp.getEmail() + "\n");
                        System.out.print("********************\n\n");

                    }
                    if(!rowFound){
                        System.out.println("**************************\n" +
                                "The Address Book is empty\n" +
                                "**************************\n");
                    }
                    break;
                //5) Delete Book
                case 5:
                    // inbuilt java method for clearing the hashmap
                    aBook.clear();
                    System.out.print("**************************\n" +
                                    "Address book cleared!\n" +
                                    "**************************\n\n") ;
                    break;

                //6) Quit
                case 6:
                    System.out.print("**************************\n" +
                            "Bye!\n" +
                            "**************************\n\n") ;
                    System.exit(0);
//                case 7:
//                    aBook.
                default:
                    System.out.println("Invalid input. Please try again!!!!");
                    break;

            }

        }while (userOption != 6) ;

    }
}

