package com.train.controller;


import com.train.common.R;
import com.train.domain.Consumer;
import com.train.service.IConsumerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Api(tags = "用户信息相关接口")
@RestController
@RequestMapping("/user")
public class ConsumerController {

    @Resource
    private IConsumerService consumerService;

    @ApiOperation("注册用户")
    @PostMapping("/add")
    public R addUser(@RequestBody Consumer consumer) {
        return this.consumerService.addUser(consumer);
    }

    @ApiOperation("登录判断")
    @PostMapping("/login/status")
    public R loginStatus(@RequestBody Consumer consumer, HttpSession session) {
        return this.consumerService.loginStatus(consumer, session);
    }

    @ApiOperation("查询所有用户")
    @GetMapping
    public R allUser() {
        return this.consumerService.allUser();
    }


    @ApiOperation("根据id查询用户")
    @GetMapping("/detail")
    public R userOfId(@RequestParam int id) {
        return this.consumerService.userOfId(id);
    }

    @ApiOperation("删除用户")
    @GetMapping("/delete")
    public R deleteUser(@RequestParam int id) {
        return this.consumerService.deleteUser(id);
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/update")
    public R updateUserMsg(@RequestBody Consumer consumer) {
        return this.consumerService.updateUser(consumer);
    }

    @ApiOperation("更新用户密码")
    @PostMapping("/updatePassword")
    public R updatePassword(@RequestBody Consumer consumer) {
        return this.consumerService.updatePassword(consumer);
    }

    @ApiOperation("更新用户头像")
    @PostMapping("/avatar/update")
    public R updateUserAvator(@RequestParam("file") MultipartFile avatarFile, @RequestParam("id") int id) {
        return this.consumerService.updateUserAvator(avatarFile, id);
    }

}
