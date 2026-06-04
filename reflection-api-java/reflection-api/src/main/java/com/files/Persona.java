package com.files;

public class Persona {
    public String name;
    private String cellphone;
    private String email;

    public Persona() {

    }

    public Persona(String name, String cellphone, String email) {
        this.name = name;
        this.cellphone = cellphone;
        this.email = email;
    }

    public Persona changeEmail(String email) {
        return new Persona(this.name, this.cellphone, email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
