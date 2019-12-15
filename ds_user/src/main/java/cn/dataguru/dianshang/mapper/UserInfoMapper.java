package cn.dataguru.dianshang.mapper;

import cn.dataguru.dianshang.entity.UserInfo;
import cn.dataguru.dianshang.vo.UserInfoVo;

import java.util.List;

public interface UserInfoMapper {
    public void insertUserInfo(UserInfo userinfo);
    public UserInfo findUserById(UserInfo userinfo);
    public void updateUserById(UserInfo userinfo);
    public List<UserInfo> findUserInfoByVo(UserInfoVo userInfoVo);
    public UserInfo findByUsername(UserInfo userinfo);
}
