package com.websarva.wings.android.baseballscore;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    //データベースファイル名の定数フィールド
    private static final String DATABASE_NAME = "baseballscore.db";
    //バージョン情報の定数フィールド
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        //親クラスのコンストラクタの呼び出し
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //テーブル作成用SQL文字列の作成
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE baseballscore (");
        sb.append("_id INTEGER PRIMARY KEY,");
        sb.append("name TEXT");
        sb.append("siaisuu INTEGER");
        sb.append("anda INTEGER");
        sb.append("daritu NUMERIC");
        sb.append("datenn INTEGER");
        sb.append("tokutenn INTEGER");
        sb.append("tanda INTEGER");
        sb.append("niruida INTEGER");
        sb.append("sanruida INTEGER");
        sb.append("honruida INTEGER");
        sb.append("sansinn INTEGER");
        sb.append("foabooru INTEGER");
        sb.append("dettobooru INTEGER");
        sb.append("syuturuiritu NUMERIC");
        sb.append("ops NUMERIC");
        sb.append("tyoudaritu NUMERIC");
        sb.append("tourui INTEGER");
        sb.append("touruisasareru INTEGER");
        sb.append("gida INTEGER");
        sb.append("gihi INTEGER");
        sb.append("toukyuukai NUMERIC");
        sb.append("sittenn INTEGER");
        sb.append("jisekitenn INTEGER");
        sb.append("yosisikyuu INTEGER");
        sb.append("datusansinn INTEGER");
        sb.append("bougyoritu INTEGER");
        sb.append("touruisasu INTEGER");
        sb.append("syubiritu NUMERIC");
        sb.append("sissaku INTEGER");
        sb.append("touruisosiritu NUMERIC");
        sb.append("syusseki INTEGER");
        sb.append("tikoku INTEGER");
        sb.append(");");
        String sql = sb.toString();

        //SQLの実行
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int DATABASE_VERSION) {
    }
}
