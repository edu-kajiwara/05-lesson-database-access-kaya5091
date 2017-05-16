package jp.ac.tama.service;

import jp.ac.tama.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by YK on 2017/05/16.
 */
@Service
public class UserDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> selectUserList(){
        return jdbcTemplate.query("SELECT * FROM user;", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User(rs.getString("user_id"),rs.getString("user_name"));
                return user;
            }
        });
    }

    public void insertUser(User user){
        jdbcTemplate.update(
                "INSERT INTO user(user_id, user_name) VALUES (?,?)",
                user.getId(),user.getName());
    }


    public void updateUser(User user){
        jdbcTemplate.update(
                "UPDATE user SET user_name=? WHERE user_id = ?",
                user.getName(),user.getId());
    }

    public void deleteUser(String userId){
        jdbcTemplate.update(
                "DELETE FROM user WHERE user_id = ?",
                userId);
    }
}
