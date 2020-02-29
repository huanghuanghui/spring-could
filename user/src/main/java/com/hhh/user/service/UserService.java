package com.hhh.user.service;

import com.hhh.user.dataobject.UserInfo;

public interface UserService {

    /**
     * 通过openid来查询用户信息
     *
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);
}
