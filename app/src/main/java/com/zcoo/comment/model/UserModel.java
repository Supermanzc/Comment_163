package com.zcoo.comment.model;

import com.zcoo.comment.common.ClsCons;

import java.util.UUID;

/**
 * Author: Supermanzc
 * Project: Comment_163
 * Package: com.zcoo.comment.model
 * Time: 2015/7/26 15:12
 * 用户实体类
 */
public class UserModel {

    public static final String COLUMN_FLAG = "flag", COLUMN_USERNAME = "userName",
            COLUMN_LOCATION = "location", COLUMN_NICK = "nick";
    private String flag;//用户标识系统随机生成
    private String userName;//用户名
    private String location;//用户当前所在位置
    private String nick;//用户头像资源ID

    public UserModel(){
        this.flag = UUID.randomUUID().toString();
        this.userName = ClsCons.USER_NAME[(int)Math.random() * 10];
        this.location = ClsCons.DEFAULT_LOCATION[(int)(Math.random() * 5)];
        this.nick = ClsCons.DEFAULT_NICK_RESID[(int)(Math.random() * 4)];
    }

    /**
     * 用户实体的构造函数，从数据库获取用户数据并实例化对象使用
     * @param flag 用户标识
     * @param userName 用户名
     * @param location 用户地理位置
     * @param nick 用户头像资源ID
     */
    public UserModel(String flag, String userName, String location, String nick) {
        this.flag = flag;
        this.userName = userName;
        this.location = location;
        this.nick = nick;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
