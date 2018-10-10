package com.creativityapps.gmailbackground;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.creativityapps.gmailbackgroundlibrary.BackgroundMail;

public class MainActivity extends AppCompatActivity {

    private EditText etToMail, etSubject, etBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button fab = (Button) findViewById(R.id.btnSend);
        etToMail = (EditText) findViewById(R.id.etToMail);
        etSubject = (EditText) findViewById(R.id.etSubject);
        etBody = (EditText) findViewById(R.id.etBody);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendTestEmail(etToMail.getText().toString(), etSubject.getText().toString(), etBody.getText().toString());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void sendTestEmail(String mailTO, String subject, String body) {
        ///https://www.google.com/settings/security/lesssecureapps
        // go above link and turn it on other wise sender email will not be able to send mail[important]
        /*BackgroundMail.newBuilder(this)
                .withUsername("tajmultipletrading@gmail.com")
                .withPassword("Multiple312")
                .withMailto("taj.cse37@gmail.com")
                .withSubject("this is the subject")
                .withBody("this is the body")
                .withProcessVisibility(false)
                .withOnSuccessCallback(new BackgroundMail.OnSuccessCallback() {
                    @Override
                    public void onSuccess() {
                        //do some magic
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                })
                .withOnFailCallback(new BackgroundMail.OnFailCallback() {
                    @Override
                    public void onFail() {
                        //do some magic
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                    }
                })
                .send();*/
        BackgroundMail.newBuilder(this)
                .withUsername("tajmultipletrading@gmail.com")
                .withPassword("Multiple312")
                .withMailto(mailTO)
                .withSubject(subject)
                .withBody(body)
                .withProcessVisibility(true)
                .withOnSuccessCallback(new BackgroundMail.OnSuccessCallback() {
                    @Override
                    public void onSuccess() {
                        //do some magic
                        Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                })
                .withOnFailCallback(new BackgroundMail.OnFailCallback() {
                    @Override
                    public void onFail() {
                        //do some magic
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();

                    }
                })
                .send();
    }
}
