package com.train.service;

import com.train.common.R;
import com.train.domain.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 管理员信息 服务类
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
public interface IAdminService extends IService<Admin> {

    R verityPasswd(Admin admin, HttpSession session);

    R saveAdmin(Admin admin);

    R delete(List<Integer> ids);

    R update(Admin admin);

    R select(Integer id, String name);
}
