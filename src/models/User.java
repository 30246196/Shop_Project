/*
Java class User is a model in the models package.
It is used to represent a user entity.
username, password, firstName and lastName

Key concepts

Encapsulation: Attributes are private; accessed via getters/setters.
*/
package models;// place the class in the model package

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 30246196
 */
// Declares a public class User , accesible from other packages
// Has 2 subclasses : Customer and Staff
public class User {
    
    // 1. Static constants and variables
    
    // 2. Attributes
    // private instance variables,they can only be accessed or modified through getters and setters
    private String username;
    private String password; // changed to private
    private String firstName;
    private String lastName;
    
    // 3. Constructors
    
    // User() -0 Parameters (Default constructor)
    public User()
    {
        // Initialise a User object with default values
        // Useful for testing purposes
        username = "username";
        password = "passw0rd";
        firstName ="name";
        lastName ="surname";
    }
    
    // User(Everything) - 4 Parameters
    public User(String userNameIn, String passwordIn, String firstNameIn, String lastNameIn)
    {
        // the values are the values of the variables given to the constructor
        // promotes flexibility and reusability
        username = userNameIn;
        password = passwordIn;
        firstName =firstNameIn;
        lastName =lastNameIn;
    }    
    
    // 4. Getters and Setters
    
    //Getters (ctrl + space bar)  a getter does not require no input
    // Provide read access to private fields
    
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
    // Provide write access to private fields
    
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
