package service;

import pojo.Goods;
import java.util.List;
/**
 * @Author: zhengyi
 * @Date: 2021/6/10 18:37
 * @Description:商品服务层接口
 */
public interface GoodsService {
    /**
     * 获取全部商品
     * @return
     */
    List<Goods> getAllGoods();

    /**
     * 通过id查询商品
     * @param id
     * @return
     */
    Goods getGoodsById(Integer id);
}
