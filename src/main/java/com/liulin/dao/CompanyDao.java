package com.liulin.dao;

import com.liulin.pojo.Company;

public interface CompanyDao {

    void insertCompany(Company company);

    int getCompanyCountByName(String name);

}
