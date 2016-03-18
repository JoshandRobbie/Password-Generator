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

/**
 * Created by joshua on 3/17/2016.
 */
public class EditFragment extends Fragment {

    EditText Website, UserName;
    Button Save;
    String sWeb, sName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_edit, container, false);

           final String password = getArguments().getString("Password");
            Website = (EditText)v.findViewById(R.id.etWebsite);
            UserName = (EditText)v.findViewById(R.id.etUserName);
            Save = (Button)v.findViewById(R.id.bSave);


        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sWeb = Website.getText().toString();
                sName = UserName.getText().toString();


                Passwords p = new Passwords();// = new Passwords(password,sName,sWeb);
                p.setPassword(password);
                p.setUserName(sName);
                p.setWebsite(sWeb);
                PasswordSingleton.get(getActivity()).addPassword(p);

                Fragment fragment = new ViewFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragmentContainer,fragment);
                ft.commit();

            }
        });



        return v;
    }
}