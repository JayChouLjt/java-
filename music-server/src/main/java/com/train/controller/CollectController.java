package com.train.controller;


import com.train.common.R;
import com.train.domain.Collect;
import com.train.service.ICollectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 收藏信息 前端控制器
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Api(tags = "收藏相关接口")
@RestController
@RequestMapping("/collection")
public class CollectController {

    @Resource
    private ICollectService collectService;

    @ApiOperation("添加收藏的歌曲")
    @PostMapping("/add")
    public R addCollection(@RequestBody Collect collect) {
        return this.collectService.addCollection(collect);
    }

    @ApiOperation("取消收藏的歌曲")
    @DeleteMapping("/delete")
    public R deleteCollection(@RequestParam Integer userId, @RequestParam Integer songId) {
        return this.collectService.deleteCollect(userId, songId);
    }

    @ApiOperation("是否收藏歌曲")
    @PostMapping("/status")
    public R isCollection(@RequestBody Collect collect) {
        return this.collectService.existSongId(collect);

    }

    @ApiOperation("收藏的列表")
    @GetMapping("/detail")
    public R collectionOfUser(@RequestParam Integer userId) {
        return this.collectService.collectionOfUser(userId);
    }

}
