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

public class MessageFragment extends Fragment {

    EditText mMessage;
    Button mSendButton;
    OnMessageReadListener onMessageReadListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message, container, false);
        mMessage = view.findViewById(R.id.et_message);
        mSendButton = view.findViewById(R.id.btn_submit);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mMessage.getText().toString();
                onMessageReadListener.onMessageRead(message);
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            onMessageReadListener = (OnMessageReadListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must override onMessageRead...");
        }
    }

    public interface OnMessageReadListener {
        void onMessageRead(String message);
    }
}
