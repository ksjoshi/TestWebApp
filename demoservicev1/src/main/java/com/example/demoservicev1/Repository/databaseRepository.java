package com.example.demoservicev1.Repository;

import com.example.demoservicev1.model.Pwd;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class databaseRepository {

    JdbcTemplate jdbcTemplate;

    public databaseRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Pwd getUserInfo(String userName) {
        String sql = "select * from pwd where id = (select id from users where username = ?)";

        System.out.println("SQL is " + sql);

        return jdbcTemplate.queryForObject(sql,new PwdMapper(), userName);
    }

    private static final class PwdMapper implements RowMapper<Pwd> {

        @Override
        public Pwd mapRow(ResultSet rs, int rowNum) throws SQLException {
            Pwd pwd = new Pwd(
                    rs.getInt("id"),
                    rs.getString("pwd")
            );
            return pwd;
        }
    }
}
