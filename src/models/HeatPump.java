/*
This Java class defines a HeatPump model that extends the Product class
represents a specialised type of Product with an additional attribute:
effiency rating.

Key concepts

Inheritance: HeatPump inherits from Product, reuse attributes and methods.
Encapsulation: Private attribute effiencyRating accessed via geter/setter.
Constructor Overloading: Multiple constructors allow flexible object creation.
Code reuse: super() calls parent constructors to avoid duplication.
Specialisation: HeatPump adds domain-specific logic to a general Product class.
JavaBean Convention: Follows standard naming for getters/setters for compability.

*/
package models; // the class is part of the models package

//import models.Product;// imports Product, although this is redundant since both are in the same package.

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */

/* Inheritance: HeatPump inherits from Product, HeatPump is a subclass of Product.
   HeatPump has all attributes and methods from Product 
   (productId,productName,price,stockLevel)
    plus its own.
*/
public class HeatPump extends Product{
    
    // 1. Static constants and variables
    
    // 2. Attributes
    
    private double efficiencyRating;
    //CoP(Coefficient of Performance): Typically from 2 to 5.
    //SCoP(Seasonal CoP): Generally ranges from 3 to 4.
    
    // 3. Constructors
    
    //Default Constructor HeatPump(0-input parameter)
    public HeatPump()
    {
        // Call the default constructor of Product
        super();//we use super(as parent class) instead HeatPump()
        //object class       
        efficiencyRating=3.2;// default value for effieciencyRating
    }
    
    //Constructor HeatPump(Everything EXCEPT productId - 5 parameters)
    // Useful when productId is auto-generated (e.g.,by a database)
    public HeatPump(String productNameIn, double priceIn, int stockLevelIn, String productTypeIn,
            double efficiencyRatingIn)
    {
        // when you do a call do not write the variable type      
        super( productNameIn, priceIn, stockLevelIn,productTypeIn);
        efficiencyRating=efficiencyRatingIn;   
    }
    
    //Full Constructor HeatPump(Everything - 6 parameters)
    // Allows full initialisation of both inherited and new attributes.
    public HeatPump(int productIdIn,String productNameIn, double priceIn, int stockLevelIn, String productTypeIn,
            double efficiencyRatingIn)
    {
        // when you do a call do not write the variable type      
        super( productIdIn, productNameIn, priceIn, stockLevelIn,productTypeIn);
        efficiencyRating=efficiencyRatingIn;   
    }
        
    // 4. Getters and Setters
    
    //Getter
    public double getEfficiencyRating()
    {
        return efficiencyRating;
    }
    
    //Setter
    public void setEfficiencyRating(double efficiencyRatingIn)
    {
        efficiencyRating=efficiencyRatingIn;
    }
    
}
 