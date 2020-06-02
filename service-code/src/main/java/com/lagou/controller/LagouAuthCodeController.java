package com.lagou.controller;

import com.lagou.entity.LagouAuthCode;
import com.lagou.service.LagouAuthCodeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (LagouAuthCode)表控制层
 *
 * @author makejava
 * @since 2020-05-26 23:04:46
 */
@RestController
@RequestMapping("lagouAuthCode")
public class LagouAuthCodeController {
    /**
     * 服务对象
     */
    @Resource
    private LagouAuthCodeService lagouAuthCodeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public LagouAuthCode selectOne(Integer id) {
        return this.lagouAuthCodeService.queryById(id);
    }

}