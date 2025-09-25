package com.example.librarysystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegistrationRequest {

    @NotBlank(message = "Förnamn krävs")
    @Size(max = 100, message = "Förnamn får max vara 100 tecken")
    private String firstName;

    @NotBlank(message = "Efternamn krävs")
    @Size(max = 100, message = "Efternamn får max vara 100 tecken")
    private String lastName;

    @NotBlank(message = "E-post krävs")
    @Email(message = "E-post måste vara giltig")
    @Size(max = 150, message = "E-post får max vara 150 tecken")
    private String email;

    @NotBlank(message = "Lösenord krävs")
    @Size(min = 8, message = "Lösenord måste vara minst 8 tecken")
    private String password;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
