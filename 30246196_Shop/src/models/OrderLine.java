package models;


import models.Product;

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
    private Product product;// ASSOCIATION is weaker tham inheritance
    private int quantity;
    private double lineTotal;
    
    //Getters and Setters
    // Getters
    public int  getorderLineId()
    {
        return orderLineId;
    }
    // Setters
    public void setorderLineId(int orderLineIdIn)
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
    
    public int  getquantity()
    {
        return quantity;
    }
    // Setters
    public void setquantity(int quantityIn)
    {
        quantity=quantityIn;
    }
    // Getters
    public double  getlineTotal()
    {
        return lineTotal;
    }
    // Setters
    public void setlineTotal(double lineTotalIn)
    {
        lineTotal=lineTotalIn;
    }
    
    //Constructors
    
    // Constructor OrderLine ALL parameters
    
    private OrderLine(int orderLineIdIn, Product productIn,int quantityIn, double lineTotalIn)
    {
        orderLineId=orderLineIdIn;
        product=productIn;
        quantity=quantityIn;
        lineTotal=lineTotalIn;
    }
    // Constructor ALL except lineTotal
    private OrderLine(int orderLineIdIn, Product productIn,int quantityIn)
    {
        orderLineId=orderLineIdIn;
        product=productIn;
        quantity=quantityIn;
        lineTotal=product.getPrice()*quantity;
    }
}
