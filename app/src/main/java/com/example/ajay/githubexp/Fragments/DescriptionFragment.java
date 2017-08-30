package com.example.ajay.githubexp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ajay.githubexp.Datautils.dataUtils;
import com.example.ajay.githubexp.R;

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
    @BindView(R.id.first_para) TextView firstPara;
    @BindView(R.id.second_para) TextView secondPara;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        titles= dataUtils.getTitles();
        firstParas=dataUtils.getFirstParas();
        secondParas=dataUtils.getSecondParas();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        title=null;
        firstPara=null;
        secondPara=null;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.description_layout,container,false);
        ButterKnife.bind(this,rootView);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        title=(TextView)getView().findViewById(R.id.title);

    }

    public void setContent(int i)
    {

        title.setText(titles.get(i));
        firstPara.setText(firstParas.get(i));
        secondPara.setText(secondParas.get(i));
    }



}
