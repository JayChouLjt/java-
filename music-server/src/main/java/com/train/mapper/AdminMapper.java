package com.train.mapper;

import com.train.domain.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 管理员信息 Mapper 接口
 * </p>
 *
 * @author liuhongjun
 * @since 2024-05-24
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

}
