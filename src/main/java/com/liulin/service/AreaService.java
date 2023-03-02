package com.liulin.service;

import com.liulin.dao.AreaDao;
import com.liulin.dao.AreaDaoImpl;
import com.liulin.pojo.Area;

import java.util.List;

public class AreaService {
    private final AreaDao areaDaoImpl = new AreaDaoImpl();

    public List<Area> getAllAreas() {
        return areaDaoImpl.getAreas();
    }

    public void addOneArea(Area area) throws Exception {
        if(areaDaoImpl.getAreaCountByName(area.getAreaname()) > 0) {
            throw new RuntimeException(area.getAreaname()+"地区已经存在！");
        }
        areaDaoImpl.addOneArea(area);
    }

}
