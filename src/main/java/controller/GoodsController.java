package controller;

import pojo.Goods;
import service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
/**
 * @Author: zhengyi
 * @Date: 2021/6/10 18:50
 * @Description:商品控制层
 */
@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    GoodsServiceImpl goodsService;

    @GetMapping
    public ModelAndView getGoodsList(ModelAndView modelAndView){
        //获取商品并存入modelAndView中
        List<Goods> goods = goodsService.getAllGoods();
        modelAndView.addObject("goods", goods);
        modelAndView.setViewName("goods");
        return modelAndView;
    }
}