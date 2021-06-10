package pojo;

import java.util.Map;
/**
 * @Author: zhengyi
 * @Date: 2021/6/10 18:25
 * @Description: 购物车实体类
 */
public class Cart {
    Map<Goods, Integer> map;

    private static final long serialVersionUID = 2L;

    public Cart() {
    }

    public Cart(Map<Goods, Integer> map) {
        this.map = map;
    }

    public Map<Goods, Integer> getMap() {
        return map;
    }

    public void setMap(Map<Goods, Integer> map) {
        this.map = map;
    }
}
