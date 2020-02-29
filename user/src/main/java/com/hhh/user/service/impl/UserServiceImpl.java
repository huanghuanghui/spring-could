package com.hhh.user.service.impl;

import com.hhh.user.dataobject.UserInfo;
import com.hhh.user.repository.UserInfoRepostory;
import com.hhh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hhh
 * @date 2020/2/23 13:57
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepostory repostory;

    /**
     * 通过openid来查询用户信息
     *
     * @param openid
     * @return
     */
    @Override
    public UserInfo findByOpenid(String openid) {
        return repostory.findByOpenid(openid);
    }
}
