package com.song.o2o.dto;

import java.util.List;

public class RediusSeries {
	private String name;
	private List<Integer> data;
	private String type="bar";
	private String coordinateSystem="polar";
	private String stack="a";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
	
	
	public String getType() {
		return type;
	}
	
	public String getCoordinateSystem() {
		return coordinateSystem;
	}
	
	public String getStack() {
		return stack;
	}
	
	
	
	
}
