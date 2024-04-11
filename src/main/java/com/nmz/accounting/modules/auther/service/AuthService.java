package com.nmz.accounting.modules.auther.service;

import com.nmz.accounting.modules.auther.entity.SysUserEntity;
import com.nmz.accounting.modules.auther.vo.LoginVO;
import com.nmz.accounting.modules.auther.vo.RouteRecordRawVO;
import com.nmz.accounting.modules.common.result.Result;

import java.util.List;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/27-16:40
 */
public interface AuthService {

    Result<LoginVO> login(SysUserEntity user);

    Result<List<RouteRecordRawVO>> getUserMenu(Long userId);

    Result<String> logout(Long userId);
}
