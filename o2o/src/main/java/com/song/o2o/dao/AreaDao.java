package com.song.o2o.dao;

import java.util.List;

import com.song.o2o.entity.Area;

public interface AreaDao {
	/**
	 * 列出区域列表信息
	 * @return areaList
	 */
	List<Area> queryArea();
}
