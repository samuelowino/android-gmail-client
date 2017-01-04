package com.androidgeek.org.gmailclientapp;

import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText phoneField;


    private EditText messageField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        phoneField = (EditText) findViewById(R.id.phone_edit_text);
        messageField = (EditText) findViewById(R.id.message_edit_text);

    }

    public void sendMessage(View view) {
        try {

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneField.getText().toString(), null, messageField.getText().toString(), null, null);
            Toast.makeText(this, "Message Sent Succefully", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Toast.makeText(this, "Unable to send Text message", Toast.LENGTH_LONG).show();
            Log.d("Message",""+e.getMessage());
        }
    }
}
