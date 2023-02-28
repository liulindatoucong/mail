package com.liulin.service;

import com.liulin.pojo.Area;
import java.util.List;

public class InitService {

    private final AreaService areaService = new AreaService();

    public List<Area> getAllAreas() {
        return areaService.getAllAreas();
    }

}
