package com.lagou.dao;

import com.lagou.entity.LagouAuthCode;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (LagouAuthCode)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-26 23:04:46
 */
public interface LagouAuthCodeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LagouAuthCode queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LagouAuthCode> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param lagouAuthCode 实例对象
     * @return 对象列表
     */
    List<LagouAuthCode> queryAll(LagouAuthCode lagouAuthCode);

    /**
     * 新增数据
     *
     * @param lagouAuthCode 实例对象
     * @return 影响行数
     */
    int insert(LagouAuthCode lagouAuthCode);

    /**
     * 修改数据
     *
     * @param lagouAuthCode 实例对象
     * @return 影响行数
     */
    int update(LagouAuthCode lagouAuthCode);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}