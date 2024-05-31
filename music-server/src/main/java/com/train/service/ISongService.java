package com.train.service;

import com.train.common.R;
import com.train.domain.Song;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 歌曲信息 服务类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
public interface ISongService extends IService<Song> {

    R addSong(Song song, MultipartFile mpfile);

    R deleteSong(int id);

    R allSong();

    R songOfId(int id);

    R songOfSingerId(int singerId);

    R songOfSingerName(String name);

    R updateSongMsg(Song song);

    R updateSongPic(MultipartFile urlFile, int id);

    R updateSongUrl(MultipartFile urlFile, int id);

}
