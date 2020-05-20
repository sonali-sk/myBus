package com.example.rand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SeatActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,View.OnClickListener {
    String[] sea= { "Seat1", "Seat2", "Seat3", "Seat4","Seat5","Seat6"};
    String[] boa= { "Kumaraswamy Layout", "Velachery", "Bandra", "Secunderabad","Other"};
    String[] arri={"Kumaraswamy Layout", "Velachery", "Bandra", "Secunderabad","Other"};
    String boar;
    String arriv;
    String seat;
    private Button conf;
    String travels;
    String dt;
    String pr;
    String currentDateString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat);
        conf=(Button) findViewById(R.id.conf);
        //adding listener to button
        conf.setOnClickListener(this);

        Spinner spin_seat = (Spinner) findViewById(R.id.seat_spinner);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter<String> ada = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sea);
        ada.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin_seat.setAdapter(ada);
        spin_seat.setOnItemSelectedListener(this);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin_board = (Spinner) findViewById(R.id.board_spinner);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter<String> ada1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,boa);
        ada1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin_board.setAdapter(ada1);
        spin_board.setOnItemSelectedListener(this);
        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin_arrive = (Spinner) findViewById(R.id.arrive_spinner);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter<String> ada2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arri);
        ada2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin_arrive.setAdapter(ada2);
        spin_arrive.setOnItemSelectedListener(this);
        Intent intent2=getIntent();
         travels=intent2.getStringExtra("key7");
        dt=intent2.getStringExtra("key8");
        pr=intent2.getStringExtra("key9");
        currentDateString=intent2.getStringExtra("key10");
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch(parent.getId()) {
            case R.id.seat_spinner:
                Toast.makeText(getApplicationContext(), sea[position], Toast.LENGTH_LONG).show();
                seat= parent.getItemAtPosition(position).toString();
                break;
            case R.id.board_spinner:Toast.makeText(getApplicationContext(), boa[position], Toast.LENGTH_LONG).show();
                boar = parent.getItemAtPosition(position).toString();
                break;
            case R.id.arrive_spinner:Toast.makeText(getApplicationContext(), arri[position], Toast.LENGTH_LONG).show();
                arriv = parent.getItemAtPosition(position).toString();
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if(v== conf){
            Intent intent3=new Intent(getApplicationContext(),DetailsActivity.class);
            intent3.putExtra("key4",seat);
            intent3.putExtra("key5",boar);
            intent3.putExtra("key6",arriv);
            intent3.putExtra("key11",travels);
            intent3.putExtra("key12",dt);
            intent3.putExtra("key13",pr);
            intent3.putExtra("key14",currentDateString);
            startActivity(intent3);
        }
    }
}
