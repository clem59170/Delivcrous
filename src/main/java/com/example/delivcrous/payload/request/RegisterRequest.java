package com.example.delivcrous.payload.request;

import jakarta.validation.constraints.*;

public class RegisterRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String tel;
    private String adresse;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTel(String tel) { this.tel = tel; }

    public String getTel() { return tel; }

    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getAdresse() { return adresse; }
}
