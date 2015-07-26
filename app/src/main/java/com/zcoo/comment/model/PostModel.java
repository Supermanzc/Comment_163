package com.zcoo.comment.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * Author: Supermanzc
 * Project: Comment_163
 * Package: com.zcoo.comment.model
 * Time: 2015/7/26 16:50
 * 帖子实体类
 */
public class PostModel {

    private String flag; //评论标识
    private String createAt; //评论时间
    private List<CommentModel> comments; //帖子下所有的评论
    //帖子点赞人数，踩的人数和收藏的人数
    private List<UserModel> userPraises, userUnPraises, userCollects;
    private Type type;

    public PostModel(){
        this.flag = UUID.randomUUID().toString();

        //生成系统时间，这个创建时间是服务器生成
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss", Locale.getDefault());
        this.createAt = format.format(date);
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    public List<UserModel> getUserPraises() {
        return userPraises;
    }

    public void setUserPraises(List<UserModel> userPraises) {
        this.userPraises = userPraises;
    }

    public List<UserModel> getUserUnPraises() {
        return userUnPraises;
    }

    public void setUserUnPraises(List<UserModel> userUnPraises) {
        this.userUnPraises = userUnPraises;
    }

    public List<UserModel> getUserCollects() {
        return userCollects;
    }

    public void setUserCollects(List<UserModel> userCollects) {
        this.userCollects = userCollects;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        HOTTEST, NEWST, NORMAL
    }
}
