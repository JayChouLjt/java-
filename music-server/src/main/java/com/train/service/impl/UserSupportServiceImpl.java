package com.train.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.train.common.R;
import com.train.domain.UserSupport;
import com.train.mapper.UserSupportMapper;
import com.train.service.IUserSupportService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Service
public class UserSupportServiceImpl extends ServiceImpl<UserSupportMapper, UserSupport> implements IUserSupportService {

    @Override
    public R isUserSupportComment(UserSupport userSupport) {
        Long count = super.lambdaQuery()
                .eq(UserSupport::getCommentId, userSupport.getCommentId())
                .eq(UserSupport::getUserId, userSupport.getUserId())
                .count();
        if (count > 0) {
            return R.success("您已取消点赞", true);
        } else {
            return R.success("您已点赞", false);
        }
    }

    @Override
    public R insertCommentSupport(UserSupport userSupport) {
        if (super.save(userSupport)) {
            return R.success("添加记录成功");
        }
        return R.error("添加时,发生异常");
    }

    @Override
    public R deleteCommentSupport(UserSupport userSupport) {
        boolean b = super.lambdaUpdate()
                .eq(UserSupport::getCommentId, userSupport.getCommentId())
                .eq(UserSupport::getUserId, userSupport.getUserId())
                .remove();
        ;
        if (b) {
            return R.success("删除记录成功");
        }
        return R.error("删除记录发生异常");
    }
}
