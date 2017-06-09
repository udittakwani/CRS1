package crs.crs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {

    private static final String LOG ="Home";
   Button button15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        button15 = (Button)findViewById(R.id.button15);
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Bundle bundle = getIntent().getExtras();
        final String account_number =bundle.getString("account_number");
        Log.d(LOG, account_number);

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();

                data.putString("account_number", account_number);
                Intent intent = new Intent(Home.this, complaintregister.class);
                intent.putExtras(data);
                startActivity(intent);

            }
        });

        Button button8 = (Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();

                data.putString("account_number", account_number);
                Intent intent = new Intent(Home.this, ViewComplaint.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });


        Button button9 = (Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();

                data.putString("account_number", account_number);
                Intent intent = new Intent(Home.this, currentpolls.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });

        Button button11 = (Button) findViewById(R.id.button11);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();

                data.putString("account_number", account_number);
                Intent intent = new Intent(Home.this, pollresult.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });


        Button button10 = (Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle data = new Bundle();

                data.putString("account_number", account_number);Intent intent = new Intent(Home.this, similarIssues.class);
                intent.putExtras(data);
                startActivity(intent);

            }
        });

        Button button12 = (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();

                data.putString("account_number", account_number);
                Intent intent = new Intent(Home.this, complaintregisterissue.class);
                intent.putExtras(data);
                startActivity(intent);
            }
        });

    }
}
