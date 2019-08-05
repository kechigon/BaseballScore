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
        sb.append("name TEXT,");
        sb.append("anda INTEGER DEFAULT 0,");
        sb.append("daritu NUMERIC DEFAULT NoRecord,");
        sb.append("datenn INTEGER DEFAULT 0,");
        sb.append("tokutenn INTEGER DEFAULT 0,");
        sb.append("tanda INTEGER DEFAULT 0,");
        sb.append("niruida INTEGER DEFAULT 0,");
        sb.append("dasuu INTEGER DEFAULT 0,");
        sb.append("sanruida INTEGER DEFAULT 0,");
        sb.append("honruida INTEGER DEFAULT 0,");
        sb.append("dasekisuu INTEGER DEFAULT 0,");
        sb.append("sansinn INTEGER DEFAULT 0,");
        sb.append("foabooru INTEGER DEFAULT 0,");
        sb.append("dettobooru INTEGER DEFAULT 0,");
        sb.append("syuturuiritu NUMERIC DEFAULT NoRecord,");
        sb.append("ops NUMERIC DEFAULT NoRecord,");
        sb.append("tyoudaritu NUMERIC DEFAULT NoRecord,");
        sb.append("tourui INTEGER DEFAULT 0,");
        sb.append("touruisasareru INTEGER DEFAULT 0,");
        sb.append("gida INTEGER DEFAULT 0,");
        sb.append("gihi INTEGER DEFAULT 0,");
        sb.append("toukyuukai NUMERIC DEFAULT 0,");
        sb.append("sittenn INTEGER DEFAULT 0,");
        sb.append("jisekitenn INTEGER DEFAULT 0,");
        sb.append("datusansinn INTEGER DEFAULT 0,");
        sb.append("foabooruataeru INTEGER DEFAULT 0,");
        sb.append("dettobooruataeru INTEGER DEFAULT 0,");
        sb.append("bougyoritu NUMERIC DEFAULT NoRecord,");
        sb.append("touruisasu INTEGER DEFAULT 0,");
        sb.append("syubiritu NUMERIC DEFAULT NoRecord,");
        sb.append("syubikikai INTEGER DEFAULT 0,");
        sb.append("sissaku INTEGER DEFAULT 0,");
        sb.append("syusseki INTEGER DEFAULT 0,");
        sb.append("tikoku INTEGER DEFAULT 0");
        sb.append(");");
        String sql = sb.toString();

        //SQLの実行
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int DATABASE_VERSION) {
    }
}
