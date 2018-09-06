package com.song.o2o.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.o2o.BaseTest;
import com.song.o2o.entity.Area;

public class AreaServiceTest extends BaseTest{
	@Autowired
	private AreaService areaService;
	@Autowired
	private CacheService cacheService;
	@Test
	public void testGetArealList(){
		List<Area>areaList=areaService.getAreaList();
		assertEquals("北邮西门",areaList.get(0).getAreaName());
		cacheService.removeFromCache(areaService.AREALISTKEY);
	}
}
