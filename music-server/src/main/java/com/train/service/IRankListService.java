package com.train.service;

import com.train.common.R;
import com.train.domain.RankList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 评分信息 服务类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
public interface IRankListService extends IService<RankList> {

    R addRank(RankList rankList);

    R rankOfSongListId(Long songListId);

    R getUserRank(Long consumerId, Long songListId);
}
