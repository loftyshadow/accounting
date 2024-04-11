package com.nmz.accounting.auther.service;

import com.nmz.authserver.entity.SysUserEntity;
import com.nmz.authserver.vo.LoginVO;
import com.nmz.authserver.vo.RouteRecordRawVO;
import com.nmz.common.result.Result;

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
