package com.example.uniconvo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = (Button)findViewById(R.id.buutton);
        textView =  (TextView)findViewById(R.id.texttView);
        editText = (EditText)findViewById(R.id.edittText);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editText.getText().toString();
                int lbs = Integer.parseInt(s);
                double kg = lbs/2.20;
                textView.setText("The value of given pounds is " + kg + " kgs.");
            }
        });


    }
}