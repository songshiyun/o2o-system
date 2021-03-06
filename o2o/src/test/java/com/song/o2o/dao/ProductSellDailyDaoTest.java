package com.song.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.o2o.BaseTest;
import com.song.o2o.entity.ProductSellDaily;
import com.song.o2o.entity.Shop;

public class ProductSellDailyDaoTest extends BaseTest{
	@Autowired
	private ProductSellDailyDao productSellDailyDao;

	/**
	 * 测试添加功能
	 * 
	 * @throws Exception
	 */
	@Ignore
	public void testAInsertProductSellDaily() throws Exception {
		// 创建商品日销量统计
		int effectedNum = productSellDailyDao.insertProductSellDaily();
		assertEquals(3, effectedNum);
	}
	
	/**
	 * 测试添加功能
	 * 
	 * @throws Exception
	 */
	@Ignore
	public void testBInsertDefaultProductSellDaily() throws Exception {
		// 创建商品日销量统计
		int effectedNum = productSellDailyDao.insertDefaultProductSellDaily();
		assertEquals(10, effectedNum);
	}

	/**
	 * 测试查询功能
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCQueryProductSellDaily() throws Exception {
		ProductSellDaily productSellDaily = new ProductSellDaily();
		// 叠加店铺去查询
		Shop shop = new Shop();
		shop.setShopId(28L);
		Calendar calendar = Calendar.getInstance();
		// 获取昨天的日期
		//calendar.add(Calendar.DATE, -1);
		Date endTime = calendar.getTime();
		// 获取七天前的日期
		calendar.add(Calendar.DATE, -1);
		Date beginTime = calendar.getTime();
		productSellDaily.setShop(shop);
		List<ProductSellDaily> productSellDailyList = productSellDailyDao.queryProductSellDailyList(productSellDaily,
				beginTime, endTime);
		System.out.println(productSellDailyList.size());
	}
}
