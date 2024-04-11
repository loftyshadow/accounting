package com.nmz.accounting.modules.auther.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/25-16:04
 */
@Slf4j
public class SecurityUtil {

    private SecurityUtil() {
    }

    // 通过Security获取用户id
    public static Long getUserIdBySecurity() {
        return (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static String md5(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(data.getBytes(StandardCharsets.UTF_8));

            // 将处理后的字节转成 16 进制，得到最终 32 个字符
            StringBuilder sb = new StringBuilder();
            for (byte b : md5) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("MD5加密失败", e);
        }
        return "";
    }


}
