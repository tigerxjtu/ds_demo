package cn.dataguru.dianshang.entity;

import lombok.Data;

@Data
public class UserInfo {
    private Long id;
    private String account;
    private String passwordplaintext;
    private String passwordencrypt;
    private String name;
    private int age;
    private String address;
    private String telphone;
    private String qq;
    private String weixin;
    private String email;
    private String sex;
    private String birthday;
}
