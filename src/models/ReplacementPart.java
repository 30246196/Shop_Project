/* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
*This Java class defines a Replacement_Parts model that extends the Product class
*represents a specialised type of Product with an additional attribute:
*partFor.
*
*Key Concepts
*
*Inheritance: Replacement_Parts inherits from Product, reuse the attributes and methods.
*Encapsulation: Private attribute partFor accessed via getter/setter.
*Constructor Overloading:Multiple constructors allow flexible object creation.
*Code reuse: super() calls parent constructors to avoid duplication.
*Specialisation: Replacement_Parts adds domain-specific logic to a general Product class.
*JavaBean Convention: Follows standard naming for getters /setters for compatibility.
 * 
 * 
 * @author 30246196
 */

/* Inheritance: HeatPump inherits from Product, HeatPump is a subclass of Product.
   HeatPump has all attributes and methods from Product 
   (productId,productName,price,stockLevel)
    plus its own.
*/
public class ReplacementPart extends Product{
    
    // 1. Static constants and variables
    
    // 2. Attributes
    
    private String partFor;
    // this attribute has to possible values: HeatPump and SolarPanel.
    
    // 3. Constructors
    
    // Default Constructor Replacement_Parts ( 0 - input parameters)
    public ReplacementPart()
    {
        // Call the defaultt constructor of Product
        super();
        partFor = "SolarPanel";// default value for Replacement_Parts
    }
    
    // Constructor Replacement_Parts (everything except productId - 4 parameters)
    // Useful when productId is auto-generated (e.g.,by a database)
//    Replacement_Part(productId, productName, price, stockLevel,partFor)
    public ReplacementPart(String productNameIn, double priceIn, int stockLevelIn, String partForIn)
    {
        // when you do a call do not write the variable type      
        super( productNameIn, priceIn, stockLevelIn);
        partFor = partForIn;
    }
   
    // Full Constructor Replacement_Parts (everything - 5 parameters)
    // Allows full initialisation of both inherited and new attributes.
    // Replacement_Part(productId, productName, price, stockLevel,partFor)
    public ReplacementPart(int productIdIn,String productNameIn, double priceIn, int stockLevelIn,
            String partForIn)
    {
        // when you do a call do not write the variable type      
        super( productIdIn, productNameIn, priceIn, stockLevelIn);
        partFor = partForIn;   
    }
    
    
    // 4. Getters and Setters
    
    // Getter
    public String getPartFor()
    {
        return partFor;
    }
    // Setter
    public void setPartFor(String partForIn)
    {
        partFor = partForIn;
    }
}
