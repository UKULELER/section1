package com.example.dao;

import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;

/**
 * Repository interface with operations for {@link User} persistence.
 *
 * @author habuma
 */
public interface UserDao extends JpaRepository<User, Integer> {

    int countByUserNameAndPassword(String userName, String password);

//    public int getMatchCount(String userName, String password) {
//        String sqlStr = " SELECT count(*) FROM t_user "
//                + " WHERE user_name =? and password=? ";
//        return jdbcTemplate.queryForObject(sqlStr, new Object[]{userName, password}, Integer.class);
//    }

//    @Query("select u from t_user u where u.userName = ?1")
    @Cacheable("userCache")
    User findUserByUserName(final String userName);

//    public User findUserByUserName(final String userName) {
//        String sqlStr = " SELECT user_id,user_name "
//                + " FROM t_user WHERE user_name =? ";
//
//        return jdbcTemplate.queryForObject(sqlStr, (ResultSet rs, int rowNum) -> {
//            User user = new User(rs.getInt("user_id"), rs.getString("user_name"));
//            return user;
//        }, userName);
//    }

    @Transactional
    @Modifying
    @Query(value = "update t_user u set u.lastVisit = :#{#user.lastVisit} , u.lastIp = :#{#user.lastIp}  where u.userId = :#{#user.userId} ")
    void updateLoginInfo(@Param("user") User user);

//    @Transactional
//    @Modifying
//    @Query(value="UPDATE t_user SET last_visit=:#{#user.lastVisit},last_ip=:#{#user.lastIp} WHERE user_id =:#{#user.userId}",nativeQuery = true)
//    void updateLoginInfo(@Param("user") User user);

//    public void updateLoginInfo(User user) {
//        String sqlStr = " UPDATE t_user SET last_visit=?,last_ip=?"
//                + " WHERE user_id =?";
//        jdbcTemplate.update(sqlStr, new Object[]{user.getLastVisit(),
//                user.getLastIp(), user.getUserId()});
//    }
}
