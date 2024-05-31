package com.train.service;

import com.train.common.R;
import com.train.domain.Collect;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 收藏信息 服务类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
public interface ICollectService extends IService<Collect> {

    R addCollection(Collect collect);

    R deleteCollect(Integer userId, Integer songId);

    R existSongId(Collect collect);

    R collectionOfUser(Integer userId);
}
