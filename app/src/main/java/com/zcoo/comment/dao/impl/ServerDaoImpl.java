package com.zcoo.comment.dao.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zcoo.comment.dao.IServerDao;
import com.zcoo.comment.sqlit.ServerDBHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Supermanzc
 * Project: Comment_163
 * Package: com.zcoo.comment.dao.impl
 * Time: 2015/7/26 14:28
 * 服务器数据层
 */
public class ServerDaoImpl implements IServerDao {
    private ServerDBHelper mDbHelper;

    public ServerDaoImpl(Context context) {
        mDbHelper = new ServerDBHelper(context);
    }

    @Override
    public boolean add(String table, ContentValues values) {
        boolean flag = false;
        SQLiteDatabase db = null;
        try {
            db = mDbHelper.getWritableDatabase();
            long id = db.insert(table, null, values);
            flag = (id != -1 ? true : false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return flag;
    }

    @Override
    public boolean add(String sql) {
        return false;
    }

    @Override
    public List<Map<String, String>> queryMulti(String table, String[] columns, String whereClause,
                                                String[] selectionArgs, String groupBy, String having,
                                                String orderBy, String limit) {
        List<Map<String, String>> list = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;
        try {
            db = mDbHelper.getWritableDatabase();
            cursor = db.query(table, columns, whereClause, selectionArgs, groupBy, having, orderBy, limit);
            while (cursor.moveToNext()) {
                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    String columnName = cursor.getColumnName(i);
                    String columnValue = cursor.getString(cursor.getColumnIndex(columnName));
                    map.put(columnName, columnValue);
                }
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return list;
    }

    @Override
    public List<Map<String, String>> queryMulti(String sql) {
        List<Map<String, String>> list = new ArrayList<>();
        SQLiteDatabase db = null;
        Cursor cursor;
        try {
            db = mDbHelper.getWritableDatabase();
            cursor = db.rawQuery(sql, null);
            while (cursor.moveToNext()) {
                Map<String, String> map = new HashMap<>();
                for (int i = 0; i < cursor.getColumnCount(); i++) {
                    String columnName = cursor.getColumnName(i);
                    String columnValue = cursor.getString(cursor.getColumnIndex(columnName));
                    map.put(columnName, columnValue);
                }
                list.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return list;
    }

    @Override
    public Map<String, String> querySingle(String table, String[] columns, String flag, String groupBy, String having, String orderBy, String limit) {
        Map<String, String> map = new HashMap<>();
        SQLiteDatabase db = null;
        Cursor cursor;
        try {
            db = mDbHelper.getWritableDatabase();
            cursor = db.query(table, columns, "flag like ?", new String[]{flag}, groupBy, having, orderBy, limit);
            while(cursor.moveToNext()){
                for (int i = 0; i < cursor.getColumnCount(); i++){
                    String columnName = cursor.getColumnName(i);
                    String columnValue = cursor.getString(cursor.getColumnIndex(columnName));
                    map.put(columnName, columnValue);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (db != null) {
                db.close();
            }
        }
        return map;
    }

    @Override
    public Map<String, String> querySingle(String sql) {
        return null;
    }

    @Override
    public String queryValue(String table, String[] columns, String key, String value) {
        String result = null;
        SQLiteDatabase db = null;
        try {
            db = mDbHelper.getWritableDatabase();
            Cursor cursor = db.query(table, columns, key + " like ?", new String[]{value},
                    null, null, null, null);
            cursor.moveToNext();
            String columnName = cursor.getColumnName(0); //第一条数据
            result = cursor.getString(cursor.getColumnIndex(columnName));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != db) {
                db.close();
            }
        }
        return result;
    }

    @Override
    public String queryValue(String sql) {
        return null;
    }
}
