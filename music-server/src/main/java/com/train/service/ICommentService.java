package com.train.service;

import com.train.common.R;
import com.train.domain.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 评论信息 服务类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
public interface ICommentService extends IService<Comment> {

    R addComment(Comment comment);

    R deleteComment(Integer id);

    R commentOfSongId(Integer songId);

    R commentOfSongListId(Integer songListId);

    R updateCommentMsg(Comment comment);
}
