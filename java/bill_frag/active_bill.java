package bill_frag;

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
import com.example.varvind.congress.CustomAdapter;
import com.example.varvind.congress.CustomAdapter2;
import com.example.varvind.congress.Leg_Details;
import com.example.varvind.congress.R;
import com.example.varvind.congress.Stuff2;

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
public class active_bill extends Fragment {
    ArrayList<Stuff2> arrayList;
    ListView lv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.billactive,container,false);
        arrayList = new ArrayList<>();
        lv = (ListView) view.findViewById(R.id.listView);
        lv.setFastScrollEnabled(true);

        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new ReadJSON().execute("http://custom-env.dxxbn3agvm.us-west-2.elasticbeanstalk.com/?retrieve=activebill");
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
                    String id = obj.getString("bill_id");
                    id = id.toUpperCase();
                    String type = obj.getString("bill_type");

                    String sponsor  = obj.getString("sponsor");
                    JSONObject spo = new JSONObject(sponsor);
                    String fn = spo.getString("first_name");
                    String ln = spo.getString("last_name");
                    String ti = spo.getString("title");
                    String name = ti + ". " + ln + ", " + fn;
                    String intro = obj.getString("introduced_on");
                    String short_title = obj.getString("official_title");
                    String shty;
                    if (short_title.equalsIgnoreCase("null"))
                        shty = "N/A";
                    else
                        shty = short_title;

                    String congurl1  = obj.getString("urls");
                    JSONObject url1 = new JSONObject(congurl1);
                    String congurl  = url1.getString("congress");

                    String billurl="N/A",version="N/A";

                    if(obj.has("last_version")) {
                        String billurl1  = obj.getString("last_version");
                        if (billurl1.equals("null")) {
                            billurl  = "N/A";

                            version  = "N/A";
                        }
                        else {
                            JSONObject burl = new JSONObject(billurl1);
                            String billur  = burl.getString("urls");
                            JSONObject bur = new JSONObject(billur);
                            billurl  = bur.getString("pdf");

                            version  = burl.getString("version_name");
                        }
                    }

                    String history  = obj.getString("history");
                    JSONObject his = new JSONObject(history);
                    String act  = his.getString("active");






                    String chamber  = obj.getString("chamber");

                    arrayList.add(new Stuff2(
                            id,
                            type,
                            name,
                            chamber,
                            intro,
                            congurl,
                            version,
                            billurl,
                            shty,
                            act
                    ));

                }
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
            CustomAdapter2 adapter = new CustomAdapter2(
                    getActivity(),R.layout.custom_bill_list,arrayList
            );
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //String press = (String) adapterView.getItemAtPosition(i);
                    Intent intent = new Intent(view.getContext(),Bill_Details.class);
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
