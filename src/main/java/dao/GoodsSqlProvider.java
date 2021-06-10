package dao;

import pojo.Goods;

import static org.apache.ibatis.jdbc.SqlBuilder.*;
/**
 * @Author: zhengyi
 * @Date: 2021/6/10 18:51
 * @Description:
 */
public class GoodsSqlProvider {
    public String insertSelective(Goods record) {
        BEGIN();
        INSERT_INTO("goods");

        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }

        if (record.getPrice() != null) {
            VALUES("price", "#{price,jdbcType=DECIMAL}");
        }

        return SQL();
    }

    public String updateByPrimaryKeySelective(Goods record) {
        BEGIN();
        UPDATE("goods");

        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getPrice() != null) {
            SET("price = #{price,jdbcType=DECIMAL}");
        }

        WHERE("id = #{id,jdbcType=INTEGER}");

        return SQL();
    }
}
