/*
This class defines a Product model in the models package,
It is used to represent items in a shop.

Key concepts

Encapsulation: Attributes productId,productName, price,stockLevel are private;
accessed via getters/setters, ensuring data integrity.
*/

package models;
//place the class in the models package

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */
// Declares a public class Product, accesible from other packages
// has 2 subclasses : HeatPump and SolarPanel
public class Product {
    
    // 1. Static constants and variables
    
    // 2. Attributes
    // private instance variables, only accessible or modified through getter/setter
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;
    
    // added to check the Product Type ("Solar Panel", "Heat Pump", or "Replacement Part")
    private String productType; // getter and setter
    
    // added to store the extra attribute in String to later change the type.
    private String extraAttribute;
    
    // 3. Constructors
    
    // Product() Constructor with 0 Parameters
    // the assignation is an example, a 'by default' object's values
    public Product()
    {
        productId = 999;
        productName = "product name";
        price = 0.99;
        stockLevel = 0;
        productType="Replacement Part";
    }       
    
    // Product() Constructor with 3 Parameters, except productId
    public Product(String productNameIn, double priceIn, int stockLevelIn, String productTypeIn)
    {
        productId = 9999;// temporary value, it is going to be rewrritten by the data base
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;
        productType= productTypeIn;
    }
    // Product() Constructor with 4 Parameters
    public Product(int productIdIn, String productNameIn, double priceIn, int stockLevelIn, String productTypeIn)
    {
        productId = productIdIn;
        productName = productNameIn;
        price = priceIn;
        stockLevel = stockLevelIn;
        productType= productTypeIn;
    }

    // 4. Overridden Methods (toString())
    
    // redefine the method toString() to display parts of product on the list
    @Override // from clicking on the warning on line 18 and select
    public String toString() // stage 6
    {
        String productOutput = productName;// display only productName value
        return productOutput;
    }
    
    // 5. Getters and Setters
    
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
    
    public String getProductType() {
        return productType;
    }
    
    public String getExtraAttribute() {
        return productType;
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
    
    public void setProductType(String productType) {
        this.productType = productType;
    }
    
    public void setExtraAttribute(String extraAttribute) {
        this.extraAttribute = extraAttribute;
    } 
    
    
    
    // 6. Custom Methods Stub Method
    // This is a placeholder method intended for future implementation.
    // It signals that the logic(checking stock availability) is not yet defined.
    
    public boolean getIsAvailable() {
        throw new UnsupportedOperationException("Not supported yet."); 
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
