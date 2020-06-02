package com.lagou.service.impl;

import com.lagou.entity.LagouToken;
import com.lagou.dao.LagouTokenDao;
import com.lagou.service.LagouTokenService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LagouToken)表服务实现类
 *
 * @author makejava
 * @since 2020-05-26 23:15:13
 */
@Service("lagouTokenService")
public class LagouTokenServiceImpl implements LagouTokenService {
    @Resource
    private LagouTokenDao lagouTokenDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public LagouToken queryById(Integer id) {
        return this.lagouTokenDao.queryById(id);
    }



    @Override
    public List<LagouToken> queryAll(LagouToken lagouToken) {
        return this.lagouTokenDao.queryAll(lagouToken);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<LagouToken> queryAllByLimit(int offset, int limit) {
        return this.lagouTokenDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param lagouToken 实例对象
     * @return 实例对象
     */
    @Override
    public LagouToken insert(LagouToken lagouToken) {
        this.lagouTokenDao.insert(lagouToken);
        return lagouToken;
    }

    /**
     * 修改数据
     *
     * @param lagouToken 实例对象
     * @return 实例对象
     */
    @Override
    public LagouToken update(LagouToken lagouToken) {
        this.lagouTokenDao.update(lagouToken);
        return this.queryById(lagouToken.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.lagouTokenDao.deleteById(id) > 0;
    }
}