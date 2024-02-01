package com.example.beerfactory.dal;

import com.example.beerfactory.bo.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
@Repository
public class FactoryDAOImpl implements FactoryDAO{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    private final String findById = "SELECT * FROM FACTORY WHERE idFactory = :idFactory";
    private final String findAll = "SELECT * FROM FACTORY";
    private final String findByAddress = "SELECT * FROM FACTORY WHERE address = :address";
    private final String findOpenedFactory = "SELECT * FROM FACTORY WHERE openDate < NOW()";
    private final String findSupThanDate = "SELECT * FROM FACTORY WHERE openDate > :date";
    private final String findByName = "SELECT * FROM FACTORY WHERE nameFactory = :nameFactory";
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

    @Override
    public Factory getByAddress(String address) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("address", address);
        return jdbcTemplate.queryForObject(findByAddress, namedParameters,new FactoryRowMapper());
    }

    @Override
    public List<Factory> getOpenFactory() {
        return jdbcTemplate.query(findOpenedFactory, new FactoryRowMapper());
    }

    @Override
    public List<Factory> getSupThanOpenedDate(LocalDate date) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("date", date);
        return jdbcTemplate.query(findSupThanDate, namedParameters, new FactoryRowMapper());
    }


    @Override
    public Factory getByNom(String name) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("nameFactory", name);
        return jdbcTemplate.queryForObject(findByName, namedParameters, new FactoryRowMapper());
    }

    private class FactoryRowMapper implements RowMapper<Factory>{

        @Override
        public Factory mapRow(ResultSet rs, int rowNum) throws SQLException {
            Factory f = new Factory();
            f.setId(rs.getLong("idFactory"));
            f.setNom(rs.getString("nameFactory"));
            f.setLatitude(rs.getLong("latitude"));
            f.setLongitude(rs.getLong("longitude"));
            f.setAddress(rs.getString("address"));
            f.setOpenDate(rs.getDate("openDate").toLocalDate());
            return f;
        }
    }
}
