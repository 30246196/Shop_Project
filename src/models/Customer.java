

package models;// the class belongs to the models package


//import models.User;
import java.util.HashMap;// used to store multiple Order objects for this customer
import java.util.LinkedList; // added at stage 11

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
This class models a Customer with personal details and a list of orders.
It uses inheritance for common User info and a HashMap to manage multiple orders.

Key Concepts

Inheritance: Customer extends User → reuse common attributes.
Composition: Customer has a collection of Order objects.
Encapsulation: Attributes are private; accessed via getters/setters.
HashMap: Efficient way to store and retrieve orders by ID.
*
 * @author 30246196
 */
// Inheritance: Customer inherits from User
// Customer has all attributes and methods of User(like username, password, firstName, lastName)
// plus its own.
public class Customer extends User{
    
    // 1. Static constants
    
    // 2. Attributes
    
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private boolean isRegistered;// customer registered or no in the shop
    // new attribute Assessment 3 TODO DONE
    private HashMap<Integer,Order> orders;// right button to Fix Imports
    
       //Stage 11 Modify your Customer class to include a new attribute: a Linked List of integers
    private LinkedList<Integer> cardNumbers;
    
    // 3. Constructors    
    
    //orders= new HashMap(); to add in the Constructors
    
    //Constructor 
    
    //Constructor Customer(0-input parameter)
    public Customer()
    {
        // Call Customer()
        super();//we use super(as parent class) instead Customer()
        //object class
        
        addressLine1="1/1";
        addressLine2=" 100 North Street";
	town="Lanark";
	postcode="G1 1UZ";
	isRegistered=true;
        // added in Assessment 3
        orders= new HashMap();
        cardNumbers = new LinkedList(); // added in stage 11
    }
    //Constructor Customer(Everything EXCEPT isRegistered - 8 parameters
    public Customer(String userNameIn, String passwordIn, String firstNameIn, 
            String lastNameIn,String AddressLine1In,String AddressLine2In,
            String townIn,String postcodeIn)
    {
        //Customer(String userNameIn, String passwordIn, String firstNameIn, 
        //   String lastNameIn)
        // when you do a call do not write the variable type      
        super(userNameIn, passwordIn, firstNameIn, lastNameIn);
        addressLine1=AddressLine1In;
        addressLine2=AddressLine2In;
	town=townIn;
	postcode=postcodeIn;
        isRegistered=false; 
        // added in Assessment 3
        orders= new HashMap();// TODO check
        cardNumbers = new LinkedList(); // added in stage 11
    }
    
    // 4. Getters and Setters
    
    //Getter
    public String getAddressLine1()
    {
        return addressLine1;
    }
    //Setter
    public void setAddressLine1(String AddressLine1In)//check this style
    {
        addressLine1=AddressLine1In;
    }
    
    //Getter
    public String getAddressLine2()
    {
        return addressLine2;
    }
    //Setter
    public void setAddressLine2(String AddressLine2In)
    {
        addressLine2=AddressLine2In;
    }
    
    //Getter
    public String getTown()
    {
        return town;
    }
    //Setter
    public void setTown(String townIn)
    {
        town=townIn;
    }
    
    //Getter
    public String getPostcode()
    {
        return postcode;
    }
    //Setter
    public void setPostcode(String postcodeIn)
    {
        postcode=postcodeIn;
    }
    
    //Getter
    public Boolean getIsRegistered()
    {
        return isRegistered;
    }
    //Setter
    public void setIsRegistered(boolean isRegisteredIn)
    {
        isRegistered=isRegisteredIn;
    }
    
    //getter and setter for Orders HashMap of Orders
    //Getter
    public HashMap<Integer,Order> getOrders() //
    {
        return orders;
    }   
    //Setter
    public void setOrders(HashMap<Integer,Order> ordersIn)
    {
        orders=ordersIn;
    }
    
    //Stage 11
    // getter and setter for LinkedList cardNumbers
    //Getter
    public LinkedList<Integer> getCardNumbers()
    {
        return cardNumbers;
    }
    //Setter
    public void setCardNumbers(LinkedList<Integer> cardNumbersIn)
    {
        cardNumbers = cardNumbersIn;
    }
        
   // 5. Methods

   // a)Method addCard(int cardNo)
   // Adds the card number to the END of the linked list
    public void addCard(int cardNo)
    { 
        cardNumbers.add(cardNo);
    } 
   // b)Method removeCard(int nodeNo) 
   // Removes the card at the given index (node number) 
    public void removeCard(int nodeNo)
    { 
        cardNumbers.remove(nodeNo);
    } 
   // c) Method addFirstCard(int cardNo)
   // Adds the card number to the START of the linked list
   public void addFirstCard(int cardNo)
   {
        cardNumbers.addFirst(cardNo);   
   }
   
}//end Customer class
