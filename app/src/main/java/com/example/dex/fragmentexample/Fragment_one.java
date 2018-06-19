package com.example.dex.fragmentexample;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_one extends Fragment {

    OnMessageListener messageListener;

    public Fragment_one() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        final EditText mMessage = view.findViewById(R.id.message_fragment_one);
        Button mSendMessage = view.findViewById(R.id.submit_fragment_one);

        mSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String readMessage = mMessage.getText().toString();

                messageListener.onMessageRead(readMessage);


            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;

        try {

            messageListener = (OnMessageListener) activity;

        } catch (ClassCastException e) {

            throw new ClassCastException(activity.toString() + "must implement onMessageSend...");

        }
    }


    public interface OnMessageListener {

        void onMessageRead(String message);
    }
}
