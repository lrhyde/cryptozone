package com.hydelauren.catest1;

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
 * Use the {@link DecryptFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DecryptFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    String translated;
    String phrase;
    View mView;
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
    String[] vigenereKeys = {
            "apple",
            "banana",
            "grape",
            "love",
            "code",
            "egg",
            "bread",
            "cipher",
            "fun"
    };

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String vowels = "aeiou";
    public static int cipher;

    public DecryptFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DecryptFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DecryptFragment newInstance(int c) {
        DecryptFragment fragment = new DecryptFragment();
        cipher = c;
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public String translate(int cipher, String phrase, View view) { //arguments from bundle
        translated = "";
        String[] array = phrase.split(" ");
        String key = "";
        if(cipher==0){ //caesar
            int shift = (int)(Math.random()*26);
            key = "" + shift;
            for(int x = 0; x < array.length; x++){
                translated+=caesar(array[x], shift) + " ";
            }
        }
        if(cipher==1){ //pig latin
            for(int x = 0; x < array.length; x++){
                translated+=pigLatin(array[x]) + " ";
            }
            key = "none";
        }
        if(cipher==2){ //vigenere
            int k = (int)(Math.random()*vigenereKeys.length);
            key = vigenereKeys[k];
            //for(int x = 0; x < array.length(); x++){
            //translated+=vigenere(array[x], key) + " ";
            //}
            translated = vigenere(phrase, key);
        }
        if(cipher==3){ //transposition
            int k = (int)(Math.random()*8+2);
            key = "" + k;
            translated+=transposition(phrase, k) + " ";
        }
        TextView myKey = view.findViewById(R.id.dkey);
        myKey.setText("key: " + key);
        return translated;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void check(String input, Context cont) {
        if (input.equals(phrase)) {
            //toast displaying "correct"
            Context context = cont; //pass context??
            //CharSequence text = "click clack!";
            CharSequence text = "correct!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            //activate button saying practice another (or turn a diff color)

        } else {
            Context context = cont; //pass context??
            //CharSequence text = "click clack!";
            CharSequence text = "try again";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_decrypt, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int rand = (int)(Math.random()*phraseBank.length);
        phrase = phraseBank[rand];
        mView = view;
        translated = translate(cipher, phrase, view);
        TextView phraseView = view.findViewById(R.id.dphrase);
        phraseView.setText(translated);
    }

    public void reset() {
        int rand = (int)(Math.random()*phraseBank.length);
        phrase = phraseBank[rand];
        translated = translate(cipher, phrase, mView);
        TextView phraseView = mView.findViewById(R.id.dphrase);
        phraseView.setText(translated);
    }

    public String caesar(String message, int key) {
        String toReturn = "";
        for (int x = 0; x < message.length(); x++) {
            int currentKey = alphabet.indexOf(message.substring(x, x + 1));
            toReturn += alphabet.substring((currentKey + key) % 26, (currentKey + key) % 26 + 1);
        }
        return toReturn;
    }

    public String pigLatin(String message) {
        String toReturn = "";
        if (vowels.contains(message.substring(0, 1))) toReturn = message + "way";
        else if (!vowels.contains(message.substring(1, 2)))
            toReturn = message.substring(2, message.length()) + message.substring(0, 2) + "ay";
        else toReturn = message.substring(1, message.length()) + message.substring(0, 1) + "ay";
        return toReturn;
    }

    public String vigenere(String message, String code) {
        String toReturn = "";
        int count = 0;
        for(int x = 0; x < message.length(); x++){
            if(!message.substring(x, x+1).equals(" ")){
                toReturn+=caesar(message.substring(x, x+1), alphabet.indexOf(code.substring(count, count+1)));
                count++;
                count%=code.length();
            }
            else toReturn+=" ";
        }
        return toReturn;
    }

    public String transposition(String message, int length) {
        String toReturn = "";
        String[][] array = new String[((int) (message.length() / length) + 1)][length];
        int count = 0;
        for (int x = 0; x < array.length; x++) {
            for (int y = 0; y < array[0].length; y++) {
                if (count >= message.length()) array[x][y] = "";
                else {
                    array[x][y] = message.substring(count, count + 1);
                    count++;
                }
            }
        }
        for (int y = 0; y < array[0].length; y++) {
            for (int x = 0; x < array.length; x++) {
                toReturn += array[x][y];
            }
        }
        return toReturn;
    }

}