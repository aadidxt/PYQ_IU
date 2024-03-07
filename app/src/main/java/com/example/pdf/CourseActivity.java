package com.example.pdf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CourseActivity extends AppCompatActivity {

    Spinner spinnerCourse,spinnerSemester;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.course);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinnerCourse = findViewById(R.id.spinnerCourse);
        spinnerSemester = findViewById(R.id.spinnerSemester);
        btnSubmit = findViewById(R.id.btnsubmit);

        String [] courses = {"Your Course","B.Tech CSE","B.Sc B.Ed","BBA","BCA"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,courses);
        spinnerCourse.setAdapter(adapter1);

        String [] semester = {"Your Semester","I","II","III","IV","V","VI","VII","VIII"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,semester);
        spinnerSemester.setAdapter(adapter2);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String course = spinnerCourse.getSelectedItem().toString();
                String semester = spinnerSemester.getSelectedItem().toString();

                if(course.equals("Your Course") || semester.equals("Your Semester")){
                    Toast.makeText(CourseActivity.this, "fill areas accordingly", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(CourseActivity.this, MainActivity.class);
                    i.putExtra("course",course);
                    i.putExtra("semester",semester);
                    startActivity(i);

                }




            }
        });



    }
}