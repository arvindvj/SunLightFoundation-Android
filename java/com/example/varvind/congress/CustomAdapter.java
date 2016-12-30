package com.example.varvind.congress;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by v Arvind on 11/25/2016.
 */
public class CustomAdapter extends ArrayAdapter<Stuff> {

    ArrayList<Stuff> stuffs;
    Context context;
    int resource;
    public CustomAdapter(Context context, int resource, ArrayList<Stuff> stuffs) {
        super(context, resource, stuffs);
        this.stuffs = stuffs;
        this.context = context;
        this.resource= resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;

        if (row == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.custom_list_layout,null,true);
        }
        Stuff stuff = getItem(position);

        ImageView imageView = (ImageView) row.findViewById(R.id.imageView1);
        Picasso.with(context).load(stuff.getImage()).into(imageView);

        TextView textView1 = (TextView) row.findViewById(R.id.name);
        textView1.setText(stuff.getName());

        TextView textView2 = (TextView) row.findViewById(R.id.state);
        textView2.setText(stuff.getState());

        TextView textView3 = (TextView) row.findViewById(R.id.party);
        textView3.setText(stuff.getParty());

        TextView textView4 = (TextView) row.findViewById(R.id.district);
        textView4.setText(stuff.getDistrict());

        return row;
    }
}
