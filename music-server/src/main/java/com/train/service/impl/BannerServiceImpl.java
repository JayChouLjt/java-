package com.train.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.train.domain.Banner;
import com.train.domain.dto.BannerDTO;
import com.train.mapper.BannerMapper;
import com.train.service.IBannerService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 轮播图 服务实现类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {

    @Cacheable(value = "banner", key = "'list'")
    @Override
    public List<BannerDTO> getAllBanner() {
        List<Banner> list = super.list();
        return list.stream()
                .map(n -> BeanUtil.copyProperties(n, BannerDTO.class))
                .collect(Collectors.toList());
    }
}
