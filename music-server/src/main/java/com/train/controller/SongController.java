package com.train.controller;

import com.train.common.R;
import com.train.domain.Song;
import com.train.service.ISongService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 歌曲信息 前端控制器
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Api(tags = "歌曲信息相关接口")
@RestController
@RequestMapping("/song")
public class SongController {

    @Resource
    private ISongService songService;

    @ApiOperation("添加歌曲")
    @PostMapping("/add")
    public R addSong(@RequestBody Song song, @RequestParam("file") MultipartFile mpfile) {
        return this.songService.addSong(song, mpfile);
    }

    @ApiOperation("删除歌曲")
    @DeleteMapping("/delete")
    public R deleteSong(@RequestParam int id) {
        return this.songService.deleteSong(id);
    }

    @ApiOperation("查询歌曲列表")
    @GetMapping
    public R allSong() {
        return this.songService.allSong();
    }

    @ApiOperation("根据id查询歌曲")
    @GetMapping("/detail")
    public R songOfId(@RequestParam int id) {
        return this.songService.songOfId(id);
    }

    @ApiOperation("根据歌手id查询歌曲")
    @GetMapping("/singer/detail")
    public R songOfSingerId(@RequestParam int singerId) {
        return this.songService.songOfSingerId(singerId);
    }

    @ApiOperation("根据歌手名查询歌曲")
    @GetMapping("/singerName/detail")
    public R songOfSingerName(@RequestParam String name) {
        return this.songService.songOfSingerName('%' + name + '%');
    }

    @ApiOperation("更新歌曲信息")
    @PostMapping("/update")
    public R updateSongMsg(@RequestBody Song song) {
        return this.songService.updateSongMsg(song);
    }

    @ApiOperation("更新歌曲图片")
    @PostMapping("/img/update")
    public R updateSongPic(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        return this.songService.updateSongPic(urlFile, id);
    }

    @ApiOperation("更新歌曲")
    @PostMapping("/url/update")
    public R updateSongUrl(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id) {
        return this.songService.updateSongUrl(urlFile, id);
    }

}
