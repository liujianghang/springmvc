package org.example.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mapper.BrandMapper;
import org.example.pojo.Brand;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {

    @Test
    public void testSelectAll() throws IOException {
        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        List<Brand> brands = brandMapper.selectALl();
        System.out.println(brands);
        // 5. 资源释放
        sqlSession.close();
    }

    @Test
    public void testById() throws IOException {
        int id = 1;
        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);
        // 5. 资源释放
        sqlSession.close();
    }

    @Test
    public void testSelectByCondition() throws IOException {
        // 接收参数(方法1)
        int status = 1;
        String companyName = "z";
        String brandName = "1";
        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        // 封装对象(方法2)
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        // map集合(方法3)
        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        // 方法一： List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        // 方法二： List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);
        // 5. 资源释放
        sqlSession.close();
    }

    @Test
    public void testAdd() throws IOException {
        // 接收参数(方法1)
        int status = 1;
        String companyName = "zz";
        String brandName = "1";
        String description = "手机";
        int ordered = 100;

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        // 封装对象(方法2)
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        // map集合(方法3)
        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2. 获取SqlSession对象(手动提交事务/自动提交事务)
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        // 方法一： List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        brandMapper.add(brand);
        // 提交事务
        sqlSession.commit();
//        List<Brand> brands = brandMapper.selectByCondition(map);
//        System.out.println(brands);
        // 5. 资源释放
        sqlSession.close();
    }

    @Test
    public void testAdd2() throws IOException {
        // 接收参数(方法1)
        int status = 1;
        String companyName = "zz";
        String brandName = "1";
        String description = "手机";
        int ordered = 100;

        // 处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";
        // 封装对象(方法2)
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        // map集合(方法3)
        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2. 获取SqlSession对象(手动提交事务/自动提交事务)
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        // 方法一： List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        brandMapper.add(brand);
        // 提交事务
//        sqlSession.commit();
//        List<Brand> brands = brandMapper.selectByCondition(map);
//        System.out.println(brands);
        int id = brand.getId();
        System.out.println(id);
        // 5. 资源释放
        sqlSession.close();
    }

    @Test
    public void testUpdate() throws IOException {
        // 接收参数(方法1)
        int status = 0;
        String companyName = "zzzz";
        String brandName = "2";
        String description = "diannao";
        int ordered = 12;
        int id = 5;

        // 封装对象(方法2)
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);
        // map集合(方法3)
        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2. 获取SqlSession对象(手动提交事务/自动提交事务)
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        // 方法一： List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);

        // 提交事务
//        sqlSession.commit();
//        List<Brand> brands = brandMapper.selectByCondition(map);
//        System.out.println(brands);
        int count = brandMapper.updata(brand);
        System.out.println(count);
        // 5. 资源释放
        sqlSession.close();
    }
    @Test
    public void testDeleteById() throws IOException {
        // 接收参数(方法1)
        int id = 5;

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2. 获取SqlSession对象(手动提交事务/自动提交事务)
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        // 方法一： List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);;
        brandMapper.deleteById(id);
        // 5. 资源释放
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        // 接收参数(方法1)
        int[] ids = {1,2,3};

        // 1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2. 获取SqlSession对象(手动提交事务/自动提交事务)
        // SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        // 4. 执行方法
        // 方法一： List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);;
        brandMapper.deleteByIds(ids);
        // 5. 资源释放
        sqlSession.close();
    }
}
