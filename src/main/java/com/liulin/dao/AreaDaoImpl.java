package com.liulin.dao;

import com.liulin.pojo.Area;
import com.liulin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AreaDaoImpl implements AreaDao{


    @Override
    public List<Area> getAreas() {
        try (SqlSession session = MybatisUtils.getSession()) {
            AreaDao mapper = session.getMapper(AreaDao.class);
            return mapper.getAreas();
        }
    }

    @Override
    public void addOneArea(Area area) throws Exception {
        try (SqlSession session = MybatisUtils.getSession()) {
            AreaDao mapper = session.getMapper(AreaDao.class);
            mapper.addOneArea(area);
            session.commit();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public int getAreaCountByName(String areaname) throws Exception{
        try (SqlSession session = MybatisUtils.getSession()) {
            AreaDao mapper = session.getMapper(AreaDao.class);
            return mapper.getAreaCountByName(areaname);
        } catch (Exception e) {
            throw e;
        }
    }
}
