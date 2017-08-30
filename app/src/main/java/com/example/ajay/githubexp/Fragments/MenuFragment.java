package com.example.ajay.githubexp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ajay.githubexp.Datautils.dataUtils;
import com.example.ajay.githubexp.R;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajay on 29/8/17.
 */

public class MenuFragment extends android.app.Fragment {

    public FragmentInteractor interactor;
    public static int id=123;
    public int Id;

    public MenuFragment()
    {
        Id=id;
        id+=100;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        interactor=(FragmentInteractor)context;
        Logger.d("Ping...");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_layout,container,false);
    }

    @Override
    public void onResume() {
        super.onResume();

        View rootView=getView();

        if(rootView!=null)
        {
            Log.d("main","root view not null...setting data");
            ListView view=(ListView)rootView.findViewById(R.id.menuList);

            List<String> data=dataUtils.getMenuData();

            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,data);

            view.setAdapter(adapter);

            view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    Logger.d(Id);
                    interactor.sendPosition(i);
                }
            });

        }

    }


    public interface  FragmentInteractor{

        public int sendPosition(int position);
    }
}
