package com.example.demoservicev1.repository;

import com.example.demoservicev1.model.RegisterUserRequest;
import com.example.demoservicev1.model.UserInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;



@Repository
public class DatabaseRepository {

  private JdbcTemplate jdbcTemplate;

  public DatabaseRepository(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  public UserInfo getUserInfo(String userName) {
    String sql = "select * from users where username = ?";

    System.out.println("SQL is " + sql);

    return jdbcTemplate.queryForObject(sql, new UserInfoMapper(), userName);
  }

  public int registerUser(RegisterUserRequest registerUserRequest) {
    String insertSql = "insert into users(username, first_name,last_name,pwd,hint)"
            + " values (?,?,?,?,?)";
    return jdbcTemplate.update(insertSql, registerUserRequest.getUserName(),
            registerUserRequest.getFirstName(),
            registerUserRequest.getLastName(),
            registerUserRequest.getPwd(),
            registerUserRequest.getHint());
  }

  private static final class UserInfoMapper implements RowMapper<UserInfo> {
    @Override
    public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
      UserInfo pwd = new UserInfo(
              rs.getInt("id"),
              rs.getString("username"),
              rs.getNString("first_name"),
              rs.getString("last_name"),
              rs.getString("pwd"),
              rs.getString("hint")
      );
      return pwd;
    }
  }
}
