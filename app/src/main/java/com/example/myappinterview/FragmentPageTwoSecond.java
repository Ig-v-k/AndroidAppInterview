package com.example.myappinterview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FragmentPageTwoSecond extends Fragment {

  RecyclerView recyclerView;

  EmployeeAdapter adapter;
  SharedViewModel sharedViewModel;

  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	View view = inflater.inflate(R.layout.fragment_page_two_second, container, false);
	androidx.fragment.app.Fragment fragment = new PageOneFragment();

	FloatingActionButton fab = view.findViewById(R.id.floating_action_button);
	fab.setOnClickListener(view1 ->
		  getParentFragmentManager().beginTransaction().replace(R.id.placeholder, fragment).commit()
	);

	recyclerView = view.findViewById(R.id.recyclerViewSecond);
	EmployeeAdapter adapter = new EmployeeAdapter(EmployeeDataBase.getAll());
	recyclerView.setAdapter(adapter);
	recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

	return view;
  }
}