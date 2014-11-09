package com.thoughtworks.dao.impl;

import com.thoughtworks.dao.PromotionDao;
import com.thoughtworks.entity.Promotion;
import com.thoughtworks.entity.PromotionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class PromotionDaoImpl implements PromotionDao {

    private JdbcTemplate jdbcTemplate;

    public PromotionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Promotion getPromotion(int id) {
        String sql = "SELECT * FROM promotions WHERE p_id = ?";

        return jdbcTemplate.queryForObject(sql,new Object[]{id},new RowMapper<Promotion>() {
            @Override
            public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {
                Promotion mapRowPromotion = PromotionFactory.getPromotionByType(rs.getInt("p_type"));
                mapRowPromotion.setId(rs.getInt("p_id"));
                mapRowPromotion.setDescription(rs.getString("p_description"));
                mapRowPromotion.setType(rs.getInt("p_type"));
                return mapRowPromotion;
            }
        });
    }

    @Override
    public Set<String> getPromotionBarcodes() {
        String sql = "select * from items i, items_promotions ip where i.i_id = ip.itemid ";

        List<String> promotionBarcodeList = jdbcTemplate.query(sql,new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("i_barcode");
            }
        });

        Set<String> promotionBarcodes = new HashSet<String>();
        promotionBarcodes.addAll(promotionBarcodeList);
        return promotionBarcodes;
    }

}
