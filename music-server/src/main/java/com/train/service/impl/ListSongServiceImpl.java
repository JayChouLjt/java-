package com.train.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.train.common.R;
import com.train.domain.ListSong;
import com.train.mapper.ListSongMapper;
import com.train.service.IListSongService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 歌单、歌曲关联表 服务实现类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Service
public class ListSongServiceImpl extends ServiceImpl<ListSongMapper, ListSong> implements IListSongService {

    @Override
    public R addListSong(ListSong listSong) {
        if (super.save(listSong)) {
            return R.success("添加成功");
        } else {
            return R.error("添加失败");
        }
    }

    @Override
    public R deleteListSong(int songId) {
        boolean b = super.lambdaUpdate()
                .eq(ListSong::getSongId, songId)
                .remove();
        if (b) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    @Override
    public R listSongOfSongId(int songListId) {
        List<ListSong> list = super.lambdaQuery()
                .eq(ListSong::getSongListId, songListId)
                .list();
        return R.success(list);
    }

    @Override
    public R updateListSongMsg(ListSong listSong) {
        if (super.updateById(listSong)) {
            return R.success("修改成功");
        } else {
            return R.error("修改失败");
        }
    }

}
