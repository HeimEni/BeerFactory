package com.example.beerfactory.dal;

import com.example.beerfactory.bo.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class BeerDAOImpl implements BeerDAO{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private FactoryDAO factoryDAO;
    private final String findById = "SELECT * FROM BEER WHERE idBeer = :idBeer";
    private final String findAll = "SELECT * FROM BEER";
    @Override
    public Beer findById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("idBeer", id);
        return jdbcTemplate.queryForObject(findById, namedParameters, new BeerRowMapper());
    }

    @Override
    public List<Beer> findAll() {
        return null;
    }
    public class BeerRowMapper implements RowMapper<Beer>{
        @Override
        public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Beer b = new Beer();
            b.setId(rs.getLong("idBeer"));
            b.setName(rs.getString("name"));
            b.setDescription(rs.getString("descrption"));
            b.setType(rs.getString("type"));
            b.setEvaluation(rs.getLong("evaluation"));
            b.setAlcoholPercenatge(rs.getLong("alcoholPercentage"));
            b.setFactory(factoryDAO.findById(rs.getLong("idFactory")));
            return b;
        }
    }

}

