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
    private final String findByIdBeer = "SELECT * FROM BEER WHERE idBeer = :idBeer";
    private final String findByIdFactory = "SELECT * FROM BEER WHERE idFactory = :idFactory";

    private final String findAll = "SELECT * FROM BEER";
    private final String findByName = "SELECT * FROM BEER WHERE nameBeer = :name";
    private final String findByType = "SELECT * FROM BEER WHERE typeBeer = :type";
    @Override
    public Beer findById(Long id) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("idBeer", id);
        return jdbcTemplate.queryForObject(findByIdBeer, namedParameters, new BeerRowMapper());
    }

    @Override
    public List<Beer> findAll() {

        return jdbcTemplate.query(findAll, new BeerRowMapper());
    }

    @Override
    public List<Beer> getByFactoryId(Long idFactory) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("idFactory", idFactory);
        return jdbcTemplate.query(findByIdFactory, namedParameters,new BeerRowMapper());
    }

    @Override
    public Beer getByName(String name) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", name);
        return jdbcTemplate.queryForObject(findByName, namedParameters,new BeerRowMapper());
    }

    @Override
    public Beer getByType(String type) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("type", type);
        return jdbcTemplate.queryForObject(findByType, namedParameters,new BeerRowMapper());
    }

    public class BeerRowMapper implements RowMapper<Beer>{
        @Override
        public Beer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Beer b = new Beer();
            b.setId(rs.getLong("idBeer"));
            b.setName(rs.getString("nameBeer"));
            b.setType(rs.getString("typeBeer"));
            b.setDescription(rs.getString("description"));
            b.setAlcoholPercenatge(rs.getLong("alcoholPercentage"));
            b.setEvaluation(rs.getLong("evaluation"));
            b.setFactory(factoryDAO.findById(rs.getLong("idFactory")));
            return b;
        }
    }

}

