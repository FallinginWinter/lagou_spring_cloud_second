package com.lagou.service.impl;

import com.lagou.entity.LagouAuthCode;
import com.lagou.dao.LagouAuthCodeDao;
import com.lagou.service.LagouAuthCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LagouAuthCode)表服务实现类
 *
 * @author makejava
 * @since 2020-05-26 23:04:46
 */
@Service("lagouAuthCodeService")
public class LagouAuthCodeServiceImpl implements LagouAuthCodeService {
    @Resource
    private LagouAuthCodeDao lagouAuthCodeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public LagouAuthCode queryById(Integer id) {
        return this.lagouAuthCodeDao.queryById(id);
    }

    @Override
    public List<LagouAuthCode> queryAll(LagouAuthCode lagouAuthCode) {
        return this.lagouAuthCodeDao.queryAll(lagouAuthCode);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<LagouAuthCode> queryAllByLimit(int offset, int limit) {
        return this.lagouAuthCodeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param lagouAuthCode 实例对象
     * @return 实例对象
     */
    @Override
    public LagouAuthCode insert(LagouAuthCode lagouAuthCode) {
        this.lagouAuthCodeDao.insert(lagouAuthCode);
        return lagouAuthCode;
    }

    /**
     * 修改数据
     *
     * @param lagouAuthCode 实例对象
     * @return 实例对象
     */
    @Override
    public LagouAuthCode update(LagouAuthCode lagouAuthCode) {
        this.lagouAuthCodeDao.update(lagouAuthCode);
        return this.queryById(lagouAuthCode.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.lagouAuthCodeDao.deleteById(id) > 0;
    }
}