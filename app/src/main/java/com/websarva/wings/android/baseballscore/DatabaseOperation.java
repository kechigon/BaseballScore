package com.websarva.wings.android.baseballscore;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

public class DatabaseOperation {

    //データベースから選手名を取得する処理メソッド
    public static ArrayList<String> returnPlayerName(ArrayList<String> item, Context context) {
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

    //データベースに選手名を登録する処理メソッド
    public static void insertPlayerName(int id, String name, Context context) {
        //データベースヘルパーオブジェクトを作成
        DatabaseHelper helper = new DatabaseHelper(context);
        //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            //インサート用のSQL文字列の用意
            String sqlInsert = "INSERT INTO baseballscore (_id, name) VALUES (?, ?)";
            //SQL文字列をもとにプリペアドステートメントを取得
            SQLiteStatement stmt = db.compileStatement(sqlInsert);
            //変数バインド
            stmt.bindLong(1,id);
            stmt.bindString(2,name);
            //インサートSQLの実行
            stmt.executeInsert();
        }
        finally {
            db.close();
        }
    }

    //データベースに単打を登録する処理メソッド
    public static void updateTanda(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET tanda = tanda+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1,date_2);
                stmt.bindString(2,name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            }
            finally {
                db.close();
            }
        }
    }

    //データベースに二塁打を登録する処理メソッド
    public static void updateNiruida(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET niruida = niruida+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに三塁打を登録する処理メソッド
    public static void updateSanruida(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET sanruida = sanruidsa+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに本塁打を登録する処理メソッド
    public static void updateHonnruida(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET honnruida = honruida+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに打数を登録する処理メソッド
    public static void updateDasuu(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET dasuu = dasuu+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに打席数を登録する処理メソッド
    public static void updateDasekisuu(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET dasekisuu = dsasekisuu+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに打点を登録する処理メソッド
    public static void updateDatenn(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET datenn = datenn+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに得点を登録する処理メソッド
    public static void updateTokutenn(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET tokutenn = tokutenn+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに三振を登録する処理メソッド
    public static void updateSansinn(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET sansinn = sansinn+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに四球を登録する処理メソッド
    public static void updateFoabooru(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET foabooru = foabooru+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに死球を登録する処理メソッド
    public static void updateDettobooru(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET dettobooru = dettobooru+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに盗塁を登録する処理メソッド
    public static void updateTourui(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET tourui = tourui+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに盗塁死を登録する処理メソッド
    public static void updateTouruisasareru(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET touruisasareru = touruisasareru+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに犠打を登録する処理メソッド
    public static void updateGida(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET gida = gida+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに犠飛を登録する処理メソッド
    public static void updateGihi(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET gihi = gihi+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに投球回を登録する処理メソッド
    public static void updateToukyuukai(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをdouble型に変換
            double date_2 = Double.parseDouble(data);
            //今の投球回のフィード
            double nowToukyuukai = 0;

            //投球回の小数点以下(0.0～0.2になってる)を再現

            //今の投球回を取得

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();

            try {
                //SQL文の用意
                String sql = "SELECT toukyuukai FROM baseballscore WHERE name = "+name;
                //SQLの実行
                Cursor cursor = db.rawQuery(sql, null);
                //データを取得
                if (cursor.moveToFirst()) {
                    do {
                        //カラムのインデックス値を取得
                        int idxToukyuukai = cursor.getColumnIndex("touukyuukai");
                        //カラムのインデックス値をもとにデータを取得
                        nowToukyuukai = cursor.getInt(idxToukyuukai);
                    } while (cursor.moveToNext());
                }
            }
            finally {
                db.close();
            }

            //今の投球回とこれから登録する投球回の合計の小数点以下が3以下になるようにする処理

            //今の投球回とこれから登録する投球回の整数部を取得
            int date_2Before = (int)date_2;
            int nowToukyuukaiBefore = (int)nowToukyuukai;
            //今の投球回とこれから登録する投球回の小数点以下を取得
            double date_2After = date_2%1.0;
            double nowToukyuukaiAfter = nowToukyuukai%1.0;

            //小数点以下が3より大きかった時の処理とそうでない時の処理
            double toukyuukai = 0;
            if (date_2After + nowToukyuukaiAfter >= 0.3) {
                toukyuukai = date_2Before + nowToukyuukaiBefore + 1;
                if (date_2After + nowToukyuukaiAfter == 0.4) {
                    toukyuukai += 0.1;
                }
            } else {
                toukyuukai = date_2 + nowToukyuukai;
            }

            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET toukyuukai = ? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindDouble(1, toukyuukai);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに失点を登録する処理メソッド
    public static void updateSittenn(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET sittenn = sittenn+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに自責点を登録する処理メソッド
    public static void updateJisekitenn(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET jisekitenn = jisekitenn+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに奪三振を登録する処理メソッド
    public static void updateDatusansinn(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET datusansinn = datusansinn+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに盗塁刺を登録する処理メソッド
    public static void updateTouruisasu(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET touruisasu = touruisasu+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに守備機会を登録する処理メソッド
    public static void updateSyubikikai(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET syubikikai = syubikikai+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに失策を登録する処理メソッド
    public static void updateSissaku(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET sissaku = sissaku+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに出席を登録する処理メソッド
    public static void updateSyusseki(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET syusseki = syusseki+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //データベースに遅刻を登録する処理メソッド
    public static void updateTikoku(String name, String data, Context context) {
        //データが入力されている場合登録する
        if (!data.equals("")) {
            //データをint型に変換
            int date_2 = Integer.parseInt(data);

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET tikoku = tikoku+? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインドている場合
                stmt.bindLong(1, date_2);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //安打を計算し登録する処理メソッド
    public static void calculateAndRegistrationAnda(String name, String tanda, String niruida, String sanruida, String honruida, Context context) {
        //安打のデータが入力されている場合登録する
        if (!tanda.equals("") && !niruida.equals("") && !sanruida.equals("") && !honruida.equals("")) {
            //データ型をint型に変換
            int tanda_2 = Integer.parseInt(tanda);
            int niruida_2 = Integer.parseInt(niruida);
            int sanruida_2 = Integer.parseInt(sanruida);
            int honruida_2 = Integer.parseInt(honruida);
            //今のデータのフィード
            int nowTanda = 0;
            int nowNiruida = 0;
            int nowSanruida = 0;
            int nowHonruida = 0;

            //今の安打を取得

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();

            try {
                //SQL文の用意
                String sql = "SELECT tanda,niruida,sanruida,honruida,dasuu FROM baseballscore WHERE name = "+name;
                //SQLの実行
                Cursor cursor = db.rawQuery(sql, null);
                //データを取得
                if (cursor.moveToFirst()) {
                    do {
                        //カラムのインデックス値を取得
                        int idxTanda = cursor.getColumnIndex("tanda");
                        int idxNiruida = cursor.getColumnIndex("niruida");
                        int idxSanruida = cursor.getColumnIndex("sanruida");
                        int idxHoruida = cursor.getColumnIndex("honruida");
                        //カラムのインデックス値をもとにデータを取得
                        nowTanda = cursor.getInt(idxTanda);
                        nowNiruida = cursor.getInt(idxNiruida);
                        nowSanruida = cursor.getInt(idxSanruida);
                        nowHonruida = cursor.getInt(idxHoruida);
                    } while (cursor.moveToNext());
                }
            }
            finally {
                db.close();
            }

            //安打を算出する式
            int tanda_3 = tanda_2+nowTanda;
            int niruida_3 = niruida_2+nowNiruida;
            int sanruida_3 = sanruida_2+nowSanruida;
            int honruida_3 = honruida_2+nowHonruida;

            int anda = tanda_3+niruida_3+sanruida_3+honruida_3;

            //安打をデータベースに登録
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET anda = ? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindLong(1, anda);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //打率を計算し登録する処理メソッド
    public static void calculateAndRegistrationDariut(String name, String tanda, String niruida, String sanruida, String honruida, String dasuu, Context context) {
        //打数のデータが入力されている場合登録する
        if (!dasuu.equals("")) {
            //データ型をint型に変換
            int tanda_2 = Integer.parseInt(tanda);
            int niruida_2 = Integer.parseInt(niruida);
            int sanruida_2 = Integer.parseInt(sanruida);
            int honruida_2 = Integer.parseInt(honruida);
            int dasuu_2 = Integer.parseInt(dasuu);
            //今のデータのフィード
            int nowTanda = 0;
            int nowNiruida = 0;
            int nowSanruida = 0;
            int nowHonruida = 0;
            int nowDasuu = 0;

            //今の安打数と打数を取得

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();

            try {
                //SQL文の用意
                String sql = "SELECT tanda,niruida,sanruida,honruida,dasuu FROM baseballscore WHERE name = "+name;
                //SQLの実行
                Cursor cursor = db.rawQuery(sql, null);
                //データを取得
                if (cursor.moveToFirst()) {
                    do {
                        //カラムのインデックス値を取得
                        int idxTanda = cursor.getColumnIndex("tanda");
                        int idxNiruida = cursor.getColumnIndex("niruida");
                        int idxSanruida = cursor.getColumnIndex("sanruida");
                        int idxHoruida = cursor.getColumnIndex("honruida");
                        int idxDasuu = cursor.getColumnIndex("dasuu");
                        //カラムのインデックス値をもとにデータを取得
                        nowTanda = cursor.getInt(idxTanda);
                        nowNiruida = cursor.getInt(idxNiruida);
                        nowSanruida = cursor.getInt(idxSanruida);
                        nowHonruida = cursor.getInt(idxHoruida);
                        nowDasuu = cursor.getInt(idxDasuu);
                    } while (cursor.moveToNext());
                }
            }
            finally {
                db.close();
            }

            //打率を算出する式
            int tanda_3 = tanda_2+nowTanda;
            int niruida_3 = niruida_2+nowNiruida;
            int sanruida_3 = sanruida_2+nowSanruida;
            int honruida_3 = honruida_2+nowHonruida;
            int dasuu_3 =  dasuu_2+nowDasuu;

            double daritu = Math.round((tanda_3+niruida_3+sanruida_3+honruida_3)/dasuu_3*1000)/1000;

            //打率をデータベースに登録
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET daritu = ? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindDouble(1, daritu);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //出塁率を計算し登録する処理メソッド
    public static void calculateAndRegistrationSyuturuiritu(String name, String tanda, String niruida, String sanruida, String honruida, String foabooru, String dettobooru, String dasuu, String gihi, Context context) {
        //四死球、打数、犠飛のデータが入力されている場合登録する
        if (!foabooru.equals("") && !dettobooru.equals("") && !dasuu.equals("") && !gihi.equals("")) {
            //データ型をint型に変換
            int tanda_2 = Integer.parseInt(tanda);
            int niruida_2 = Integer.parseInt(niruida);
            int sanruida_2 = Integer.parseInt(sanruida);
            int honruida_2 = Integer.parseInt(honruida);
            int foabooru_2 = Integer.parseInt(foabooru);
            int dettobooru_2 = Integer.parseInt(dettobooru);
            int dasuu_2 = Integer.parseInt(dasuu);
            int gihi_2 = Integer.parseInt(gihi);
            //今のデータのフィード
            int nowTanda = 0;
            int nowNiruida = 0;
            int nowSanruida = 0;
            int nowHonruida = 0;
            int nowFoabooru = 0;
            int nowDettobooru = 0;
            int nowDasuu = 0;
            int nowGihi = 0;

            //今の安打数と四死球、打数、犠飛を取得

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();

            try {
                //SQL文の用意
                String sql = "SELECT tanda,niruida,sanruida,honruida,foabooru,dettobooru,dasuu,gihi FROM baseballscore WHERE name = "+name;
                //SQLの実行
                Cursor cursor = db.rawQuery(sql, null);
                //データを取得
                if (cursor.moveToFirst()) {
                    do {
                        //カラムのインデックス値を取得
                        int idxTanda = cursor.getColumnIndex("tanda");
                        int idxNiruida = cursor.getColumnIndex("niruida");
                        int idxSanruida = cursor.getColumnIndex("sanruida");
                        int idxHoruida = cursor.getColumnIndex("honruida");
                        int idxFoabooru = cursor.getColumnIndex("foabooru");
                        int idxDettobooru = cursor.getColumnIndex("dettobooru");
                        int idxDasuu = cursor.getColumnIndex("dasuu");
                        int idxGihi = cursor.getColumnIndex("gihi");
                        //カラムのインデックス値をもとにデータを取得
                        nowTanda = cursor.getInt(idxTanda);
                        nowNiruida = cursor.getInt(idxNiruida);
                        nowSanruida = cursor.getInt(idxSanruida);
                        nowHonruida = cursor.getInt(idxHoruida);
                        nowFoabooru = cursor.getInt(idxFoabooru);
                        nowDettobooru = cursor.getInt(idxDettobooru);
                        nowDasuu = cursor.getInt(idxDasuu);
                        nowGihi = cursor.getInt(idxGihi);
                    } while (cursor.moveToNext());
                }
            }
            finally {
                db.close();
            }

            //出塁率を算出する式
            int tanda_3 = tanda_2+nowTanda;
            int niruida_3 = niruida_2+nowNiruida;
            int sanruida_3 = sanruida_2+nowSanruida;
            int honruida_3 = honruida_2+nowHonruida;
            int foabooru_3 = foabooru_2+nowFoabooru;
            int dettobooru_3 = dettobooru_2+nowDettobooru;
            int dasuu_3 =  dasuu_2+nowDasuu;
            int gihi_3 = gihi_2+nowGihi;

            double syuturuiritu = Math.round((tanda_3+niruida_3+sanruida_3+honruida_3+foabooru_3+dettobooru_3)/(dasuu_3+foabooru_3+dettobooru_3+gihi_3)*1000)/1000;

            //出塁率をデータベースに登録
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET syuturuiritu = ? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindDouble(1, syuturuiritu);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //長打率を計算し登録する処理メソッド
    public static void calculateAndRegistrationChoudaritu(String name, String tanda, String niruida, String sanruida, String honruida, String dasuu, Context context) {
        //打数のデータが入力されている場合登録する
        if (!dasuu.equals("")) {
            //データ型をint型に変換
            int tanda_2 = Integer.parseInt(tanda);
            int niruida_2 = Integer.parseInt(niruida);
            int sanruida_2 = Integer.parseInt(sanruida);
            int honruida_2 = Integer.parseInt(honruida);
            int dasuu_2 = Integer.parseInt(dasuu);
            //今のデータのフィード
            int nowTanda = 0;
            int nowNiruida = 0;
            int nowSanruida = 0;
            int nowHonruida = 0;
            int nowDasuu = 0;

            //今の安打数と打数を取得

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();

            try {
                //SQL文の用意
                String sql = "SELECT tanda,niruida,sanruida,honruida,dasuu, FROM baseballscore WHERE name = "+name;
                //SQLの実行
                Cursor cursor = db.rawQuery(sql, null);
                //データを取得
                if (cursor.moveToFirst()) {
                    do {
                        //カラムのインデックス値を取得
                        int idxTanda = cursor.getColumnIndex("tanda");
                        int idxNiruida = cursor.getColumnIndex("niruida");
                        int idxSanruida = cursor.getColumnIndex("sanruida");
                        int idxHoruida = cursor.getColumnIndex("honruida");
                        int idxDasuu = cursor.getColumnIndex("dasuu");
                        //カラムのインデックス値をもとにデータを取得
                        nowTanda = cursor.getInt(idxTanda);
                        nowNiruida = cursor.getInt(idxNiruida);
                        nowSanruida = cursor.getInt(idxSanruida);
                        nowHonruida = cursor.getInt(idxHoruida);
                        nowDasuu = cursor.getInt(idxDasuu);
                    } while (cursor.moveToNext());
                }
            }
            finally {
                db.close();
            }

            //長打率を算出する式
            int tanda_3 = tanda_2+nowTanda;
            int niruida_3 = niruida_2+nowNiruida;
            int sanruida_3 = sanruida_2+nowSanruida;
            int honruida_3 = honruida_2+nowHonruida;
            int dasuu_3 =  dasuu_2+nowDasuu;

            double tyoudaritu = Math.round((tanda_3+niruida_3*2+sanruida_3*3+honruida_3*4)/dasuu_3*1000)/1000;

            //長打率をデータベースに登録
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET tyoudaritu = ? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindDouble(1, tyoudaritu);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //OPSを計算し登録する処理メソッド
    public static void calculateAndRegistrationOPS(String name, String tanda, String niruida, String sanruida, String honruida, String foabooru, String dettobooru, String dasuu, String gihi, Context context) {
        //四死球、打数、犠飛のデータが入力されている場合登録する
        if ((!foabooru.equals("") && !dettobooru.equals("") && !dasuu.equals("") && !gihi.equals("")) || !dasuu.equals("")) {
            //データ型をint型に変換
            int tanda_2 = Integer.parseInt(tanda);
            int niruida_2 = Integer.parseInt(niruida);
            int sanruida_2 = Integer.parseInt(sanruida);
            int honruida_2 = Integer.parseInt(honruida);
            int foabooru_2 = Integer.parseInt(foabooru);
            int dettobooru_2 = Integer.parseInt(dettobooru);
            int dasuu_2 = Integer.parseInt(dasuu);
            int gihi_2 = Integer.parseInt(gihi);
            //今のデータのフィード
            int nowTanda = 0;
            int nowNiruida = 0;
            int nowSanruida = 0;
            int nowHonruida = 0;
            int nowFoabooru = 0;
            int nowDettobooru = 0;
            int nowDasuu = 0;
            int nowGihi = 0;

            //今の安打数と四死球、打数、犠飛を取得

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();

            try {
                //SQL文の用意
                String sql = "SELECT tanda,niruida,sanruida,honruida,foabooru,dettobooru,dasuu,gihi FROM baseballscore WHERE name = "+name;
                //SQLの実行
                Cursor cursor = db.rawQuery(sql, null);
                //データを取得
                if (cursor.moveToFirst()) {
                    do {
                        //カラムのインデックス値を取得
                        int idxTanda = cursor.getColumnIndex("tanda");
                        int idxNiruida = cursor.getColumnIndex("niruida");
                        int idxSanruida = cursor.getColumnIndex("sanruida");
                        int idxHoruida = cursor.getColumnIndex("honruida");
                        int idxFoabooru = cursor.getColumnIndex("foabooru");
                        int idxDettobooru = cursor.getColumnIndex("dettobooru");
                        int idxDasuu = cursor.getColumnIndex("dasuu");
                        int idxGihi = cursor.getColumnIndex("gihi");
                        //カラムのインデックス値をもとにデータを取得
                        nowTanda = cursor.getInt(idxTanda);
                        nowNiruida = cursor.getInt(idxNiruida);
                        nowSanruida = cursor.getInt(idxSanruida);
                        nowHonruida = cursor.getInt(idxHoruida);
                        nowFoabooru = cursor.getInt(idxFoabooru);
                        nowDettobooru = cursor.getInt(idxDettobooru);
                        nowDasuu = cursor.getInt(idxDasuu);
                        nowGihi = cursor.getInt(idxGihi);
                    } while (cursor.moveToNext());
                }
            }
            finally {
                db.close();
            }

            //OPSを算出する式
            int tanda_3 = tanda_2+nowTanda;
            int niruida_3 = niruida_2+nowNiruida;
            int sanruida_3 = sanruida_2+nowSanruida;
            int honruida_3 = honruida_2+nowHonruida;
            int foabooru_3 = foabooru_2+nowFoabooru;
            int dettobooru_3 = dettobooru_2+nowDettobooru;
            int dasuu_3 =  dasuu_2+nowDasuu;
            int gihi_3 = gihi_2+nowGihi;

            double ops = Math.round((tanda_3+niruida_3+sanruida_3+honruida_3+foabooru_3+dettobooru_3)/(dasuu_3+foabooru_3+dettobooru_3+gihi_3)*1000)/1000+Math.round((tanda_3+niruida_3+sanruida_3+honruida_3+foabooru_3+dettobooru_3)/(dasuu_3+foabooru_3+dettobooru_3+gihi_3)*1000)/1000;

            //OPSをデータベースに登録
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET ops = ? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindDouble(1, ops);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //防御率を計算し登録する処理メソッド
    public static void calculateAndRegistrationBougyoritu(String name, String jisekitenn, String toukyuukai, Context context) {
        //投球回のデータが入力されている場合登録する
        if (!toukyuukai.equals("")) {
            //データ型をint型に変換
            int jisekitenn_2 = Integer.parseInt(jisekitenn);
            int toukyuukai_2 = Integer.parseInt(toukyuukai);
            //今のデータのフィード
            int nowJisekitenn = 0;
            int nowToukyuukai = 0;

            //今の自責点、投球回を取得

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();

            try {
                //SQL文の用意
                String sql = "SELECT jisekitenn,toukyuukai FROM baseballscore WHERE name = "+name;
                //SQLの実行
                Cursor cursor = db.rawQuery(sql, null);
                //データを取得
                if (cursor.moveToFirst()) {
                    do {
                        //カラムのインデックス値を取得
                        int idxJisekitenn = cursor.getColumnIndex("jisekitenn");
                        int idxToukyuukai = cursor.getColumnIndex("toukyuukai");
                        //カラムのインデックス値をもとにデータを取得
                        nowJisekitenn = cursor.getInt(idxJisekitenn);
                        nowToukyuukai = cursor.getInt(idxToukyuukai);
                    } while (cursor.moveToNext());
                }
            }
            finally {
                db.close();
            }

            //防御率を算出する式
            int jisekitenn_3 =  jisekitenn_2+nowJisekitenn;
            int toukyuukai_3 = toukyuukai_2+nowToukyuukai;

            double bougyoritu = Math.round((jisekitenn_3*9*3)/(toukyuukai_3*3)*100)/100;

            //防御率をデータベースに登録
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET bougyoritu = ? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindDouble(1, bougyoritu);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

    //守備率を計算し登録する処理メソッド
    public static void calculateAndRegistrationSyubiritu(String name, String syubikikai, String sissaku, Context context) {
        //守備機会のデータが入力されている場合登録する
        if (!syubikikai.equals("")) {
            //データ型をint型に変換
            int syubikikai_2 = Integer.parseInt(syubikikai);
            int sissaku_2 = Integer.parseInt(sissaku);
            //今のデータのフィード
            int nowSyubikikai = 0;
            int nowSissaku = 0;

            //今の守備機会、失策を取得

            //データベースヘルパーオブジェクトを作成
            DatabaseHelper helper = new DatabaseHelper(context);
            //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
            SQLiteDatabase db = helper.getWritableDatabase();

            try {
                //SQL文の用意
                String sql = "SELECT syubikikai,sissaku FROM baseballscore WHERE name = "+name;
                //SQLの実行
                Cursor cursor = db.rawQuery(sql, null);
                //データを取得
                if (cursor.moveToFirst()) {
                    do {
                        //カラムのインデックス値を取得
                        int idxSyubikikai = cursor.getColumnIndex("syubikikai");
                        int idxSissaku = cursor.getColumnIndex("sissaku");
                        //カラムのインデックス値をもとにデータを取得
                        nowSyubikikai = cursor.getInt(idxSyubikikai);
                        nowSissaku = cursor.getInt(idxSissaku);
                    } while (cursor.moveToNext());
                }
            }
            finally {
                db.close();
            }

            //守備率を算出する式
            int syubikikai_3 =  syubikikai_2+nowSyubikikai;
            int sissaku_3 = sissaku_2+nowSissaku;

            double syubiritu = Math.round((syubikikai_3-sissaku_3)/syubikikai_3*1000)/1000;

            //守備率をデータベースに登録
            try {
                //インサート用のSQL文字列を用意
                String sqlUpdate = "UPDATE baseballscore SET syubiritu = ? WHERE name = ?";
                //SQL文字列をもとにプリペアードステートメントを取得
                SQLiteStatement stmt = db.compileStatement(sqlUpdate);
                //変数バインド
                stmt.bindDouble(1, syubiritu);
                stmt.bindString(2, name);
                //アップデートSQLの実行
                stmt.executeUpdateDelete();
            } finally {
                db.close();
            }
        }
    }

}


