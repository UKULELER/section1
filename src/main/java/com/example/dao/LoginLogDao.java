package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.LoginLog;

/**
 * Repository interface with operations for {@link LoginLog} persistence.
 *
 * @author cgc
 */
public interface LoginLogDao extends JpaRepository<LoginLog, Integer> {

//    public void insertLoginLog(LoginLog loginLog) {
//        String sqlStr = "INSERT INTO t_login_log(user_id,ip,login_datetime) "
//                + "VALUES(?,?,?)";
//        Object[] args = {loginLog.getUserId(), loginLog.getIp(),
//                loginLog.getLoginDate()};
//        jdbcTemplate.update(sqlStr, args);
//    }
}