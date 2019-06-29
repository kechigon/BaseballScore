package com.websarva.wings.android.baseballscore;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DatabaseOperation {

    //データベースから選手名を取得する処理メソッド
    public static ArrayList<String> returnItem(ArrayList<String> item, Context context) {
        //データベースヘルパーオブジェクトを作成
        DatabaseHelper dHelper = new DatabaseHelper(context);
        //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
        SQLiteDatabase database = dHelper.getWritableDatabase();

        try {
                //SQL文の用意
            String sql = "SELECT name FROM baseballscore";
            //SQLの実行
            Cursor cursor = database.rawQuery(sql, null);
            //データを取得
            if (cursor.moveToFirst()) {
                do {
                    item.add(cursor.getString(0));
                } while (cursor.moveToNext());
            }
        }
        finally {
            database.close();
        }
        return item;
    }
}


