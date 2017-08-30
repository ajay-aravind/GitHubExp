package com.example.ajay.githubexp;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ajay.githubexp.Fragments.DescriptionFragment;
import com.example.ajay.githubexp.Fragments.MenuFragment;

public class MainActivity extends AppCompatActivity implements MenuFragment.FragmentInteractor {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpFrags();

    }

    @Override
    public int sendPosition(int position) {
       DescriptionFragment frag=(DescriptionFragment)getSupportFragmentManager().findFragmentByTag("DescFrag");
        frag.setContent(position);
        return 0;
    }

    public void setUpFrags()
    {
        if(getFragmentManager().findFragmentByTag("MenuFrag")==null) {
            Fragment leftFrag = new MenuFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.menuLayout, leftFrag, "MenuFrag").commitNow();

        }
        if(getFragmentManager().findFragmentByTag("DescFrag")==null) {
            DescriptionFragment rightFrag = new DescriptionFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.decrptLayout, rightFrag, "DescFrag").commitNow();
        }
    }
}
