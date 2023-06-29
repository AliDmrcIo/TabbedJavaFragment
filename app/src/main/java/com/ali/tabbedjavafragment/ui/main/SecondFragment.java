package com.ali.tabbedjavafragment.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ali.tabbedjavafragment.R;


public class SecondFragment extends Fragment {

    PageViewModel pageViewModel;

    public static SecondFragment newInstance(){ //SectionsPagerAdapter class'ından direkt olarak buraya ulaşabilmek için ve bu class'ı return edebilmek için böyle bişey yaptık
        return new SecondFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel=new ViewModelProvider(requireActivity()).get(PageViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textView=view.findViewById(R.id.textView);

        pageViewModel.getName().observe(requireActivity(), new Observer<String>() { //burada observe diyince asıl olay başlıyor. observe() gözlemle demektir. PageViewModel classını habire gözlemliyor ve alttaki methodda herhangi bir değişiklik olduğunda direkt textView'ımız yansıt dicez
            @Override
            public void onChanged(String s) {

                textView.setText(s);//burada da değişen şeyleri textview'a gönder dedik

            }
        });


    }
}