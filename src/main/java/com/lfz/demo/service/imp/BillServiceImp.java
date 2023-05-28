package com.lfz.demo.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfz.demo.entity.Bill;
import com.lfz.demo.mapper.BillMapper;
import com.lfz.demo.service.BillService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BillServiceImp extends ServiceImpl<BillMapper, Bill> implements BillService {
    @Resource
    private BillMapper billMapper;

    @Override
    public PageInfo<Bill> findAllPage(Integer pageNum, Integer size, Bill b) {

        PageHelper.startPage(pageNum, size);
        List<Bill> list = billMapper.select(b);

        PageInfo<Bill> pageInfo = new PageInfo<>(list);

        return pageInfo;
    }
}
