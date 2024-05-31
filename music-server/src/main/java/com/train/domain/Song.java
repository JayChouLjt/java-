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
 * 歌曲信息
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("song")
@ApiModel(value="Song对象", description="歌曲信息")
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "歌手id")
    private Integer singerId;

    @ApiModelProperty(value = "歌曲名")
    private String name;

    @ApiModelProperty(value = "简介")
    private String introduction;

    @ApiModelProperty(value = "图片路径")
    private String pic;

    @ApiModelProperty(value = "歌词")
    private String lyric;

    @ApiModelProperty(value = "歌曲路径")
    private String url;

    @ApiModelProperty(value = "发行时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "逻辑删除标志")
    private Integer isDeleted;


}
