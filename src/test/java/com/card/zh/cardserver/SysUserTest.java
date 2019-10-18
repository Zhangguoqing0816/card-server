package com.card.zh.cardserver;

import com.card.zh.entity.SysRole;
import com.card.zh.entity.SysUser;
import com.card.zh.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.relation.Role;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserTest {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void test() {
        List<SysUser> list = sysUserMapper.selectUserRoleAndMenu(new SysUser());
        for (SysUser user:list) {
            System.out.println(user);
            Set<SysRole> roles =user.getRoleSet();
            for (SysRole menu:roles ) {
                System.out.println(menu);
                System.out.println(menu.getMenuSet());
            }

        }

        System.out.println(list);
    }


}
