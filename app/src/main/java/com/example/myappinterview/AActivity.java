package com.example.myappinterview;

import android.os.Bundle;
import android.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
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
  List<Employee> userModelList = new ArrayList<>();
  String[] names = {"Richard","Alice","Hannah","David"};
//  UsersAdapter usersAdapter;

  /**
   * The constructor initializer
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_a);

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

	this.setSupportActionBar(toolbar);
	this.getSupportActionBar().setTitle("");

	recyclerView.setLayoutManager(new LinearLayoutManager(this));
	recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

	for(String s:names){
	  Employee userModel = new Employee(s);

	  userModelList.add(userModel);
	}

	usersAdapter = new UsersAdapter(userModelList,this);

	recyclerView.setAdapter(usersAdapter);

  }
}