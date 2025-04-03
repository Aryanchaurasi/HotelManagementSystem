package com.cg.guestmanagement.model;
import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String memberCode;
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private String address;
    private String company;

    // Constructors, getters, and setters
}