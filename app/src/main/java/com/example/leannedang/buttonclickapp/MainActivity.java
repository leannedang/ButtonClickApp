package com.example.leannedang.buttonclickapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private TextView textView;
//    private int numTimesClicked = 0; //created int variable - keeps track of how many times we clicked button
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "TextContents";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = (EditText) findViewById(R.id.editText);
        userInput.setText(""); //sets it to empty when you first open it
        Button button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView); //title the same as title of widgets in activity_main
        textView.setText(""); //sets text in textView to blank string (nothing)
        textView.setMovementMethod(new ScrollingMovementMethod()); //makes textView scroll only bc added scroll in layout
        View.OnClickListener ourOnClickListener = new View.OnClickListener() { //created new object
            // as all widgets extend View, they know of this interface
            @Override
            public void onClick(View view) {
//                numTimesClicked = numTimesClicked + 1; //increments by 1 each time button is clicked
//                String result = "The button got tapped " + numTimesClicked + " time";
//                if(numTimesClicked != 1) {
//                    result += "s"; //this is the same as result = result + "s"
//                    //if clicked more than once, changes to "the button got tapped _ times"
//                }
//                result = result + "\n"; //no matter what time, always leaves a blank line after
//                textView.append(result); //calling append method to add line of text to TextView
                //uncomment above to print out statements after each time you click the button
                //below prints out what was in the textView after you click the button
                String result = userInput.getText().toString();
                //get text is returning an editable and calls toString method of that editable
                //final result is put into resultVariable
                result = result + "\n";
                textView.append(result);
                userInput.setText(""); //clears text each time after you click it
            }
        };
        button.setOnClickListener(ourOnClickListener); //want it to use ourOnClickListener whenever button is clicked
        //when button is clicked, will call the onClick method defined in line 27 and execute code from 28-30
        Log.d(TAG, "onCreate: out");
    }
    //following methods allow the app to save activities and restore them as you rotate phone
    //note: two most essential methods are onRestore and onSaveInstanceState
    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in"); //allows you to see what is going in the logcat as you use the app
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
//        String savedString = savedInstanceState.getString(TEXT_CONTENTS); //gets value that was stored in text contents & assign to string
//        //calling super method first to retrieve data from bundle
//        //then extracting info saved from bundle called TEXT_CONTENTS
//        textView.setText(savedString);
        //short cut for lines 71-74
        textView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) { //saves states that android doesnt know about e.g. state of textview
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, textView.getText().toString()); //saving current value of what is in textview into the bundle
        //putString before super b/c super is in charge of taking care of bundle
        //save value so it can be saved somewhere else
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume: in");
        super.onResume();
        Log.d(TAG, "onResume: out");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop: in");
        super.onStop();
        Log.d(TAG, "onStop: out");
    }
}
