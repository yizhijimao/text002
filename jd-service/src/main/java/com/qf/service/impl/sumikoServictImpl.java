package com.qf.service.impl;


import com.qf.DAO.imol.sumikoDAOImpl;
import com.qf.DAO.sumikoDAO;
import com.qf.entity.Sumiko;
import com.qf.service.sumikoServict;

import java.util.List;

public class sumikoServictImpl implements sumikoServict {
    private sumikoDAO su = new sumikoDAOImpl();


    @Override
    public List<Sumiko> findAll() {
        try{
              return su.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
