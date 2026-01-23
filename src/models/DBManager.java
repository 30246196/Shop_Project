/*
This Java class DBManager is a data access layer that connects to 
a Microsoft Access database (ShopDB.accdb) using the UCanAccess JDBC driver. 
It handles reading and writing data for orders, customers, staff, and products.

Key Concepts

JDBC (Java Database Connectivity): connects and interacts with the Access database.
Encapsulation : Each method encapsulates a specific database operation.
PreparedStatement : Prevents SQL injection and improves performance for repeated queries.
Object Mapping : Converts database rows into Java objects (Customer, Staff, Product).
Polymorphism : Uses subclass constructors (HeatPump, SolarPanel) based on product type.
Error handling : Uses try-catch-finally blocks to manage exceptions and ensure stability.
Login Validation : Implements basic credential checking using object comparison.
Separation of Concerns : Keeps database logic separate from UI and business logic.

*/
package models; // the class is part of the models package

import java.sql.Connection;// JDBC classes to connect to and interact with the Access database
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
        
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.sql.PreparedStatement;// added manually
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */
public class DBManager {
    
    // 1. Static Constants and Variables. 
    /*   Constants(Final Variables) 
     A final variable in Java is a variable whose value cannot be changed once it is assigned. 
    It’s essentially a constant, and it’s declared using the final keyword.
    */
    
    // global variables definition, final is for a constant variable
    // specifies the JDBC driver class
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    // we need a connection for a db
    // Path to the Access database file
    private final String connectionString="jdbc:ucanaccess://Data/ShopDB.accdb";
    //private final String connectionString ="jdbc:ucanaccess:///C:/Users/30246196/OneDrive - City of Glasgow College/HND 2025/SOFT DEVELOPMENT/NetBeans/Data/ShopDB.accdb";

    
    //added after stage 14 to check the connection
    
public DBManager() {
        try 
        {
            // load the driver UCanAccess
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("driver UCanAccessnot not found. Check the JARs in the classpath.", e);
        }
        
        
        String dbRel = "Data/ShopDB.accdb";
        java.io.File f = new java.io.File(dbRel);
        System.out.println("Resolved DB path: " + f.getAbsolutePath());
        System.out.println("DB exists? " + f.exists());

    }

    
    //
    
    // 2. Method Write Order to Database

    // writeOrder() method added in stage 8
    
    // Insert a new order record into a database.
    // Purpose is to save an Order object into a database table called Orders,
    // associating it with a customer's username.
    // Order o is an object containing: date,username,total and status.
    // Uses SimpleDateFormat to format the order date.
    // Ensures safe SQL execution and prevents SQL injection.
    public void writeOrder(Order o, String customerUsername)
    {
        // using PreparedStatement  for safety and clarity:
        String sql ="INSERT INTO Orders(OrderDate,Username,OrderTotal,Status) VALUES (?,?,?,?)";
        // try check
        try (Connection conn = DriverManager.getConnection(connectionString);
             PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            // Loads the JDBC driver class dynamically using its fully qualified
            // stored in the driver variable("net.ucanaccess.jdbc.UcanaccessDriver")
            // this step ensures the driver is registeed with the JDBC DriveManager.
            Class.forName(driver);
            // Establish a connection to the database using the connectionString
            // ("jdbc:ucanaccess://Data\\ShopDB.accdb")
            //Connection conn = DriverManager.getConnection(connectionString);
            // Create a Statemnet object to execute SQL queries.
            //Statement stmt = conn.createStatement();
            
            // Set parameters safely using PreparedStatement
            pstmt.setString(1, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(o.getOrderDate()));
            pstmt.setString(2, customerUsername);
            pstmt.setDouble(3, o.getOrderTotal());
            pstmt.setString(4, o.getStatus());
            
            pstmt.executeUpdate();
        }
        catch(Exception ex)
        {
            System.out.println("Error writing Order: " + ex.getMessage());
        }
    }
    
    // 3. Method Load Customers() for ddbb
    
    // Executes SELECT * FROM Customers
    // Iterates through the result set and creates Customer objects.
    // Returns an ArrayList<Customer>.
    public ArrayList<Customer> loadCustomers()// right click, Fix Imports
    {
        //ArrayList<Customer> allCustomers = new ArrayList();
        ArrayList<Customer> allCustomers = new ArrayList<>();
        /*
        Exception handling Improvement: 
        * Log detailed errors(not just ex.getMessage)
        * Close resources properly using try-with-resources
        * Avoid returnung from finally blocks
        * Use custom messages to clarify context
        * Optionally rethrow exceptions if needed for higher-level handling
        */
        
        /*
        - ArrayList is a class that implements a resizable array.
        - <Type> is a generic placeholder for the type of objects you want to store (e.g., String, Customer, Product).
        - new ArrayList<>() creates a new, empty list.
        */
         
        // check the connection
        try (Connection conn = DriverManager.getConnection(connectionString);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Customers")) 
        {
            
//            Connection conn = DriverManager.getConnection(connectionString);
//            // check the connection Edith
//            System.out.println("Connected successfully to Oracle!");
//            
//            Statement stmt = conn.createStatement();
//            // because the type of.SELECT statement
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");
//            // store the result in a table
            
            // sql language and taking the value for this column
            Class.forName(driver);
            
            // going through the results and ** Customers
            while(rs.next())
            {
                Customer c = new Customer(
                rs.getString("Username"),
                rs.getString("Password"),
                rs.getString("FirstName"),
                rs.getString("LastName"),
                rs.getString("AddressLine1"),
                rs.getString("AddressLine2"),
                rs.getString("Town"),
                rs.getString("Postcode")
            );


//                // we need to know the column name  and the data type
//                String username = rs.getString("Username");
//                String password = rs.getString("Password");
//                String firstName = rs.getString("FirstName");
//                String lastName = rs.getString("LastName");
//                String addressLine1 = rs.getString("AddressLine1");
//                String addressLine2 = rs.getString("AddressLine2");
//                String town = rs.getString("Town");
//                String postcode=rs.getString("Postcode");
                
                // need a Customer
                // we need to pick the best Customer() constructor
                // we choose this one all parameters
                // Customer(String userNameIn, String passwordIn, String firstNameIn, 
                //String lastNameIn,String AddressLine1In,String AddressLine2In,
                //String townIn,String postcodeIn)
                        
//                Customer c = new Customer(username, password, firstName, 
//                    lastName, addressLine1, addressLine2,
//                    town, postcode);
                
                // next, 
                allCustomers.add(c);
            }
//        }
//        catch(Exception ex)
//        {
//            System.out.println("Error loading Customers: " + ex.getMessage());
//        }
//        finally
//        {
          
//    } catch (SQLException sqlEx) {
//                System.err.println("SQL error while loading customers:");
//                sqlEx.printStackTrace();
    } catch (ClassNotFoundException cnfEx) {
                System.err.println("JDBC driver not found:");
                cnfEx.printStackTrace();
    } catch (Exception ex) {
                System.err.println("Unexpected error in loadCustomers:");
                ex.printStackTrace();
    }

        return allCustomers;
    }
        

    // 4. Method Load Staff
    
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
    
    // 5. Method Customer Login
    
    // check if there is any Customer with same username and password
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
    
    // 6. Method Staff Login
    
    // to check if there is any Staff with same username and password
    
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
    
    // 7. Method Load Products
    
    public ArrayList<Product> loadProducts() // fix imports
    {
    // create an ArrayList to store the content of the Products table
    ArrayList<Product> allProducts = new ArrayList<>();
    
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
            
            String category = rs.getString("ProductType");//TODO check
            
            //Protection against NULL
            if (category == null) 
                { System.out.println("ProductType is NULL for product " + productId);
                continue;
                } // avoid crash
            
            // read extra attributes
            int wattageOutput = rs.getInt("WattageOutput");
            double efficiencyRating = rs.getDouble("EfficiencyRating");
            String partFor = rs.getString("PartFor");// added in stage 8 extra
            
            // create a product category based on 
            // String1.equals(String2)
            //suitable constructor for
//            if(category.equals("Heat Pump"))
//            {
//                HeatPump h = new HeatPump(productId, productName, price, stockLevel, efficiencyRating);
//                // add to allProducts list
//                allProducts.add(h);
//               
//            }
//            else if(category.equals("Solar Panel"))
//            {
//                SolarPanel s = new SolarPanel(productId, productName, price, stockLevel, wattageOutput);
//                // add
//                allProducts.add(s);
//            }
//            
//            // added in stage 8 extra credit Replacement_Part
//            else if(category.equals("Replacement Part"))
//            {
//                ReplacementPart r = new ReplacementPart(productId, productName, price, stockLevel,partFor);
//                // add
//                allProducts.add(r);
//            }

        // Converted to a switch: //stage 8 extra 
         switch (category) 
            {
            case "Heat Pump":
                HeatPump h = new HeatPump(productId, productName, price, stockLevel,category, efficiencyRating);
                allProducts.add(h);
                break;

            case "Solar Panel":
                SolarPanel s = new SolarPanel(productId, productName, price, stockLevel,category, wattageOutput);
                allProducts.add(s);
                break;

            case "Replacement Part":
                ReplacementPart r = new ReplacementPart(productId, productName, price, stockLevel,category, partFor);
                allProducts.add(r);
                break;

            default:
                System.out.println("Unknown category: " + category);
                break;
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
    
    // 8. Method delete product
    
    // stage 9
   public void deleteProduct(int productId)
   {
      try
        {
            // load
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
                                                           //Product.getProduct()
            stmt.executeUpdate("DELETE FROM Products WHERE ProductID = " + productId);// update the db, by deleting
            
        }
        catch(Exception ex )
        {
            System.out.println("Error loading products: " + ex.getMessage());
        }
   }  
   
   
   // 9. Method edit product
   
   // stage 10
   
   public void editProduct(Product p)
    {
        String extraAttributeSQL = "";
        
        //String category = p.getProductType();
        String productType = p.getClass().getName();
        
        switch (productType) 
            {
           case "models.HeatPump":
               HeatPump hp = (HeatPump)p; 
               extraAttributeSQL = "EfficiencyRating = '" + hp.getEfficiencyRating() + "' ";
               break;

           case "models.SolarPanel":
               SolarPanel sp = (SolarPanel)p;
               extraAttributeSQL = "WattageOutput = '" + sp.getWattageOutput() + "' ";
               break;
              
            case "models.ReplacementPart":
               ReplacementPart rp = (ReplacementPart)p;
               extraAttributeSQL = "PartFor = '" + rp.getPartFor() + "' ";
                break;

            default:
                System.out.println("Unknown category: " + productType);
                break;
            }  
        
       
        // set up connection
        try
        {
          Class.forName(driver);
          Connection conn = DriverManager.getConnection(connectionString);
          //conn.prepareStatement() TODO
          Statement stmt = conn.createStatement();
          
          stmt.executeUpdate("UPDATE Products SET "
          + "ProductName = '" + p.getProductName() + "',"
          + "Price = '" + p.getPrice() + "',"
          + "StockLevel = '" + p.getStockLevel() + "',"
          + "ProductType = '" + p.getProductType() + "',"
         // + "Extra = '" + p.getExtraAttribute() + "',"
          + extraAttributeSQL                
          + "WHERE ProductID = '" + p.getProductId() +"'");
         
         
        }
        catch(Exception ex)
        {
            System.out.println("Error Editing Product: " + ex.getMessage());
        }
    }
   
   // 10. Method loadOrders from an specifc username customer
   // It could be used for staff and customers,
   // Can staff look for all orders and customer by their username
   
   
   public ArrayList<Order> loadOrders(String username)
   {
       //TODO decide if loadOrders will be one method or 2
       
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("username cannot be neither null nor empty.");
        }

        
        String sql = "SELECT OrderId, OrderDate, Username, OrderTotal, Status " +
                     "FROM Orders WHERE Username = ?";

        //ArrayList<Order> orders = new ArrayList<>();
        java.util.ArrayList<Order> orders = new java.util.ArrayList<>();
        
        try(Connection conn = DriverManager.getConnection(connectionString);
        PreparedStatement stmt = conn.prepareStatement(sql);)
        {
            stmt.setString(1, username);
        
            try(ResultSet rs = stmt.executeQuery())
            {
                while (rs.next())
                {
                    Order o = new Order();
                    o.setOrderId(rs.getInt("OrderId"));
                    o.setOrderDate(rs.getDate("OrderDate"));
                    o.setUsername(rs.getString("Username"));
                    o.setOrderTotal(rs.getDouble("OrderTotal"));
                    o.setStatus(rs.getString("Status"));
                    orders.add(o);
                }
            }
        
        }catch(SQLException ex)
        {
          throw new RuntimeException("Error loading orders from '" + username + "': " + ex.getMessage(), ex);  
        }
        return orders;
        
   }//end loadOrders()

    
   /* 11.  Method Register new Customer
   *
   * added after stage 14
   */
   
   public boolean registerCustomer(String username , String password,
                                   String firstName,String lastName,
                                   String address1, String address2,
                                   String town, String postcode )
   {
       try {
           //  Load all customers from DB
           ArrayList<Customer> allCustomers = loadCustomers();
           
           //  Check if username already exists
            for (Customer c : allCustomers)
            {
                if (c.getUsername().equalsIgnoreCase(username))
                {
                    System.out.println("Username already exists: " + username);
                    return false; // registration fails
                }
            }
        
            //  Insert new customer into DB
            Class.forName(driver);
            
            try (Connection conn = DriverManager.getConnection(connectionString);
                    PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Customers (Username, Password, FirstName, LastName, AddressLine1, AddressLine2, Town, Postcode) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)" ))
            {
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.setString(3, firstName);
                pstmt.setString(4, lastName);
                pstmt.setString(5, address1);
                pstmt.setString(6, address2);
                pstmt.setString(7, town);
                pstmt.setString(8, postcode);
                pstmt.executeUpdate();
                return true; // Registration successful
            }
                
        }catch (Exception ex)
        {
            System.err.println("Error in registerCustomer:");
            ex.printStackTrace();
            return false;
        }   
    }

   // 12. Method Unregister an existing Customer
   
   public boolean unregisterCustomer(String username)
   { 
    try { 
       Class.forName(driver);
   
        try (Connection conn = DriverManager.getConnection(connectionString);
           PreparedStatement pstmt = conn.prepareStatement( "DELETE FROM Customers WHERE Username = ?" ))
        { 
            pstmt.setString(1, username);
        
            int rows = pstmt.executeUpdate();
            return rows > 0;// true if a customer was deleted
        }
    } catch (Exception ex)
        { 
            System.err.println("Error in unregisterCustomer:");
            ex.printStackTrace();
            return false;// if there is no customer with this username or another issue
        }
   }//end unregisterCustomer()
   
   
   // 13. Method update password for users
   
   public boolean updatePassword(String username, String currentPassword, String newPassword)
   {    
       try {
            Class.forName(driver);

            try (Connection conn = DriverManager.getConnection(connectionString))
            {
                
            // Verify current password
            String checkSql = "SELECT * FROM Customers WHERE Username = ? AND Password = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql))
            {
                checkStmt.setString(1, username);
                checkStmt.setString(2, currentPassword);
                
                ResultSet rs = checkStmt.executeQuery();
                if (!rs.next())
                { // Current password is incorrect
                    return false;
                }
            }
            
            // Update new password
            String updateSql = "UPDATE Customers SET Password = ? WHERE Username = ?";
            
            try (PreparedStatement updateStmt = conn.prepareStatement(updateSql))
            { 
                updateStmt.setString(1, newPassword);
                updateStmt.setString(2, username);
                
                int rows = updateStmt.executeUpdate();
                return rows > 0;
            }
            
        } 
            
       }catch (Exception ex)
       {
           System.err.println("Error updating password:");
           ex.printStackTrace();
           return false;
       }
    
   } // end updatePassword()
   
   // 14. Method getAllOrders() for Staff
   
   public List<String[]> getAllOrders() {
       List<String[]> orders = new ArrayList<>();
       
       try {
           Class.forName(driver);
       try (Connection conn = DriverManager.getConnection(connectionString))
       { 
           String sql = "SELECT OrderId, OrderDate, UserName, OrderTotal, Status FROM Orders";
           
           try (PreparedStatement stmt = conn.prepareStatement(sql))
            { 
                ResultSet rs = stmt.executeQuery();
                
                // Date formatters: input = Access format, output = dd/MM/yyyy
                SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
                
                while (rs.next())
                {
                    // Read the raw date string from Access
                    String rawDate = rs.getString("OrderDate");
                    
                    // Convert the raw date into desired format
                    String formattedDate ="";
                    try
                    {
                        Date date = inputFormat.parse(rawDate);
                        formattedDate = outputFormat.format(date);
                    }catch (Exception ex)
                    {
                        //If parsing fails, keep the original format
                        formattedDate = rawDate;
                    }
                    
                    // Buid the row for the tableOrders
                    String[] row = new String[]
                        { 
                            rs.getString("OrderId"),
                            formattedDate, //changed
                            rs.getString("UserName"),
                            rs.getString("OrderTotal"),
                            rs.getString("Status")
                        };
                        orders.add(row);
                }
            }
       }
       } catch (Exception ex)
            { 
                ex.printStackTrace();
            }
   
   return orders;
   }// end getAllOrders()
   
   // 15. Method updateOrderStatus
   
   public boolean updateOrderStatus(String orderId, String newStatus)
   { 
       try
       {
           Class.forName(driver);
           
           try (Connection conn = DriverManager.getConnection(connectionString))
           {
               String sql = "UPDATE Orders SET Status = ? WHERE OrderId = ?";
               
               try (PreparedStatement stmt = conn.prepareStatement(sql))
               {
                   stmt.setString(1, newStatus);
                   stmt.setString(2, orderId);
                   
                   int rows = stmt.executeUpdate();
                   return rows > 0;
               }
           }
           
       }catch (Exception ex)
       {
           System.err.println("Error updating order status:");
           ex.printStackTrace();
           return false;
       }
       
   }// end updateOrderStatus 
   
   // 16. Method Update Staff Password
   
   public boolean updateStaffPassword(String username, String newPassword)
   { 
       try {
           Class.forName(driver);
           
           try (Connection conn = DriverManager.getConnection(connectionString))
           {
               String sql = "UPDATE Staff SET Password = ? WHERE UserName = ?";
               
               try (PreparedStatement stmt = conn.prepareStatement(sql)) 
               {
                   stmt.setString(1, newPassword);
                   stmt.setString(2, username);
                   
                   int rows = stmt.executeUpdate();
                   return rows > 0;
               }
           }
           
       }catch (Exception ex)
            {
                ex.printStackTrace();
                return false;
            }
   }
   
   // 17.Method Update Customer Address
   
   
// In DBManager.java (add near other methods)
public boolean updateCustomerAddress(String username,
                                     String newaddress1,
                                     String newaddress2,
                                     String newtown,
                                     String newpostcode) {
    String sql = "UPDATE Customers " +
                 "SET AddressLine1 = ?, AddressLine2 = ?, Town = ?, Postcode = ? " +
                 "WHERE Username = ?";

    try {
        Class.forName(driver);
        try (Connection conn = DriverManager.getConnection(connectionString);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newaddress1);
            stmt.setString(2, newaddress2);
            stmt.setString(3, newtown);
            stmt.setString(4, newpostcode);
            stmt.setString(5, username);

            int rows = stmt.executeUpdate();
            return rows > 0;
        }
    } catch (Exception ex) {
        System.err.println("Error updating address for user '" + username + "': " + ex.getMessage());
        ex.printStackTrace();
        return false;
    }
}

   
   //18. Method Add New Product from Staff
   
   
   
}// End DBManager

