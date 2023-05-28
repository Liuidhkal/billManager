package com.lfz.demo.controller;

import com.github.pagehelper.PageInfo;
import com.lfz.demo.entity.Bill;
import com.lfz.demo.entity.BillType;
import com.lfz.demo.service.BillService;
import com.lfz.demo.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Resource
    private BillService billService;
    @Resource
    private TypeService typeService;

    /*
    * 分页查询所有
    * */
    @RequestMapping("/list-page")
    public ModelAndView listPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer size,
                                 Bill b){
        ModelAndView mv = new ModelAndView();
        //查询类型，存入请求
        List<BillType> types = typeService.list();
        mv.addObject("types", types);

        PageInfo<Bill> pageInfo = billService.findAllPage(pageNum, size, b);

        mv.addObject("bill",b);
        mv.addObject("page", pageInfo);
        mv.setViewName("/bill/list-page");
        return mv;
    }

    /*
    * 删除
    * */
    @RequestMapping("/del/{id}")
    public String del(@PathVariable("id") Long id){
        billService.removeById(id);

        return "redirect:/bill/list-page";
    }

    /*
    * 修改跳转
    * */
    @RequestMapping("/toUpdate/{id}")
    public ModelAndView toUpdate(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView();

        //存入所有类型
        List<BillType> types = typeService.list();
        mv.addObject("types", types);

        //根据id查询所有
        Bill bill = billService.getById(id);
        mv.addObject("bill", bill);
        mv.setViewName("/bill/update");
        return mv;
    }

    /*
    * 执行修改
    * */
    @RequestMapping("/update")
    public String update(Bill bill){
        billService.updateById(bill);

        return "redirect:/bill/list-page";
    }

    /*
    * 添加跳转
    * */
    @RequestMapping("/toAdd")
    public ModelAndView toAdd(){
        ModelAndView mv = new ModelAndView();
        //查询类型
        List<BillType> types = typeService.list();

        mv.addObject("types", types);
        mv.setViewName("/bill/add");

        return mv;
    }

    /*
    * 添加
    * */
    @RequestMapping("/add")
    public String add(Bill bill){
        billService.save(bill);

        return "redirect:/bill/list-page";
    }


}
