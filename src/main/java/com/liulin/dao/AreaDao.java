package com.liulin.dao;

import com.liulin.pojo.Area;

import java.util.List;

public interface AreaDao {

    /**
     * 获取全部地区数据
     * @return
     * List<Area>
     */
    List<Area> getAreas();

    void addOneArea(Area area) throws Exception;

    int getAreaCountByName(String areaname) throws Exception;
}
