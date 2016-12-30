package com.example.varvind.congress;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class Comm_Details extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_comm__details);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);

            ArrayList<Stuff3> myList = (ArrayList<Stuff3>) getIntent().getSerializableExtra("items");
            int pos = getIntent().getIntExtra("pos", 0);

            String id = myList.get(pos).getId();
            TextView textView1 = (TextView) findViewById(R.id.tvc1);
            textView1.setText(id);

            String title = myList.get(pos).getName();
            TextView textView2 = (TextView) findViewById(R.id.tvc2);
            textView2.setText(title);

            String billtype = myList.get(pos).getChamber();
            TextView textView3 = (TextView) findViewById(R.id.tvc3);
            textView3.setText(billtype);

            String sponsor = myList.get(pos).getParentcom();
            TextView textView4 = (TextView) findViewById(R.id.tvc4);
            textView4.setText(sponsor);

            String chamber = myList.get(pos).getContact();
            TextView textView5 = (TextView) findViewById(R.id.tvc5);
            textView5.setText(chamber);

            String office = myList.get(pos).getContact();
            TextView textView6 = (TextView) findViewById(R.id.tvc6);
            textView6.setText(office);


        }

        public boolean onOptionsItemSelected(MenuItem item){
            finish();
            return true;
        }
    }
