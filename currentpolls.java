package crs.crs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import org.json.JSONObject;

import java.util.HashMap;


public class currentpolls extends AppCompatActivity {
    private static final String LOG ="currentpolls" ;
    String str;
    EditText test;
    Button polls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currentpolls);
       // test = (EditText) findViewById(R.id.test);

        Bundle bundle = getIntent().getExtras();
        final String account_number =bundle.getString("account_number");

        //polls = (Button) findViewById(R.id.button15);
        final Spinner dropdown = (Spinner) findViewById(R.id.spinner6);
        String[] items = new String[]{"Navigate", "Home", "Complaint Register", "Pollresult", "Similiar issue", "Currentpolls", "View Complaint", "Complaint about Person"};
        ArrayAdapter<String> adapter22 = new ArrayAdapter<>(currentpolls.this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter22);


                HashMap postdata = new HashMap();

                postdata.put("username" ,account_number);
               // postdata.put("password", "123");
           //     Log.d(LOG, str);

                PostResponseAsyncTask task1 = new PostResponseAsyncTask(currentpolls.this, postdata, new AsyncResponse() {
                    JSONObject e;


                    @Override
                    public void processFinish(String s) {
                        //Log.d(LOG, s);

                     //   if (s.contains("success")) {

                            //Toast.makeText(currentpolls.this, "successfully logged in", Toast.LENGTH_SHORT).show();

                      //  } else {
                       //     Toast.makeText(currentpolls.this, "invalid", Toast.LENGTH_SHORT).show();
                      //  }
                    }

                });
               //task1.execute("http://192.168.43.96/a/poll/session.php");

        WebView myWebView = (WebView) findViewById(R.id.webView);
        myWebView.loadUrl("http://192.168.0.104/a/poll/index.php" + "?username=" + account_number);






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

                       /* Intent intent19 = new Intent(currentpolls.this, Home.class);
                        startActivity(intent19);
                        break;

*/

                    case 2:
                        Bundle data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent9 = new Intent(currentpolls.this, complaintregister.class);
                        intent9.putExtras(data);

                        startActivity(intent9);
                        break;

                    case 3:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent91 = new Intent(currentpolls.this, pollresult.class);
                        intent91.putExtras(data);
                        startActivity(intent91);
                        break;

                    case 4:
                        data = new Bundle();

                        data.putString("account_number", account_number);

                        Intent intent1 = new Intent(currentpolls.this, similarIssues.class);
                        intent1.putExtras(data);
                        startActivity(intent1);
                        break;
                    case 5:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent2 = new Intent(currentpolls.this, currentpolls.class);
                        intent2.putExtras(data);
                        startActivity(intent2);
                        break;

                    case 6:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent21 = new Intent(currentpolls.this, ViewComplaint.class);
                        intent21.putExtras(data);
                        startActivity(intent21);
                        break;

                    case 7:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent23 = new Intent(currentpolls.this, complaintregisterissue.class);
                        intent23.putExtras(data);
                        startActivity(intent23);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

    }
}

