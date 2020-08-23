package com.example.myappinterview.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myappinterview.DisplayEmployeeInformation;
import com.example.myappinterview.R;
import com.example.myappinterview.db.utils.SampleDbContract;
import com.example.myappinterview.db.utils.SampleDbSQLiteHelper;
import com.example.myappinterview.model.Employee;
import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
* RecyclerView configuration
*
*	Inner class ViewHolder
*/
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

	Cursor cursor = this.getFromDB(holder.itemView.getContext());

	if (cursor.move(position + 1)) {
	  int name = cursor.getColumnIndex(SampleDbContract.EmployeeDb.COLUMN_NAME);
	  int telephone = cursor.getColumnIndex(SampleDbContract.EmployeeDb.COLUMN_TELEPHONE);

	  holder.imageView.setImageResource(R.drawable.man);
	  holder.nameEmployee.setText(cursor.getString(name));
	  holder.telephoneEmployee.setText(cursor.getString(telephone));
	}

	holder.itemView.setOnClickListener(view -> {
	  Intent intent = new Intent(view.getContext(), DisplayEmployeeInformation.class);

	  intent.putExtra("dataName", cursor.getString(1));
	  intent.putExtra("dataTelephone", cursor.getString(2));
	  intent.putExtra("dataAge", String.valueOf(cursor.getString(3)));
	  intent.putExtra("dataSex", cursor.getString(4));

	  view.getContext().startActivity(intent);
	});
  }

  private Cursor getFromDB(Context context) {
	SQLiteDatabase database = new SampleDbSQLiteHelper(context).getReadableDatabase();
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

  private void deleteFromDb(Context context, String... args) {
	SQLiteDatabase database = new SampleDbSQLiteHelper(context).getReadableDatabase();
	database.delete(SampleDbContract.EmployeeDb.TABLE_NAME, SampleDbContract.EmployeeDb.COLUMN_TELEPHONE + "=?", args);
  }

  @Override
  public int getItemCount() {
	return getFromDB(context).getCount();
  }


  /**
   * Inner Class
   */
  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

	ImageView imageView;
	TextView nameEmployee, telephoneEmployee;
	ImageButton imageButtonDelete, imageButtonEdit;

	public ViewHolder(@NonNull @NotNull View itemView) {
	  super(itemView);

	  this.imageView = itemView.findViewById(R.id.RVCVImage);
	  this.nameEmployee = itemView.findViewById(R.id.RVCVName);
	  this.telephoneEmployee = itemView.findViewById(R.id.RVCVTelephone);
	  this.imageButtonDelete = itemView.findViewById(R.id.RVCVDelete);
	  this.imageButtonEdit = itemView.findViewById(R.id.RVCVEdit);
	}

	@Override
	public void onClick(View view) {
	  if(view.equals(imageButtonDelete)) {
		System.out.println("onClick() ---------------------------------->");
	    deleteFromDb(itemView.getContext(), telephoneEmployee.getText().toString());
	  }
	}
  }
}
