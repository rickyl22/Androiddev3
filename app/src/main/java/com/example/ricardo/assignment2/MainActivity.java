package com.example.ricardo.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private AppDatabase mDb;
    private int idCounter;
    private EditText mName;
    private EditText mNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        idCounter = 0;
        mName = findViewById(R.id.student_name);
        mNumber = findViewById(R.id.student_number);

        // Note: Db references should not be in an activity.
        mDb = AppDatabase.getInMemoryDatabase(getApplicationContext());

        populateDb();

        Button display = findViewById(R.id.display);
        View.OnClickListener disp = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler_students);
                recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
                List<Student> students = new ArrayList<Student>();

                students  = mDb.userModel().loadAllUsers();

                AdapterStudent adapter = new AdapterStudent(students);

                recycler.setAdapter(adapter);
            }
        };
        display.setOnClickListener(disp);

        Button delete = findViewById(R.id.delete_all);
        View.OnClickListener del = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDb.userModel().deleteAll();
            }
        };
        delete.setOnClickListener(del);

        Button insert = findViewById(R.id.insert_student);
        View.OnClickListener ins = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDb.userModel().insertUser(new Student(idCounter++,((EditText) findViewById(R.id.student_name)).getText().toString(),Integer.parseInt(((EditText) findViewById(R.id.student_number)).getText().toString())));
            }
        };
        insert.setOnClickListener(ins);
        //fetchData();


    }

    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }

    private void populateDb() {
        DatabaseInitializer.populateSync(mDb);
    }

    public void fetchData() {
        // Note: this kind of logic should not be in an activity.
        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler_students);
        recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        List<Student> students = new ArrayList<Student>();

        students  = mDb.userModel().loadAllUsers();

        AdapterStudent adapter = new AdapterStudent(students);

        recycler.setAdapter(adapter);

    }
}

