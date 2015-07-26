package com.zcoo.comment.sqlit;

import android.content.ContentValues;
import android.content.Context;

import com.zcoo.comment.dao.IServerDao;
import com.zcoo.comment.dao.impl.ServerDaoImpl;
import com.zcoo.comment.model.CommentModel;
import com.zcoo.comment.model.PostModel;
import com.zcoo.comment.model.UserModel;

import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Supermanzc
 * Project: Comment_163
 * Package: com.zcoo.comment.sqlit
 * Time: 2015/7/26 17:29
 */
public class SQLiteDataBO {

    IServerDao serverDAO;

    private List<String> userFlagList, postFlagList, commentFlagList;//用户唯一标识、帖子唯一标识、评论唯一标识列表数据
    private List<UserModel> users;//用户列表：用于模拟多个用户操作

    public SQLiteDataBO(Context context) {
        serverDAO = new ServerDaoImpl(context);
    }

    /**
     * 初始化服务器数据
     */
    public void initServerData() {
        userFlagList = new ArrayList<>();
        postFlagList = new ArrayList<>();
        commentFlagList = new ArrayList<>();
        users = new ArrayList<>();

        /*
        创建用户数据
        */
        for (int i = 0; i < 10; i++) {
            UserModel user = new UserModel();
            ContentValues values = new ContentValues();
            values.put("flag", user.getFlag());
            values.put("userName", user.getUserName());
            values.put("nick", user.getNick());
            values.put("location", user.getLocation());
            serverDAO.add("user", values);

            //对象标识存储便于后续操作
            userFlagList.add(user.getFlag());
            users.add(user);
        }

        /*
         创建帖子数据
        */
        for (int i = 0; i < 100; i++) {
            PostModel comment = new PostModel();
            ContentValues values = new ContentValues();
            values.put("flag", comment.getFlag());
            values.put("createAt", comment.getCreateAt());
            serverDAO.add("post", values);

            //对象标识存储便于后续操作
            postFlagList.add(comment.getFlag());
        }

        /*
        创建评论数据
        */
        for (int i = 0; i < 100; i++) {
            CommentModel comment = new CommentModel("评论" + i, users.get((int) (Math.random() * 10)));
            ContentValues values = new ContentValues();
            values.put("flag", comment.getFlag());
            values.put("userFlag", comment.getUser().getFlag());
            values.put("content", comment.getContent());
            values.put("createAt", comment.getCreateAt());
            serverDAO.add("comment", values);

            //对象标识存储便于后续操作
            commentFlagList.add(comment.getFlag());
        }

        /*
        关联帖子和评论的数据
         */
        for (String post : postFlagList) {
            /*
            每条评论最多50条回复
             */
            for (int i = 0; i < (int) (Math.random() * 50); i++) {
                ContentValues values = new ContentValues();
                values.put("postFlag", post);
                values.put("commentFlag", commentFlagList.get((int) (Math.random() * commentFlagList.size())));
                serverDAO.add("post_comment", values);
            }
        }
        /*
        关联用户赞数据
         */
        for (String user : userFlagList) {
            /*
            每个用户最多赞10个帖子
             */
            for (int i = 0; i < (int) (Math.random() * 10); i++) {
                ContentValues values = new ContentValues();
                values.put("userFlag", user);

                //从帖子列表中随机挑选
                values.put("postFlag", postFlagList.get((int) (Math.random() * postFlagList.size())));
                serverDAO.add("user_praise", values);
            }
        }
        /*
        关联用户踩数据
         */
        for (String user : userFlagList) {
            /*
            每个用户最多踩10个帖子
             */
            for (int i = 0; i < (int) (Math.random() * 10); i++) {
                ContentValues values = new ContentValues();
                values.put("userFlag", user);

                //从帖子列表中随机挑选
                values.put("postFlag", postFlagList.get((int) (Math.random() * postFlagList.size())));
                serverDAO.add("user_unpraise", values);
            }
        }
          /*
        关联用户收藏数据
         */
        for (String user : userFlagList) {
            /*
            每个用户最多踩10个帖子
             */
            for (int i = 0; i < (int) (Math.random() * 10); i++) {
                ContentValues values = new ContentValues();
                values.put("userFlag", user);

                //从帖子列表中随机挑选
                values.put("postFlag", postFlagList.get((int) (Math.random() * postFlagList.size())));
                serverDAO.add("user_collect", values);
            }
        }
    }
}
