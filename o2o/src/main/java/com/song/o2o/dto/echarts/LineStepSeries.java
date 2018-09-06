package com.song.o2o.dto.echarts;

import java.util.List;

public class LineStepSeries {
	private String name;
	private String type="line";
	private String step;
	private List<Integer> data;
	
	public List<Integer> getData() {
		return data;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStep(String step) {
		this.step = step;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getStep() {
		return step;
	}
	
}
