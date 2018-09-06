package com.song.o2o.service;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.song.o2o.BaseTest;
import com.song.o2o.entity.ShopCategory;


public class testShopCategoryService extends BaseTest{
	@Autowired
	private ShopCategoryService shopCategoryService;
	
	@Test
	public void testGetShopCategoryList(){
		List<ShopCategory> listShopCategory = shopCategoryService.getShopCategoryList(new ShopCategory());
		assertEquals("Coffee",listShopCategory.get(0).getShopCategoryName());
	}
}
