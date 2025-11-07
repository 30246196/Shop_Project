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

// SolarPanel inherits from Product
public class SolarPanel extends Product{
    //Attributes
    private int wattageOutput;
    //Most of the home solar panels that installers offer in 2025 
    //produce between 390 and 460 watts of power
        
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
    
    //Constructor SolarPanel()
    //Constructor SolarPanel(0-input parameter)
    public SolarPanel()
    {
        // Call SolarPanel()
        super();//we use super(as parent class) instead SolarPanel()
        //object class       
        wattageOutput=400;
    }
    
    //Constructor SolarPanel(Everything EXCEPT productId - 4 parameters)
    public SolarPanel(String productNameIn, double priceIn, int stockLevelIn,
            int wattageOutputIn)
    {
        //SolarPanel(String productNameIn, double priceIn, int stockLevelIn,
        //int wattageOutputIn)
        // when you do a call do not write the variable type      
        super( productNameIn, priceIn, stockLevelIn);
        wattageOutput=wattageOutputIn;   
    }
    
    //Constructor SolarPanel(Everything - 5 parameters)
    public SolarPanel(int productIdIn,String productNameIn, double priceIn, int stockLevelIn,
            int wattageOutputIn)
    {
        //SolarPanel(String productNameIn, double priceIn, int stockLevelIn,
        //int wattageOutputIn)
        // when you do a call do not write the variable type      
        super( productIdIn, productNameIn, priceIn, stockLevelIn);
        wattageOutput=wattageOutputIn;   
    }
}
