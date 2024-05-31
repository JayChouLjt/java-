package com.train.controller;


import com.train.common.R;
import com.train.domain.Admin;
import com.train.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 管理员信息 前端控制器
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Api(tags = "管理员相关接口")
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private IAdminService adminService;

    @ApiOperation("新增管理员")
    @PostMapping
    public R saveAdmin(@RequestBody Admin admin) {
        return this.adminService.saveAdmin(admin);
    }

    @ApiOperation("批量删除管理员")
    @DeleteMapping
    public R delete(@RequestParam List<Integer> ids) {
        return this.adminService.delete(ids);
    }

    @ApiOperation("修改管理员")
    @PutMapping
    public R update(@RequestBody Admin admin) {
        return this.adminService.update(admin);
    }

    @ApiOperation("查询管理员")
    @GetMapping
    public R select(@RequestParam(required = false) Integer id,
                    @RequestParam(required = false) String name) {
        return this.adminService.select(id, name);
    }

    @ApiOperation("判断是否登录成功")
    @PostMapping("/login/status")
    public R loginStatus(@RequestBody Admin admin, HttpSession session) {
        return this.adminService.verityPasswd(admin, session);
    }

}
