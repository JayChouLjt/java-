package com.train.service;

import com.train.common.R;
import com.train.domain.Singer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 歌手信息 服务类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
public interface ISingerService extends IService<Singer> {

    R addSinger(Singer singer);

    R deleteSinger(int id);

    R allSinger();

    R singerOfName(String name);

    R singerOfSex(int sex);

    R updateSingerMsg(Singer singer);

    R updateSingerPic(MultipartFile avatarFile, int id);
}
