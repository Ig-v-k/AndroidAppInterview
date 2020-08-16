package com.example.myappinterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersAdapterVh> {
  private final List<Employee> employeeList;

  public UsersAdapter(List<Employee> employeeList) {
	this.employeeList = employeeList;
  }

  @NonNull
  @Override
  public UsersAdapter.UsersAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
	Context context = parent.getContext();
	return new UsersAdapterVh(LayoutInflater.from(context).inflate(R.layout.row_staff, null));
  }

  @Override
  public void onBindViewHolder(@NonNull UsersAdapter.UsersAdapterVh holder, int position) {
	Employee employee = employeeList.get(position);

	String username = employee.getNameEmp();
	int age = employee.getAge();

	holder.tvUsername.setText(username);
	holder.tvAge.setText(age);
  }

  @Override
  public int getItemCount() {
	return employeeList.size();
  }

  public static class UsersAdapterVh extends RecyclerView.ViewHolder {
	TextView tvAge;
	TextView tvUsername;
	ImageView imIcon;

	public UsersAdapterVh(@NonNull View itemView) {
	  super(itemView);
	  tvAge = itemView.findViewById(R.id.age);
	  tvUsername = itemView.findViewById(R.id.username);
	  imIcon = itemView.findViewById(R.id.imageView);
	}
  }
}