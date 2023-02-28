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
        areaDaoImpl.addOneArea(area);
    }
}
