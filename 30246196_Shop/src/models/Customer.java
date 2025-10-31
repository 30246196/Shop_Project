package models;


import models.User;
import java.util.HashMap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */
// Customer inherits from User
public class Customer extends User{
    //Attributes
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private boolean isRegistered;
    // new attribute Assessment 3 TODO
    private HashMap<Integer,Order> orders;// right button to Fix Imports
    
    //orders= new HashMap(); to add in the Constructors
    
    //Getter
    public String getAddressLine1()
    {
        return addressLine1;
    }
    //Setter
    public void setAddressLine1(String AddressLine1In)
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
    
    //add getter and setter for Orders HashMap of Orders
    //Getter
    public HashMap<Integer,Order> getOrders() //**** TODO
    {
        return orders;
    }
    //Setter
    public void setOrders(HashMap<Integer,Order> ordersIn)
    {
        orders=ordersIn;
    }
    //Constructor Customer()
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
        orders= new HashMap();
    }
       
}
