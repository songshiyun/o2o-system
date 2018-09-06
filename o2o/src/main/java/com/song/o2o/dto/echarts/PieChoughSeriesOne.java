package com.song.o2o.dto.echarts;

import java.util.List;

public class PieChoughSeriesOne {
	private String name="商品名稱";
	private String type="pie";
	private String [] radius={"50%","70%"};
	private boolean avoidLabelOverlap=false;
	private Label lebel = new Label();
	private LabelLine labelLine = new LabelLine();
	private List<Data> data;
	
	public List<Data> getData() {
		return data;
	}
	public void setData(List<Data> data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String[] getRadius() {
		return radius;
	}
	public boolean isAvoidLabelOverlap() {
		return avoidLabelOverlap;
	}
	public Label getLebel() {
		return lebel;
	}
	public LabelLine getLabelLine() {
		return labelLine;
	}



	public static class Data {
		private int value;
		private String name;
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}

	
	private static class LabelLine{
		private NomaleOne nomal = new NomaleOne();
		public NomaleOne getNomal() {
			return nomal;
		}
		private static class NomaleOne{
			private boolean show =false;

			public boolean isShow() {
				return show;
			}	
		}
	}
	private static class Label{
		private Normal normal=new Normal();
		private Emphasis emphasis= new Emphasis();
		public Normal getNormal() {
			return normal;
		}
		public Emphasis getEmphasis() {
			return emphasis;
		}
		
	}
	private static class Normal{
		private boolean show=false;
		private String position ="center";
		public boolean isShow() {
			return show;
		}
		public String getPosition() {
			return position;
		}
	}
	private static class Emphasis{
		private boolean show = true;
		private TextStyle textStyle=new TextStyle();
		
	}
	private static class TextStyle{
		private String fontSize="30";
        private String fontWeight="bold";
		public String getFontSize() {
			return fontSize;
		}
		public String getFontWeight() {
			return fontWeight;
		}
        
	}
}