$(function() {
	getProductSellDailyList();
	function getProductSellDailyList() {
		// 获取该店铺商品7天销量的URL
		var listProductSellDailyUrl = '/o2o/shopadmin/awardsteplineinfo';
		// 访问后台，该店铺商品7天销量的URL
		$.getJSON(listProductSellDailyUrl, function(data) {
			if (data.success) {
				var myChart = echarts.init(document.getElementById('container'));
				// 生成静态的Echart信息的部分
				var option = generateStaticEchartPart();
				// 遍历销量统计列表,动态设定echarts的值
				option.legend.data=data.legendData;
				option.xAxis=data.xAxis;
				option.series = data.series;
				myChart.setOption(option);
			}
		});
	}
	
	function generateStaticEchartPart(){
		var	option = {
		    title: {
		        text: '銷量統計圖'
		    },
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: { },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    toolbox: {
		        feature: {
		            saveAsImage: {}
		        }
		    },
		    xAxis: {},
		    yAxis: {
		        type: 'value'
		    },
		    series: [
		    ]
		};
		return option;
	}
});