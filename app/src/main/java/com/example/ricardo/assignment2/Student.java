package com.example.ricardo.assignment2;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Student {

    public String name;

    @PrimaryKey
    public int roll_number;

    public Student(String name, int roll_number) {
        this.name = name;
        this.roll_number = roll_number;
    }
}
