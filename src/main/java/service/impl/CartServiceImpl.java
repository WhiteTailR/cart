package service.impl;

import dao.GoodsMapper;
import pojo.Cart;
import pojo.Goods;
import exception.Exception;
import service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
/**
 * @Author: zhengyi
 * @Date: 2021/6/10 18:41
 * @Description:购物车服务层
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 添加商品到购物车
     * @param id
     * @param cart
     * @return
     */
    @Override
    public Cart addGoodsToCart(Integer id, Cart cart) {
        try{
            //获取map
            Map<Goods, Integer> map = cart.getMap();
            Goods goods = goodsMapper.selectByPrimaryKey(id);
            //goods有则数量+1， 没有就添加进map
            if(map == null){
                map = new HashMap<>();
                map.put(goods, 1);
            }else if(map.containsKey(goods)){
                map.replace(goods, map.get(goods) + 1);
            }else{
                map.put(goods, 1);
            }
            cart.setMap(map);
            return cart;
        }catch (Exception e){
            throw new Exception("20001", e.getMessage(), e);
        }
    }

    /**
     * 从购物车删除商品
     * @param id
     * @param cart
     * @return
     */
    @Override
    public Cart deleteGoodsFromCart(Integer id, Cart cart) {
        try{
            //获取map，包含商品id就删除
            Map<Goods, Integer> map = cart.getMap();
            Goods goods = goodsMapper.selectByPrimaryKey(id);
            if(map == null){
                map = new HashMap<>();
            }else if(map.containsKey(goods)){
                map.remove(goods);
            }
            cart.setMap(map);
            return cart;
        }catch (Exception e){
            throw new Exception("20002", e.getMessage(), e);
        }

    }

    /**
     * 更新商品数量
     * @param id
     * @param cart
     * @param number
     * @return
     */
    @Override
    public Cart updateGoodsNumber(Integer id, Cart cart, Integer number) {
        try{
            //获取map，
            Map<Goods, Integer> map = cart.getMap();
            Goods goods = goodsMapper.selectByPrimaryKey(id);
            map.replace(goods, number);
            cart.setMap(map);
            return cart;
        }catch (Exception e){
            throw new Exception("20003", e.getMessage(), e);
        }
    }
}
