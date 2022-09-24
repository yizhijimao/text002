package com.qf.DAO;

import com.qf.entity.Sumiko;

import java.sql.SQLException;
import java.util.List;

public interface sumikoDAO {
     List<Sumiko> findAll() throws SQLException;



}
