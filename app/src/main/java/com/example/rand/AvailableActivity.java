package com.example.rand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AvailableActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView receiver_msg;
    private TextView DuT;
    private TextView Time;
    private TextView Price;
    private TextView SrT;
    private TextView Time1;
    private TextView Price1;
    private TextView SaT;
    private TextView Time2;
    private TextView Price2;
    private Button b1;
    private Button b2;
    private Button b3;
    String currentDateString,tr1,tr2,tr3,dt1,dt2,dt3,pr1,pr2,pr3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3);
        //adding listener to button
        b1.setOnClickListener(this);
        //adding listener to button
        b2.setOnClickListener(this);
        //adding listener to button
        b3.setOnClickListener(this);
        receiver_msg=(TextView) findViewById(R.id.receive);
        DuT=(TextView) findViewById(R.id.DuT);
        Time=(TextView) findViewById(R.id.Time);
        Price=(TextView) findViewById(R.id.Price);
        SrT=(TextView) findViewById(R.id.SrT);
        Time1=(TextView) findViewById(R.id.Time1);
        Price1=(TextView) findViewById(R.id.Price1);
        SaT=(TextView) findViewById(R.id.SaT);
        Time2=(TextView) findViewById(R.id.Time2);
        Price2=(TextView) findViewById(R.id.Price2);
        Intent intent=getIntent();
        String src=intent.getStringExtra("key1");
        String destv=intent.getStringExtra("key2");
        currentDateString=intent.getStringExtra("key3");
        receiver_msg.setText("Available Buses:\t"+currentDateString+"\n"+src+" to "+destv);
        tr1=DuT.getText().toString();
        dt1=Time.getText().toString();
        pr1=Price.getText().toString();
        tr2=SrT.getText().toString();
        dt2=Time1.getText().toString();
        pr2=Price1.getText().toString();
        tr3=SaT.getText().toString();
        dt3=Time2.getText().toString();
        pr3=Price2.getText().toString();
    }

    @Override
    public void onClick(View v) {
        if(v== b1){
            Intent intent2=new Intent(getApplicationContext(),SeatActivity.class);
            intent2.putExtra("key7",tr1);
            intent2.putExtra("key8",dt1);
            intent2.putExtra("key9",pr1);
            intent2.putExtra("key10",currentDateString);
            startActivity(intent2);
        }
        if(v== b2){
            Intent intent2=new Intent(getApplicationContext(),SeatActivity.class);
            intent2.putExtra("key7",tr2);
            intent2.putExtra("key8",dt2);
            intent2.putExtra("key9",pr2);
            intent2.putExtra("key10",currentDateString);
            startActivity(intent2);
        }
        if(v== b3){
            Intent intent2=new Intent(getApplicationContext(),SeatActivity.class);
            intent2.putExtra("key7",tr3);
            intent2.putExtra("key8",dt3);
            intent2.putExtra("key9",pr3);
            intent2.putExtra("key10",currentDateString);
            startActivity(intent2);
        }
    }
}
