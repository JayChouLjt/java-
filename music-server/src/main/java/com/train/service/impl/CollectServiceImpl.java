package com.train.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.train.common.R;
import com.train.domain.Collect;
import com.train.mapper.CollectMapper;
import com.train.service.ICollectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 收藏信息 服务实现类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService {

    @Override
    public R addCollection(Collect collect) {
        if (super.save(collect)) {
            return R.success("收藏成功", true);
        } else {
            return R.error("收藏失败");
        }
    }

    @Override
    public R deleteCollect(Integer userId, Integer songId) {
        if (userId == null || songId == null) {
            return R.error("用户id和歌曲id不能为空");
        }
        LambdaUpdateWrapper<Collect> wrapper = Wrappers.<Collect>lambdaUpdate()
                .eq(Collect::getUserId, userId)
                .eq(Collect::getSongId, songId);
        if (super.remove(wrapper)) {
            return R.success("取消收藏", false);
        } else {
            return R.error("取消收藏失败");
        }
    }

    @Override
    public R existSongId(Collect collect) {
        Long count = super.lambdaQuery()
                .eq(Collect::getUserId, collect.getUserId())
                .eq(Collect::getSongId, collect.getSongId())
                .count();
        if (count > 0) {
            return R.success("已收藏", true);
        } else {
            return R.success("未收藏", false);
        }
    }

    @Override
    public R collectionOfUser(Integer userId) {
        List<Collect> list = super.lambdaQuery()
                .eq(Collect::getUserId, userId)
                .list();
        return R.success("用户收藏", list);
    }

}
