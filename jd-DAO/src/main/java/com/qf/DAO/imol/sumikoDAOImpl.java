package com.qf.DAO.imol;

import com.qf.DAO.sumikoDAO;
import com.qf.entity.Sumiko;
import com.qf.util.DBConnection;
import com.qf.util.SQLConnection;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class sumikoDAOImpl implements sumikoDAO {
    QueryRunner runner = new QueryRunner(DBConnection.getDataSource());
    @Override
    public List<Sumiko> findAll() throws SQLException {
    return runner.query(SQLConnection.SUMIKO_FIND_ALL, new ResultSetHandler<List<Sumiko>>() {
        @Override
        public List<Sumiko> handle(ResultSet resultSet) throws SQLException {
            List<Sumiko> list =new ArrayList<>();
                while(resultSet.next()){
                    list.add(Sumiko.builder()
                                    .id(resultSet.getInt("id"))
                                    .name(resultSet.getString("name"))
                                    .number(resultSet.getInt("number"))
                            .build());
                }
         return list;
        }
    });
    }
//    public List<Sumiko> findAll() throws SQLException {
//        return runner.query(SQLConnection.SUMIKO_FIND_ALL,
//                new BeanHandler<Sumiko>(Sumiko.class));
//    }

}







































