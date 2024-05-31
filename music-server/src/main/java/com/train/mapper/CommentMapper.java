package com.train.mapper;

import com.train.domain.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 评论信息 Mapper 接口
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
