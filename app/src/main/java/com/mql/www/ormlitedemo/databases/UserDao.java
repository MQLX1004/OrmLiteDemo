package com.mql.www.ormlitedemo.databases;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.mql.www.ormlitedemo.beans.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by MQL on 2017/8/18.
 */

public class UserDao extends AbUserDao {
    private Dao<User, Integer> userDao;

    private DatabaseHelp dbHelp;

    public UserDao(Context context){
        dbHelp = DatabaseHelp.getHelp(context);
        try {
            userDao = dbHelp.getUserDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(User user) {
        try {
            userDao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try {
            userDao.delete(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        QueryBuilder queryBuilder = userDao.queryBuilder();


    }

    @Override
    public void updata(User user) {
        try {
            userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User queryForId(int id) {
        User user = null;
        try {
            user = userDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> queryForAll() {
        List<User> users = new ArrayList<>();
        try {
            users = userDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


}
