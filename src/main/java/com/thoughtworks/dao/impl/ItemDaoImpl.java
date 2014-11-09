package com.thoughtworks.dao.impl;

import com.thoughtworks.dao.ItemDao;
import com.thoughtworks.dao.PromotionDao;
import com.thoughtworks.entity.Item;
import com.thoughtworks.entity.Promotion;
import com.thoughtworks.entity.PromotionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {

    @Autowired
    private PromotionDao promotionDaoImpl;
    private JdbcTemplate jdbcTemplate;

    public ItemDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Item getItem(String barcode) {
        String sql = "select * from items i,categories c where  i.i_categoryid = c.c_id and i_barcode = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{barcode}, new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Item(rs.getInt("i_id"), rs.getString("i_barcode"), rs.getString("i_Name"), rs.getString("i_unit"), rs.getDouble("i_price"), rs.getString("c_name"));
            }
        });
    }

    @Override
    public List<Promotion> getItemPromotions(String barcode) {
        String sql = "select * from items i,items_promotions ip where i.i_id=ip.itemid  and i_barcode = ?";

        return jdbcTemplate.query(sql, new Object[]{barcode}, new RowMapper<Promotion>() {
            @Override
            public Promotion mapRow(ResultSet rs, int rowNum) throws SQLException {

                int promotionId = rs.getInt("promotionid");
                Promotion promotionForType = promotionDaoImpl.getPromotion(promotionId);

                Promotion promotion = PromotionFactory.getPromotionByType(promotionForType.getType());
                promotion.setId(promotionForType.getId());
                promotion.setType(promotionForType.getType());
                promotion.setDescription(promotionForType.getDescription());
                promotion.setDiscount(rs.getDouble("discount"));
                return promotion;
            }
        });
    }

}



