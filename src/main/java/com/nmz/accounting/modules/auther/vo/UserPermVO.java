package com.nmz.accounting.auther.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @Description: 用户动态路由
 * @Author: 聂明智
 * @Date: 2023/9/25-16:26
 */
@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(title = "用户动态路由")
public class UserPermVO {
    @Schema(name = "菜单ID", description = "菜单ID属性", format = "int64", example = "1")
    private Integer menuId;

    @Schema(name = "组件", description = "组件属性", format = "string", example = "Layout")
    private String component;

    @Schema(name = "标题", description = "标题属性", format = "string", example = "Layout")
    private String title;

    @Schema(name = "图标", description = "图标属性", format = "string", example = "Layout")
    private String icon;

    @Schema(name = "是否显示", description = "是否显示属性", format = "boolean", example = "true")
    private Boolean isShow;

    @Schema(name = "是否显示面包屑", description = "是否显示面包屑属性", format = "boolean", example = "true")
    private Boolean isShowBreadCrumb;

    @Schema(name = "子菜单", description = "子菜单属性", format = "string", example = "Layout")
    private List<UserPermVO> children;

}
