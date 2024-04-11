package com.nmz.accounting.auther.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @Description:
 * @Author: 聂明智
 * @Date: 2023/9/27-21:06
 */
@Getter
@Setter
@ToString
@Entity
@Schema(name = "用户菜单")
@Table(name = "sys_menu", catalog = "")
public class SysMenuEntity {

    @Schema(name = "菜单ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "menu_id", nullable = false)
    private long menuId;

    @Schema(name = "父菜单ID")
    @Basic
    @Column(name = "parent_id", nullable = false)
    private long parentId;

    @Schema(name = "组件")
    @Basic
    @Column(name = "component", nullable = true, length = 255)
    private String component;

    @Schema(name = "组件路径")
    @Basic
    @Column(name = "path", nullable = false, length = 255)
    private String path;

    @Schema(name = "菜单名称")
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Schema(name = "重定向地址")
    @Basic
    @Column(name = "redirect", nullable = true, length = 255)
    private String redirect;

    @Schema(name = "菜单icon")
    @Basic
    @Column(name = "icon", nullable = true, length = 255)
    private String icon;

    @Schema(name = "标题")
    @Basic
    @Column(name = "title", nullable = true, length = 255)
    private String title;

    @Schema(name = "activeMenu")
    @Basic
    @Column(name = "active_menu", nullable = true, length = 255)
    private String activeMenu;

    @Schema(name = "是否外链")
    @Basic
    @Column(name = "is_link", nullable = true, length = 255)
    private String isLink;

    @Schema(name = "是否隐藏")
    @Basic
    @Column(name = "is_hide", nullable = true, length = 255)
    private Boolean isHide;

    @Schema(name = "是否全屏")
    @Basic
    @Column(name = "is_full", nullable = true, length = 255)
    private Boolean isFull;

    @Schema(name = "是否附上")
    @Basic
    @Column(name = "is_affix", nullable = true, length = 255)
    private Boolean isAffix;

    @Schema(name = "是否缓存")
    @Basic
    @Column(name = "is_keep_alive", nullable = true, length = 255)
    private Boolean isKeepAlive;

}
