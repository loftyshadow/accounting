package com.nmz.accounting.auther.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 路由元信息
 * @Author: 聂明智
 * @Date: 2023/10/13-14:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "路由元信息")
public class RouterMetaVO {
    @Schema(name = "icon", description = "菜单和面包屑对应的图标", example = "help")
    /** 菜单和面包屑对应的图标 */
    private String icon;

    @Schema(name = "title", description = "路由标题 (用作 document.title || 菜单的名称)", example = "帮助")
    /** 路由标题 (用作 document.title || 菜单的名称) */
    private String title;

    @Schema(name = "activeMenu", description = "是否在菜单中高亮显示, 需要高亮的 path", example = "/help/list")
    /** 是否在菜单中隐藏, 需要高亮的 path (通常用作详情页高亮父级菜单) */
    private String activeMenu;

    @Schema(name = "isLink", description = "路由外链时填写的访问地址", example = "https://github.com/loftyshadow")
    /** 路由外链时填写的访问地址 */
    private String isLink;

    @Schema(name = "isHide", description = "是否在菜单中隐藏 (通常列表详情页需要隐藏)", example = "true")
    /** 是否在菜单中隐藏 (通常列表详情页需要隐藏) */
    private Boolean isHide;

    @Schema(name = "isFull", description = "菜单是否全屏 (示例：数据大屏页面)", example = "true")
    /** 菜单是否全屏 (示例：数据大屏页面) */
    private Boolean isFull;

    @Schema(name = "isAffix", description = "菜单是否固定在标签页中 (首页通常是固定项)", example = "true")
    /** 菜单是否固定在标签页中 (首页通常是固定项) */
    private Boolean isAffix;

    @Schema(name = "isKeepAlive", description = "当前路由是否缓存", example = "true")
    /** 当前路由是否缓存 */
    private Boolean isKeepAlive;
}
