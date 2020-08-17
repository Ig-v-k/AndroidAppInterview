package com.example.myappinterview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import static com.example.myappinterview.R.id.*;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {

  FragmentTransaction fragmentTransaction;
  OnItemClickListener listener;

  public EmployeeAdapter(FragmentTransaction fragmentTransaction) {
	this.fragmentTransaction = fragmentTransaction;
  }

  public interface OnItemClickListener {
    void onClick(View view, int position);
  }

  public void setListener(OnItemClickListener listener) {
	this.listener = listener;
  }

  @NonNull
  @NotNull
  @Override
  public EmployeeAdapter.ViewHolder onCreateViewHolder(
		@NonNull
		@NotNull ViewGroup parent, int viewType) {

	View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_staff_second, parent, false);
	return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(
		@NonNull
		@NotNull EmployeeAdapter.ViewHolder holder, int position) {

	holder.fragmentTransaction = this.fragmentTransaction;
	holder.bindView(position);
  }

  @Override
  public int getItemCount() {
	return EmployeeDataBase.getAll().size();
  }

  /**
   * Inner Class
   */
  class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

	FragmentTransaction fragmentTransaction;
	TextView nameEmployee, telephoneEmployee;
	CardView cardView;
	ImageView imageView;
	Employee employee;

	public ViewHolder(@NonNull @NotNull View itemView) {
	  super(itemView);

	  this.imageView = itemView.findViewById(RVCVImage);
	  this.nameEmployee = itemView.findViewById(RVCVName);
	  this.telephoneEmployee = itemView.findViewById(RVCVTelephone);
	  this.cardView = itemView.findViewById(mainCardViewEmployee);

	  itemView.setOnClickListener(this);
	}

	public void bindView(int position) {
	  employee = EmployeeDataBase.getAll().get(position);

	  imageView.setImageResource(R.drawable.man);
	  nameEmployee.setText(employee.getNameEmp());
	  telephoneEmployee.setText(employee.getTelNum());
	}

	@Override
	public void onClick(View view) {
	  Bundle bundle = new Bundle();
	  bundle.putString("dataName", employee.getNameEmp());
	  bundle.putString("dataTelephone", employee.getTelNum());
	  bundle.putString("dataAge", String.valueOf(employee.getAge()));
	  bundle.putString("dataSex", employee.getSex());

	  listener.onClick(view, getAdapterPosition());

	}
  }
}
