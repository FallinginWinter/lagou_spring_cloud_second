package com.lagou.service;

import com.lagou.entity.LagouAuthCode;
import java.util.List;

/**
 * (LagouAuthCode)表服务接口
 *
 * @author makejava
 * @since 2020-05-26 23:04:46
 */
public interface LagouAuthCodeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LagouAuthCode queryById(Integer id);

    List<LagouAuthCode> queryAll(LagouAuthCode lagouAuthCode);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LagouAuthCode> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param lagouAuthCode 实例对象
     * @return 实例对象
     */
    LagouAuthCode insert(LagouAuthCode lagouAuthCode);

    /**
     * 修改数据
     *
     * @param lagouAuthCode 实例对象
     * @return 实例对象
     */
    LagouAuthCode update(LagouAuthCode lagouAuthCode);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}