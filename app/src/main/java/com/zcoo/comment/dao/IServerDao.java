package com.zcoo.comment.dao;

import android.content.ContentValues;

import java.util.List;
import java.util.Map;

/**
 * Author: Supermanzc
 * Project: Comment_163
 * Package: com.zcoo.comment.dao
 * Time: 2015/7/26 14:09
 */
public interface IServerDao {

    /**
     * 根据参数添加一条数据
     *
     * @param table  数据要添加的表名
     * @param values 数据对象
     * @return 布尔值代表数据是否添加成功
     */
    boolean add(String table, ContentValues values);

    /**
     * 根据SQL语句添加一条数据
     *
     * @param sql
     * @return 布尔值表示数据是否添加成功
     */
    boolean add(String sql);

    /**
     * 根据条件参数多条数据查询
     * @param table 表名称
     * @param columns 查询的列名
     * @param whereClause 查询的条件子句
     * @param selectionArgs 条件子句占位符的参数
     * @param groupBy 分组控制
     * @param having 分组过滤
     * @param orderBy 排序
     * @param limit 分页
     * @return 数据列表
     */
    List<Map<String, String>> queryMulti(String table, String[] columns, String whereClause,
                                         String[] selectionArgs, String groupBy, String having,
                                         String orderBy, String limit);

    /**
     * 根据sql查询数据
     * @param sql SQL语句
     * @return 单条数据
     */
    List<Map<String, String>> queryMulti(String sql);

    /**
     * 根据条件查询单条数据
     * @param table 查询表名
     * @param columns 查询的列名
     * @param flag 唯一标示
     * @param groupBy 分组控制
     * @param having 分组过滤
     * @param orderBy 排序
     * @param limit 分页
     * @return 单条
     */
    Map<String, String> querySingle(String table, String[] columns, String flag, String groupBy,
                                    String having, String orderBy, String limit);

    /**
     * 根据SQL语句查询单条数据
     * @param sql SQL语句
     * @return 单条数据
     */
    Map<String, String> querySingle(String sql);


    /**
     * 根据条件查询单个值
     * @param table 表名
     * @param columns 查询的列表
     * @param key 查询的依据列名
     * @param value 查询依据值
     * @return 查询结果
     */
    String queryValue(String table, String[] columns, String key, String value);

    /**
     * 根据SQL语句查询单个值
     * @param sql SQL语句
     * @return 查询结果
     */
    String queryValue(String sql);

}
