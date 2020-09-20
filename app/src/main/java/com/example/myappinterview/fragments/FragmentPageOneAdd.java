package com.example.myappinterview.fragments;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.myappinterview.*;
import com.example.myappinterview.db.EmployeeDataBase;
import com.example.myappinterview.db.utils.SampleDbContract;
import com.example.myappinterview.db.utils.SampleDbSQLiteHelper;
import com.example.myappinterview.model.Employee;

/**
 *  Class realise a Fragment view - fragment_page_one_add.xml
 */
public class FragmentPageOneAdd extends Fragment {

  @Override
  public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	View view = inflater.inflate(R.layout.fragment_page_one_add, container, false);

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
//	  if("".equals(editTextAge.getText().toString()) || "".equals(editTextTelephone.getText().toString()) || "".equals(editTextName.getText().toString())) {
	  if (checkBoxMale.isChecked()) {
		EmployeeDataBase.addEmployee(
			  new Employee(
					editTextName.getText().toString(),
					editTextTelephone.getText().toString(),
					"Male",
					Integer.parseInt(editTextAge.getText().toString())
			  )
		);
		this.saveToDb(view, editTextName, editTextTelephone, editTextAge, "Male");
	  }
	  if (checkBoxFemale.isChecked()) {
		EmployeeDataBase.addEmployee(
			  new Employee(
					editTextName.getText().toString(),
					editTextTelephone.getText().toString(),
					"Female",
					Integer.parseInt(editTextAge.getText().toString())
			  )
		);
		this.saveToDb(view, editTextName, editTextTelephone, editTextAge, "Female");
	  }
//	  }
	});

	return view;
  }

  private void saveToDb(View view, EditText editTextName, EditText editTextTelephone, EditText editTextAge, String sex) {
	SQLiteDatabase database = new SampleDbSQLiteHelper(view.getContext()).getWritableDatabase();
	ContentValues values = new ContentValues();
	values.put(SampleDbContract.EmployeeDb.COLUMN_NAME, editTextName.getText().toString());
	values.put(SampleDbContract.EmployeeDb.COLUMN_TELEPHONE, editTextTelephone.getText().toString());
	values.put(SampleDbContract.EmployeeDb.COLUMN_AGE, editTextAge.getText().toString());
	values.put(SampleDbContract.EmployeeDb.COLUMN_SEX, sex);
	long newRowId = database.insert(SampleDbContract.EmployeeDb.TABLE_NAME, null, values);
	Toast.makeText(view.getContext(), "The new Employee is " + newRowId, Toast.LENGTH_LONG).show();
	database.close();
  }

}