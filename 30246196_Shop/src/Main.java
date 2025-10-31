/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author edith
 */
import models.DBManager;
import models.Customer;
import models.Staff;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
    DBManager db = new DBManager();
    // Load and display all customers
        ArrayList<Customer> customers = db.loadCustomers();
        System.out.println(" Customers:");
        for (Customer c : customers) 
        {
            System.out.println(c);
        }
    // Load and display all staff
        ArrayList<Staff> staffList = db.loadStaff();
        System.out.println("\n Staff:");
        for (Staff s : staffList) {
            System.out.println(s); // Ensure Staff class has a toString() method
        }
        
    // Optional: Test login
        String testUsername = "DonaldL";
        String testPassword = "blehbleh"; // For CustomerLogin, password is postcode
        Customer loggedInCustomer = db.CustomerLogin(testUsername, testPassword);
        if (loggedInCustomer != null) {
            System.out.println("\n✅ Customer login successful: " + loggedInCustomer.getFirstName());
        } else {
            System.out.println("\n❌ Customer login failed.");
        }
    }       
}
