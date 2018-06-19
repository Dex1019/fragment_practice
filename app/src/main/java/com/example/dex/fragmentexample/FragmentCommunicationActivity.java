package com.example.dex.fragmentexample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class FragmentCommunicationActivity extends AppCompatActivity implements Fragment_one.OnMessageListener {


    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);

        if (findViewById(R.id.frag_message_container) != null) {

            if (savedInstanceState != null) {

                return;
            }

            Fragment_one fragment_one = new Fragment_one();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frag_message_container, fragment_one, null)
                    .commit();


        }


    }

    @Override
    public void onMessageRead(String message) {

        Fragment_two fragment_two = new Fragment_two();
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        fragment_two.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.frag_message_container, fragment_two, null);

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }
}
