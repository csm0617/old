package com.csm.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 快乐小柴
 * @Date 2022/10/14 18:25
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQuery {
    //当前的页码
    private Integer pageNumber = 1;
    //每页所显示的数量
    private Integer pageSize=2;
    private String name;
}
