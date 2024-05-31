package com.train.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.train.common.Constants;
import com.train.common.R;
import com.train.domain.Song;
import com.train.mapper.SongMapper;
import com.train.service.ISongService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 歌曲信息 服务实现类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements ISongService {

    @Override
    public R addSong(Song song, MultipartFile mpfile) {
        String pic = "/img/songPic/default.jpg";
        String fileName = mpfile.getOriginalFilename();
        String filePath = Constants.PROJECT_PATH + "/img/song";
        File file = new File(filePath);
        if (!file.exists() && !file.mkdir()) {
            return R.fatal("创建文件失败");
        }
        File dist = new File(filePath + "/" + fileName);
        String storeUrlPath = "/song/" + fileName;
        try {
            mpfile.transferTo(dist);
        } catch (IOException e) {
            return R.fatal("上传失败" + e.getMessage());
        }
        song.setPic(pic);
        song.setUrl(storeUrlPath);
        if (super.save(song)) {
            return R.success("上传成功", storeUrlPath);
        } else {
            return R.error("上传失败");
        }
    }

    @Override
    public R deleteSong(int id) {
        if (super.removeById(id)) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    @Override
    public R allSong() {
        return R.success(super.list());
    }

    @Override
    public R songOfId(int id) {
        List<Song> list = super.lambdaQuery()
                .eq(Song::getId, id)
                .list();
        return R.success(list);
    }

    @Override
    public R songOfSingerId(int singerId) {
        List<Song> list = super.lambdaQuery()
                .eq(Song::getSingerId, singerId)
                .list();
        return R.success(list);
    }


    @Override
    public R songOfSingerName(String name) {
        List<Song> list = super.lambdaQuery()
                .like(Song::getName, name)
                .list();
        return R.success(list);
    }

    @Override
    public R updateSongMsg(Song song) {
        if (super.updateById(song)) {
            return R.success("修改成功");
        } else {
            return R.error("修改失败");
        }
    }

    @Override
    public R updateSongPic(MultipartFile urlFile, int id) { //先删除，再修改
        String fileName = System.currentTimeMillis() + urlFile.getOriginalFilename();
        String filePath = Constants.PROJECT_PATH + "/img/songPic";
        File file = new File(filePath);
        if (!file.exists() && !file.mkdir()) {
            return R.fatal("创建文件失败");
        }
        Song songInfo = super.lambdaQuery().eq(Song::getId, id).one();
        File oldFile = new File(Constants.PROJECT_PATH, songInfo.getPic());
        if (oldFile.exists()) {
            try {
                oldFile.delete();
            } catch (Exception e) {
                return R.fatal("删除失败" + e.getMessage());
            }
        }
        File dist = new File(filePath + "/" + fileName);
        String storeUrlPath = "/img/songPic/" + fileName;
        try {
            urlFile.transferTo(dist);
        } catch (IOException e) {
            return R.fatal("上传失败" + e.getMessage());
        }
        Song song = new Song();
        song.setId(id);
        song.setPic(storeUrlPath);
        if (super.save(song)) {
            return R.success("上传成功", storeUrlPath);
        } else {
            return R.error("上传失败");
        }
    }

    @Override
    public R updateSongUrl(MultipartFile urlFile, int id) {
        String fileName = urlFile.getOriginalFilename();
        String filePath = Constants.PROJECT_PATH + "/img/song";
        File file = new File(filePath);
        if (!file.exists() && !file.mkdir()) {
            return R.fatal("创建文件失败");
        }
        File dist = new File(filePath + "/" + fileName);
        String storeUrlPath = "/song/" + fileName;
        try {
            urlFile.transferTo(dist);
        } catch (IOException e) {
            return R.fatal("上传失败" + e.getMessage());
        }
        Song song = new Song();
        song.setId(id);
        song.setUrl(storeUrlPath);
        if (super.save(song)) {
            return R.success("更新成功", storeUrlPath);
        } else {
            return R.error("更新失败");
        }
    }
}
