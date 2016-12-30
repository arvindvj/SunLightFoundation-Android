package com_frag;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.varvind.congress.Bill_Details;
import com.example.varvind.congress.Comm_Details;
import com.example.varvind.congress.CustomAdapter3;
import com.example.varvind.congress.R;
import com.example.varvind.congress.Stuff3;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by v Arvind on 11/20/2016.
 */
public class joint_com extends Fragment {
    ArrayList<Stuff3> arrayList;
    ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.comjoint,container,false);
        arrayList = new ArrayList<>();
        lv = (ListView) view.findViewById(R.id.listView);
        lv.setFastScrollEnabled(true);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("http://custom-env.dxxbn3agvm.us-west-2.elasticbeanstalk.com/?retrieve=committeejoint");
            }
        });


        return view;
    }

    class ReadJSON extends AsyncTask<String,Integer,String> {
        @Override
        protected String doInBackground(String... strings) {
            return readURL(strings[0]);
        }

        @Override
        protected void onPostExecute(String s) {

            try {
                JSONArray jsonArray = new JSONArray(s);
                String string = (String) jsonArray.get(0);

                JSONObject jsonObject = new JSONObject(string);
                JSONArray resultsArray = jsonObject.getJSONArray("results");
                for (int i=0;i<resultsArray.length();i++) {
                    JSONObject obj = resultsArray.getJSONObject(i);
                    String id = obj.getString("committee_id");

                    String name  = obj.getString("name");

                    String chamber  = obj.getString("chamber");
                    chamber = chamber.substring(0,1).toUpperCase() + chamber.substring(1).toLowerCase();


                    String parentcom  = "";
                    if(obj.has("parent_committee_id")) {
                        parentcom  = obj.getString("parent_committee_id");
                        if (parentcom.equals("null"))
                            parentcom = "";
                    }


                    String contact  = obj.getString("phone");

                    String office="";
                    if(obj.has("office")) {
                        office = obj.getString("office");
                    }


                    arrayList.add(new Stuff3(
                            id,
                            name,
                            chamber,
                            parentcom,
                            contact,
                            office
                    ));

                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            CustomAdapter3 adapter = new CustomAdapter3(
                    getActivity(),R.layout.custom_com_list,arrayList
            );
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //String press = (String) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(view.getContext(),Comm_Details.class);

                    intent.putExtra("items",arrayList);
                    intent.putExtra("pos",i);
                    startActivity(intent);
                }
            });

        }
    }

    private static String readURL(String theUrl) {
        StringBuilder stringBuilder = new StringBuilder();
        HttpURLConnection httpURLConnection;

        try {
            URL url = new URL(theUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
