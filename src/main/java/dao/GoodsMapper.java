package dao;

import pojo.Goods;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * @Author: zhengyi
 * @Date: 2021/6/10 18:50
 * @Description:持久层接口
 */
@Repository
public interface GoodsMapper {
    @Delete({
            "delete from goods",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into goods (id, name, ",
            "price)",
            "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
            "#{price,jdbcType=DECIMAL})"
    })
    int insert(Goods record);

    @InsertProvider(type=GoodsSqlProvider.class, method="insertSelective")
    int insertSelective(Goods record);

    @Select({
            "select",
            "id, name, price",
            "from goods",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    Goods selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, name, price",
            "from goods"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="price", property="price", jdbcType=JdbcType.DECIMAL)
    })
    List<Goods> selectAll();

    @UpdateProvider(type=GoodsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Goods record);

    @Update({
            "update goods",
            "set name = #{name,jdbcType=VARCHAR},",
            "price = #{price,jdbcType=DECIMAL}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Goods record);

}
