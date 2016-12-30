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
 * Created by v Arvind on 11/30/2016.
 */
public class CustomAdapter2 extends ArrayAdapter<Stuff2> {
    ArrayList<Stuff2> stuffs;
    Context context;
    int resource;
    public CustomAdapter2(Context context, int resource, ArrayList<Stuff2> stuffs) {
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
            row = layoutInflater.inflate(R.layout.custom_bill_list,null,true);
        }
        Stuff2 stuff = getItem(position);


        TextView textView1 = (TextView) row.findViewById(R.id.name);
        textView1.setText(stuff.getBillid());

        TextView textView2 = (TextView) row.findViewById(R.id.party);
        textView2.setText(stuff.getTitle());

        TextView textView3 = (TextView) row.findViewById(R.id.state);
        textView3.setText(stuff.getIntro());


        return row;
    }
}
