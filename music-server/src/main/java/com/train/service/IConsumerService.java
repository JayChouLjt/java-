package com.train.service;

import com.train.common.R;
import com.train.domain.Consumer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
public interface IConsumerService extends IService<Consumer> {

    R addUser(Consumer consumer);

    R loginStatus(Consumer consumer, HttpSession session);

    R allUser();

    R userOfId(int id);

    R deleteUser(int id);

    R updateUser(Consumer consumer);

    R updatePassword(Consumer consumer);

    R updateUserAvator(MultipartFile avatarFile, int id);

    boolean existUser(String username);

    boolean verityPasswd(String username, String password);

}
