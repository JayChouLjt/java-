package com.train.mapper;

import com.train.domain.ListSong;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 歌单、歌曲关联表 Mapper 接口
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Mapper
public interface ListSongMapper extends BaseMapper<ListSong> {

}
