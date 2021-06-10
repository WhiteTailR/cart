package service;

import pojo.Cart;
/**
 * @Author: zhengyi
 * @Date: 2021/6/10 18:37
 * @Description: 购物车服务层接口
 */
public interface CartService {
    /**
     * 添加到购物车
     * @param id
     * @param cart
     * @return
     */
    Cart addGoodsToCart(Integer id, Cart cart);

    /**
     * 从购物车删除
     * @param id
     * @param cart
     * @return
     */
    Cart deleteGoodsFromCart(Integer id, Cart cart);

    /**
     * 修改购物车商品数量
     * @param id
     * @param cart
     * @param number
     * @return
     */
    Cart updateGoodsNumber(Integer id, Cart cart, Integer number);
}
