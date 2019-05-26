package com.example.modul8.tpm.model.post;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PostResponse{

	@SerializedName("data")
	private List<Data> data;

	@SerializedName("errors")
	private Object errors;

	public void setData(List<Data> data){
		this.data = data;
	}

	public List<Data> getData(){
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
			"PostResponse{" + 
			"data = '" + data + '\'' + 
			",errors = '" + errors + '\'' + 
			"}";
		}
}