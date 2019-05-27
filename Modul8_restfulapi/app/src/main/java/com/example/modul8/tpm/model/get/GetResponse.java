package com.example.modul8.tpm.model.get;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetResponse{

	@SerializedName("data")
	private List<DataItems> data;

	@SerializedName("errors")
	private Object errors;

	public void setData(List<DataItems> data){
		this.data = data;
	}

	public List<DataItems> getData(){
		return data;
	}

	public void setErrors(Object errors){
		this.errors = errors;
	}

	public Object getErrors(){
		return errors;
	}

	@Override
 	public String toString(){
		return 
			"GetResponseById{" +
			"data = '" + data + '\'' + 
			",errors = '" + errors + '\'' + 
			"}";
		}
}