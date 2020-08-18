package com.example.myappinterview;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

  List<Employee> employeeList;
  Context context;

  public EmployeeAdapter(List<Employee> employeeList, Context context) {
	this.employeeList = employeeList;
	this.context = context;
  }

  @NonNull
  @NotNull
  @Override
  public EmployeeAdapter.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
	View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_staff_second, parent, false);
	return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(
		@NonNull
		@NotNull EmployeeAdapter.ViewHolder holder, int position) {

//    Employee employee = employeeList.get(position);

//	holder.imageView.setImageResource(R.drawable.man);
//	holder.nameEmployee.setText(employee.getNameEmp());
//	holder.telephoneEmployee.setText(employee.getTelNum());
	Cursor cursor = this.getFromDB(holder.itemView.getContext());

	if (cursor.move(position + 1)) {
	  int name = cursor.getColumnIndex(SampleDbContract.EmployeeDb.COLUMN_NAME);
	  int telephone = cursor.getColumnIndex(SampleDbContract.EmployeeDb.COLUMN_TELEPHONE);

	  holder.imageView.setImageResource(R.drawable.man);
	  holder.nameEmployee.setText("SQLite " + cursor.getString(name));
	  holder.telephoneEmployee.setText("SQLite " + cursor.getString(telephone));
	}

	holder.itemView.setOnClickListener(view -> {
	  Intent intent = new Intent(view.getContext(), DisplayMessageActivity.class);

//	  intent.putExtra("dataName", employee.getNameEmp());
//	  intent.putExtra("dataTelephone", employee.getTelNum());
//	  intent.putExtra("dataAge", String.valueOf(employee.getAge()));
//	  intent.putExtra("dataSex", employee.getSex());

	  intent.putExtra("dataName", cursor.getString(1));
	  intent.putExtra("dataTelephone", cursor.getString(2));
	  intent.putExtra("dataAge", String.valueOf(cursor.getString(3)));
	  intent.putExtra("dataSex", cursor.getString(4));

	  view.getContext().startActivity(intent);
	});
//	cursor.close();
  }

  private Cursor getFromDB(Context context) {
	SQLiteDatabase database = new SampleDbSQLiteHelper(context).getReadableDatabase();
//	String query = "Select * FROM "	+ SampleDbContract.EmployeeDb.CREATE_TABLE + " WHERE " + SampleDbContract.EmployeeDb.COLUMN_NAME + " = " + data;
//	String[] projection = {
//		  SampleDbContract.EmployeeDb._ID,
//		  SampleDbContract.EmployeeDb.COLUMN_NAME,
//		  SampleDbContract.EmployeeDb.COLUMN_TELEPHONE
//	};
	return database.query(
		  SampleDbContract.EmployeeDb.TABLE_NAME,
		  null,
		  null,
		  null,
		  null,
		  null,
		  null
	);
  }

  @Override
  public int getItemCount() {
	return getFromDB(context).getCount();
  }

  /**
   * Inner Class
   */
  class ViewHolder extends RecyclerView.ViewHolder {

	TextView nameEmployee, telephoneEmployee;
	ImageView imageView;

	public ViewHolder(@NonNull @NotNull View itemView) {
	  super(itemView);

	  this.imageView = itemView.findViewById(R.id.RVCVImage);
	  this.nameEmployee = itemView.findViewById(R.id.RVCVName);
	  this.telephoneEmployee = itemView.findViewById(R.id.RVCVTelephone);
	}
  }
}
