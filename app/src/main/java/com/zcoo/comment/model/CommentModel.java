package com.zcoo.comment.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * Author: Supermanzc
 * Project: Comment_163
 * Package: com.zcoo.comment.model
 * Time: 2015/7/26 16:51
 * 评论实体类
 */
public class CommentModel {

    /*
    对应数据库表列名
     */
    public static final String COLUMN_FLAG = "flag", COLUMN_USERFLAG = "userFlag",
            COLUMN_CONTENT = "content", COLUMN_CREATEAT = "createAt";

    private String flag;//评论标识：系统随机生成
    private String content;//评论内容
    private String createAt;//评论时间：系统生成
    private UserModel user;//用户实体

    /**
     * 评论实体的构造函数，生成评论插入数据库时使用
     *
     * @param content 评论内容
     */
    public CommentModel(String content, UserModel user) {
        //生成随机标识，这个随机标识准确来说应该是服务端生成，这里就不麻烦了 = =
        flag = UUID.randomUUID().toString();

        //生成系统时间，这个数据创建时间也应该是服务端生成
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss", Locale.getDefault());
        this.createAt = format.format(date);
        this.user = user;
        this.content = content;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }
}
