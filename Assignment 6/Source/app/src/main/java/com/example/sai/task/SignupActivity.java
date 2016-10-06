package com.example.rajaramya.task;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class SignupActivity extends AppCompatActivity {
    int TAKE_PHOTO_CODE = 0;
    ImageView userImage ;
    private GoogleMap mMap;
    public Geocoder geocoder;

    private static EditText firstname;
    private static EditText lastname;
    private static EditText email;
    private static EditText password;
    EditText Address;
    Button capture;
    private static Button signup;
    private static Button upload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Address = (EditText)findViewById(R.id.add);
         capture = (Button) findViewById(R.id.upload);
        userImage = (ImageView) findViewById(R.id.imageView);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        LoginFunc();
        UploadFunc();

    }

    public void UploadFunc(){
        capture.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(cameraIntent, TAKE_PHOTO_CODE);
                    }

                }
        );
    }

    //If the photo is captured then set the image view to the photo captured.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO_CODE && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(photo);
            Log.d("CameraDemo", "Pic saved");
        }
    }


    public void LoginFunc(){
        firstname = (EditText)findViewById(R.id.firstname);
        lastname = (EditText)findViewById(R.id.lastname);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);

        signup = (Button)findViewById(R.id.button);
        upload = (Button)findViewById(R.id.upload);

        signup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            userImage.setDrawingCacheEnabled(true);
                            Bitmap bm = userImage.getDrawingCache();
                        Intent mapsIntent = new Intent(SignupActivity.this,MapsActivity.class);
                        mapsIntent.putExtra("PROFILING",bm);
                        startActivity(mapsIntent);
                        if (firstname.getText().toString()!=null && lastname.getText().toString()!=null
                                && email.getText().toString()!=null && password.getText().toString()!=null&&Address.getText().toString()!=null) {
                            Toast.makeText(SignupActivity.this, "user and password are correct", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent("com.example.rajaramya.task.MapsActivity");
                            startActivity(intent);
                        } else {
                            Toast.makeText(SignupActivity.this, "user and password are incorrect", Toast.LENGTH_SHORT).show();
                        }

                    }


                }
        );
    }







    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_signup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
