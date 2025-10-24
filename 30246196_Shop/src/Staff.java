/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */

//Staff inherits from User
public class Staff extends User{
   //Attributes
    private String position;
    private double salary;
    
    //Getter
    public String getPosition()
    {
        return position;
    }
    //Setter
    public void setPosition(String positionIn)
    {
        position=positionIn;
    }
    
    //Getter
    public double getSalary()
    {
        return salary;
    }
    //Setter
    public void setSalary(double salaryIn)
    {
        salary=salaryIn;
    }
    
    // Constructors
    
    //Constructor Staff(0-input parameter)
    public Staff()
    {
        // Call Staff()
        super();//we use super(as parent class) instead Customer()
        //object class
        
        position="Shop Manager";
        salary=40000;
	
    }
    //Constructor Staff(Everything  - 6 parameters)
    public Staff(String userNameIn, String passwordIn, String firstNameIn, 
            String lastNameIn,String positionIn,double salaryIn)
    {
        //Staff(String userNameIn, String passwordIn, String firstNameIn, 
        //   String lastNameIn)
        // when you do a call do not write the variable type      
        super(userNameIn, passwordIn, firstNameIn, lastNameIn);
        
        position=positionIn;
        salary=salaryIn;
    } 
}
