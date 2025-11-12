/*
The Order class represents a customer order with 
attributes :orderId,orderDate, status and orderTotal
The order will be stored in a table called Orders from a db 
with an attribute from customer(username)
Manages multiple OrderLine item objects(each representing a product and quantity)
using a HashMap 
and recalculates the total whenever items are added.
*/
package models;// Order class belongs to the models package

import java.util.Date;// for storing the order date
import java.util.HashMap;//used to store multiple OrderLine objects in a collection
// Map also to store multiple OrderLine objects in a collection
import java.util.Map;// added when fix imports in the for loop of calculateOrderTotal() method

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */
public class Order {
    
    // 1. Static constants
    
    // private static final String DEFAULT_STATUS = "Ongoing";
    
    // 2. Attributes
    
    // all attributes should be private
    private int orderId; // unique identifier for the order
    private Date orderDate;// when the order was created
    /*select the all line and right button -> fix imports*/
    private String status;// current state of the order("Ongoing","Completed")
    private double orderTotal;//Total cost of the order
    
    // A HashMap where:
    // HashMap<Data_Type_of_key,Data_Type_of_Value>
    private HashMap <Integer,OrderLine> orderLines;//Collection of OrderLine objects
    // connect order with the OrderLine
    // Key:Integer because of orderLineId, instead of int
    // Value: OrderLine object
    // HashMap is the equivalent to dictionary in C#       
    // orderLines is a collection of several Orderline 
    
    // 3. Constructors

    //Constructors - give an started value
    // -0 imput parameter
    public Order()
    {
        orderId=0;
        orderDate=new Date();
        status="Ongoing";// we can add DEFAULT_STATUS static constant
        orderTotal=0;
        orderLines=new HashMap();
    }
    
    //Constructor - 4 input parameters
    public Order(int orderIdIn,Date orderDateIn,String statusIn,
            double orderTotalIn,HashMap<Integer,OrderLine>orderLines)
    {
        orderId=orderIdIn;
        orderDate=orderDateIn;
        status=statusIn;
        orderTotal=orderTotalIn;
        orderLines=new HashMap();
    }
    
    // 4. Getters and setters
    
    // Getter
    public int  getorderId()
    {
        return orderId;
    }
    // Setters
    public void setorderId(int orderIdIn)
    {
        orderId=orderIdIn;
    }  
    
    // Getters
    public Date  getOrderDate()
    {
        return orderDate;
    }
    // Setters
    public void setOrderDate(Date orderDateIn)
    {
        orderDate=orderDateIn;
    }
    
    // Getters
    public double  getOrderTotal()
    {
        return orderTotal;
    }
    // Setters
    public void setOrderTotal(double orderTotalIn)
    {
        orderTotal=orderTotalIn;
    }
    
    // Getters
    public String  getStatus()
    {
        return status;
    }
    // Setters
    public void setStatus(String statusIn)
    {
        status=statusIn;
    }
    
    //Getter for orderLines
    public HashMap <Integer,OrderLine> getOrderLines()//right button to Fix Imports
    {
        return orderLines;
    }
    //Setter
    public void setOrderLines(HashMap<Integer,OrderLine> orderLinesIn)//Fix Imports
    {
        orderLines=orderLinesIn;
    }
    
    
    // 5. Business methods
    
    //added stage 8
    
    // a) Method calculateOrderTotal() 
    
    // This method calculates the total cost of all items in an order
    // by summing up the individual totals from each OrderLine object 
    // stored in a map called orderLines.
    public void calculateOrderTotal()
    {
        
        orderTotal=0;// initialise the orderTotal to 0
        // for (Map.Entry<Type of the Key, Type of the Value>...
        // Loop through each OrderLine object in the orderLines map
        for(Map.Entry<Integer,OrderLine> olMapEntry : orderLines.entrySet())//fix imports
        {
           //Get the actual OrderLine object from the map entry
           OrderLine actualOrderLine = olMapEntry.getValue();
           
           //TODO create getLineTotal() method inside OrderLine model
           //DONE
           
           //Add the line total of this OrderLine to the overall
           orderTotal = orderTotal + actualOrderLine.getLineTotal();
        }
    }//end calculateOrderTotal()
    
    // added in stage 7
    
    // b) Method addOrderLine(OrderLine ol)
    
    // adds a new OrderLine to the Order,
    // automatically assigns a unique orderLineId,
    // Updates the orderTotal value
    public void addOrderLine(OrderLine ol)
    {
        int orderLineId=0;// initialises orderLineId to 0
        // while the id orderLineId exists, then add 1
        // The loop checks if the orderLines map already contains the key orderLineId.
        // If it does, orderLineId is incremented by 1 to find the next available ID.
        // This ensures unique keys for each OrderLine in the HashMap.
        while(orderLines.containsKey(orderLineId))
        {
            orderLineId++; //orderLineId = orderLineId + 1;
            //orderLineId++ increases the value of the variable orderLineId by 1.
            //post-increment operator because it returns the current value first, then increments it.
        }
        ol.setOrderLineId(orderLineId);//assigns the unique orderLineId to the OrderLine object (ol)
        
        orderLines.put(orderLineId, ol);//adds the OrderLine object to the orderLines map
        //Key: orderLineId (unique integer)
        //Value: ol (the orderLine object)
        
        // TODO calculateOrderTotal() method DONE
        calculateOrderTotal();
        
    }//end addOrderLine(OrderLine ol)
    
           
     
}//end public class Order
