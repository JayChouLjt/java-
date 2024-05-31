package com.train.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.train.common.Constants;
import com.train.common.R;
import com.train.domain.Singer;
import com.train.mapper.SingerMapper;
import com.train.service.ISingerService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 * 歌手信息 服务实现类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer> implements ISingerService {

    @Override
    public R addSinger(Singer singer) {
        String pic = "/img/avatar/avatar.jpg";
        singer.setPic(pic);
        if (super.save(singer)) {
            return R.success("添加成功");
        } else {
            return R.error("添加失败");
        }
    }

    @Override
    public R deleteSinger(int id) {
        if (super.removeById(id)) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    @Override
    public R allSinger() {
        return R.success(super.list());
    }

    @Override
    public R singerOfName(String name) {
        List<Singer> list = super.lambdaQuery()
                .like(Singer::getName, name)
                .list();
        return R.success(list);
    }

    @Override
    public R singerOfSex(int sex) {
        List<Singer> list = super.lambdaQuery()
                .eq(Singer::getSex, sex)
                .list();
        return R.success(list);
    }

    @Override
    public R updateSingerMsg(Singer singer) {
        if (super.updateById(singer)) {
            return R.success("修改成功");
        } else {
            return R.error("修改失败");
        }
    }

    @Override
    public R updateSingerPic(MultipartFile avatarFile, int id) {
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = Constants.PROJECT_PATH + "/img/singerPic";
        File file = new File(filePath);
        if (!file.exists() && !file.mkdir()) {
            return R.fatal("创建文件失败");
        }
        File dist = new File(filePath + "/" + fileName);
        String imgPath = "/img/singerPic/" + fileName;
        try {
            avatarFile.transferTo(dist);
        } catch (IOException e) {
            return R.fatal("上传失败" + e.getMessage());
        }
        Singer singer = new Singer();
        singer.setId(id);
        singer.setPic(imgPath);
        if (super.updateById(singer)) {
            return R.success("上传成功", imgPath);
        } else {
            return R.error("上传失败");
        }
    }

}
