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

    int numClicks = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(numClicks>3) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.animator.slide_left, R.animator.slide_left_off);
            //ft.replace(R.id.your_placeholder, BlankFragment.newInstance(1, "hello!"), "firstFragment");
            ft.replace(R.id.your_placeholder, Homescreen.newInstance("hi", "hello!"), "homes");
            ft.commit();
            TextView a = findViewById(R.id.a);
            TextView b = findViewById(R.id.b);
            TextView c = findViewById(R.id.c);
            TextView d = findViewById(R.id.d);
            a.setText("");
            b.setText("");
            c.setText("");
            d.setText("");
        }
        else{
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.animator.slide_left, R.animator.slide_left_off);
            ft.replace(R.id.your_placeholder, BlankFragment.newInstance(numClicks), "firstFragment");
            ft.commit();
            TextView a = findViewById(R.id.a);
            TextView b = findViewById(R.id.b);
            TextView c = findViewById(R.id.c);
            TextView d = findViewById(R.id.d);
            a.setText("");
            b.setText("");
            c.setText("");
            d.setText("");
        }
        numClicks++;
        return true;
    }

    public void submit(View view) {
        EditText field = findViewById(R.id.einput);
        String input = field.getText().toString();
        ExerciseFragment fragmentB = (ExerciseFragment)getSupportFragmentManager().findFragmentByTag("ef");
        fragmentB.check(input, getApplicationContext());
        //call fragment method on the input
    }

    public void decrypt(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.slide_left, R.animator.slide_left_off);
        Homescreen fragmentB = (Homescreen) getSupportFragmentManager().findFragmentByTag("homes");
        ft.hide(fragmentB);
        ft.add(R.id.your_placeholder,
                DecryptFragment.newInstance(1),
                "df");

        ft.commit();
    }

    public void encrypt(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.slide_left, R.animator.slide_left_off);

        Homescreen fragmentB = (Homescreen) getSupportFragmentManager().findFragmentByTag("homes");
        ft.hide(fragmentB);
        ft.add(R.id.your_placeholder,
                ExerciseFragment.newInstance(1),
                "ef");
        //ExerciseFragment fe = ExerciseFragment.newInstance("hello", "hello!");
        //ft.add(fe);

        ft.commit();
    }

    public void submit2(View view) {
        EditText field = findViewById(R.id.einput);
        String input = field.getText().toString();
        DecryptFragment fragmentB = (DecryptFragment) getSupportFragmentManager().findFragmentByTag("df");
        fragmentB.check(input, getApplicationContext());
        //call fragment method on the input
    }

    public void ereset(View view) {
        ExerciseFragment fragmentB = (ExerciseFragment) getSupportFragmentManager().findFragmentByTag("ef");
        fragmentB.reset();
    }

    public void dreset(View view) {
        DecryptFragment fragmentB = (DecryptFragment) getSupportFragmentManager().findFragmentByTag("df");
        fragmentB.reset();
    }

    public void button(View view) {
        if(numClicks>3) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.animator.slide_left, R.animator.slide_left_off);
            //ft.replace(R.id.your_placeholder, BlankFragment.newInstance(1, "hello!"), "firstFragment");
            ft.replace(R.id.your_placeholder, Homescreen.newInstance("hi", "hello!"), "homes");
            ft.commit();
            TextView a = findViewById(R.id.a);
            TextView b = findViewById(R.id.b);
            TextView c = findViewById(R.id.c);
            TextView d = findViewById(R.id.d);
            a.setText("");
            b.setText("");
            c.setText("");
            d.setText("");
        }
        else{
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.animator.slide_left, R.animator.slide_left_off);
            ft.replace(R.id.your_placeholder, BlankFragment.newInstance(numClicks), "firstFragment");
            ft.commit();
            TextView a = findViewById(R.id.a);
            TextView b = findViewById(R.id.b);
            TextView c = findViewById(R.id.c);
            TextView d = findViewById(R.id.d);
            a.setText("");
            b.setText("");
            c.setText("");
            d.setText("");
        }
        numClicks++;
    }
}