package com.jen.models;

public class customer {
    private int id;
    private String fname;
    private String lname;
    private String email;
    public customer() {
    }
    // Constructor
    public customer(int id, String fname, String email, String lname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String name) {
        this.fname = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getLname() {
        return lname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
