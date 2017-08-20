package com.mql.www.ormlitedemo.databases;

import com.mql.www.ormlitedemo.beans.User;

import java.util.List;

/**
 * UserDao abstract class
 * Created by MQL on 2017/8/18.
 */

public abstract class AbUserDao {

    public abstract void add(User user);

    public abstract void delete(User user);

    public abstract void updata(User user);

    public abstract User queryForId(int id);

    public abstract List<User> queryForAll();
}
