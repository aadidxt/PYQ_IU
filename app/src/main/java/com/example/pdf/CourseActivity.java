package com.example.pdf;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class CourseActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    Spinner spinnerCourse,spinnerSemester;
    Button btnSubmit;
    TextView aboutME;

    private AdView adView,adView1;





    private boolean isDarkModeOn() {
        int nightModeFlags = getResources().getConfiguration().uiMode &
                Configuration.UI_MODE_NIGHT_MASK;
        return nightModeFlags == Configuration.UI_MODE_NIGHT_YES;
    }

    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (isDarkModeOn()) {
            setTheme(R.style.AppTheme);
        } else {
            setTheme(R.style.AppTheme_Dark);
        }
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.course);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MobileAds.initialize(CourseActivity.this);
        AdView adView = new AdView(this);
        adView.setAdUnitId("ca-app-pub-9063143935807721/4878914205");

        MobileAds.initialize(CourseActivity.this);
        AdView adView1 = new AdView(this);
        adView1.setAdUnitId("ca-app-pub-9063143935807721/8237497296");


        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        adView1 = findViewById(R.id.adView1);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        adView1.loadAd(adRequest1);

        spinnerCourse = findViewById(R.id.spinnerCourse);
        spinnerSemester = findViewById(R.id.spinnerSemester);
        btnSubmit = findViewById(R.id.btnsubmit);
        aboutME = findViewById(R.id.AboutMe);

        String [] courses = {"Your Course","B.Tech CSE","BBA","BCA"};
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

        aboutME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Dialog dialogBox = new Dialog(CourseActivity.this);
                dialogBox.setContentView(R.layout.custom_dialog_box);
                dialogBox.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialogBox.getWindow().setBackgroundDrawable(getDrawable(R.drawable.spinner_shape));
                dialogBox.setCancelable(true);
                dialogBox.show();
            }
        });



    }
}