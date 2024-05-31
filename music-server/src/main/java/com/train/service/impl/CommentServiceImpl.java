package com.train.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.train.common.R;
import com.train.domain.Comment;
import com.train.mapper.CommentMapper;
import com.train.service.ICommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 评论信息 服务实现类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Override
    public R addComment(Comment comment) {
        comment.setType(comment.getNowType());
        if (super.save(comment)) {
            return R.success("评论成功");
        } else {
            return R.error("评论失败");
        }
    }

    @Override
    public R deleteComment(Integer id) {
        if (super.removeById(id)) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    @Override
    public R commentOfSongId(Integer songId) {
        List<Comment> list = super.lambdaQuery()
                .eq(Comment::getSongId, songId)
                .list();
        return R.success( list);
    }

    @Override
    public R commentOfSongListId(Integer songListId) {
        List<Comment> list = super.lambdaQuery()
                .eq(Comment::getSongListId, songListId)
                .list();
        return R.success( list);
    }

    @Override
    public R updateCommentMsg(Comment comment) {
        if (super.updateById(comment)) {
            return R.success("点赞成功");
        } else {
            return R.error("点赞失败");
        }
    }
}
