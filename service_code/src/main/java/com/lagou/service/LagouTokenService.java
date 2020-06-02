package com.lagou.service;

import com.lagou.entity.LagouToken;
import java.util.List;

/**
 * (LagouToken)表服务接口
 *
 * @author makejava
 * @since 2020-05-26 23:03:24
 */
public interface LagouTokenService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LagouToken queryById(Integer id);

    List<LagouToken> queryAll(LagouToken lagouToken);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LagouToken> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param lagouToken 实例对象
     * @return 实例对象
     */
    LagouToken insert(LagouToken lagouToken);

    /**
     * 修改数据
     *
     * @param lagouToken 实例对象
     * @return 实例对象
     */
    LagouToken update(LagouToken lagouToken);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}