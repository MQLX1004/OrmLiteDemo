package com.mql.www.ormlitedemo.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.mql.www.ormlitedemo.beans.Card;
import com.mql.www.ormlitedemo.beans.User;

import java.sql.SQLException;

/**
 *
 * Created by MQL on 2017/8/18.
 */

public class DatabaseHelp extends OrmLiteSqliteOpenHelper {
    private static final String DB_NAME="sqlite-test.db";

    private static final int DB_VERSION=1;

    private static DatabaseHelp instance;

    private DatabaseHelp(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    public static synchronized DatabaseHelp getHelp(Context context){
        if(instance == null){
            synchronized (DatabaseHelp.class){
                if(instance == null){
                    instance = new DatabaseHelp(context);
                }
            }
        }
        return instance;
    }

    @Override
    public void close() {
        super.close();
        userDao = null;
        cardDao = null;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try{
            TableUtils.createTable(connectionSource,User.class);
            TableUtils.createTable(connectionSource, Card.class);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource,User.class,true);
            TableUtils.dropTable(connectionSource,Card.class,true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //----------------------------------------------------------------------------------------------
    //userDao 每一张表对应一个
    private Dao<User, Integer> userDao;

    public Dao<User, Integer> getUserDao() throws SQLException{
        if(userDao == null){
            userDao = getDao(User.class);
        }
        return userDao;
    }
   //-----------------------------------------------------------------------------------------------

    //----------------------------------------------------------------------------------------------
    //cardDao 每一张表对应一个
    private Dao<Card, Integer> cardDao;

    public Dao<Card, Integer> getCardDao() throws SQLException{
        if(cardDao == null){
            cardDao = getDao(Card.class);
        }
        return cardDao;
    }
    //----------------------------------------------------------------------------------------------
}
