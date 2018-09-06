package com.song.o2o.service;

import java.io.File;

import com.song.o2o.dto.ImageHolder;
import com.song.o2o.dto.ShopExecution;
import com.song.o2o.entity.Shop;
import com.song.o2o.exceptions.ShopOperationException;

public interface ShopService {
	/**
	 * 根据shopCondition分页返回相应店铺列表
	 * 
	 * @param shopCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

	/**
	 * 添加店铺
	 * @param shop
	 * @param thumbnail
	 * @return
	 */
	ShopExecution addShop(Shop shop,ImageHolder thumbnail);
	
	/**
	 * 通过店铺Id获取店铺信息
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);

	
	/**
	 * 更新店铺信息，包括对图片的处理
	 * 
	 * @param shop
	 * @param shopImg
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution modifyShop(Shop shop, ImageHolder thumbnail) throws ShopOperationException;
}
