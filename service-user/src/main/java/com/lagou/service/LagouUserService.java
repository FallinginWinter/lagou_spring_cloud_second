package com.lagou.service;

import com.lagou.entity.LagouUser;
import java.util.List;

/**
 * (LagouUser)表服务接口
 *
 * @author makejava
 * @since 2020-05-26 22:47:13
 */
public interface LagouUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LagouUser queryById(Long id);

    List<LagouUser> queryAll(LagouUser lagouUser);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LagouUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param lagouUser 实例对象
     * @return 实例对象
     */
    LagouUser insert(LagouUser lagouUser);

    /**
     * 修改数据
     *
     * @param lagouUser 实例对象
     * @return 实例对象
     */
    LagouUser update(LagouUser lagouUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}