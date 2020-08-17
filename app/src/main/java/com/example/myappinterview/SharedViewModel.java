package com.example.myappinterview;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
  private MutableLiveData<Employee> selected = new MutableLiveData<>();

  public void setSelected(Employee employee) {
    selected.setValue(employee);
  }

  public MutableLiveData<Employee> getSelected() {
    return selected;
  }

}
