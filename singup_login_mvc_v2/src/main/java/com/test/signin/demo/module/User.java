package com.test.signin.demo.module;

import com.test.signin.demo.validation.ConfirmPass;
import jakarta.validation.constraints.*;

@ConfirmPass //it needs to stay above the class to be able to get information from password and confirmPassword fields
// remember to put ElementType.TYPE in the annotation class.
public class User {

    private String firstName;
    private String lastName;

    @Pattern(regexp="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "Not a valid email")
    private String email;

    //@Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)")
    @Size(min=8, max=16, message="Must contain between 8 and 16 characters." +
            " At least 1 capital letter and one special character.")
    private String password;

    private String confirmPassword;

    public User(){}

    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){return lastName;}
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getEmail(){return email;}
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){return password;}
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getConfirmPassword(){return confirmPassword;}
    public void setConfirmPassword(String confirmPassword ){
        this.confirmPassword = confirmPassword;
    }
}
