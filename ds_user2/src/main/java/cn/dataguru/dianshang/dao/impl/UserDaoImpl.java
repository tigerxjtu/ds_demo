package cn.dataguru.dianshang.dao.impl;

import cn.dataguru.dianshang.dao.UserDao;
import cn.dataguru.dianshang.entity.UserInfo;
import cn.dataguru.dianshang.mapper.UserInfoMapper;
import cn.dataguru.dianshang.vo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void insertUserInfo(UserInfo userinfo) {
        userInfoMapper.insertUserInfo(userinfo);
    }

    @Override
    public UserInfo findUserById(UserInfo userinfo) {
        return userInfoMapper.findUserById(userinfo);
    }

    @Override
    public void updateUserById(UserInfo userinfo) {
        userInfoMapper.updateUserById(userinfo);
    }

    @Override
    public List<UserInfo> findUserInfoByVo(UserInfoVo userInfoVo) {
        return userInfoMapper.findUserInfoByVo(userInfoVo);
    }

    @Override
    public UserInfo findByUsername(UserInfo userinfo) {
        return userInfoMapper.findByUsername(userinfo);
    }


}
