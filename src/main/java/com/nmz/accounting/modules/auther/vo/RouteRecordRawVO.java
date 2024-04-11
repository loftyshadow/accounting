package com.nmz.accounting.modules.auther.vo;

import com.nmz.accounting.modules.auther.entity.SysMenuEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 路由参数
 * @Author: 聂明智
 * @Date: 2023/10/13-14:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "路由参数")
public class RouteRecordRawVO {
    /** 路由访问路径 */
    @Schema(name = "path", description = "路由访问路径", example = "/home")
    private String path;
    /** 路由 name (对应页面组件 name, 可用作 KeepAlive 缓存标识 && 按钮权限筛选) */
    private String name;
    /** 路由重定向地址 */
    private String redirect;
    /** 视图文件路径 */
    private String component;
    /** 路由元信息 */
    private RouterMetaVO meta;
    /** 多级路由嵌套 */
    private List<RouteRecordRawVO> children;

    public static List<RouteRecordRawVO> toRouteRecordRawVO (List<SysMenuEntity> menuList) {
        List<RouteRecordRawVO> routeRecordRawVOList = new ArrayList<>();
        for (SysMenuEntity menu : menuList) {
            routeRecordRawVOList.add(toRouteRecordRawVO(menu));
        }
        return routeRecordRawVOList;
    }
    public static RouteRecordRawVO toRouteRecordRawVO (SysMenuEntity menu) {
        RouteRecordRawVO routeRecordRawVO = new RouteRecordRawVO();
        RouterMetaVO meta = new RouterMetaVO();
        meta.setIcon(menu.getIcon());
        meta.setActiveMenu(menu.getActiveMenu());
        meta.setTitle(menu.getTitle());
        meta.setIsAffix(menu.getIsAffix());
        meta.setIsKeepAlive(menu.getIsKeepAlive());
        meta.setIsFull(menu.getIsFull());
        meta.setIsLink(menu.getIsLink());
        meta.setIsHide(menu.getIsHide());
        routeRecordRawVO.setPath(menu.getPath());
        routeRecordRawVO.setName(menu.getName());
        routeRecordRawVO.setRedirect(menu.getRedirect());
        routeRecordRawVO.setComponent(menu.getComponent());
        routeRecordRawVO.setMeta(meta);
        return routeRecordRawVO;
    }
}
