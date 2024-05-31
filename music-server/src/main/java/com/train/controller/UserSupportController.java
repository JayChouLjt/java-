package com.train.controller;


import com.train.common.R;
import com.train.domain.UserSupport;
import com.train.service.IUserSupportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  用户支持操作 前端控制器
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Api(tags = "用户支持相关接口")
@RestController
@RequestMapping("/userSupport")
public class UserSupportController {

    @Resource
    IUserSupportService userSupportService;

    @ApiOperation("test")
    @PostMapping("/test")
    public R isUserSupportComment(@RequestBody UserSupport userSupport) {
        return this.userSupportService.isUserSupportComment(userSupport);
    }

    @ApiOperation("添加评论")
    @PostMapping("/insert")
    public R insertCommentSupport(@RequestBody UserSupport userSupport) {
        return this.userSupportService.insertCommentSupport(userSupport);
    }

    @ApiOperation("删除评论")
    @PostMapping("/delete")
    public R deleteCommentSupport(@RequestBody UserSupport userSupport) {
        return this.userSupportService.deleteCommentSupport(userSupport);
    }

}
