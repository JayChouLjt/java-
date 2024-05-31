package com.train.service;

import com.train.common.R;
import com.train.domain.ListSong;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 歌单、歌曲关联表 服务类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
public interface IListSongService extends IService<ListSong> {

    R addListSong(ListSong listSong);

    R deleteListSong(int songId);

    R listSongOfSongId(int songListId);

    R updateListSongMsg(ListSong listSong);
}
