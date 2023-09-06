package com.hydelauren.catest1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.slide_left, R.animator.slide_left_off);
        ft.replace(R.id.your_placeholder, BlankFragment.newInstance(1, "hello!"), "firstFragment");
        ft.commit();
        TextView a = findViewById(R.id.a);
        TextView b = findViewById(R.id.b);
        TextView c = findViewById(R.id.c);
        TextView d = findViewById(R.id.d);
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
        return true;
    }

    public void submit(View view) {
        EditText field = findViewById(R.id.einput);
        String input = field.getText().toString();
        ExerciseFragment fragmentB = (ExerciseFragment)getSupportFragmentManager().findFragmentByTag("firstFragment");
        fragmentB.check(input, getApplicationContext());
        //call fragment method on the input
    }
}