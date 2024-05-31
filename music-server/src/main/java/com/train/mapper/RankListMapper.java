package com.train.mapper;

import com.train.domain.RankList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 评分信息 Mapper 接口
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Mapper
public interface RankListMapper extends BaseMapper<RankList> {
    /**
     * 查总分
     */
    Integer selectScoreSum(Long songListId);

    /**
     * 查制定用户评分
     */
    Integer selectUserRank(@Param("consumer_id") Long consumerId, @Param("song_list_id") Long songListId);
}
