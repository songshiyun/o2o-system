$(function(){
	var awarId=  getQueryString('awardId');
	var productUrl = '/o2o/frontend/listAwarddetailpageinfo?awardId='
		+ awarId;
	
	$.getJSON(productUrl,function(data){
		//返回的award对象信息
		var award = data.award;
		// 商品缩略图
		$('#product-img').attr('src', award.awardImg);
		// 商品更新时间
		$('#product-time').text('创建时间: '+
				new Date(award.lastEditTime).Format("yyyy-MM-dd"));
		 if (award.point != undefined) {
		 $('#product-point').text('奖品需要' + award.point + '积分');
		// 商品名称
		$('#product-name').text(award.awardName);
			// 商品简介
		$('#product-name_one').text('奖品名称: '+award.awardName);
		$('#product-desc').text('奖品描述: '+award.awardDesc);
		 }
	});
	// 点击后打开右侧栏
	$('#me').click(function() {
		$.openPanel('#panel-right-demo');
	});
	$.init();
});