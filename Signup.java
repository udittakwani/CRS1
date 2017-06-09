package crs.crs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity implements  View.OnClickListener{
    final String LOG = "Signup";
    String text;
    Spinner gender;

    EditText name, address, phoneno, password, age, username, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        name = (EditText) findViewById(R.id.editText4);
        address = (EditText) findViewById(R.id.editText11);
        phoneno = (EditText) findViewById(R.id.editText12);
        password = (EditText) findViewById(R.id.editText13);
        age = (EditText) findViewById(R.id.editText9);
        username = (EditText) findViewById(R.id.editText14);
        email = (EditText) findViewById(R.id.editText15);




        gender = (Spinner) findViewById(R.id.spinner8);
        String[] items1 = new String[]{"FEMALE", "MALE"};
        ArrayAdapter<String> adapter21 = new ArrayAdapter<>(Signup.this, android.R.layout.simple_spinner_dropdown_item, items1);
        gender.setAdapter(adapter21);


        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


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

                        text = gender.getSelectedItem().toString();


                    case 1:

                        text = gender.getSelectedItem().toString();


                }


                Button signup = (Button) findViewById(R.id.button13);
                signup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        final String email1 = email.getText().toString();
                        if (email1.length() == 0) {
                            email.setError("Invalid Email");

                        }

                        else if(name.length() == 0) {

                            name.setError("enter name");
                        }

                         else if(username.length() == 0) {

                             username.setError("enter username");
                         }
                         else if(password.getText().toString().length()<8 &&!isValidPassword(password.getText().toString())){
                             password.setError("password should be alfanumeric");

                         }

                         else if(age.length() > 2 || age.length() <  1) {

                             age.setError("Not Valid Age");
                         }

                         else if(phoneno.length() != 10) {

                             phoneno.setError("Not Valid Number");
                         }


                        else if(address.length() > 50 || address.length() <  5) {

                            address.setError("enter valid address between 5-50 character");
                        }


else {

                            HashMap postdata = new HashMap();
                            final String str = name.getText().toString();
                            final String str1 = address.getText().toString();
                            final String str2 = phoneno.getText().toString();
                            final String str3 = password.getText().toString();
                            final String str4 = age.getText().toString();
                            final String str5 = username.getText().toString();


                            postdata.put("name", str);
                            postdata.put("address", str1);
                            postdata.put("phone_no", str2);
                            postdata.put("password", str3);
                            postdata.put("age", str4);
                            postdata.put("username", str5);
                            postdata.put("gender", text);


                            PostResponseAsyncTask task1 = new PostResponseAsyncTask(Signup.this, postdata, new AsyncResponse() {
                                JSONObject e;
                                String account_number;

                                @Override
                                public void processFinish(String s) {
                                    Log.d(LOG, s);

                                    if (s.contains("success")) {

                                        Toast.makeText(Signup.this, "successfully registered", Toast.LENGTH_SHORT).show();
                                        //account_number = str;
                                        Intent log1 = new Intent(Signup.this, MainActivity.class);
                                        startActivity(log1);
                                    } else {
                                        Toast.makeText(Signup.this, "invalid", Toast.LENGTH_SHORT).show();
                                    }
                                }

                            });
                            task1.execute("http://192.168.0.104/a/register.php");
                        }
                    }
                });


                Button button14 = (Button) findViewById(R.id.button14);
                button14.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Signup.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });
    }

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }

    @Override
    public void onClick(View v) {

    }
}