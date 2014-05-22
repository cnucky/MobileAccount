package com.mobile.dao;

import java.util.ArrayList;

import com.mobile.model.ModelInterface;

public interface DaoInterface {

	public ArrayList<ModelInterface>  getAll();
	
	public ModelInterface getObjectById(int id);
	
	public ModelInterface getObjectById(String id);
	
	public int add(ModelInterface model);
	
	public int remove(int id);
	
	public int remove(String id);
	
	public int update(ModelInterface model);
	
}
