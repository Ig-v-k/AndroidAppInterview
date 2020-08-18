package com.example.myappinterview.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myappinterview.AActivity;
import com.example.myappinterview.adapter.EmployeeAdapter;
import com.example.myappinterview.db.EmployeeDataBase;
import com.example.myappinterview.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 *  Class realise a Fragment view - fragment_page_two_home.xml
 */
public class FragmentPageTwoHome extends Fragment {

  RecyclerView recyclerView;
  Intent intent;

  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	View view = inflater.inflate(R.layout.fragment_page_two_home, container, false);

	FloatingActionButton fab = view.findViewById(R.id.floating_action_button);
	fab.setOnClickListener(view1 -> {
	  intent = new Intent(view.getContext(), AActivity.class);
	  view.getContext().startActivity(intent);
	});

	recyclerView = view.findViewById(R.id.recyclerViewSecond);
	EmployeeAdapter adapter = new EmployeeAdapter(EmployeeDataBase.getAll(), view.getContext());
	recyclerView.setAdapter(adapter);
	recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

	return view;
  }
}