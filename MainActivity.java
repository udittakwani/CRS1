package crs.crs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.genasync12.AsyncResponse;
import com.kosalgeek.genasync12.PostResponseAsyncTask;

import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText loginid,pass;
    final String LOG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginid = (EditText)findViewById(R.id.logid);
        pass = (EditText)findViewById(R.id.pass);

        Button register=(Button)findViewById(R.id.button2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Signup.class);
                startActivity(intent);
            }
        });
        final Button login = (Button) findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (loginid.length() == 0) {

                    loginid.setError("enter name");
                } else if (pass.length() == 0) {

                    pass.setError("enter password");
                } else {
                    HashMap postdata = new HashMap();
                    final String str = loginid.getText().toString();
                    final String str1 = pass.getText().toString();

                    postdata.put("username", str);
                    postdata.put("password", str1);


                    PostResponseAsyncTask task1 = new PostResponseAsyncTask(MainActivity.this, postdata, new AsyncResponse() {
                        JSONObject e;
                        String account_number;


                        @Override
                        public void processFinish(String s) {
                            Log.d(LOG, s);

                            if (s.contains("success")) {

                                Toast.makeText(MainActivity.this, "successfully logged in", Toast.LENGTH_SHORT).show();
                                account_number = str;
                                Bundle data = new Bundle();
                                data.putString("account_number", account_number);
                                Intent log1 = new Intent(MainActivity.this, Home.class);
                                log1.putExtras(data);
                                Log.d(LOG, String.valueOf(data));
                                startActivity(log1);
                            } else {
                                Toast.makeText(MainActivity.this, "invalid", Toast.LENGTH_SHORT).show();
                            }
                        }

                    });
                    task1.execute("http://192.168.0.104/a/login.php");


                }
            }
        });
}
}

