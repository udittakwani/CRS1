package crs.crs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class ViewComplaint extends AppCompatActivity{
    ArrayList<String> stringarray = new ArrayList<String>();
    ArrayList<String> stringarray1 = new ArrayList<String>();
    ListView listView,listView1;

    final String LOG = "ViewComplaint";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcompalint);

        Bundle bundle = getIntent().getExtras();
        final String account_number = bundle.getString("account_number");
        listView = (ListView) findViewById(R.id.namelist);
        listView1 = (ListView) findViewById(R.id.statuslist);
        Spinner dropdown = (Spinner) findViewById(R.id.spinner5);
        String[] items = new String[]{"Navigate", "Home", "Complaint Register", "Pollresult", "Similiar issue", "Currentpolls", "View Complaint", "Complaint about Person"};
        ArrayAdapter<String> adapter22 = new ArrayAdapter<>(ViewComplaint.this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter22);



        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_SHORT).show();

            }


            ;

            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int position, long row_id) {


                switch (position) {

                    case 1:
                        Bundle data = new Bundle();

                        data.putString("account_number", account_number);

                        Intent intent19 = new Intent(ViewComplaint.this, Home.class);
                        intent19.putExtras(data);
                        startActivity(intent19);
                        break;

                    case 2:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent9 = new Intent(ViewComplaint.this, complaintregister.class);
                        intent9.putExtras(data);
                        startActivity(intent9);
                        break;

                    case 3:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent91 = new Intent(ViewComplaint.this, pollresult.class);
                        intent91.putExtras(data);
                        startActivity(intent91);
                        break;

                    case 4:
                        data = new Bundle();

                        data.putString("account_number", account_number);

                        Intent intent1 = new Intent(ViewComplaint.this, similarIssues.class);
                        intent1.putExtras(data);
                        startActivity(intent1);
                        break;
                    case 5:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent2 = new Intent(ViewComplaint.this, currentpolls.class);
                        intent2.putExtras(data);
                        startActivity(intent2);
                        break;

                    case 6:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent21 = new Intent(ViewComplaint.this, ViewComplaint.class);
                        intent21.putExtras(data);
                        startActivity(intent21);
                        break;

                    case 7:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent23 = new Intent(ViewComplaint.this, complaintregisterissue.class);
                        intent23.putExtras(data);
                        startActivity(intent23);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

        Spinner types = (Spinner) findViewById(R.id.spinner11);
        String[] items2 = new String[]{"Navigate", "Against issue", "Against person", "Solved issue","Solved Person issue"};
        ArrayAdapter<String> adapter52 = new ArrayAdapter<>(ViewComplaint.this, android.R.layout.simple_spinner_dropdown_item, items2);
        types.setAdapter(adapter52);


        types.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub

                Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_SHORT).show();

            }


            ;

            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int position, long row_id) {


                switch (position) {

                    case 1:
                    {
                        stringarray.clear();
                        stringarray1.clear();
                        HashMap postdata = new HashMap();

                        postdata.put("account_number", account_number);
                        // postdata.put("password", "123");
                        Log.d(LOG, account_number);

                        PostResponseAsyncTask task1 = new PostResponseAsyncTask(ViewComplaint.this, postdata, new AsyncResponse() {
                            JSONArray e;


                            @Override
                            public void processFinish(String s) {
                                Log.d(LOG, s);

                                if (s.contains("Faliure")) {


                                } else {
                                    try {
                                        e = new JSONArray(s.toString());
                                    } catch (JSONException e1) {
                                        e1.printStackTrace();
                                    }

                                    for (int i = 0; i < e.length(); i++) {
                                        try {
                                            stringarray.add(i, e.getJSONObject(i).getString("status").toString());
                                            stringarray1.add(i, e.getJSONObject(i).getString("desc").toString());
                                        } catch (Exception e1) {
                                            e1.printStackTrace();
                                        }
                                    }
                                    ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.text_view1, stringarray1);

                                    listView.setAdapter(adapter);
                                    ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), R.layout.text_view2, stringarray);

                                    listView1.setAdapter(adapter1);

                                }

                            }

                        });

                        task1.execute("http://192.168.0.104/a/view.php");
                        break;
                    }

                    case 2:
                    {
                        stringarray.clear();
                        stringarray1.clear();
                        HashMap postdata = new HashMap();

                        postdata.put("account_number", account_number);
                        // postdata.put("password", "123");
                        Log.d(LOG, account_number);

                        PostResponseAsyncTask task1 = new PostResponseAsyncTask(ViewComplaint.this, postdata, new AsyncResponse() {
                            JSONArray e;


                            @Override
                            public void processFinish(String s) {
                                Log.d(LOG, s);

                                if (s.contains("Faliure")) {


                                } else {
                                    try {
                                        e = new JSONArray(s.toString());
                                    } catch (JSONException e1) {
                                        e1.printStackTrace();
                                    }

                                    for (int i = 0; i < e.length(); i++) {
                                        try {
                                            stringarray.add(i, e.getJSONObject(i).getString("status").toString());
                                            stringarray1.add(i, e.getJSONObject(i).getString("complaint_description").toString());
                                        } catch (Exception e1) {
                                            e1.printStackTrace();
                                        }
                                    }
                                    ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.text_view3, stringarray1);

                                    listView.setAdapter(adapter);
                                    ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), R.layout.text_view4, stringarray);

                                    listView1.setAdapter(adapter1);
                                }

                            }

                        });

                        task1.execute("http://192.168.0.104/a/against.php");
                        break;
                    }


                    case 3:
                    {
                        stringarray.clear();
                        stringarray1.clear();
                        HashMap postdata = new HashMap();

                        postdata.put("account_number", account_number);
                        // postdata.put("password", "123");
                        Log.d(LOG, account_number);

                        PostResponseAsyncTask task1 = new PostResponseAsyncTask(ViewComplaint.this, postdata, new AsyncResponse() {
                            JSONArray e;


                            @Override
                            public void processFinish(String s) {
                                Log.d(LOG, s);

                                if (s.contains("Faliure")) {


                                } else {
                                    try {
                                        e = new JSONArray(s.toString());
                                    } catch (JSONException e1) {
                                        e1.printStackTrace();
                                    }

                                    for (int i = 0; i < e.length(); i++) {
                                        try {

                                            stringarray1.add(i, e.getJSONObject(i).getString("desc").toString());
                                        } catch (Exception e1) {
                                            e1.printStackTrace();
                                        }
                                    }
                                    ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.text_view1, stringarray1);

                                    listView.setAdapter(adapter);

                                }

                            }

                        });

                        task1.execute("http://192.168.0.104/a/solved.php");
                        break;
                    }

                    case 4:
                    {
                        stringarray.clear();
                        stringarray1.clear();
                        HashMap postdata = new HashMap();

                        postdata.put("account_number", account_number);
                        // postdata.put("password", "123");
                        Log.d(LOG, account_number);

                        PostResponseAsyncTask task1 = new PostResponseAsyncTask(ViewComplaint.this, postdata, new AsyncResponse() {
                            JSONArray e;


                            @Override
                            public void processFinish(String s) {
                                Log.d(LOG, s);

                                if (s.contains("Faliure")) {


                                } else {
                                    try {
                                        e = new JSONArray(s.toString());
                                    } catch (JSONException e1) {
                                        e1.printStackTrace();
                                    }

                                    for (int i = 0; i < e.length(); i++) {
                                        try {
                                            stringarray1.add(i, e.getJSONObject(i).getString("complaint_description").toString());

                                        } catch (Exception e1) {
                                            e1.printStackTrace();
                                        }
                                    }
                                    ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.text_view3, stringarray1);
                                    listView.setAdapter(adapter);

                                }

                            }

                        });

                        task1.execute("http://192.168.0.104/a/solvedperson.php");
                        break;
                    }



                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }
    }