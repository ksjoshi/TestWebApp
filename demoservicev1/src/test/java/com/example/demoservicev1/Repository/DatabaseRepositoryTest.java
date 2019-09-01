package com.example.demoservicev1.Repository;

import com.example.demoservicev1.model.RegisterUserRequest;
import com.example.demoservicev1.model.UserInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DatabaseRepositoryTest {

    private JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);

    private DatabaseRepository subject = new DatabaseRepository(jdbcTemplate);

    @Test
    void shouldGetPasswordInformationForPassedUserName() {
        String userName = "test";
        UserInfo response = new UserInfo(1,"test","fName","lName", "test","hint");
        when(jdbcTemplate.queryForObject(any(String.class),any(RowMapper.class),any(String.class)))
                .thenReturn(response);

        UserInfo actual = subject.getUserInfo(userName);

        assertThat(actual,equalTo(response));
    }

    @Test
    void shouldReturnNullWhenUserNameIsNotFoundInDatabase() {
        String userName = "test";

        when(jdbcTemplate.queryForObject(any(String.class),any(RowMapper.class),any(String.class)))
                .thenReturn(null);

        UserInfo actual = subject.getUserInfo(userName);

        Assert.assertNull(actual);

    }

    @Test
    void shouldRegisterUser() {
        RegisterUserRequest request = new RegisterUserRequest("dummy","dummy","dummy","dummy","dummy");
        when(jdbcTemplate.update(any(String.class),any(Object.class))).thenReturn(1);
        int actual = subject.registerUser(request);
        assertThat(actual, equalTo(1));
    }



}