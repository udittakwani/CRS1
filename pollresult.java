package crs.crs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


public class pollresult extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pollresult);


        Bundle bundle = getIntent().getExtras();
        final String account_number =bundle.getString("account_number");

        Spinner dropdown = (Spinner) findViewById(R.id.spinner7);
        String[] items = new String[]{ "Navigate","Home", "Complaint Register","Pollresult", "Similiar issue", "Currentpolls","View Complaint","Complaint about Person"};
        ArrayAdapter<String> adapter22 = new ArrayAdapter<>(pollresult.this, android.R.layout.simple_spinner_dropdown_item,items);
        dropdown.setAdapter(adapter22);
        WebView myWebView = (WebView) findViewById(R.id.webView2);
        myWebView.loadUrl("http://192.168.0.104/a/poll/view.php" + "?username=" + account_number);


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
                        Intent intent19 = new Intent(pollresult.this, Home.class);
                        intent19.putExtras(data);
                        startActivity(intent19);

                        break;

                    case 2:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent9 = new Intent(pollresult.this, complaintregister.class);
                        intent9.putExtras(data);
                        startActivity(intent9);

                        break;

                    case 3:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent91 = new Intent(pollresult.this, pollresult.class);
                        intent91.putExtras(data);
                        startActivity(intent91);
                        break;

                    case 4:
                        data = new Bundle();

                        data.putString("account_number", account_number);

                        Intent intent1 = new Intent(pollresult.this, similarIssues.class);
                        intent1.putExtras(data);
                        startActivity(intent1);
                        break;
                    case 5:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent2 = new Intent(pollresult.this, currentpolls.class);
                        intent2.putExtras(data);
                        startActivity(intent2);
                        break;

                    case 6:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent21 = new Intent(pollresult.this, ViewComplaint.class);
                        intent21.putExtras(data);
                        startActivity(intent21);
                        break;

                    case 7:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent23 = new Intent(pollresult.this, complaintregisterissue.class);
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
