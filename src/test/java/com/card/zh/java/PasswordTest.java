package com.card.zh.java;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordTest {

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void init() {
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }


    /**
     * BCryptPasswordEncoder对密码加密后是不可逆的
     */
    @Test
    public void test() {
        String pwd = bCryptPasswordEncoder.encode("123456");
        System.out.println(pwd);// $2a$10$r6PO9emYTb07.B2klHtemu4CaHt3uMispN4MXoSG619fsCVHMzypu
        Boolean pwdEq = bCryptPasswordEncoder.matches("123456", pwd);
        System.out.println(pwdEq);


    }


}
