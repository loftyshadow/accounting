package com.nmz.accounting.modules.common.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.Date;


/**
 * 生成JSON Web令牌的工具类
 */
@Slf4j
public class JwtUtils {

    private static final long TOKEN_EXPIRATION = 365L * 24 * 60 * 60 * 1000;//token过期时间
    private static final String TOKEN_SIGN_KEY = "map";//加密密钥

    private JwtUtils() {
    }


    public static String createToken(Integer userId) {
        String token = "";
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SIGN_KEY);
            token = JWT.create()
                    .withClaim("userId", userId)
                    .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
        }
        return token;
    }

    //根据用户ID 和 用户名 生成token字符串
    public static String createToken(Long userId, String userName) {
        String token = "";
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SIGN_KEY);
            token = JWT.create()
                    .withClaim("userId", userId)
                    .withClaim("userName", userName)
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
        }
        return token;
    }

    //从token字符串获取userid
    public static Long getUserId(String token) {
        try {
            if (!verifyToken(token))
                return null;
            if (!StringUtils.hasLength(token))
                return null;
            return JWT.decode(token)
                    .getClaim("userId")
                    .asLong();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //从token字符串获取username
    public static String getUserName(String token) {
        try {
            if (!StringUtils.hasLength(token))
                return null;
            return JWT.decode(token)
                    .getClaim("userId").asString();
        } catch (Exception e) {
            log.error("token验证失败");
            return null;
        }
    }

    // 验证单JWT token
    public static boolean verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SIGN_KEY);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            log.error("token验证失败");
            return false;
        }
    }

}