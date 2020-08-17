package com.example.myappinterview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayMessageActivity extends AppCompatActivity {

  ImageView imageViewAvatar;
  TextView textViewName, textViewTelephone, textViewAge, textViewSex;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_display_message);

	imageViewAvatar = findViewById(R.id.infoImage);
	textViewName = findViewById(R.id.infoTextViewName);
	textViewTelephone = findViewById(R.id.infoTextViewTelephone);
	textViewAge = findViewById(R.id.infoTextViewAge);
	textViewSex = findViewById(R.id.infoTextViewSex);

	this.setData();
  }

  private void setData() {
	imageViewAvatar.setImageResource(R.drawable.man);
	textViewName.setText(getIntent().getStringExtra("dataName"));
	textViewTelephone.setText(getIntent().getStringExtra("dataTelephone"));
	textViewAge.setText(getIntent().getStringExtra("dataAge"));
	textViewSex.setText(getIntent().getStringExtra("dataSex"));
  }

}