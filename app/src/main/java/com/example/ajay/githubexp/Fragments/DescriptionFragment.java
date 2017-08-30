package com.example.ajay.githubexp.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ajay.githubexp.Datautils.dataUtils;
import com.example.ajay.githubexp.R;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ajay on 29/8/17.
 */

public class DescriptionFragment extends Fragment {

    public List<String> titles=new ArrayList<String>();
    public List<String> firstParas=new ArrayList<String>();
    public List<String> secondParas=new ArrayList<String>();

    TextView title;
    TextView firstPara;
    TextView secondPara;

    public static int id=123;
    public int Id;
    public int chapter=0;

    public DescriptionFragment(){
        Id=id;
        id+=100;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        titles=dataUtils.getTitles();
        firstParas=dataUtils.getFirstParas();
        secondParas=dataUtils.getSecondParas();

        Logger.d("In on attach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null&&savedInstanceState.containsKey("chapter"))
        {
            chapter=savedInstanceState.getInt("chapter");
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Logger.d("In on createView");
       View root=inflater.inflate(R.layout.description_layout,container,false);
        title=(TextView)root.findViewById(R.id.title);
        firstPara=(TextView)root.findViewById(R.id.first_para);
        secondPara=(TextView)root.findViewById(R.id.second_para);

        setContent(chapter);

        return root;
    }
    @Override
    public void onStart() {
        super.onStart();
        Logger.d("Ping..");
    }

    @Override
    public void onResume() {
        super.onResume();
            Logger.d("Ping...");
    }

    @Override
    public void onStop() {
        super.onStop();
            Logger.d("Ping...");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("chapter",chapter);
    }

    @Override
    public void onPause() {
        super.onPause();
            Logger.d("Ping...");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
            Logger.d("Ping...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
            Logger.d("Ping...");

    }

    @Override
    public void onDetach() {
        super.onDetach();
            Logger.d("Ping...");
    }


    public void setContent(int i)
    {
        if(titles.size()>i)
        {
            title.setText(titles.get(i));
            Logger.d("setting titile:"+titles.get(i));
            chapter=i;
        }

        if(firstParas.size()>i)
        {
            firstPara.setText(firstParas.get(i));
            Logger.d("setting first para:"+firstParas.get(i));
        }

        if(secondParas.size()>i)
        {
            secondPara.setText(secondParas.get(i));
            Logger.d("setting second para:"+secondParas.get(i));
        }

    }
}
