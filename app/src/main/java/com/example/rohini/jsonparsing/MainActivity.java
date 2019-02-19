package com.example.rohini.jsonparsing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Spinner subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subject= (Spinner)findViewById(R.id.spinner);

        ArrayList<String> subjectlist = new ArrayList<>();
        subjectlist.add("Android");
        subjectlist.add("IOs");
        subjectlist.add("Ethecal Hacking");
        subjectlist.add("Effective Speaking");
        subjectlist.add("Linux");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,subjectlist);
        subject.setAdapter(adapter);

        //default it will get First spinner value as selected item so it will redirect to android activity directly


        subject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String subject = adapterView.getItemAtPosition(i).toString();

                if(subject == "Android") {
                    Intent androidActivity = new Intent(MainActivity.this,Android.class);
                    startActivity(androidActivity);
                }
                else if(subject=="IOs") {
                    Intent IOsActivity = new Intent(MainActivity.this,IOs.class);
                    startActivity(IOsActivity);
                }
                else if(subject == "Ethecal Hacking") {
                    Intent ehActivity = new Intent(MainActivity.this,EthecalHacking.class);
                    startActivity(ehActivity);
                }
                else if(subject == "Effective Speaking") {
                    Intent ESActivity = new Intent(MainActivity.this,EffectiveSpeaking.class);
                    startActivity(ESActivity);
                }
                else if(subject == "Linux") {
                    Intent linuxActivity = new Intent(MainActivity.this,Linux.class);
                    startActivity(linuxActivity);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
