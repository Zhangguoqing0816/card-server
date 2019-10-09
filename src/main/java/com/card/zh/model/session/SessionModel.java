package com.card.zh.model.session;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @Auther:
 * @Description:
 * @Date: 2019/10/9 15:29
 */
public class SessionModel implements Serializable {

    private Long id;//账号id

    private Long userId;//用户id

    private String userName;//用户名称

    private String userCode;//登录用户

    private String token;//身份校验

//    private Set<RoleInfoResponse> roleInfoSet;//角色信息

//    private List<Resource> resources;//菜单

    private Long departId;//机构id

    private String departName;//机构名称

    private String departCode;//机构code
}
