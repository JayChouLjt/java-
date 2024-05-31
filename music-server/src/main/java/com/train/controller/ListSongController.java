package com.train.controller;


import com.train.common.R;
import com.train.domain.ListSong;
import com.train.service.IListSongService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 歌单、歌曲关联表 前端控制器
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Api(tags = "歌单、歌曲关联相关接口")
@RestController
@RequestMapping("/listSong")
public class ListSongController {

    @Resource
    private IListSongService listSongService;

    @ApiOperation("歌单添加歌曲")
    @PostMapping("/add")
    public R addListSong(@RequestBody ListSong listSong) {
        return this.listSongService.addListSong(listSong);
    }

    @ApiOperation("删除歌单里的歌曲")
    @GetMapping("/delete")
    public R deleteListSong(@RequestParam int songId) {
        return this.listSongService.deleteListSong(songId);
    }

    @ApiOperation("根据歌单id查询对应的歌曲")
    @GetMapping("/detail")
    public R listSongOfSongId(@RequestParam int songListId) {
        return this.listSongService.listSongOfSongId(songListId);
    }

    @ApiOperation("更新歌单的歌曲信息")
    @PostMapping("/update")
    public R updateListSongMsg(@RequestBody ListSong listSong) {
        return this.listSongService.updateListSongMsg(listSong);
    }

}
