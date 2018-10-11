package com.example.ricardo.assignment2;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Student {

    public String name;

    @NonNull
    @PrimaryKey
    public int id;

    public int roll_number;

    public Student(int id, String name, int roll_number) {
        this.id = id;
        this.name = name;
        this.roll_number = roll_number;
    }
}
