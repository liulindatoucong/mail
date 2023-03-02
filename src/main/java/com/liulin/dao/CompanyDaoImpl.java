package com.liulin.dao;

import com.liulin.pojo.Company;
import com.liulin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class CompanyDaoImpl implements CompanyDao{
    @Override
    public void insertCompany(Company company) {
        try (SqlSession session = MybatisUtils.getSession()) {
            CompanyDao mapper = session.getMapper(CompanyDao.class);
            mapper.insertCompany(company);
            session.commit();
        }
    }

    @Override
    public int getCompanyCountByName(String name) {
        try (SqlSession session = MybatisUtils.getSession()) {
            CompanyDao mapper = session.getMapper(CompanyDao.class);
            return  mapper.getCompanyCountByName(name);
        }
    }
}
