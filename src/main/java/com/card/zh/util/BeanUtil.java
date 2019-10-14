package com.card.zh.util;

import com.card.zh.entity.UserInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther:
 * @Description: 对象之间的值复制
 * @Date: 2019/10/14 13:29
 */
public class BeanUtil {

    public static void main(String[] args) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId("1");
        System.out.println(userInfo.toString());
        UserInfo userInfo1 = new UserInfo();
        userInfo1.setId("3");
        userInfo1.setSex("F");
        BeanUtil.copyProperties(userInfo, userInfo1);
        System.out.println(userInfo1.toString());
    }

    /**
     * 对象之间的值复制 - 属性为 null 的不复制
     *
     * @param source
     * @param target
     */
    public static void copyProperties(Object source, Object target) {
        BeanUtils.copyProperties(source, target, BeanUtil.getNullPropertyNames(source));
    }


    /**
     * 获取传入对象的空属性
     *
     * @param source Object
     * @return
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
