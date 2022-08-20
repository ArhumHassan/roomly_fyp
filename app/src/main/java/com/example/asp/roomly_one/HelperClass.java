package com.example.asp.roomly_one;

public class HelperClass {

    String name,email,pasword,phone;

    public HelperClass (){
    }

    public HelperClass(String name, String email, String pasword, String phone) {
        this.name = name;
        this.email = email;
        this.pasword = pasword;
        this.phone = phone;
    }

    public HelperClass(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

}
