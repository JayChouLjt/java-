package com.train.service;

import com.train.domain.Banner;
import com.baomidou.mybatisplus.extension.service.IService;
import com.train.domain.dto.BannerDTO;

import java.util.List;

/**
 * <p>
 * 轮播图 服务类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
public interface IBannerService extends IService<Banner> {

    List<BannerDTO> getAllBanner();
}
