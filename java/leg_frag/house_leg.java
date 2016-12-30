package leg_frag;

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

import com.example.varvind.congress.CustomAdapter;
import com.example.varvind.congress.Leg_Details;
import com.example.varvind.congress.R;
import com.example.varvind.congress.Stuff;

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
public class house_leg extends Fragment {
    ArrayList<Stuff> arrayList;
    ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.leghouse,container,false);
        arrayList = new ArrayList<>();
        lv = (ListView) view.findViewById(R.id.listView);
        lv.setFastScrollEnabled(true);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("http://custom-env.dxxbn3agvm.us-west-2.elasticbeanstalk.com/?retrieve=legislatorhouse");
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
                    String id = obj.getString("bioguide_id");
                    String fn = obj.getString("first_name");
                    String ln = obj.getString("last_name");
                    String name = ln + ", " + fn;
                    String party = "(" + obj.getString("party") + ") ";
                    String state = obj.getString("state_name");
                    String pic = "https://theunitedstates.io/images/congress/225x275/" + id + ".jpg";
                    String dis = obj.getString("district");
                    String district;
                    if (dis.equalsIgnoreCase("null"))
                        district = "";
                    else
                        district = " -   District " + dis;

                    String title  = obj.getString("title") + ". ";
                    String email  = obj.getString("oc_email");
                    String chamber  = obj.getString("chamber");
                    String contact  = obj.getString("phone");
                    String start  = obj.getString("term_start");
                    String end  = obj.getString("term_end");
                    String office  = obj.getString("office");
                    String fax = obj.getString("fax");
                    String birthday  = obj.getString("birthday");

                    arrayList.add(new Stuff(
                            pic,
                            name,
                            party,
                            state,
                            district,
                            title,
                            email,
                            chamber,
                            contact,
                            start,
                            end,
                            office,
                            fax,
                            birthday
                    ));

                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            CustomAdapter adapter = new CustomAdapter(
                    getActivity(),R.layout.custom_list_layout,arrayList
            );
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //String press = (String) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(view.getContext(),Leg_Details.class);
                    String project_name = arrayList.get(i).getName();
                    intent.putExtra("Name",project_name);
                    String pic = arrayList.get(i).getImage();
                    intent.putExtra("pic",pic);
                    String party = arrayList.get(i).getParty();
                    intent.putExtra("party",party);
                    String title = arrayList.get(i).getTitle();
                    intent.putExtra("title",title);
                    String state = arrayList.get(i).getState();
                    intent.putExtra("state",state);
                    String email = arrayList.get(i).getEmail();
                    intent.putExtra("email",email);
                    String chamber = arrayList.get(i).getChamber();
                    intent.putExtra("chamber",chamber);
                    String contact = arrayList.get(i).getContact();
                    intent.putExtra("contact",contact);
                    String start = arrayList.get(i).getStart();
                    intent.putExtra("start",start);
                    String end = arrayList.get(i).getEnd();
                    intent.putExtra("end",end);
                    String office = arrayList.get(i).getOffice();
                    intent.putExtra("office",office);
                    String fax = arrayList.get(i).getFax();
                    intent.putExtra("fax",fax);
                    String birthday = arrayList.get(i).getBirthday();
                    intent.putExtra("birthday",birthday);
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
