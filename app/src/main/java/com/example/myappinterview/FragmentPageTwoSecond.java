package com.example.myappinterview;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
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

import static android.content.ContentValues.TAG;

public class FragmentPageTwoSecond extends Fragment {

  RecyclerView recyclerView;
  Intent intent;

  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	View view = inflater.inflate(R.layout.fragment_page_two_second, container, false);

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