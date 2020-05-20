package com.example.rand;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Application;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private Button buttonLogout;
    private Button buttonNext;
    String[] source= { "Bangalore", "Chennai", "Mumbai", "Hyderabad","Other"};
    String[] dest={"Bangalore", "Chennai", "Mumbai", "Hyderabad","Other"};
    String src;
    String destv;
    String currentDateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.sort_by_spinner);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,source);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        spin.setOnItemSelectedListener(this);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin2 = (Spinner) findViewById(R.id.sort_by_spinner2);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter<String> aa1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,source);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin2.setAdapter(aa1);
        spin2.setOnItemSelectedListener(this);

        //initializing views
        Button date=(Button) findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker=new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonNext=(Button) findViewById(R.id.buttonNext);

        //displaying logged in user name


        //adding listener to button
        buttonNext.setOnClickListener(this);
        buttonLogout.setOnClickListener(this);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c=Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month);
        c.set(Calendar.DAY_OF_MONTH,dayOfMonth);
        currentDateString= DateFormat.getDateInstance(DateFormat.SHORT).format(c.getTime());

    }

    @Override


    //Performing action onItemSelected and onNothing selected
    public void onItemSelected(AdapterView<?> parent, View arg1, int position, long id) {
        switch(parent.getId()) {
            case R.id.sort_by_spinner:Toast.makeText(getApplicationContext(), source[position], Toast.LENGTH_LONG).show();
                                      src = parent.getItemAtPosition(position).toString();
                                      break;
            case R.id.sort_by_spinner2:Toast.makeText(getApplicationContext(), dest[position], Toast.LENGTH_LONG).show();
                                       destv = parent.getItemAtPosition(position).toString();
                                       break;
        }
    }
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    public void onClick(View view) {
        //if logout is pressed
        if(view == buttonLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
        if(view== buttonNext){
            Intent intent=new Intent(getApplicationContext(),AvailableActivity.class);
            intent.putExtra("key1",src);
            intent.putExtra("key2",destv);
            intent.putExtra("key3",currentDateString);
            startActivity(intent);
        }
    }
}
