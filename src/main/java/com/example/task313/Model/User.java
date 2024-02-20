package com.example.task313.Model;


import jakarta.persistence.*;

@Entity
@Table (name = "users")
public class User {


    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
