package com.zcoo.comment.sqlit;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Author: Supermanzc
 * Project: Comment_163
 * Package: com.zcoo.comment.sqlit
 * Time: 2015/7/26 13:39
 * 网易评论表结构创建
 */
public class ServerDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "server.db"; //数据库名字
    private static final int VERSION = 1; //数据库版本

    /*
     * 创建模型表SQL
     */
    private static final String CREATE_TABLE_USER_SQL = "create table user(_id integer primary" +
            " key autoincrement, flag varchar(16), userName varchar(16), nick integer, location" +
            " varchar(32))";
    private static final String CREATE_TABLE_POST_SQL = "create table post(_id integer primary" +
            " key autoincrement, flag varchar(16), createAt varchar(32))";
    private static final String CREATE_TABLE_COMMENT_SQL = "create table comment(_id integer primary" +
            " key autoincrement, flag varchar(16), userFlag varchar(16), content varchar(1024)," +
            "createAt varchar(32))";

    /*
    创建关联表
     */
    //帖子跟评论关联
    private static final String CREATE_TABLE_POST_AND_COMMENT_SQL = "create table post_comment(_id" +
            " integer primary key autoincrement, postFlag varchar(16), commentFlag varchar(16))";
    //用户和点赞帖关联
    private static final String CREATE_TABLE_USER_AND_PRAISE_SQL = "create table user_praise(_id" +
            " integer primary key autoincrement, userFlag varchar(16), postFlag varchar(16))";
    //用户和被踩帖子关联
    private static final String CREATE_TABLE_USER_AND_UNPRAISE_SQL = "create table user_unpraise(_id" +
            " integer primary key autoincrement, userFlag varchar(16), postFlag varchar(16))";
    //用户和收藏帖子关联
    private static final String CREATE_TABLE_USER_AND_COLLECT_SQL = "create table user_collect(_id " +
            "integer primary key autoincrement, userFlag varchar(16), postFlag varchar(16))";


    public ServerDBHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER_SQL);
        db.execSQL(CREATE_TABLE_POST_SQL);
        db.execSQL(CREATE_TABLE_COMMENT_SQL);
        db.execSQL(CREATE_TABLE_POST_AND_COMMENT_SQL);
        db.execSQL(CREATE_TABLE_USER_AND_PRAISE_SQL);
        db.execSQL(CREATE_TABLE_USER_AND_UNPRAISE_SQL);
        db.execSQL(CREATE_TABLE_USER_AND_COLLECT_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
