package com.song.o2o.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.song.o2o.BaseTest;
import com.song.o2o.entity.Area;

/**
 * @author Mosaic_Song
 *测试spring-dao的相关配置是否正确
 */
public class AreaDaoTest extends BaseTest {
	@Autowired
	private AreaDao areaDao;
	
	@Test
	public void testQueryArea(){
		List<Area> areaList = areaDao.queryArea();
		assertEquals(2, areaList.size());
	}
}
