package com.train.controller;


import com.train.common.R;
import com.train.domain.Comment;
import com.train.service.ICommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 评论信息 前端控制器
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Api(tags = "评论信息相关接口")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Resource
    private ICommentService commentService;

    @ApiOperation("提交评论")
    @PostMapping("/add")
    public R addComment(@RequestBody Comment comment) {
        return this.commentService.addComment(comment);
    }

    @ApiOperation("删除评论")
    @GetMapping("/delete")
    public R deleteComment(@RequestParam Integer id) {
        return this.commentService.deleteComment(id);
    }

    @ApiOperation("根据歌曲id获取评论列表")
    @GetMapping("/song/detail")
    public R commentOfSongId(@RequestParam Integer songId) {
        return this.commentService.commentOfSongId(songId);
    }

    @ApiOperation("根据歌单id获取评论列表")
    @GetMapping("/songList/detail")
    public R commentOfSongListId(@RequestParam Integer songListId) {
        return this.commentService.commentOfSongListId(songListId);
    }

    @ApiOperation("点赞")
    @PostMapping("/like")
    public R commentOfLike(@RequestBody Comment comment) {
        return this.commentService.updateCommentMsg(comment);
    }

}
