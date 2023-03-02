package com.liulin.service;

import com.liulin.dao.CompanyDao;
import com.liulin.dao.CompanyDaoImpl;
import com.liulin.pojo.Company;

public class CompanyService {

    private CompanyDao companyDaoImpl = new CompanyDaoImpl();

    public void addCompany(Company company) {
        if(companyDaoImpl.getCompanyCountByName(company.getName())>0) {
            throw new RuntimeException("该公司已经存在"+company.getName());
        }
        companyDaoImpl.insertCompany(company);
    }
}
