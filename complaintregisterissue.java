package crs.crs;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

public class complaintregisterissue extends AppCompatActivity implements View.OnClickListener {

    private EditText fromDateEtxt;
    private EditText toDateEtxt;

    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;

    private SimpleDateFormat dateFormatter;
    EditText name, desc,place,culpritname;
    String text;
    Spinner field;
    final String LOG = "complaintregisterissue";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complaintregisterissue);

        desc=(EditText)findViewById(R.id.editText6);
        place=(EditText)findViewById(R.id.editText8);
        culpritname=(EditText)findViewById(R.id.editText2);

        Button submit = (Button) findViewById(R.id.button5);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        Bundle bundle = getIntent().getExtras();
        final String account_number =bundle.getString("account_number");
        Log.d(LOG, account_number);
        findViewsById();
        setDateTimeField();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(culpritname.length() == 0 || culpritname.length()<3 || culpritname.length()>15) {

                    culpritname.setError("enter culpritname");
                }
                else if(desc.length() == 0 || desc.length()<30 || desc.length()>200) {

                    desc.setError("enter description minimum 30 characters");
                }
                else if(place.length() == 0 ) {

                    place.setError("enter place of issue");
                }

                else {

                    HashMap postdata = new HashMap();

                    final String str1 = desc.getText().toString();
                    final String str2 = place.getText().toString();

                    final String str5 = culpritname.getText().toString();
                    final String str3 = fromDateEtxt.getText().toString();


                    postdata.put("complaint_description", str1);
                    postdata.put("place", str2);
                    postdata.put("field", text);
                    postdata.put("name", account_number);
                    postdata.put("culprit_name", str5);
                    postdata.put("date", str3);


                    PostResponseAsyncTask task1 = new PostResponseAsyncTask(complaintregisterissue.this, postdata, new AsyncResponse() {

                        @Override
                        public void processFinish(String s) {
                            Log.d(LOG, s);

                            if (s.contains("success")) {

                                Toast.makeText(complaintregisterissue.this, "successfully logged in", Toast.LENGTH_SHORT).show();
                                Bundle data = new Bundle();

                                data.putString("account_number", account_number);
                                Intent intent19 = new Intent(complaintregisterissue.this, Home.class);
                                intent19.putExtras(data);
                                startActivity(intent19);

                            } else {
                                Toast.makeText(complaintregisterissue.this, "invalid", Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                    task1.execute("http://192.168.0.104/a/register_complaintperson.php");
                }
            }
        });

        Button button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(complaintregisterissue.this, Home.class);
                startActivity(intent);
            }
        });


        Spinner dropdown = (Spinner) findViewById(R.id.spinner2);
        String[] items = new String[]{ "Navigate","Home", "Complaint Register","Pollresult", "Similiar issue", "Currentpolls","View Complaint","Complaint about Person"};
        ArrayAdapter<String> adapter22 = new ArrayAdapter<>(complaintregisterissue.this, android.R.layout.simple_spinner_dropdown_item,items);
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
                        Intent intent19 = new Intent(complaintregisterissue.this, Home.class);
                        intent19.putExtras(data);
                        startActivity(intent19);
                        break;

                    case 2:
                        data = new Bundle();

                        data.putString("account_number", account_number);

                        Intent intent9 = new Intent(complaintregisterissue.this, complaintregister.class);
                        intent9.putExtras(data);
                        startActivity(intent9);
                        break;

                    case 3:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent91 = new Intent(complaintregisterissue.this, pollresult.class);
                        intent91.putExtras(data);
                        startActivity(intent91);
                        break;

                    case 4:
                        data = new Bundle();

                        data.putString("account_number", account_number);

                        Intent intent1 = new Intent(complaintregisterissue.this, similarIssues.class);
                        intent1.putExtras(data);
                        startActivity(intent1);
                        break;
                    case 5:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent2 = new Intent(complaintregisterissue.this, currentpolls.class);
                        intent2.putExtras(data);
                        startActivity(intent2);
                        break;

                    case 6:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent21 = new Intent(complaintregisterissue.this, ViewComplaint.class);
                        intent21.putExtras(data);
                        startActivity(intent21);
                        break;

                    case 7:
                        data = new Bundle();

                        data.putString("account_number", account_number);
                        Intent intent23 = new Intent(complaintregisterissue.this, complaintregisterissue.class);
                        intent23.putExtras(data);
                        startActivity(intent23);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }


        });



         field = (Spinner) findViewById(R.id.spinner3);
        String[] items1 = new String[]{ "RPF","BMC", "WOMAN","BEST", "POLICE"};
        ArrayAdapter<String> adapter23 = new ArrayAdapter<>(complaintregisterissue.this, android.R.layout.simple_spinner_dropdown_item,items1);
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
    private void findViewsById() {
        fromDateEtxt = (EditText) findViewById(R.id.editText7);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();

        //toDateEtxt = (EditText) findViewById(R.id.editText16);
        //toDateEtxt.setInputType(InputType.TYPE_NULL);
    }

    private void setDateTimeField() {
        fromDateEtxt.setOnClickListener(this);
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
