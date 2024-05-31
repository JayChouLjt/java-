package com.train.service;

import com.train.common.R;
import com.train.domain.UserSupport;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
public interface IUserSupportService extends IService<UserSupport> {

    R isUserSupportComment(UserSupport userSupport);

    R insertCommentSupport(UserSupport userSupport);

    R deleteCommentSupport(UserSupport userSupport);
}
