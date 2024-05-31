package com.train.controller;


import com.train.common.R;
import com.train.domain.RankList;
import com.train.service.IRankListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 评分信息 前端控制器
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Api(tags = "评分信息相关接口")
@RestController
@RequestMapping("/rankList")
public class RankListController {

    @Resource
    private IRankListService rankListService;

    @ApiOperation("提交评分")
    @PostMapping("/add")
    public R addRank(@RequestBody RankList rankList) {
        return this.rankListService.addRank(rankList);
    }

    @ApiOperation("获取指定歌单的评分")
    @GetMapping
    public R rankOfSongListId(@RequestParam Long songListId) {
        return this.rankListService.rankOfSongListId(songListId);
    }

    @ApiOperation("获取指定用户的歌单评分")
    @GetMapping("/user")
    public R getUserRank(@RequestParam Long consumerId, @RequestParam Long songListId) {
        return this.rankListService.getUserRank(consumerId, songListId);
    }

}
