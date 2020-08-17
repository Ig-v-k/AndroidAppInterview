package com.example.myappinterview;

import android.content.Intent;
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

  public EmployeeAdapter(List<Employee> employeeList) {
	this.employeeList = employeeList;
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

    Employee employee = employeeList.get(position);

	holder.imageView.setImageResource(R.drawable.man);
	holder.nameEmployee.setText(employee.getNameEmp());
	holder.telephoneEmployee.setText(employee.getTelNum());

	holder.itemView.setOnClickListener(view -> {
	  Intent intent = new Intent(view.getContext(), DisplayMessageActivity.class);

	  intent.putExtra("dataName", employee.getNameEmp());
	  intent.putExtra("dataTelephone", employee.getTelNum());
	  intent.putExtra("dataAge", String.valueOf(employee.getAge()));
	  intent.putExtra("dataSex", employee.getSex());

	  view.getContext().startActivity(intent);
	});
  }

  @Override
  public int getItemCount() {
	return EmployeeDataBase.getAll().size();
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
