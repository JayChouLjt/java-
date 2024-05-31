package com.train.mapper;

import com.train.domain.Song;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 歌曲信息 Mapper 接口
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Mapper
public interface SongMapper extends BaseMapper<Song> {

}
