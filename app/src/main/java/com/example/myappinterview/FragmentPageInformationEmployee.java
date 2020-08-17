package com.example.myappinterview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

public class FragmentPageInformationEmployee extends Fragment {

    ImageView imageView;
    TextView textViewName, textViewTelephone, textViewAge, textViewSex;
    String name, telephone, age, sex;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_information_emploee, container, false);

        imageView = view.findViewById(R.drawable.info);
        textViewName = view.findViewById(R.id.infoTextViewName);
        textViewTelephone = view.findViewById(R.id.infoTextViewTelephone);
        textViewAge = view.findViewById(R.id.infoTextViewAge);
        textViewSex = view.findViewById(R.id.infoTextViewSex);



        textViewName.setText(name);
        textViewTelephone.setText(telephone);
        textViewAge.setText(age);
        textViewSex.setText(sex);

        return view;
    }


}