package com.hydelauren.ca2;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExerciseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExerciseFragment extends Fragment {
    String[] phraseBank = {
            "Have a nice day",
            "What time is it?",
            "Today is tuesday",
            "My name is lauren",
            "Do you speak german?",
            "Nice to meet you",
            "I went to the dentist today",
            "Pesto pasta",
            "I am in eleventh grade",
            "This is the secret code message",
            "Take a walk",
            "Happy fall!",
            "The sunset is pretty today",
            "My brother is thirteen",
            "Go bake a cake",
            "Rewind the tv",
            "Luke I am your father",
            "Its all greek to me",
            "You are awesome!"
    };
    String translated;
    int cipher;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ExerciseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExerciseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExerciseFragment newInstance(String param1, String param2) {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int rand = (int)(Math.random()*phraseBank.length);
        String phrase = phraseBank[rand];
        translate(cipher, phrase);
        TextView phraseView = view.findViewById(R.id.ephrase);
        phraseView.setText("Phrase: " + phrase);
    }
    public String translate(int cipher, String phrase){ //arguments from bundle
        translated = "";
        return "";
    }

    public void check(String input, Context cont) {
        if(input.equals(translated)){
            //toast displaying "correct"
            Context context = cont; //pass context??
            //CharSequence text = "click clack!";
            CharSequence text = "correct!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            //activate button saying practice another (or turn a diff color)

        }
        else{
            Context context = cont; //pass context??
            //CharSequence text = "click clack!";
            CharSequence text = "try again";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}