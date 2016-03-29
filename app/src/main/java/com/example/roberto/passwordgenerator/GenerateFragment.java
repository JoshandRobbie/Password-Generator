package com.example.roberto.passwordgenerator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

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
    String password;
    Button bGenerate;
    Button bSave;

    int x;

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




        // NOTE: The following code is not yet complete 3.14*****************************
        // This code will allow the button to perform a function when it has been clicked
        // We have created 2 buttons: bGenerate and bSave
        // bGenerate will generate a random password once clicked
        // bSave will allow for the user to save the generated password into a list view
        // on another fragment

        //@onclick Generate button will return the value from Generate method algorithm and will
        // display it on the tvOutPut box
        bGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code to Generate the random password\
                String x = eUserInput.getText().toString();
                int y = Integer.parseInt(x);
                password = generate(y);
                tvOutPut.setText(password);

                
            }
        }) ;


        // @Onclick save button will allow for the user to save String Generated from
        // onclick generate method

        bSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //code to save the generated password
                Fragment fr = new EditFragment();

                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                Bundle args = new Bundle();
                args.putString("Password", password);
                fr.setArguments(args);
                ft.replace(R.id.fragmentContainer,fr);
                ft.commit();

            }
        });

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

        // Object used to create Random String
        Random password = new Random();

        //Array contains the alphabet so that the program can use the letters to create a password
        String[] alphabet = {"A", "a", "B", "b", "C", "c", "D", "d", "E", "e", "F", "f", "G", "g", "H", "h", "I", "i", "J", "j", "K", "k", "L", "l",
                "M", "m", "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "Z", "z"};

        /**
         * We have declared all our variables that will
         * be used for the Generate Password algorithm
         *
         */

        //since x is called from the edit text and passed as a int
        //here we can just set x = c which then follows through the process
        //in the same pattern
        int c = x;
        int nc = (c / 2) + 1;
        int ncm = (nc/c);
        int totalValues = c / 2;

            // if statement that will be executed if the user input is a even number
            if (c % 2 == 0)

            {
                String passWord1 = "";

                for (int i = 0; i < totalValues; i++) {
                    int alphaNum = password.nextInt(52); // gives a range from 0-52
                    passWord1 = passWord1 + alphabet[alphaNum];
                    int numNum = password.nextInt(10);// gives a range from 0-10
                    passWord1 = passWord1 + numNum;
                } // incorporates the number into the password

                //Will return the password generated that is stored in passWord2
                return passWord1;

                //else (if the user input was a odd number)
            } else

            {
                String passWord2 = "";
                for (int i = 0; i < totalValues; i++) {

                    int alphaNum = password.nextInt(52);
                    passWord2 = passWord2 + alphabet[alphaNum];
                    int numNum = password.nextInt(10);
                    passWord2 = passWord2 + numNum;
                }

                //since the else statement only will output a even number (which will be one value
                // less than users input was ) I added another value to be added to the end
                //ex. If the user input was 7, in the loop above, the user would receive a
                //password of 6 now at the end this code will add 1 more value(a string); thus
                //displaying 7 characters instead of 6
                int alphaNum = password.nextInt(52);
                passWord2 = passWord2 + alphabet[alphaNum];

                //Will return the password generated that is stored in passWord2
                return passWord2;
            }

            }



}


