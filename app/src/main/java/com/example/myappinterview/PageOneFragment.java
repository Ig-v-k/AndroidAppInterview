package com.example.myappinterview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class PageOneFragment extends Fragment {

  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	View view = inflater.inflate(R.layout.fragment_page_one, container, false);

	/**
	 *  Instance Data's
	 */
	EditText editTextName = view.findViewById(R.id.employeeNameAdd);
	EditText editTextTelephone = view.findViewById(R.id.employeeTelephoneAdd);
	EditText editTextAge = view.findViewById(R.id.employeeAgeAdd);
	CheckBox checkBoxMale = view.findViewById(R.id.checkBoxMale);
	CheckBox checkBoxFemale = view.findViewById(R.id.checkBoxFemale);
	Button buttonAdd = view.findViewById(R.id.buttonAdd);

	buttonAdd.setOnClickListener(view1 -> {
	  if(checkBoxMale.isChecked()) {
		EmployeeDataBase.addEmployee(
			  new Employee(
					editTextName.getText().toString(),
				  editTextTelephone.getText().toString(),
				  "Male",
				  Integer.parseInt(editTextAge.getText().toString())
			)
		);
	  }
	  if(checkBoxFemale.isChecked()) {
		EmployeeDataBase.addEmployee(
			  new Employee(
					editTextName.getText().toString(),
				  editTextTelephone.getText().toString(),
				  "Female",
				  Integer.parseInt(editTextAge.getText().toString())
			)
		);
	  }
	});

	return view;
  }
}