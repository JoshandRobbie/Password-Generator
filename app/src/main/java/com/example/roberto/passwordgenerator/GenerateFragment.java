package com.example.roberto.passwordgenerator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.*;

/**
 * Created by Robert Ortiz
 * 3/3/2016
 *
 * Modified by Robert Ortiz and Joshua Cantero [Start] 3.5.16 - PRESENT DAY
 *
 * Description:
 * This program generates a random password for the user based on the amount of characters
 * he/she would like their password to contain
 *
 * References other classes and XML files to allow the widgets to fully function
 */
public class GenerateFragment extends Fragment {

    //Variables declared
    EditText eUserInput;
    TextView tvOutPut;
    int x;
    String password;
    Button bGenerate;
    Button bSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_generate, container, false);

        //Initializing widgets
        //Edit Text Id's
        eUserInput = (EditText) v.findViewById(R.id.etUserInput);
        tvOutPut = (TextView) v.findViewById(R.id.tvOutPut);

        //Initializing widgets
        //Button Id's
        bGenerate = (Button) v.findViewById(R.id.bGenerate);
        bSave = (Button) v.findViewById(R.id.bSave);

        // From lines 58 - 71
        // NOTE: The following code is not yet complete 3.14*****************************
        // This code will allow the button to perform a function when it has been clicked
        // We have created 2 buttons: bGenerate and bSave
        // bGenerate will generate a random password once clicked
        // bSave will allow for the user to save the generated password into a list view
        // on another fragment

        bGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code to Generate the random password

                x = Integer.parseInt(eUserInput.getText().toString());
                password = generate(x);
                tvOutPut.setText(password);

            }
        }) ;

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to save the generated password

            }
        });


        /*
            NEXT STEPS:
            Input from Edit Text
         */

        return v;

    }

    /*
        Not complete, contains errors
        FUNCTION: To store the data, into a local data base (Users device)
     */
   /* public void saveInfo(View view){
        SharedPreferences sharedPref = getSharedPreferences("etOutPut", getContext().MODE_PRIVATE);

        SharedPreferences.Editor edit = sharedPref.edit();

        editor.putString("Password", eOutPut.getText().toStirng());
        }

*/
    public String generate(int x) {

       // Scanner vitamin = new Scanner(System.in); //Scanner for randomString Function
        Random password = new Random(); // Object used to create Random String
       // int c; // Used for user input on regarding the amount of characters he/she wishes to use in their password


        //Array[52]
        //Array contains the alphabet so that the program can use the letters to create a password
        String[] alphabet = {"A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k", "L", "l",
                "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z"};

        /**
         * We have declared all our variables that will
         * be used for the Generate Password algorithm
         *
         */


       // int c = vitamin.nextInt();
        int c = x;
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
                passWord2 = passWord2 + alphaNum ; //System.out.print(alphabet[alphaNum]);
                int numNum = password.nextInt(10);
                passWord2 = passWord2 + numNum; // System.out.println(numNum);


            }
            return passWord2;

            //System.out.print(numNum +"\n");

        }
    }




}