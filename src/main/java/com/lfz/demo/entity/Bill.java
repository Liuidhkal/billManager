package com.lfz.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("bill_")
public class Bill {
    @TableId(value = "id_", type = IdType.AUTO)
    private Long id;
    @TableField("title_")
    private String title;//名称
    @TableField("bill_time_")
    private Date billTime;//日期
    @TableField("type_id_")
    private Long typeId;//类型表id
    @TableField("price_")
    private Double price;//价格
    @TableField("explain_")
    private String explain;//备注

    //类别名称
    @TableField(exist = false)
    private String typeName;

    //开始日期
    @TableField(exist = false)
    private Date date1;

    //结束日期
    @TableField(exist = false)
    private Date date2;
}
