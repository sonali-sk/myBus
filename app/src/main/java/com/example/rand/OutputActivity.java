package com.example.rand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class OutputActivity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth firebaseAuth;
    private Button Logout;
    TextView seaf;
    TextView boardf;
    TextView arrivef;
    TextView travf,datecf,board_timef,prif,pnof,emailf,namef;
    String seat,boar,arriv,travels,dt,pr,currentDateString,n1,e1,p1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

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
        seaf=(TextView) findViewById(R.id.seaf);
        boardf=(TextView) findViewById(R.id.boardf);
        arrivef=(TextView) findViewById(R.id.arrivef);
        travf=(TextView)findViewById(R.id.travf);
        datecf=(TextView)findViewById(R.id.datecf);
        board_timef=(TextView)findViewById(R.id.board_timef);
        prif=(TextView)findViewById(R.id.prif);
        namef=(TextView)findViewById(R.id.namef);
        emailf=(TextView)findViewById(R.id.emailf);
        pnof=(TextView)findViewById(R.id.pnof);
        Intent intent4=getIntent();
        seat=intent4.getStringExtra("key15");
        boar=intent4.getStringExtra("key16");
        arriv=intent4.getStringExtra("key17");
        travels=intent4.getStringExtra("key18");
        dt=intent4.getStringExtra("key19");
        pr=intent4.getStringExtra("key20");
        currentDateString=intent4.getStringExtra("key21");
        n1=intent4.getStringExtra("key22");
        e1=intent4.getStringExtra("key23");
        p1=intent4.getStringExtra("key24");
        namef.setText(n1);
        emailf.setText(e1);
        pnof.setText(p1);
        seaf.setText(seat);
        boardf.setText(boar);
        arrivef.setText(arriv);
        travf.setText(travels);
        datecf.setText(currentDateString);
        board_timef.setText(dt);
        prif.setText(pr);
        Logout = (Button) findViewById(R.id.Logout);
        Logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == Logout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
