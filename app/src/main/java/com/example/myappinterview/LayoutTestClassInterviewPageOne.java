package com.example.myappinterview;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LayoutTestClassInterviewPageOne extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_layout);

	BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
	bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
	  switch (item.getItemId()) {
		case R.id.page_1:
		  startActivity(new Intent(this, MainActivity.class));
		  break;
		case R.id.page_2:
		  startActivity(new Intent(this, DisplayMessageActivity.class));
		  break;
	  }
	  return true;
	});
  }
}
