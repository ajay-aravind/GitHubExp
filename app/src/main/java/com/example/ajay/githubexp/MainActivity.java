package com.example.ajay.githubexp;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

import com.example.ajay.githubexp.Fragments.DescriptionFragment;
import com.example.ajay.githubexp.Fragments.MenuFragment;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

public class MainActivity extends AppCompatActivity implements MenuFragment.FragmentInteractor {

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setUpLogger();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null)
        {
            setUpFrags();
        }

    }

    @Override
    public int sendPosition(int position) {

       DescriptionFragment frag=(DescriptionFragment)getFragmentManager().findFragmentByTag("DescFrag");
        frag.setContent(position);
        Logger.d(frag.Id);
        return 0;
    }

    public void setUpFrags()
    {

            MenuFragment leftFrag=new MenuFragment();

            getFragmentManager().beginTransaction().add(R.id.menuLayout, leftFrag, "MenuFrag").commit();

            DescriptionFragment rightFrag = new DescriptionFragment();

            getFragmentManager().beginTransaction().add(R.id.decrptLayout, rightFrag, "DescFrag").commit();
    }

    public void setUpLogger() {

//        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
//                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
//                .methodCount(2)         // (Optional) How many method line to show. Default 2
//                .methodOffset(2)        // (Optional) Hides internal method calls up to offset. Default 5// (Optional) Changes the log strategy to print out. Default LogCat
//                .tag("Advaced logger")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
//                .build();
        Logger.addLogAdapter(new AndroidLogAdapter());

    }
}
