package com.example.roberto.passwordgenerator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.*;

/**
 * Created by Roberto on 3/3/2016.
 */
public class GenerateFragment extends Fragment {

    //Variables declared
    EditText eUserInput;
    EditText eOutPut;

    Button bGenerate;
    Button bSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_generate,container,false);

        //Initializing widgets
        //Edit Text Id's
        eUserInput = (EditText) v.findViewById(R.id.etUserInput);
        eOutPut = (EditText) v.findViewById(R.id.etOutPut);

        //Initializing widgets
        //Button Id's
        bGenerate = (Button) v.findViewById(R.id.bGenerate);
        bSave = (Button) v.findViewById(R.id.bSave);


        /*
            NEXT STEPS:
            Input from Edit Text
         */



        return v;
    }

    public String generate(int x) {

        Scanner vitamin = new Scanner(System.in); //Scanner for randomString Function
        Random password = new Random(); // Object used to create Random String
        int c; // Used for user input on regarding the amount of characters he/she wishes to use in their password


        //Array[52]
        //Array contains the alphabet so that the program can use the letters to create a password
        String[] alphabet = {"A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k", "L", "l",
                "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z"};

        /**
         * We have declared all our variables that will
         * be used for the Generate Password algorithm
         *
          */
        c = x;
        c = vitamin.nextInt();
        int nc = (c / 2) + 1;
        int ncm = (nc / 2);
        int totalValues = c / 2;

        //Since the c value is negative, you will recieve the remainder which will then send you through the statement
        if (c % 2 == 0)

        {
            String passWord1 = "";

            for (int i = 0; i < totalValues; i++) {
                int alphaNum = password.nextInt(52);
                passWord1 = passWord1 + alphaNum; //System.out.print(alphabet[alphaNum]);
                int numNum = password.nextInt(10);// gives a range from 0-10
               passWord1 = passWord1 + numNum; // System.out.print(numNum);
            } // incorporates the number into the password

            //System.out.println();
            return passWord1;
        } else

        {
            String passWord2 = "";
            for (int i = 0; i < ncm + 1; i++) {

                int alphaNum = password.nextInt(52);
                passWord2 = passWord2 + alphaNum; //System.out.print(alphabet[alphaNum]);
                int numNum = password.nextInt(10);
                passWord2 = passWord2 + numNum; // System.out.println(numNum);


            }
            return passWord2;

            //System.out.print(numNum +"\n");

        }
    }

}