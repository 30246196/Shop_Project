package models;


//import models.Product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */
public class OrderLine {
    private int orderLineId; // primary key to store in a ddbb
    private Product product;// ASSOCIATION is weaker than inheritance
    private int quantity;
    private double lineTotal;
    
    //Getters and Setters
    // Getters
    public int  getOrderLineId()
    {
        return orderLineId;
    }
    // Setters
    public void setOrderLineId(int orderLineIdIn)
    {
        orderLineId=orderLineIdIn;
    }
    
    // Getters
    public Product  getProduct()
    {
        return product;
    }
    // Setters
    public void setProduct(Product productIn)
    {
        product=productIn;
    }
    
    public int  getQuantity()
    {
        return quantity;
    }
    // Setters
    public void setQuantity(int quantityIn)
    {
        quantity=quantityIn;
    }
    
    // Getters
    public double  getLineTotal() // check
    {
        return lineTotal;
    }
    // Setters
    public void setLineTotal(double lineTotalIn)
    {
        lineTotal=lineTotalIn;
    }
    
    //Constructors
    
    // Constructor OrderLine ALL parameters
    
    public OrderLine(int orderLineIdIn, Product productIn, int quantityIn, double lineTotalIn) // changed to public
    {
        orderLineId=orderLineIdIn;
        product=productIn;
        quantity=quantityIn;
        lineTotal=lineTotalIn;
        
    }
    // Constructor ALL except lineTotal
    public OrderLine(int orderLineIdIn, Product productIn,int quantityIn)// to pubic
    {
        orderLineId=orderLineIdIn;
        product=productIn;
        quantity=quantityIn;
        lineTotal=product.getPrice()*quantityIn;
    }
   
    // Constructor just with product and quantity
    public OrderLine(Product productIn, int quantityIn)
    {
        orderLineId = 0;
        product= productIn;
        quantity = quantityIn;
        lineTotal = product.getPrice()*quantity;
    }
}
