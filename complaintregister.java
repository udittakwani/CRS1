package crs.crs;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by udit on 2/28/2017.
 */
public class complaintregister extends AppCompatActivity implements View.OnClickListener {
    private EditText fromDateEtxt;
    private EditText toDateEtxt;

    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;

    private SimpleDateFormat dateFormatter;
    EditText onelinedesc,desc,place;
    String text;
    Spinner field;
    EditText abc;
    final String LOG = "complaintregister";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        abc  =(EditText)findViewById(R.id.editText2);
        onelinedesc  =(EditText)findViewById(R.id.editText3);
        desc  =(EditText)findViewById(R.id.editText5);
        place =(EditText)findViewById(R.id.editText);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        findViewsById();
        setDateTimeField();

        Bundle bundle = getIntent().getExtras();
        final String account_number =bundle.getString("account_number");



        Spinner dropdown = (Spinner) findViewById(R.id.spinner);
        String[] items = new String[]{ "Navigate","Home", "Complaint Register","Pollresult", "Similiar issue", "Currentpolls","View Complaint","Complaint about Person"};
        ArrayAdapter<String> adapter22 = new ArrayAdapter<>(complaintregister.this, android.R.layout.simple_spinner_dropdown_item,items);
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
                        Intent intent19 = new Intent(complaintregister.this, Home.class);
                        intent19.putExtras(data);
                        startActivity(intent19);
                        break;

                    case 2:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent9 = new Intent(complaintregister.this, complaintregister.class);
                        intent9.putExtras(data);
                        startActivity(intent9);
                        break;

                    case 3:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent91 = new Intent(complaintregister.this, pollresult.class);
                        intent91.putExtras(data);
                        startActivity(intent91);
                        break;

                    case 4:
                        data = new Bundle();

                        data.putString("account_number", account_number);

                        Intent intent1 = new Intent(complaintregister.this, similarIssues.class);
                        intent1.putExtras(data);
                        startActivity(intent1);
                        break;
                    case 5:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent2 = new Intent(complaintregister.this, currentpolls.class);
                        intent2.putExtras(data);
                        startActivity(intent2);
                        break;

                    case 6:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent21 = new Intent(complaintregister.this, ViewComplaint.class);
                        intent21.putExtras(data);
                        startActivity(intent21);
                        break;

                    case 7:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent23 = new Intent(complaintregister.this, complaintregisterissue.class);
                        intent23.putExtras(data);
                        startActivity(intent23);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });
        field = (Spinner) findViewById(R.id.spinner4);
        String[] items1 = new String[]{ "RPF","BMC", "WOMAN","BEST", "POLICE"};
        ArrayAdapter<String> adapter21 = new ArrayAdapter<>(complaintregister.this, android.R.layout.simple_spinner_dropdown_item,items1);
        field.setAdapter(adapter21);


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
                Button button = (Button)findViewById(R.id.button3);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(onelinedesc.length() == 0 || onelinedesc.length()<4 || onelinedesc.length()>50) {

                            onelinedesc.setError("enter one line description");
                        }
                        else if(desc.length() == 0 || desc.length()<30 || desc.length()>200) {

                            desc.setError("enter description minimum 30 characters");
                        }
                        else if(place.length() == 0 ) {

                            place.setError("enter place of issue");
                        }

else {
                            HashMap postdata = new HashMap();
                            final String str = onelinedesc.getText().toString();
                            final String str1 = desc.getText().toString();
                            final String str2 = place.getText().toString();
                            final String str3 = fromDateEtxt.getText().toString();
                            // final String str3 = place.getText().toString();


                            postdata.put("name", account_number);
                            postdata.put("desc", str);
                            postdata.put("complaint_description", str1);
                            postdata.put("place", str2);
                            postdata.put("date", str3);
                            postdata.put("field", text);


                            PostResponseAsyncTask task1 = new PostResponseAsyncTask(complaintregister.this, postdata, new AsyncResponse() {

                                @Override
                                public void processFinish(String s) {
                                    Log.d(LOG, s);

                                    if (s.contains("success")) {

                                        Toast.makeText(complaintregister.this, "successfully Registered", Toast.LENGTH_SHORT).show();
                                        Bundle data = new Bundle();

                                        data.putString("account_number", account_number);
                                        Intent intent19 = new Intent(complaintregister.this, Home.class);
                                        intent19.putExtras(data);
                                        startActivity(intent19);


                                    } else {
                                        Toast.makeText(complaintregister.this, "invalid", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            });
                            task1.execute("http://192.168.0.104/a/register_complaint.php");
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });




    }
    private void findViewsById() {
        fromDateEtxt = (EditText) findViewById(R.id.editText10);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();

        //toDateEtxt = (EditText) findViewById(R.id.editText16);
        //toDateEtxt.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField() {
        fromDateEtxt.setOnClickListener( this);
//        toDateEtxt.setOnClickListener( this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == fromDateEtxt) {
            fromDatePickerDialog.show();
        } else if(view == toDateEtxt) {
            toDatePickerDialog.show();
        }
    }
}


