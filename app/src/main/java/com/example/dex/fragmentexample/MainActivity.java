package com.example.dex.fragmentexample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageReadListener {


    FragmentManager fragmentManager;
    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        tvMessage = findViewById(R.id.txt_display_message);

        if (findViewById(R.id.messageFragmentContainer) != null) {

            if (savedInstanceState != null) {
                return;
            }


            MessageFragment messageFragment = new MessageFragment();

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.messageFragmentContainer, messageFragment, null);
            fragmentTransaction.commit();
        }

    }

    @Override
    public void onMessageRead(String message) {

        tvMessage.setText(message);

    }
}
