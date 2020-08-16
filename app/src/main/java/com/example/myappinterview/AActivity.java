package com.example.myappinterview;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class AActivity extends AppCompatActivity {

  /**
   *  Data
   */
  Toolbar toolbar;
  RecyclerView recyclerView;
  List<Employee> employeelList = new ArrayList<>(0);
  UsersAdapter usersAdapter;

  /**
   * The constructor initializer
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_a);
	this.setSupportActionBar(toolbar);

	// Setting a 'Fragment' - PageOneFragment, by fist page
	getSupportFragmentManager()
		  .beginTransaction()
		  .replace(R.id.fragment_layout, new PageTwoFragment())
		  .commit();

	// Bottom navigation
	BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
	// Listener Bottom navigation
	bottomNav.setOnNavigationItemSelectedListener(item -> {
	  androidx.fragment.app.Fragment fragment = null;
	  switch (item.getItemId()) {
		case R.id.page_1:
		  fragment = new PageOneFragment();
		  break;
		case R.id.page_2:
		  fragment = new PageTwoFragment();
		  break;
	  }
	  assert fragment != null;
	  getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.fragment_layout, fragment)
			.commit();
	  return true;
	});

	recyclerView = findViewById(R.id.recyclerView);
	toolbar = findViewById(R.id.toolbar);

	setTitle("");

	recyclerView.setLayoutManager(new LinearLayoutManager(this));
	recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

	employeelList.add(new Employee("A", "00000000000", "Male", 10));
	employeelList.add(new Employee("B", "10000000000", "Female", 20));
	employeelList.add(new Employee("C", "20000000000", "Female", 30));
	employeelList.add(new Employee("D", "30000000000", "Male", 40));
	employeelList.add(new Employee("E", "40000000000", "Male", 50));

	usersAdapter = new UsersAdapter(employeelList);

	recyclerView.setAdapter(usersAdapter);

  }
}