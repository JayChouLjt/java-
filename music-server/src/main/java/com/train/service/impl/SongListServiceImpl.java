package com.train.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.train.common.Constants;
import com.train.common.R;
import com.train.domain.ListSong;
import com.train.domain.SongList;
import com.train.mapper.SongListMapper;
import com.train.service.IListSongService;
import com.train.service.ISongListService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 歌单信息 服务实现类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Service
public class SongListServiceImpl extends ServiceImpl<SongListMapper, SongList> implements ISongListService {

    @Resource
    private IListSongService listSongService;

    @Override
    public R addSongList(SongList songList) {
        String pic = "/img/songListPic/default.jpg";
        songList.setPic(pic);
        if (super.save(songList)) {
            return R.success("添加成功");
        } else {
            return R.error("添加失败");
        }
    }

    @Override
    public R deleteSongList(int id) {
        Long count = this.listSongService.lambdaQuery()
                .eq(ListSong::getSongListId, id)
                .count();
        if (count > 0) {
            return R.error("歌单里还有歌曲，不能直接删除歌单");
        }
        if (super.removeById(id)) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    @Override
    public R allSongList() {
        return R.success(super.list());
    }

    @Override
    public R likeTitle(String title) {
        List<SongList> list = super.lambdaQuery()
                .like(SongList::getTitle, title)
                .list();
        return R.success(list);
    }

    @Override
    public R likeStyle(String style) {
        List<SongList> list = super.lambdaQuery()
                .like(SongList::getStyle, style)
                .list();
        return R.success(list);
    }

    @Override
    public R updateSongListMsg(SongList songList) {
        if (super.updateById(songList)) {
            return R.success("修改成功");
        } else {
            return R.error("修改失败");
        }
    }

    @Override
    public R updateSongListImg(MultipartFile avatarFile, int id) {
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = Constants.PROJECT_PATH + "/img/songListPic";
        File file = new File(filePath);
        if (!file.exists() && !file.mkdir()) {
            return R.fatal("创建文件失败");
        }
        File dist = new File(filePath + "/" + fileName);
        String imgPath = "/img/songListPic/" + fileName;
        try {
            avatarFile.transferTo(dist);
        } catch (IOException e) {
            return R.fatal("上传失败" + e.getMessage());
        }
        SongList songList = new SongList();
        songList.setId(id);
        songList.setPic(imgPath);
        if (super.updateById(songList)) {
            return R.success("上传成功", imgPath);
        } else {
            return R.error("上传失败");
        }
    }

}
