package com.train.controller;


import com.train.common.R;
import com.train.domain.SongList;
import com.train.service.ISongListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 歌单信息 前端控制器
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Api(tags = "歌单信息相关接口")
@RestController
@RequestMapping("/songList")
public class SongListController {

    @Resource
    private ISongListService songListService;

    @ApiOperation("添加歌单")
    @PostMapping("/add")
    public R addSongList(@RequestBody SongList songList) {
        return this.songListService.addSongList(songList);
    }

    @ApiOperation("删除歌单")
    @GetMapping("/delete")
    public R deleteSongList(@RequestParam int id) {
        return this.songListService.deleteSongList(id);
    }

    @ApiOperation("查询歌单列表")
    @GetMapping
    public R allSongList() {
        return this.songListService.allSongList();
    }

    @ApiOperation("查询标题包含文字的歌单")
    @GetMapping("/likeTitle/detail")
    public R songListOfLikeTitle(@RequestParam String title) {
        return this.songListService.likeTitle('%' + title + '%');
    }

    @ApiOperation("查询指定类型的歌单")
    @GetMapping("/style/detail")
    public R songListOfStyle(@RequestParam String style) {
        return this.songListService.likeStyle('%' + style + '%');
    }

    @ApiOperation("更新歌单信息")
    @PostMapping("/update")
    public R updateSongListMsg(@RequestBody SongList songList) {
        return this.songListService.updateSongListMsg(songList);

    }

    @ApiOperation("更新歌单图片")
    @PostMapping("/img/update")
    public R updateSongListPic(@RequestParam("file") MultipartFile avatarFile, @RequestParam("id") int id) {
        return this.songListService.updateSongListImg(avatarFile, id);
    }

}
