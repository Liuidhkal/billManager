package com.lfz.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.lfz.demo.entity.Bill;

import java.util.List;

public interface BillService extends IService<Bill> {
    public PageInfo<Bill> findAllPage(Integer pageNum, Integer size, Bill b);
}
