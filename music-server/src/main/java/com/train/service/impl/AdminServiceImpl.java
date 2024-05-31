package com.train.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.train.common.Constants;
import com.train.common.R;
import com.train.domain.Admin;
import com.train.mapper.AdminMapper;
import com.train.service.IAdminService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * <p>
 * 管理员信息 服务实现类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Override
    public R saveAdmin(Admin admin) {
        String password = DigestUtils.md5DigestAsHex((Constants.SALT + admin.getPassword()).getBytes(StandardCharsets.UTF_8));
        admin.setPassword(password);
        try {
            if (super.save(admin)) {
                return R.success("新增成功");
            } else {
                return R.error("新增失败");
            }
        } catch (Exception e) {
            return R.fatal(e.getMessage());
        }
    }

    @Override
    public R delete(List<Integer> ids) {
        boolean b = super.removeBatchByIds(ids);
        if (!b) {
            return R.error("批量删除失败");
        }
        return R.success("批量删除成功");
    }

    @Override
    public R update(Admin admin) {
        String name = admin.getName();
        String password = admin.getPassword();
        String oldPass = admin.getOldPass();
        if (password.equals(oldPass)) {
            return R.error("新旧密码不能一样");
        }
        String hexPass = DigestUtils.md5DigestAsHex((Constants.SALT + oldPass).getBytes(StandardCharsets.UTF_8));
        Long count = super.lambdaQuery()
                .eq(Admin::getName, name)
                .eq(Admin::getPassword, hexPass)
                .count();
        if (count == 0) {
            return R.error("密码错误");
        }
        String newPass = DigestUtils.md5DigestAsHex((Constants.SALT + password).getBytes(StandardCharsets.UTF_8));
        admin.setPassword(newPass);
        boolean b = super.updateById(admin);
        if (!b) {
            return R.error("更新失败");
        }
        return R.success("更新成功");
    }

    @Override
    public R select(Integer id, String name) {
        List<Admin> list = super.lambdaQuery()
                .eq(id != null, Admin::getId, id)
                .like(name != null, Admin::getName, name)
                .list();
        if (CollUtil.isEmpty(list)) {
            return R.error("没有相关管理员信息");
        }
        return R.success(list);
    }

    @Override
    public R verityPasswd(Admin admin, HttpSession session) {
        String password = admin.getPassword();
        String hexPass = DigestUtils.md5DigestAsHex((Constants.SALT + password).getBytes(StandardCharsets.UTF_8));
        Long count = super.lambdaQuery()
                .eq(Admin::getName, admin.getName())
                .eq(Admin::getPassword, hexPass)
                .count();
        if (count > 0) {
            session.setAttribute("name", admin.getName());
            return R.success("登录成功");
        } else {
            return R.error("用户名或密码错误");
        }
    }
}
