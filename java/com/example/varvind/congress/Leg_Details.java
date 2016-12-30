package com.example.varvind.congress;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Leg_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg__details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        String pic = getIntent().getStringExtra("pic");
        ImageView pici = (ImageView) findViewById(R.id.imgpic);
        Picasso.with(this).load(pic).into(pici);

        String projectname = getIntent().getStringExtra("Name");
        TextView textView = (TextView) findViewById(R.id.textView1);
        String party = getIntent().getStringExtra("party");
        String par;
        ImageView pari = (ImageView) findViewById(R.id.ivparty);

        if (party.equals("(R) ")) {
            par = "Republican";
            String uri = "@drawable/r";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            pari.setImageDrawable(res);
        }
        else {
            par = "Democrat";
            String uri = "@drawable/d";
            int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            Drawable res = getResources().getDrawable(imageResource);
            pari.setImageDrawable(res);
        }
        TextView partyt = (TextView) findViewById(R.id.tvparty);
        partyt.setText(par);
        String state = getIntent().getStringExtra("state");
        TextView statet = (TextView) findViewById(R.id.textView9);
        statet.setText(state);
        String title = getIntent().getStringExtra("title")+projectname;
        textView.setText(title);
        String email = getIntent().getStringExtra("email");
        TextView emailt = (TextView) findViewById(R.id.textView2);
        emailt.setText(email);
        String chamber = getIntent().getStringExtra("chamber");
        TextView chambert = (TextView) findViewById(R.id.textView3);
        chamber = chamber.substring(0,1).toUpperCase() + chamber.substring(1).toLowerCase();
        chambert.setText(chamber);
        String contact = getIntent().getStringExtra("contact");
        TextView contactt = (TextView) findViewById(R.id.textView4);
        contactt.setText(contact);
        String start = getIntent().getStringExtra("start");
        TextView startt = (TextView) findViewById(R.id.textView5);
        startt.setText(start);
        String end = getIntent().getStringExtra("end");
        TextView endt = (TextView) findViewById(R.id.textView6);
        endt.setText(end);
        String office = getIntent().getStringExtra("office");
        TextView officet = (TextView) findViewById(R.id.textView8);
        officet.setText(office);
        String fax = getIntent().getStringExtra("fax");
        TextView faxt = (TextView) findViewById(R.id.textView10);
        faxt.setText(fax);
        String birthday = getIntent().getStringExtra("birthday");
        TextView birthdayt = (TextView) findViewById(R.id.textView11);
        birthdayt.setText(birthday);

        ProgressBar mProgress = (ProgressBar) findViewById(R.id.progress_bar);
        mProgress.setProgress(60);


    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;

    }
}
