package cn.dataguru.dianshang.service;

import cn.dataguru.dianshang.entity.UserInfo;
import cn.dataguru.dianshang.vo.CustomUserInfo;

import java.util.List;
import java.util.Map;

public interface UserService {
    public void insertUserInfo(UserInfo userinfo);
    public UserInfo findUserById(Long id);
    public void updateUserById(UserInfo userinfo);
    public List<UserInfo> findUserInfoByVo(CustomUserInfo customUserInfo);
    public Map<String,String> validLogin(String account, String passw);
}
