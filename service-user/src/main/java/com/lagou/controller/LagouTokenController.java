package com.lagou.controller;

import com.lagou.entity.LagouToken;
import com.lagou.service.LagouTokenService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (LagouToken)表控制层
 *
 * @author makejava
 * @since 2020-05-26 23:15:14
 */
@RestController
@RequestMapping("lagouToken")
public class LagouTokenController {
    /**
     * 服务对象
     */
    @Resource
    private LagouTokenService lagouTokenService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public LagouToken selectOne(Integer id) {
        return this.lagouTokenService.queryById(id);
    }

}