package models;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */
public class User {
    
    // Attributes
    private String username;
    private String password; // changed to private
    private String firstName;
    private String lastName;
    
    
    // Constructors
    
    // User() -0 Parameters
    public User()
    {
        username = "username";// for testing purposing we give a value
        password = "passw0rd";
        firstName ="name";
        lastName ="surname";
    }
    
    // User(Everything) - 4 Parameters
    public User(String userNameIn, String passwordIn, String firstNameIn, String lastNameIn)
    {
        username = userNameIn;// the values are the values of the variables given to the constructor
        password = passwordIn;
        firstName =firstNameIn;
        lastName =lastNameIn;
    }
    
    // Methods
    
    // Getters (ctrl + space bar)  a getter does not require no input
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    // Setters   a setter does not return anything, hence void

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
         
}
