package com.example.myappinterview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myappinterview.fragments.FragmentPageOneAdd;
import com.example.myappinterview.fragments.FragmentPageTwoHome;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * Main Activity (activity_a.xml)
 *
 * Child's:
 * 		Fragment - 1: FragmentPageOneAdd (add some employee - fragment_page_one_add)
 * 		Fragment - 2: FragmentPageOneHome (list all employee's - fragment_page_two_home)
 */
public class AActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_a);

	/*
	*	open first page(fragment)
	*/
	getSupportFragmentManager()
		  .beginTransaction()
		  .replace(R.id.aactivity_frame_layout, new FragmentPageOneAdd())
		  .commit();

	/*
	* 	bottom nav
	*/
	BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
	bottomNav.setOnNavigationItemSelectedListener(item -> {
	  androidx.fragment.app.Fragment fragment = null;
	  switch (item.getItemId()) {
		case R.id.page_1:
		  fragment = new FragmentPageOneAdd();
		  break;
		case R.id.page_2:
		  fragment = new FragmentPageTwoHome();
		  break;
	  }
	  assert fragment != null;
	  getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.aactivity_frame_layout, fragment)
			.commit();
	  return true;
	});

  }// m:onCreate
}// c:AActivity