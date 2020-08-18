package com.example.myappinterview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AActivity extends AppCompatActivity {

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
		  .replace(R.id.aactivity_frame_layout, new PageOneFragment())
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
		  fragment = new FragmentPageTwoSecond();
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