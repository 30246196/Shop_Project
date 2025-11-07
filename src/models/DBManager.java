package models;


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
        
        try // check the connection
        {
            // sql language and taking the value for this column
            Class.forName(driver);  
            
            Connection conn = DriverManager.getConnection(connectionString);
            // check the connection Edith
            System.out.println("Connected successfully to Oracle!");
            
            Statement stmt = conn.createStatement();
            // because the type of.SELECT statement
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");
            // store the result in a table
            
            // going through the results and ** Customers
            while(rs.next())
            {
                // we need to know the column name  and the data type
                String username = rs.getString("Username");
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
                Customer c = new Customer(username, password, firstName, 
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
                String username = rs.getString("Username");
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
                Staff s = new Staff( username, password,  firstName, 
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
    
    // Assessment Stage 5 
    
    // method to check if there is any Customer with same username and password
    public Customer CustomerLogin(String username, String password) 
    {
        //  ArrayList is a collection
         ArrayList <Customer> allCustomers = loadCustomers();
                
        // for each starts with a value,this for 
        // ':' means 'in',
        for(Customer c: allCustomers)
        {
            if(c.getUsername().equals(username)&& c.getPassword().equals(password))
            {
                return c;
            }
        }    
            
        return null;// if username and password are not in any customer 'c'
              
    } 
    //method to check if there is any Staff with same username and password
    
    public Staff StaffLogin(String username, String password)    
    {
    //  ArrayList is a collection
         ArrayList <Staff> allStaff = loadStaff(); 
                
        // for each starts with a value,this for 
        // ':' means 'in',
        for(Staff s: allStaff)
        {
            if(s.getUsername().equals(username)&& s.getPassword().equals(password))
            {
                return s;
            }
        }    
            
        return null;// if username and password are not in any staff 's'
    }
    
    // Stage 6
    // Create the method loadproducts() method
    
    // Method loadproducts()
    
    public ArrayList<Product> loadProducts() // fix imports
    {
    // create ab ArrayList to store the content of the Products table
    ArrayList<Product> allProducts = new ArrayList();
    
    try
    {
        //Connects to the Access database
        
        // loads the UCAnAccess JDBC driver from the String variable defined before
        Class.forName(driver);
        // connects ShopDB.accdb using the path specified
        // definition of the variable connectionString
        Connection conn = DriverManager.getConnection(connectionString);
        // executes a SQL Query
        // Run a query to pick all rows from Products table
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
        
        // Process each row
        while(rs.next())
        {
            //extract column values
            int productId = rs.getInt("ProductId");
            String productName = rs.getString("ProductName");
            double price = rs.getDouble("Price");
            int stockLevel = rs.getInt("StockLevel");
            String category = rs.getString("ProductType");
            int wattageOutput = rs.getInt("WattageOutput");
            double efficiencyRating =rs.getDouble("EfficiencyRating");
            
            
            // create a product category based on 
            // String1.equals(String2)
            //suitable constructor for
            if(category.equals("Heat Pump"))
            {
                HeatPump h = new HeatPump(productId, productName, price, stockLevel, efficiencyRating);
                // add to allProducts list
                allProducts.add(h);
               
            }
            else if(category.equals("Solar Panel"))
            {
                SolarPanel s = new SolarPanel(productId, productName, price, stockLevel, wattageOutput);
                // add
                allProducts.add(s);
            }
        }
    }
    catch(Exception ex)
    {
            System.out.println("Error loading products: " + ex.getMessage());
    }
    finally
        {
            return allProducts;
        }
    }
}   

