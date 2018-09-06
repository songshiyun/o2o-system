package com.song.o2o.dto;

import java.util.HashSet;
import java.util.List;

public class RediusAxis {
	private String  type="category";
	private HashSet<String> data;
	private int  z=10;
	
	public String getType() {
		return type;
	}
	

	public HashSet<String> getData() {
		return data;
	}
	public void setData(HashSet<String> data) {
		this.data = data;
	}
	public int getZ() {
		return z;
	}
	
	
}
