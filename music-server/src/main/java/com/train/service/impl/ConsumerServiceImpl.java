package com.train.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.train.common.Constants;
import com.train.common.R;
import com.train.domain.Consumer;
import com.train.mapper.ConsumerMapper;
import com.train.service.IConsumerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements IConsumerService {

    @Override
    public R addUser(Consumer consumer) {
        if (this.existUser(consumer.getUsername())) {
            return R.warning("用户名已注册");
        }
        //使用MD5对密码加密
        String password = DigestUtils.md5DigestAsHex((Constants.SALT + consumer.getPassword()).getBytes(StandardCharsets.UTF_8));
        consumer.setPassword(password);
        //判断电话号码以及邮箱是否为空
        if (StringUtils.isBlank(consumer.getPhoneNum())) {
            consumer.setPhoneNum(null);
        }
        if ("".equals(consumer.getEmail())) {
            consumer.setEmail(null);
        }
        //设置默认头像
        consumer.setAvatar("/img/avatar/avatar.jpg");
        try {
            if (super.save(consumer)) {
                return R.success("注册成功");
            } else {
                return R.error("注册失败");
            }
        } catch (Exception e) {
            return R.fatal(e.getMessage());
        }
    }

    @Override
    public R loginStatus(Consumer consumer, HttpSession session) {
        String username = consumer.getUsername();
        String password = consumer.getPassword();
        if (this.verityPasswd(username, password)) {
            session.setAttribute("username", username);
            consumer.setUsername(username);
            return R.success("登录成功", super.list());
        } else {
            return R.error("用户名或密码错误");
        }
    }

    @Override
    public R allUser() {
        return R.success(super.list());
    }

    @Override
    public R userOfId(int id) {
        List<Consumer> list = super.lambdaQuery()
                .eq(Consumer::getId, id)
                .list();
        return R.success(list);
    }

    @Override
    public R deleteUser(int id) {
        if (super.removeById(id)) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    @Override
    public R updateUser(Consumer consumer) {
        if (super.updateById(consumer)) {
            return R.success("修改成功");
        } else {
            return R.error("修改失败");
        }
    }

    @Override
    public R updatePassword(Consumer consumer) {
        if (!this.verityPasswd(consumer.getUsername(), consumer.getOldPass())) {
            return R.error("密码输入错误");
        }
        consumer.setId(consumer.getId());
        String hexPass = DigestUtils.md5DigestAsHex((Constants.SALT + consumer.getPassword()).getBytes(StandardCharsets.UTF_8));
        consumer.setPassword(hexPass);
        if (super.updateById(consumer)) {
            return R.success("密码修改成功");
        } else {
            return R.error("密码修改失败");
        }
    }

    @Override
    public R updateUserAvator(MultipartFile avatarFile, int id) {
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = Constants.PROJECT_PATH + "/img/avatar";
        File file = new File(filePath);
        if (!file.exists() && !file.mkdir()) {
            return R.fatal("创建文件失败");
        }
        File dist = new File(filePath + "/" + fileName);
        String imgPath = "/img/avatar/" + fileName;
        try {
            avatarFile.transferTo(dist);
        } catch (IOException e) {
            return R.fatal("上传失败" + e.getMessage());
        }
        Consumer consumer = new Consumer();
        consumer.setId(id);
        consumer.setAvatar(imgPath);
        if (super.updateById(consumer)) {
            return R.success("上传成功", imgPath);
        } else {
            return R.error("上传失败");
        }
    }

    @Override
    public boolean existUser(String username) {
        Long count = super.lambdaQuery()
                .eq(Consumer::getUsername, username)
                .count();
        return count > 0;
    }

    @Override
    public boolean verityPasswd(String username, String password) {
        String hexPass = DigestUtils.md5DigestAsHex((Constants.SALT + password).getBytes(StandardCharsets.UTF_8));
        Long count = super.lambdaQuery()
                .eq(Consumer::getUsername, username)
                .eq(Consumer::getPassword, hexPass)
                .count();
        return count > 0;
    }

}
