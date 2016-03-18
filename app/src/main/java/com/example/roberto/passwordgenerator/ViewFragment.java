package com.example.roberto.passwordgenerator;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Roberto on 3/3/2016.
 */
public class ViewFragment extends ListFragment {

    private ArrayList<Passwords> mPasswords;

    @Override
    public void onResume() {//Why "onResume() and not onStart()? Can't assume the activity is going to bne stopped when another ativity is stacked on top of it. The bottom activity may just be paused. OnResujme() is the safest place to update fragment views"
        super.onResume();
        ((PasswordAdapter) getListAdapter()).notifyDataSetChanged();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPasswords = PasswordSingleton.get(getActivity()).getPasswords();

        PasswordAdapter adapter = new PasswordAdapter(mPasswords);
        setListAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_view, container, false);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id)//What do we want to happen when we click an item on the List? We want to start a CrimeFragment with the proper data. This is the method we use..
        {
            Passwords p = ((PasswordAdapter)getListAdapter()).getItem(position);
        }


    private class PasswordAdapter extends ArrayAdapter<Passwords>{

        public PasswordAdapter(ArrayList<Passwords> password){
            super(getActivity(),android.R.layout.simple_list_item_1,password);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_password, null);
            }

            Passwords p = getItem(position);

            TextView UserName = (TextView) convertView.findViewById(R.id.tvUserName);
            UserName.setText(p.getUserName());

            TextView Password = (TextView) convertView.findViewById(R.id.tvPassword);
            Password.setText(p.getPassword());

            TextView Website = (TextView) convertView.findViewById(R.id.tvWebSite);
            Website.setText(p.getWebsite());

            return convertView;


        }

    }
}

