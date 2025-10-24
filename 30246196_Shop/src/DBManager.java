
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */
public class DBManager {
    // global variables definition, final is for a constant variable
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    // we need a connection for a db
    private final String connectionString="jdbc:ucanaccess://Data\\ShopDB.accdb";
    
    // create a method loadCustomers() for ddbb
    public ArrayList<Customer> loadCustomers()// right click, Fix Imports
    {
        ArrayList<Customer> allCustomers = new ArrayList();
        
        try
        {
            // sql language and taking the value for this column
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            // because the type of.SELECT statement
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");
            // store the result in a table
            
            // going through the results and ** Customers
            while(rs.next())
            {
                // we need to know the column name  and the data type
                String userName = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String addressLine1 = rs.getString("AddressLine1");
                String addressLine2 = rs.getString("AddressLine2");
                String town = rs.getString("Town");
                String postcode=rs.getString("Postcode");
                
                // need a Customer
                // we need to pick the best Customer() constructor
                // we choose this one all parameters
                // Customer(String userNameIn, String passwordIn, String firstNameIn, 
                //String lastNameIn,String AddressLine1In,String AddressLine2In,
                //String townIn,String postcodeIn)
                Customer c = new Customer(userName, password, firstName, 
                    lastName, addressLine1, addressLine2,
                    town, postcode);
                
                // next, 
                allCustomers.add(c);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error loading Customers: " + ex.getMessage());
        }
        finally
        {
            return allCustomers;
        }
        
    }
    
    
    // MEthod loadStaff()
    public ArrayList<Staff> loadStaff()// right click, Fix Imports
    {
        ArrayList<Staff> allStaff = new ArrayList();
        
        try
        {
            // sql language and taking the value for this column
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            // because the type of.SELECT statement
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff");
            // store the result in a table
            
            // going through the results and ** Staff
            while(rs.next())
            {
                // we need to know the column name  and the data type
                String userName = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String position = rs.getString("Position");
                double salary = rs.getDouble("Salary");
                
                
                // need a Staff
                // we need to pick the best Staff() constructor
                // we choose this one all parameters
                // Staff(String userNameIn, String passwordIn, String firstNameIn, 
                //String lastNameIn,String positionIn,double salaryIn)
                Staff s = new Staff( userName, password,  firstName, 
             lastName, position, salary);
                
                // next, 
                allStaff.add(s);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error loading Staff: " + ex.getMessage());
        }
        finally
        {
            return allStaff;
        }
    
    }
}
