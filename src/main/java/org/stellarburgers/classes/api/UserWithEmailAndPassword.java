package org.stellarburgers.classes.api;

public class UserWithEmailAndPassword
{
    private String email;
    private String password;

    public UserWithEmailAndPassword(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public UserWithEmailAndPassword(){}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}
}
