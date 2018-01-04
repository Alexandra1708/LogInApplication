package com.example.alexandra.loginapplication;

/**
 * Created by Alexandra on 12/12/2017.
 */

public class users {
    int id;
    String username, password;

    public void setId(int id)
    {
        this.id=id;
    }
    public int getId()
    {
        return this.id;
    }
    public void setUsername(String username)
    {
        this.username=username;
    }
    public String getUsername()
    {
        return this.username;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getPassword()
    {
        return this.password;
    }
}
