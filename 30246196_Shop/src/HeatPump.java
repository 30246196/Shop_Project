
import models.Product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */

//HeatPump inherits from Product
public class HeatPump extends Product{
    //Attributes
    private double efficiencyRating;
    //CoP: Typically ranges from 2 to 5.
    //SCoP: Generally ranges from 3 to 4.
    
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
    
    //Constructor HeatPump()
    //Constructor HeatPump(0-input parameter)
    public HeatPump()
    {
        // Call HeatPump()
        super();//we use super(as parent class) instead HeatPump()
        //object class       
        efficiencyRating=3.2;
    }
    
    //Constructor HeatPump(Everything EXCEPT productId - 4 parameters)
    public HeatPump(String productNameIn, double priceIn, int stockLevelIn,
            double efficiencyRatingIn)
    {
        //HeatPump(String productNameIn, double priceIn, int stockLevelIn,
        //double efficiencyRating)
        // when you do a call do not write the variable type      
        super( productNameIn, priceIn, stockLevelIn);
        efficiencyRating=efficiencyRatingIn;   
    }
    
    //Constructor HeatPump(Everything - 5 parameters)
    public HeatPump(int productIdIn,String productNameIn, double priceIn, int stockLevelIn,
            double efficiencyRatingIn)
    {
        //HeatPump(String productNameIn, double priceIn, int stockLevelIn,
        //double efficiencyRating)
        // when you do a call do not write the variable type      
        super( productIdIn, productNameIn, priceIn, stockLevelIn);
        efficiencyRating=efficiencyRatingIn;   
    }
    
}
