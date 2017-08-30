package com.example.ajay.githubexp.Datautils;

import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ajay on 29/8/17.
 */

public  class  dataUtils {

//        public static List<String> titles=new ArrayList<String>();
        public static List<String> firstParas;
        public static List<String> secondParas;

        public static ArrayList<String> menuList;

        public static ArrayList<String> getMenuData()
        {
            menuList=new ArrayList<>();
            for(int i=0;i<15;i++)
            {
                menuList.add("Chapter "+i);
            }

            return menuList;
        }

        public static ArrayList<String> getTitles()
        {
            return getMenuData();
        }

        public static List<String> getFirstParas()
        {
            firstParas=new ArrayList<>();

            for(int i=0;i<15;i++)
            {
                firstParas.add("Welcome to chapter "+i+"!!! An ordered collection (also known as a sequence). The user of this interface has precise control over where in the list each element is inserted. The user can access elements by their integer index (position in the list), and search for elements in the list.");
            }

            return firstParas;
        }


        public static List<String> getSecondParas()
        {
            secondParas=new ArrayList<>();
            for(int i=0;i<15;i++)
            {
                secondParas.add("Welcome to second paras "+i+"!!! Unlike sets, lists typically allow duplicate elements. More formally, lists typically allow pairs of elements e1 and e2 such that e1.equals(e2), and they typically allow multiple null elements if they allow null elements at all. It is not inconceivable that someone might wish to implement a list that prohibits duplicates, by throwing runtime exceptions when the user attempts to insert them, but we expect this usage to be rare.");
            }

            return secondParas;
        }








}
