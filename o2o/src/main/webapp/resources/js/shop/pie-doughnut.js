$(function() {
	getProductSellDailyList();
	function getProductSellDailyList() {
		// 获取该店铺商品7天销量的URL
		var listProductSellDailyUrl = '/o2o/shopadmin/awardpiedoughchartinfo';
		// 访问后台，该店铺商品7天销量的URL
		$.getJSON(listProductSellDailyUrl, function(data) {
			if (data.success) {
				var myChart = echarts.init(document.getElementById('container'));
				// 生成静态的Echart信息的部分
				var option = generateStaticEchartPart();
				var tooltip={
				        trigger: 'item',
				        formatter: "{a} <br/>{b}: {c} ({d}%)"
				    };
				option.tooltip=tooltip;
				option.legend.orient="vertical";
				option.legend.x='right';
				option.series.name='商品名稱';
				option.series.type='pie';
				option.series.radius=['50%', '70%'];
				var lebel={
	                normal: {
	                    show: false,
	                    position: 'center'
	                },
	                emphasis: {
	                    show: true,
	                    textStyle: {
	                        fontSize: '30',
	                        fontWeight: 'bold'
	                    }
	                }
	            };
				option.series.lebel=lebel;
				option.series.lebelLine={
	                normal: {
	                    show: false
	                }
	            };
			var res={
						"series":[
							{"value":8,"name":"珍珠奶茶"},
							{"value":6,"name":"卡布奇洛"},
							{"value":8,"name":"伏特加"},
							{"value":8,"name":"茅臺"}
						],
							"success":true,
							"legendData":["珍珠奶茶","卡布奇洛","伏特加","茅臺"]
			};
			
				// 遍历销量统计列表,动态设定echarts的值
				option.legend.data=data.legendData;
				option.series.data = data.series;
				myChart.setOption(option);
			}
		});
	}
	
	function generateStaticEchartPart(){
		var	option = {
		    title: {
		        text: '日銷量統計圖'
		    },
		    tooltip: {
		    },
		    legend: {
		       
		    },
		    series: []
		};
		return option;
	}
});