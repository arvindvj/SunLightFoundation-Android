package com.example.varvind.congress;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

import bill_frag.active_bill;
import main_fragments.frag_bill;

public class Bill_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill__details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<Stuff2> myList = (ArrayList<Stuff2>) getIntent().getSerializableExtra("items");
        int pos = getIntent().getIntExtra("pos", 0);

        String id = myList.get(pos).getBillid();
        TextView textView1 = (TextView) findViewById(R.id.tvb1);
        textView1.setText(id);

        String title = myList.get(pos).getTitle();
        TextView textView2 = (TextView) findViewById(R.id.tvb2);
        textView2.setText(title);

        String billtype = myList.get(pos).getBilltype();
        TextView textView3 = (TextView) findViewById(R.id.tvb3);
        textView3.setText(billtype);

        String sponsor = myList.get(pos).getSponsor();
        TextView textView4 = (TextView) findViewById(R.id.tvb4);
        textView4.setText(sponsor);

        String chamber = myList.get(pos).getChamber();
        TextView textView5 = (TextView) findViewById(R.id.tvb5);
        textView5.setText(chamber);

        String active = myList.get(pos).getActive();
        String act = "";
        if (active.equals("true"))
            act = "Active";
        else
            act = "Inactive";
        TextView textView6 = (TextView) findViewById(R.id.tvb6);
        textView6.setText(act);

        String intro = myList.get(pos).getIntro();
        TextView textView7 = (TextView) findViewById(R.id.tvb7);
        textView7.setText(intro);

        String congurl = myList.get(pos).getCongurl();
        TextView textView8 = (TextView) findViewById(R.id.tvb8);
        textView8.setText(congurl);

        String version = myList.get(pos).getVersion();
        TextView textView9 = (TextView) findViewById(R.id.tvb9);
        textView9.setText(version);

        String billurl = myList.get(pos).getBillurl();
        TextView textView10 = (TextView) findViewById(R.id.tvb10);
        textView10.setText(billurl);




    }

    public boolean onOptionsItemSelected(MenuItem item){
        finish();
        return true;
    }
}
