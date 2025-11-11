package models;

import java.util.Date;
import java.util.HashMap;
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
            
    // Attributes
    // all attributes should be private
    private int orderId;
    private Date orderDate;/*select the all line and right button -> fix imports*/
    private String status;
    private double orderTotal;
    
    // HashMap<Data_Type_of_key,Data_Type_of_Value>
    private HashMap <Integer,OrderLine> orderLines;// connect order with the 
    // Integer because of orderLineId, instead of int
    // HashMap is the equivalent to dictionary in C#       
    // orderLines is a collection of orderline 
    
    //added stage 8
    
    // calculateOrderTotal() method
    // This method calculates the total cost of all items in an order
    // by summing up the individual totals from each OrderLiine object 
    // stored in a map called orderLines.
    public void calculateOrderTotal()
    {
        // initialise the total to 0
        orderTotal=0;
        // for (Map.Entry<Type of the Key, Type of the Value>...
        // Loop through each entry in the orderLines map
        for(Map.Entry<Integer,OrderLine> olMapEntry : orderLines.entrySet())//fix imports
        {
           //Get the actual OrderLine object from the map entry
           OrderLine actualOrderLine = olMapEntry.getValue();
           
           //TODO create getLineTotal() method inside OrderLine model
           //DONE
           
           //Add the line total of this OrderLine to the overall
           orderTotal = orderTotal + actualOrderLine.getLineTotal();
        }
    }
    
    // added in stage 7
    public void addOrderLine(OrderLine ol)
    {
        int orderLineId=0;
        
        while(orderLines.containsKey(orderLineId))
        {
            orderLineId++; // if the id orderLineId exists, then advance at the end
            // assigns to orderLineId 
        }
        ol.setOrderLineId(orderLineId);
        // create a set OrderLineId() in OrderLine
        orderLines.put(orderLineId, ol);  
        
        // add calculateOrderTotal() method
        calculateOrderTotal();
    }
    
    //Getters and setters
    
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
    
    //Constructors - give an started value
    // -0 imput parameter
    public Order()
    {
        orderId=0;
        orderDate=new Date();
        status="Ongoing";
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
     
}
