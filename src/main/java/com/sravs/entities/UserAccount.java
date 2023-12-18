package com.sravs.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @NotBlank(message = "User name is mandatory")
    @Size(min = 5,max = 30,message = "User Name should be minimum 5 chars and maximum 30 char")
    private String userName;
    @NotBlank(message = "Password is mandatory")
    private String password;
    @NotNull(message = "Age is mandatory")
    @Min(value =18,message = "Min age is 18")
    @Max(value = 45,message = "Maz age is 45")
    private int age;
    @NotBlank(message = "Email is mandetory")
    @Email(message = "Provide a valid email")
    private String email;
    @Size(min =10,max = 10,message = "Phone number should be 10 digits")
    private String phoneNumber;
    private String gender;
    private String city;
    private String country;
    @OneToOne(mappedBy = "userAccount")
    private Interest interest;
}
