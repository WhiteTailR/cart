package controller;

import pojo.Cart;
import pojo.Goods;
import service.impl.CartServiceImpl;
import service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhengyi
 * @Date: 2021/6/10 18:31
 * @Description:购物车控制层
 */
public class CartController {
    @Autowired
    GoodsServiceImpl goodsService;

    @Autowired
    CartServiceImpl cartService;

    /**
     *
     * @param req
     * @param resp
     * @param modelAndView
     * @return
     */
    @GetMapping
    public ModelAndView getGoodsList(HttpServletRequest req, HttpServletResponse resp, ModelAndView modelAndView){

        HttpSession session = req.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if(cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        Map<Goods, Integer> goodsMap = cart.getMap();
        if(goodsMap == null){
            goodsMap = new HashMap<>();
        }
        modelAndView.addObject("goodsMap", goodsMap);
        modelAndView.setViewName("cart");
        return modelAndView;
    }

    /**
     *
     * @param req
     * @param resp
     * @param modelAndView
     * @param goodsId
     * @return
     */
    @PutMapping(value = "/{goodsId}")
    public ModelAndView addCart(HttpServletRequest req, HttpServletResponse resp, ModelAndView modelAndView,
                                @PathVariable("goodsId") Integer goodsId){

        HttpSession session = req.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if(cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        cart = cartService.addGoodsToCart(goodsId, cart);
        session.setAttribute("cart", cart);
        modelAndView.setViewName("redirect:/api/goods");
        return modelAndView;
    }

    /**
     *
     * @param req
     * @param resp
     * @param modelAndView
     * @param goodsId
     * @return
     */
    @DeleteMapping(value = "/{goodsId}")
    public ModelAndView deleteFromCart(HttpServletRequest req, HttpServletResponse resp, ModelAndView modelAndView,
                                       @PathVariable("goodsId") Integer goodsId){

        HttpSession session = req.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if(cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        cart = cartService.deleteGoodsFromCart(goodsId, cart);
        session.setAttribute("cart", cart);
        modelAndView.setViewName("redirect:/api/cart");
        return modelAndView;
    }
}
