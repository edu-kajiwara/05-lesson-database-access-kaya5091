package jp.ac.tama.service;

import jp.ac.tama.model.PhoneNumber;
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
public class PhoneNumberDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PhoneNumber> selectPhoneNumberList(){
        return jdbcTemplate.query("SELECT * FROM phoneNum;", new RowMapper<PhoneNumber>() {
            @Override
            public PhoneNumber mapRow(ResultSet rs, int rowNum) throws SQLException {
                PhoneNumber phoneNumber = new PhoneNumber(rs.getString("phoneNum_num"),rs.getString("phoneNum_name"));
                return phoneNumber;
            }
        });
    }

    public void insertPhoneNumber(PhoneNumber phoneNumber){
        jdbcTemplate.update(
                "INSERT INTO phoneNumber(phoneNumber_id, phoneNumber_name) VALUES (?,?)",
                phoneNumber.getNumber(),phoneNumber.getName());
    }


    public void updatePhoneNumber(PhoneNumber phoneNumber){
        jdbcTemplate.update(
                "UPDATE phoneNumber SET phoneNumber_name=? WHERE phoneNumber_id = ?",
                phoneNumber.getName(),phoneNumber.getNumber());
    }

    public void deletePhoneNumber(String phoneNumberId){
        jdbcTemplate.update(
                "DELETE FROM phoneNumber WHERE phoneNumber_id = ?",
                phoneNumberId);
    }
}
