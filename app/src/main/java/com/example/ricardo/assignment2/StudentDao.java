package com.example.ricardo.assignment2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface StudentDao {

    @Query("select * from student")
    List<Student> loadAllUsers();

    @Insert(onConflict = IGNORE)
    void insertUser(Student user);

    @Delete
    void deleteUser(Student user);

    @Query("DELETE FROM student")
    void deleteAll();

}