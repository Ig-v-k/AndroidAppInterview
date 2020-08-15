package com.example.myappinterview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersAdapterVh> implements Filterable {

  private List<Employee> userModelList;
  private List<Employee> getUserModelListFiltered;
  private Context context;
  private SelectedUser selectedUser;

  public UsersAdapter(List<Employee> userModelList,SelectedUser selectedUser) {
	this.userModelList = userModelList;
	this.getUserModelListFiltered = userModelList;
	this.selectedUser = selectedUser;
  }

  @NonNull
  @Override
  public UsersAdapter.UsersAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
	context = parent.getContext();

	return new UsersAdapterVh(LayoutInflater.from(context).inflate(R.layout.r, null));
  }

  @Override
  public void onBindViewHolder(@NonNull UsersAdapter.UsersAdapterVh holder, int position) {

	Employee employee = userModelList.get(position);

	String username = employee.getNameEmp();
	String age = String.valueOf(employee.getAge()).substring(0,1);

	holder.tvUsername.setText(username);
	holder.tvPrefix.setText(age);

  }

  @Override
  public int getItemCount() {
	return userModelList.size();
  }

  @Override
  public Filter getFilter() {

	Filter filter = new Filter() {
	  @Override
	  protected FilterResults performFiltering(CharSequence charSequence) {
		FilterResults filterResults = new FilterResults();
		if(charSequence == null | charSequence.length() == 0){
		  filterResults.count = getUserModelListFiltered.size();
		  filterResults.values = getUserModelListFiltered;
		}else{
		  String searchChr = charSequence.toString().toLowerCase();
		  List<Employee> resultData = new ArrayList<>();
		  for(Employee userModel: getUserModelListFiltered){
			if(userModel.getNameEmp().toLowerCase().contains(searchChr)){
			  resultData.add(userModel);
			}
		  }
		  filterResults.count = resultData.size();
		  filterResults.values = resultData;
		}
		return filterResults;
	  }

	  @Override
	  protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
		userModelList = (List<Employee>) filterResults.values;
		notifyDataSetChanged();
	  }
	};
	return filter;
  }


  public interface SelectedUser{

	void selectedUser(Employee userModel);

  }

  public class UsersAdapterVh extends RecyclerView.ViewHolder {

	TextView tvAge;
	TextView tvUsername;
	ImageView imIcon;
	public UsersAdapterVh(@NonNull View itemView) {
	  super(itemView);
	  tvAge = itemView.findViewById(R.id.age);
	  tvUsername = itemView.findViewById(R.id.username);
	  imIcon = itemView.findViewById(R.id.imageView);

	  itemView.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View view) {
		  selectedUser.selectedUser(userModelList.get(getAdapterPosition()));
		}
	  });


	}
  }
}