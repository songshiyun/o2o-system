package com.song.o2o.dto.echarts;

import java.util.List;

public class PieLegend {
	private String orient ="vertical";
	private String x="right";
	private List<String> data;
	public String getOrient() {
		return orient;
	}
	public String getX() {
		return x;
	}
	public List<String> getData() {
		return data;
	}
	public void setData(List<String> data) {
		this.data = data;
	}
}
