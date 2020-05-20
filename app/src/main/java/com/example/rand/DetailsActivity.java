package com.example.rand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{
    TextView sea;
    TextView board;
    TextView arrive;
    TextView trav,datec,board_time,pri;
    private Button pay;
    String seat,boar,arriv,travels,dt,pr,currentDateString;
    EditText name,email,pno;
    String n1,e1,p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        pay=(Button) findViewById(R.id.pay);
        pay.setOnClickListener(this);
        sea=(TextView) findViewById(R.id.sea);
        board=(TextView) findViewById(R.id.board);
        arrive=(TextView) findViewById(R.id.arrive);
        trav=(TextView)findViewById(R.id.trav);
        datec=(TextView)findViewById(R.id.datec);
        board_time=(TextView)findViewById(R.id.board_time);
        pri=(TextView)findViewById(R.id.pri);
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        pno=(EditText)findViewById(R.id.pno);
        Intent intent3=getIntent();
       seat=intent3.getStringExtra("key4");
        boar=intent3.getStringExtra("key5");
        arriv=intent3.getStringExtra("key6");
        travels=intent3.getStringExtra("key11");
        dt=intent3.getStringExtra("key12");
        pr=intent3.getStringExtra("key13");
        currentDateString=intent3.getStringExtra("key14");
        sea.setText(seat);
        board.setText(boar);
        arrive.setText(arriv);
        trav.setText(travels);
        datec.setText(currentDateString);
        board_time.setText(dt);
        pri.setText(pr);

    }

    @Override
    public void onClick(View v) {
        if(v==pay){
            Intent intent4=new Intent(getApplicationContext(),OutputActivity.class);
            n1=name.getText().toString();
            e1=email.getText().toString();
            p1=pno.getText().toString();
            intent4.putExtra("key15",seat);
            intent4.putExtra("key16",boar);
            intent4.putExtra("key17",arriv);
            intent4.putExtra("key18",travels);
            intent4.putExtra("key19",dt);
            intent4.putExtra("key20",pr);
            intent4.putExtra("key21",currentDateString);
            intent4.putExtra("key22",n1);
            intent4.putExtra("key23",e1);
            intent4.putExtra("key24",p1);
            startActivity(intent4);
        }
    }
}
