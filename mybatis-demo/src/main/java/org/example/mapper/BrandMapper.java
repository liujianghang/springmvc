package org.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     * 查询所有
     */
    List<Brand> selectALl();

    /**
     * 查看详情
     */
    Brand selectById(int id);

    /**
     * 条件查询
     * 1. 散装参数(@param标注参数给哪个占位符)
     * 2. 对象参数
     * 3. map集合参数
     */
//    List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandNAme);
//    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);
    /**
     * 单条件查询
     */
    List<Brand> selectByConditionSingle(Brand brand);
    /**
     * 添加
     */
    void add(Brand brand);
    /**
     * 更新
     */
    int updata(Brand brand);
    /**
     * 根据id删除
     */
    void deleteById(int id);
    /**
     * 批量删除
     * 注意：Mybatis接口方法中可以接受各种各样的参数，Mybatis底层对这些参数进行不同的封装处理方式
     * 单个参数
     * 1.POJO类型：直接使用。属性名 和 参数占位符名称一致。
     * 2.Map集合：直接使用。 键名 和 参数占位符名称一致。
     * 3.Collection：封装为map集合，可以使用@Param参数，替换Map集合中默认的arg键名
     * 4.List：封装为map集合，可以使用@Param参数，替换Map集合中默认的arg键名
     * 5.Array：封装为map集合，可以使用@Param参数，替换Map集合中默认的arg键名
     * 6.其他类型：直接使用
     * 多个参数：封装为map集合,可以使用@Param注解，替换Map集合中默认的arg键名
     * map.put("arg0",参数值1)
     * map.put("param1",参数值1)
     * map.put("param2",参数值2)
     * map.put("arg1",参数值2)
     */
    void deleteByIds(@Param("ids") int[] ids);
}
