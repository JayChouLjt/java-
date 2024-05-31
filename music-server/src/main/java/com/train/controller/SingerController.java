package com.train.controller;


import com.train.common.R;
import com.train.domain.Singer;
import com.train.service.ISingerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 歌手信息 前端控制器
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Api(tags = "歌手信息相关接口")
@RestController
@RequestMapping("/singer")
public class SingerController {

    @Resource
    private ISingerService singerService;

    @ApiOperation("添加歌手")
    @PostMapping("/add")
    public R addSinger(@RequestBody Singer singer) {
        return this.singerService.addSinger(singer);
    }

    @ApiOperation("删除歌手")
    @DeleteMapping("/delete")
    public R deleteSinger(@RequestParam int id) {
        return this.singerService.deleteSinger(id);
    }

    @ApiOperation("查询歌手列表")
    @GetMapping
    public R allSinger() {
        return this.singerService.allSinger();
    }

    @ApiOperation("根据歌手名查找歌手")
    @GetMapping("/name/detail")
    public R singerOfName(@RequestParam String name) {
        return this.singerService.singerOfName(name);
    }

    @ApiOperation("根据歌手性别查找歌手")
    @GetMapping("/sex/detail")
    public R singerOfSex(@RequestParam int sex) {
        return this.singerService.singerOfSex(sex);
    }

    @ApiOperation("更新歌手信息")
    @PostMapping("/update")
    public R updateSingerMsg(@RequestBody Singer singer) {
        return this.singerService.updateSingerMsg(singer);
    }

    @ApiOperation("更新歌手头像")
    @PostMapping("/avatar/update")
    public R updateSingerPic(@RequestParam("file") MultipartFile avatarFile, @RequestParam("id") int id) {
        return this.singerService.updateSingerPic(avatarFile, id);
    }

}
