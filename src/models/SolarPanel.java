/*
This Java class defines a  model that extends the  class.
It represents a specialized product with an additional attribute:
wattage output, which is relevant for energy generation systems.

Key concepts

Inheritance: SolarPanel inherits from Product, reuse attributes and methods.
Encapsulation: Private attribute wattageOutput accessed via geter/setter.
Constructor Overloading: Multiple constructors allow flexible object creation.
Code reuse: super() calls parent constructors to avoid duplication.
Specialisation: SolarPanel adds domain-specific logic to a general Product class.
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

/* Inheritance: SolarPanel inherits from Product,SolarPanel is a subclass of Product.
    SolarPanel has all attributes and methods from Product 
   (productId,productName,price,stockLevel)
    plus its own.
*/

public class SolarPanel extends Product{
    
    // 1. Static constant and variables
    
    // 2. Attributes
    
    private int wattageOutput;
    //Most of the home solar panels that installers offer in 2025 
    //produce between 390 and 460 watts of power
    
    // 3. Constructors
    
    // Default Constructor SolarPanel(0-input parameter)
    
    public SolarPanel()
    {
        // Call the default constructor of Product
        super();//we use super(as parent class) instead SolarPanel()
        //object class       
        wattageOutput=400; // default value for wattageOutput
    }
    
    //Constructor SolarPanel(Everything EXCEPT productId - 4 parameters)
    
    // Useful when productId is auto-generated (e.g.,by a database)
    public SolarPanel(String productNameIn, double priceIn, int stockLevelIn,
            int wattageOutputIn)
    {
        //SolarPanel(String productNameIn, double priceIn, int stockLevelIn,
        //int wattageOutputIn)
        // when you do a call do not write the variable type      
        super( productNameIn, priceIn, stockLevelIn);
        wattageOutput=wattageOutputIn;   
    }
    
    // Full Constructor SolarPanel(Everything - 5 parameters)
    public SolarPanel(int productIdIn,String productNameIn, double priceIn, int stockLevelIn,
            int wattageOutputIn)
    {
        // when you do a call do not write the variable type      
        super( productIdIn, productNameIn, priceIn, stockLevelIn);
        wattageOutput=wattageOutputIn;   
    }
    
    // 4. Getters and Setters
    
    //Getter
    public int getWattageOutput()
    {
        return wattageOutput;
    }
    //Setter
    public void setWattageOutput(int wattageOutputIn)
    {
        wattageOutput=wattageOutputIn;
    }
    
    
}
