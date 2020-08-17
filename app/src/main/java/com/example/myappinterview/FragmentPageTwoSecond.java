package com.example.myappinterview;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FragmentPageTwoSecond extends Fragment {

    RecyclerView recyclerView;
    View view;
    EmployeeAdapter employeeAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_page_two_second, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewSecond);


        FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentPageInformationEmployee informationEmployee = new FragmentPageInformationEmployee();
        informationEmployee.setArguments(bundle);

        fragmentTransaction.replace(R.id.fragment_information_employee, informationEmployee);
        fragmentTransaction.commit();


        employeeAdapter = new EmployeeAdapter(fragmentTransaction);
        recyclerView.setAdapter(employeeAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}