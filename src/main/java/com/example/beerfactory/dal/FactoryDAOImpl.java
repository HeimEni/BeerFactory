package com.example.beerfactory.dal;

import com.example.beerfactory.bo.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class FactoryDAOImpl implements FactoryDAO{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    private final String findById = "SELECT * FROM FACTORY WHERE idFactory = :idFactory";
    private final String findAll = "SELECT * FROM FACTORY";
    @Override
    public Factory findById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("idFactory", id);
        return jdbcTemplate.queryForObject(findById, namedParameters, new FactoryRowMapper());
    }

    @Override
    public List<Factory> findAll() {
        return jdbcTemplate.query(findAll, new FactoryRowMapper());
    }
    private class FactoryRowMapper implements RowMapper<Factory>{

        @Override
        public Factory mapRow(ResultSet rs, int rowNum) throws SQLException {
            Factory f = new Factory();
            f.setId(rs.getLong("idFactory"));
            f.setNom(rs.getString("nom"));
            f.setLatitude(rs.getLong("latitude"));
            f.setLongitude(rs.getLong("Longitude"));
            f.setAddress(rs.getString("address"));
            f.setOpenDate(rs.getDate("date").toLocalDate());
            return f;
        }
    }
}
