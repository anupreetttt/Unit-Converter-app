package com.example.uniconvo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //declaring the variables
    //button, texView and all are same as there are XML functions, but variable names will be different
    private Button button; // button is an variable
    private TextView textView;
    private EditText editText;
    private Button ton; //ton is an variable

    // First super.onCreate(savedInstanceState); calls the method in the superclass and saved InstanceState of the activity if any thing damage the activity so its saved in instanceState so when reload the activity it will be the same before.
    @Override
    protected void onCreate(Bundle savedInstanceState) { //initialize the activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //fetching information from XML file & for placing the UI

        // finding the functions info from their IDs by using findViewById(R.id.functionID);
        button = (Button) findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        ton = (Button) findViewById(R.id.button2);

        //function for what happens after the button the button is clicked
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, " Converted!", Toast.LENGTH_SHORT).show(); // on click "Text" will be highlighted
                String s = editText.getText().toString(); // converting string into int, as input will be text in the form of string.
                int kg = Integer.parseInt(s); //parsing string into integer
                double lbs = 2.20 * kg;
                textView.setText("The value of given Kgs is " + lbs + " lbs.");
            }
        });
        // button = findViewById(R.id.button2);
        ton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
              openMainActivity2();
            }
        });
    }
    public void openMainActivity2() {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }


}