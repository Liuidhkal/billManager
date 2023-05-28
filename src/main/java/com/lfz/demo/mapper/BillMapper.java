package com.lfz.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lfz.demo.entity.Bill;

import java.util.List;

public interface BillMapper extends BaseMapper<Bill> {
    public List<Bill> select(Bill b);
}
