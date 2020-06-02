package com.lagou.dao;

import com.lagou.entity.LagouUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (LagouUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-26 22:47:13
 */
public interface LagouUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LagouUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LagouUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param lagouUser 实例对象
     * @return 对象列表
     */
    List<LagouUser> queryAll(LagouUser lagouUser);

    /**
     * 新增数据
     *
     * @param lagouUser 实例对象
     * @return 影响行数
     */
    int insert(LagouUser lagouUser);

    /**
     * 修改数据
     *
     * @param lagouUser 实例对象
     * @return 影响行数
     */
    int update(LagouUser lagouUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}