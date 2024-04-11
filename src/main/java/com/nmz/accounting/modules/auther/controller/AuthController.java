package com.nmz.accounting.modules.auther.controller;


import com.nmz.accounting.modules.auther.entity.SysUserEntity;
import com.nmz.accounting.modules.auther.service.AuthService;
import com.nmz.accounting.modules.auther.vo.LoginVO;
import com.nmz.accounting.modules.auther.vo.RouteRecordRawVO;
import com.nmz.accounting.modules.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.nmz.accounting.modules.auther.utils.SecurityUtil.getUserIdBySecurity;


/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/22-15:08
 */
@RestController
@RequestMapping("/auth")
@Tag(name = "AuthController", description = "用户认证AuthController")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    @Operation(summary = "账号密码" , description = "通过账号登录")
    public Result<LoginVO> login(@RequestBody SysUserEntity user){
        return authService.login(user);
    }

    @GetMapping("/menu/list")
    public Result<List<RouteRecordRawVO>> getUserMenu(){
        Long userId = getUserIdBySecurity();
        return authService.getUserMenu(userId);
    }

    @PostMapping("/logout")
    public Result<String> logout(){
        Long userId = getUserIdBySecurity();
        return authService.logout(userId);
    }

}
