package com.example.santu_pc.labassignment2;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import java.util.Locale;

public class LocationServices extends AppCompatActivity {

    TextToSpeech textToSpeech;
    String textToConvert;
    public void convertToSpeech(View view){
        EditText editText1 = (EditText) findViewById(R.id.ConvertText);
        textToConvert = editText1.getText().toString();
         textToSpeech = new TextToSpeech(getApplicationContext(),new TextToSpeech.OnInitListener(){
            @Override
            public void onInit(int status){
                if(status != TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.ENGLISH);
                    textToSpeech.speak(textToConvert, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_services);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent1 = getIntent();
        TextView welcomeMessage = (TextView) findViewById(R.id.WelcomeMessage);
        String uName = (String) intent1.getSerializableExtra("USERNAME");
        welcomeMessage.setText("Welcome "+uName);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
