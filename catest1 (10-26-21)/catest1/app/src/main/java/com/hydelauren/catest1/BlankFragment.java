package com.hydelauren.catest1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public String[][] text = {
            {
                    "Caesar Shift",
                    "This is the most common cipher",
                    "It involves shifting the message over a certain number of letters",
                    "For example, if you have a letter A and the key is 5, your new letter would be F"
            },
            {
                    "Pig Latin",
                    "The pig latin cipher is often used verbally",
                    "It involves moving the first letter of the word to the end",
                    "For example, “Hello”",
                    "would become “Ellohay”"
            },
            {
                    "Vigenere",
                    "The vigenere cipher is an extension of the caesar shift",
                    "You pick a code word,and for each letter in the word,you do a caesar shift of that many letters on the message",
                    "Example:if the code word was “code”,you shift the first letter 2 places,the second letter 14,the third letter 3,and the fourth letter 4."
            },
            {
                    "Transposition",
                    "Another type of cipher is the transposition cipher",
                    "You put the letters in a chart of a certain length,and then read the message down the vertical columns",
                    "Example:if your chart length is 5,and your message is “hello my name is lauren” it would be read as this"
            }
    };

    // TODO: Rename and change types of parameters
    private int mParam1;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(int param1) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putInt("myint", param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        int cipher = getArguments().getInt("myint", 0);
        TextView heading = view.findViewById(R.id.heading);
        TextView intro = view.findViewById(R.id.intro);
        TextView main = view.findViewById(R.id.maintext);
        TextView ex = view.findViewById(R.id.example);
        heading.setText(text[cipher][0]);
        intro.setText(text[cipher][1]);
        main.setText(text[cipher][2]);
        ex.setText(text[cipher][3]);
    }
}
