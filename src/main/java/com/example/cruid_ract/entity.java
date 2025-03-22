package com.example.cruid_ract;

import jakarta.persistence.*;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Table(name = "books")
public class entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    private int phone;
    private String name;
    @NonNull
    private LocalDate dueDate; // Due date for book return

    // Getters and setters
    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    public entity(Long id, int phone, String name, LocalDate dueDate) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.dueDate = dueDate;
    }

    public entity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    // Constructors
}