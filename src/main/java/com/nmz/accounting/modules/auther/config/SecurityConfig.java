package com.nmz.accounting.modules.auther.config;


import com.nmz.accounting.modules.auther.entity.LoginUser;
import com.nmz.accounting.modules.auther.entity.SysUserEntity;
import com.nmz.accounting.modules.auther.filter.JwtAuthenticationTokenFilter;
import com.nmz.accounting.modules.auther.mapper.SysUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Objects;

import static com.nmz.accounting.modules.auther.exception.AuthException.USER_NAME_OR_PASSWORD_ERROR;
import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    private final SysUserRepository sysUserRepository;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated()
                )
                // 允许跨域
                .cors(withDefaults())
                // 添加token验证过滤器
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 关闭csrf
                .csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    //创建BCryptPasswordEncoder注入容器
    @Bean
    public PasswordEncoder passwordEncoder() {
        //不加密保持纯文本明文
//        return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    //创建UserDetailsService实现loadUserByUsername方法，注入容器
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            //查询用户信息
            SysUserEntity sysUser = sysUserRepository.findByUserName(username);
            //如果没有查询到用户就抛出异常
            if (Objects.isNull(sysUser)) {
                throw USER_NAME_OR_PASSWORD_ERROR;
            }
            return new LoginUser(sysUser, null);
        };
    }
}
