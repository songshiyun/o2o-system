package com.song.o2o.dto.echarts;

public class PirToolTip {
	private String trigger="item";
	private String formatter ="{a} <br/>{b}: {c} ({d}%)";
	
	
	public String getTrigger() {
		return trigger;
	}
	public String getFormatter() {
		return formatter;
	}
	
}