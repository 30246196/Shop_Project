/*
This Java class defines an OrderLine object with attributes: ordrlineId, product, quantity and line Total
help to calculate a 'line' total, the price of the product*quantity
and 'stores' to look for the product
Represents a single line in an order
*/

/*
Key concepts:
Association: OrderLine has a Product object, but does not inherit from it.
Encapsulation: Attributes are private; accessed via getters and setters.
Responsability: This class calculates the cost for one line in an order/basket.
*/

// the class belongs to the models package
package models;

//import models.Product;
/* It uses Product class,which contains details like 
  productId,
  productName,
  price, 
  stockLevel 
*/

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */


public class OrderLine {
    
    // 1. Static constants
    
    // 2. Attributes
    
    private int orderLineId; // Unique identifier:primary key to store in a ddbb
    private Product product;// ASSOCIATION is weaker than inheritance to Product
    private int quantity;    // number of units of the product
    private double lineTotal;// Total cost for this line(price*quantity)
    
    // 3. Constructors
    
    //Constructors
    
    // Full Constructor OrderLine - ALL parameters
    
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
   
    // Constructor  with only product and quantity
    
    // Useful when Id is not yet assigned(before saving to db)
    public OrderLine(Product productIn, int quantityIn)
    {
        orderLineId = 0;// default ID
        product= productIn;
        quantity = quantityIn;
        lineTotal = product.getPrice()*quantityIn;// changed from quantity to quantityIn
    }
    
    // 4. Getters and Setters
    
    // Getter
    public int  getOrderLineId()
    {
        return orderLineId;
    }
    // Setter
    public void setOrderLineId(int orderLineIdIn)
    {
        orderLineId=orderLineIdIn;
    }
    
    // Getter
    public Product  getProduct()
    {
        return product;
    }
    // Setter
    public void setProduct(Product productIn)
    {
        product=productIn;
    }
    
    public int  getQuantity()
    {
        return quantity;
    }
    // Setter
    public void setQuantity(int quantityIn)
    {
        quantity=quantityIn;
    }
    
    // Getter
    public double  getLineTotal() // check
    {
        return lineTotal;
    }
    // Setter
    public void setLineTotal(double lineTotalIn)
    {
        lineTotal=lineTotalIn;
    }
    
    
}// end OrderLine
