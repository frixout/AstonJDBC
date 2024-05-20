package ru.fattakhov.intensive.jdbc.models.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.fattakhov.intensive.jdbc.models.entity.Employee;
import ru.fattakhov.intensive.jdbc.models.entity.Profile;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileRowMapper implements RowMapper<Profile> {

    @Override
    public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {

        Profile profile = new Profile();
        profile.setId(rs.getLong("profileid"));
        profile.setAddress(rs.getString("address"));
        profile.setPhoneNumber(rs.getString("phonenumber"));
        return profile;
    }
}
