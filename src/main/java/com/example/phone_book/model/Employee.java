package com.example.phone_book.model;

import javax.persistence.*;

@Entity
@Table(name = "phone_book", schema = "phone_book")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "position")
    private String position;
    @Column(name = "department")
    private String department;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;

    public Employee() {
    }

    public Employee(String name, String position, String department, String phone, String email) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
