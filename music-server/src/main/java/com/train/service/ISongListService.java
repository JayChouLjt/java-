package com.train.service;

import com.train.common.R;
import com.train.domain.SongList;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 歌单信息 服务类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
public interface ISongListService extends IService<SongList> {

    R addSongList(SongList songList);

    R deleteSongList(int id);

    R allSongList();

    R likeTitle(String title);

    R likeStyle(String style);

    R updateSongListMsg(SongList songList);

    R updateSongListImg(MultipartFile avatarFile, int id);
}
