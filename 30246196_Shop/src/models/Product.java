package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */
public class Product {
    
    // Attributes
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;
        
    // Constructors
    
    // Product() Constructor with 0 Parameters
    // the assignation is an example, a 'by default' object's values
    public Product()
    {
        productId = 999;
        productName = "product name";
        price = 0.99;
        stockLevel = 0;
    }       
    
    // Product() Constructor with 3 Parameters, except productId
    public Product(String productNameIn, double priceIn, int stockLevelIn)
    {
        productId = 9999;// temporary value, it is going to be rewrritten by the data base
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;       
    }
    // Product() Constructor with 4 Parameters
    public Product(int productIdIn, String productNameIn, double priceIn, int stockLevelIn)
    {
        productId = productIdIn;
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;       
    }

    // Getters     a getter does not require no input
    
    public int getProductId() {
        return productId;
    }
    
    public String getProductName() {
        return productName;
    }
    public double getPrice() {
        return price;
    }
    
    public int getStockLevel() {
        return stockLevel;
    }
    
    // Setters         a setter does not return anything, hence void

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
    
    

    

    

    
    
}
