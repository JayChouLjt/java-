package com.train.domain;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 评论信息
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("comment")
@ApiModel(value = "Comment对象", description = "评论信息")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "歌曲id")
    private Integer songId;

    @ApiModelProperty(value = "歌单id")
    private Integer songListId;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "评论类型")
    private Integer type;

    @ApiModelProperty(value = "评论作者")
    private Integer up;

    @ApiModelProperty(value = "评论业务类型")
    @TableField(exist = false)
    private Integer nowType;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除标志")
    private Integer isDeleted;


}
