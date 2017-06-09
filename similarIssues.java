package crs.crs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by udit on 2/27/2017.
 */
public class similarIssues extends AppCompatActivity{
    private static final String LOG ="similarIssues" ;
Spinner field;
    String text;
    EditText search;
    ListView listView,listView1;
    Button button16;
    ArrayList<String> stringarray = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.similarissues);
        listView = (ListView) findViewById(R.id.listView);
        search=(EditText)findViewById(R.id.editText16);
        button16 = (Button)findViewById(R.id.button16);
        Bundle bundle = getIntent().getExtras();
        final String account_number =bundle.getString("account_number");
        Log.d(LOG, account_number);
        final Spinner dropdown = (Spinner) findViewById(R.id.spinner9);
        String[] items = new String[]{ "Navigate","Home", "Complaint Register","Pollresult", "Similiar issue", "Currentpolls","View Complaint","Complaint about Person"};
        ArrayAdapter<String> adapter22 = new ArrayAdapter<>(similarIssues.this, android.R.layout.simple_spinner_dropdown_item,items);
        dropdown.setAdapter(adapter22);
         final String str1 = search.getText().toString();



 button16.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         stringarray.clear();
         HashMap postdata = new HashMap();


         postdata.put("complaint_description", str1);
         postdata.put("field", text);


         PostResponseAsyncTask task1 = new PostResponseAsyncTask(similarIssues.this, postdata, new AsyncResponse() {
             JSONArray e;


             @Override
             public void processFinish(String s) {
                 Log.d(LOG, s);


                 try {
                     e = new JSONArray(s.toString());
                 } catch (JSONException e1) {
                     e1.printStackTrace();
                 }

                 for (int i = 0; i < e.length(); i++) {
                     try {
                         stringarray.add(i, e.getJSONObject(i).getString("complaint_description").toString());

                     } catch (Exception e1) {
                         e1.printStackTrace();
                     }
                 }

                 ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), R.layout.text_view3, stringarray);

                 listView.setAdapter(adapter1);
             }


         });

         task1.execute("http://192.168.0.104/a/similar.php");
     }
 });





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

                        Intent intent19 = new Intent(similarIssues.this, Home.class);
                        intent19.putExtras(data);
                        startActivity(intent19);
                        break;

                    case 2:
                        data = new Bundle();

                        data.putString("account_number", account_number);

                        Intent intent9 = new Intent(similarIssues.this, complaintregister.class);
                        intent9.putExtras(data);
                        startActivity(intent9);
                        break;

                    case 3:
                        data = new Bundle();

                        data.putString("account_number", account_number);

                        Intent intent91 = new Intent(similarIssues.this, pollresult.class);
                        intent91.putExtras(data);
                        startActivity(intent91);
                        break;

                    case 4:
                        data = new Bundle();

                        data.putString("account_number", account_number);


                        Intent intent1 = new Intent(similarIssues.this, similarIssues.class);
                        intent1.putExtras(data);
                        startActivity(intent1);
                        break;
                    case 5:
                        data = new Bundle();

                        data.putString("account_number", account_number);

                        Intent intent2 = new Intent(similarIssues.this, currentpolls.class);
                        intent2.putExtras(data);
                        startActivity(intent2);
                        break;

                    case 6:
                        data = new Bundle();

                        data.putString("account_number", account_number);

                        Intent intent21 = new Intent(similarIssues.this, ViewComplaint.class);
                        intent21.putExtras(data);
                        startActivity(intent21);
                        break;

                    case 7:
                        data = new Bundle();

                        data.putString("account_number", account_number);

                        Intent intent23 = new Intent(similarIssues.this, complaintregisterissue.class);
                        intent23.putExtras(data);
                        startActivity(intent23);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
        field = (Spinner) findViewById(R.id.spinner10);
        String[] items1 = new String[]{ "RPF","BMC", " WOMEN","BEST", "POLICE"};
        ArrayAdapter<String> adapter23 = new ArrayAdapter<>(similarIssues.this, android.R.layout.simple_spinner_dropdown_item,items1);
        field.setAdapter(adapter23);

        field.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                Toast.makeText(getApplicationContext(), "msg msg", Toast.LENGTH_SHORT).show();

            }


            ;

            @Override
            public void onItemSelected(AdapterView<?> arg0, View view,
                                       int position, long row_id) {


                switch (position) {

                    case 0:

                        text = field.getSelectedItem().toString();


                    case 1:

                        text = field.getSelectedItem().toString();


                    case 2:

                        text = field.getSelectedItem().toString();


                    case 3:


                        text = field.getSelectedItem().toString();

                    case 4:

                        text = field.getSelectedItem().toString();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });

    }

}
