package com.lagou.service.impl;

import com.lagou.entity.LagouAuthCode;
import com.lagou.entity.LagouToken;
import com.lagou.entity.LagouUser;
import com.lagou.dao.LagouUserDao;
import com.lagou.service.LagouUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LagouUser)表服务实现类
 *
 * @author makejava
 * @since 2020-05-26 22:47:13
 */
@Service("lagouUserService")
public class LagouUserServiceImpl implements LagouUserService {
    @Resource
    private LagouUserDao lagouUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public LagouUser queryById(Long id) {
        return this.lagouUserDao.queryById(id);
    }


    @Override
    public List<LagouUser> queryAll(LagouUser lagouUser){
        return this.lagouUserDao.queryAll(lagouUser);
    }
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<LagouUser> queryAllByLimit(int offset, int limit) {
        return this.lagouUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param lagouUser 实例对象
     * @return 实例对象
     */
    @Override
    public LagouUser insert(LagouUser lagouUser) {
        this.lagouUserDao.insert(lagouUser);
        return lagouUser;
    }

    /**
     * 修改数据
     *
     * @param lagouUser 实例对象
     * @return 实例对象
     */
    @Override
    public LagouUser update(LagouUser lagouUser) {
        this.lagouUserDao.update(lagouUser);
        return this.queryById(lagouUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.lagouUserDao.deleteById(id) > 0;
    }
}