package ru.fattakhov.intensive.jdbc.DAO;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ru.fattakhov.intensive.jdbc.models.Profile;
import ru.fattakhov.intensive.jdbc.mapper.ProfileRowMapper;

@Repository
public class ProfileDAO {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProfileDAO(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long createProfile(Profile profile) {
        String sql = "INSERT INTO profile (address, phonenumber) VALUES (:address, :phonenumber) RETURNING profileid";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("address", profile.getAddress())
                .addValue("phonenumber", profile.getPhoneNumber());
        return jdbcTemplate.queryForObject(sql, params, Long.class);
    }

    public Profile getProfileById(Long profileid) {
        String sql = "SELECT * FROM profile WHERE profileid = :profileid";
        SqlParameterSource params = new MapSqlParameterSource("profileid", profileid);
        return jdbcTemplate.queryForObject(sql, params, new ProfileRowMapper());
    }

    public void updateProfile(Profile profile) {
        String sql = "UPDATE profile SET address = :address, phonenumber = :phonenumber WHERE profileid = :profileid";
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("profileid", profile.getId())
                .addValue("address", profile.getAddress())
                .addValue("phonenumber", profile.getPhoneNumber());
        jdbcTemplate.update(sql, params);
    }

    public void deleteProfile(Long profileid) {
        String sql = "DELETE FROM profile WHERE profileid = :profileid";
        SqlParameterSource params = new MapSqlParameterSource("profileid", profileid);
        jdbcTemplate.update(sql, params);
    }
}
