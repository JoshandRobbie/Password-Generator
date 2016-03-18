package com.example.roberto.passwordgenerator;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Roberto on 3/3/2016.
 */
public class Adapter extends FragmentPagerAdapter {

  private String fragments[] = {"Generate","View"};

    public Adapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
       
        switch(position){
            case 0: return new GenerateFragment();

            case 1: return new ViewFragment();//EditFragment();

           // case 2: return new ViewFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return fragments[position];
    }
}
