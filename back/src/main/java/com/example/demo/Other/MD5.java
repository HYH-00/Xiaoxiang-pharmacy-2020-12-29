package com.example.demo.Other;



import org.apache.commons.codec.digest.DigestUtils;

import java.io.*;
import java.util.Scanner;

public class MD5 {
    /**
     * @param text 明文
     * @return 密文
     */
    // 带秘钥加密
    public static String md5(String text) throws Exception {
        // 加密后的字符串
        String md5str = DigestUtils.md5Hex(text);
        return md5str;
    }

    /**
     * MD5验证方法
     *
     * @param text 明文
     * @param md5 密文
     */
    // 根据传入的密钥进行验证
    public static boolean verify(String text,String md5) throws Exception {
        String md5str = md5(text);
        if (md5str.equalsIgnoreCase(md5)) {
            System.out.println("MD5验证通过");
            return true;
        }
        return false;
    }

    // 测试
    public static void main(String[] args) throws Exception {
        System.out.println(MD5.md5("123456"));
    }
}
