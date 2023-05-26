package com.gxy.mapper;


import com.gxy.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /*查询所有*/
    public List<Brand> selectAll();

    /*
    * 条件查询，参数接受
    * 1. 散装参数
    * 2. 对象参数
    * 3. map集合的参数
    * */
    List<Brand> selectByCondition(@Param("status")int status, @Param("companyName")String companyName,
                                  @Param("brandName")String brandName);
    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    // 单条件动态查询
    List<Brand> selectByConditionSingle(Brand brand);

    // 添加
    void add(Brand brand);

    // 修改全部字段
    int update(Brand brand);

    void deleteById(int id);

    void deleteByIds(@Param("ids") int[] ids);
}
