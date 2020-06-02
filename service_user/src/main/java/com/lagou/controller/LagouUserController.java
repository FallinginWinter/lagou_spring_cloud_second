package com.lagou.controller;

import com.lagou.entity.LagouUser;
import com.lagou.service.LagouUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (LagouUser)表控制层
 *
 * @author makejava
 * @since 2020-05-26 22:47:13
 */
@RestController
@RequestMapping("lagouUser")
public class LagouUserController {
    /**
     * 服务对象
     */
    @Resource
    private LagouUserService lagouUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public LagouUser selectOne(Long id) {
        return this.lagouUserService.queryById(id);
    }

}