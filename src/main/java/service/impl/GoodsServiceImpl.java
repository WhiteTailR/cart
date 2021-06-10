package service.impl;

import dao.GoodsMapper;
import pojo.Goods;
import exception.Exception;
import service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @Author: zhengyi
 * @Date: 2021/6/10 18:41
 * @Description:商品服务层
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 获取所有商品信息
     * @return
     */
    @Override
    public List<Goods> getAllGoods(){
        try{
            return goodsMapper.selectAll();
        }catch (Exception e){
            throw new Exception("10001", e.getMessage(), e);
        }
    }

    /**
     * 根据id获取商品信息
     * @param id
     * @return
     */
    @Override
    public Goods getGoodsById(Integer id) {
        try{
            return goodsMapper.selectByPrimaryKey(id);
        }catch (Exception e){
            throw new Exception("10002", e.getMessage(), e);
        }
    }
}