package com.example.lesson32;

public class ContactModel {
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }


    public ContactModel(String name, String phone) {
        this.name = name;
      this.phone = phone;
    }

}
