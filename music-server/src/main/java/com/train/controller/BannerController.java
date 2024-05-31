package com.train.controller;


import com.train.common.R;
import com.train.domain.dto.BannerDTO;
import com.train.service.IBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 轮播图 前端控制器
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Api(tags = "轮播图相关接口")
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Resource
    private IBannerService bannerService;

    @ApiOperation("获取轮播图与")
    @GetMapping("/getAllBanner")
    public R getAllBanner() {
        List<BannerDTO> bannerList = this.bannerService.getAllBanner();
        return R.success("成功获取轮播图与", bannerList);
    }
}
