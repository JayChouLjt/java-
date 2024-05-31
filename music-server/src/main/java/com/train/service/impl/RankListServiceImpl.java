package com.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.train.common.R;
import com.train.domain.RankList;
import com.train.mapper.RankListMapper;
import com.train.service.IRankListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 评分信息 服务实现类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-25
 */
@Service
public class RankListServiceImpl extends ServiceImpl<RankListMapper, RankList> implements IRankListService {

    @Resource
    private RankListMapper rankListMapper;

    @Override
    public R addRank(RankList rankList) {
        Long count = super.lambdaQuery()
                .eq(RankList::getConsumerId, rankList.getConsumerId())
                .eq(RankList::getSongListId, rankList.getSongListId())
                .count();
        if (count > 0) {
            return R.error("请勿重复评分");
        }
        if (super.save(rankList)) {
            return R.success("评价成功");
        } else {
            return R.error("评价失败");
        }
    }

    @Override
    public R rankOfSongListId(Long songListId) {
        // 评分总人数如果为 0，则返回0；否则返回计算出的结果
        QueryWrapper<RankList> wrapper = new QueryWrapper<>();
        wrapper.eq("song_list_id", songListId);
        Long rankNum = super.baseMapper.selectCount(wrapper);
        return R.success((rankNum <= 0) ? 0 : this.rankListMapper.selectScoreSum(songListId) / rankNum);
    }

    @Override
    public R getUserRank(Long consumerId, Long songListId) {
        /*RankList rankList = super.lambdaQuery()
                .select(RankList::getScore)
                .eq(RankList::getConsumerId, consumerId)
                .eq(RankList::getSongListId, songListId)
                .one();
        if (ObjectUtil.isEmpty(rankList)) {
            return R.success(0);
        }*/
        return R.success(this.rankListMapper.selectUserRank(consumerId, songListId));
    }
}
