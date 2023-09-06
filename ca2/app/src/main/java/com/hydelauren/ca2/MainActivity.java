package com.hydelauren.ca2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.slide_left, R.animator.slide_left);
        ft.replace(R.id.your_placeholder, BlankFragment.newInstance(1, "hello!"), "firstFragment");
        ft.commit();
        return true;
    }

    public void submit(View view) {
        EditText field = findViewById(R.id.einput);
        String input = (String) (field.getText());
        ExerciseFragment fragmentB = (ExerciseFragment)getSupportFragmentManager().findFragmentByTag("firstFragment");
        fragmentB.check(input, getApplicationContext());
        //call fragment method on the input
    }
}