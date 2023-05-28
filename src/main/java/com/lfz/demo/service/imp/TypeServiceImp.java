package com.lfz.demo.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lfz.demo.entity.BillType;
import com.lfz.demo.mapper.TypeMapper;
import com.lfz.demo.service.TypeService;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImp extends ServiceImpl<TypeMapper, BillType> implements TypeService {

}
