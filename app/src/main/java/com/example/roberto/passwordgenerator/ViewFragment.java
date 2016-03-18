package com.example.roberto.passwordgenerator;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Roberto on 3/3/2016.
 */
public class ViewFragment extends ListFragment {

    private ArrayList<Passwords> mPasswords;

    @Override
    public void onResume(){//Why "onResume() and not onStart()? Can't assume the activity is going to bne stopped when another ativity is stacked on top of it. The bottom activity may just be paused. OnResujme() is the safest place to update fragment views"
        super.onResume();
        ((PasswordAdapter)getListAdapter()).notifyDataSetChanged();
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mPasswords = PasswordSingleton.get(getActivity()).getPasswords();

        PasswordAdapter adapter = new PasswordAdapter(mPasswords);
        setListAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view,container,false);

        return v;
    }

    private class PasswordAdapter extends ArrayAdapter<Passwords>{

        public PasswordAdapter(ArrayAdapter<Passwords> password){
            super(getActivity(),android.R.layout.simple_list_item_1,password);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_password,null);
            }

            Passwords p = getItem(position);
        }


    }

}


