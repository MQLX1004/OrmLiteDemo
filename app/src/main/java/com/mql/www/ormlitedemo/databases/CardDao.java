package com.mql.www.ormlitedemo.databases;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.mql.www.ormlitedemo.beans.Card;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * Created by MQL on 2017/8/18.
 */

public class CardDao {
    private Dao<Card, Integer> cardDao;

    private DatabaseHelp dbHelp;

    public CardDao(Context context){
        dbHelp = DatabaseHelp.getHelp(context);
        try {
            cardDao = dbHelp.getCardDao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(Card card){
        try {
            cardDao.create(card);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updata(Card card){
        try {
            cardDao.update(card);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Card card){
        try {
            cardDao.delete(card);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Card queryForId(int id){
        Card card = null;
        try {
            card = cardDao.queryForId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    public List<Card> queryForAll(){
        List<Card> cards = null;
        try {
            cards = cardDao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

}
