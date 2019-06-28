package com.websarva.wings.android.baseballscore;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    //選手IDを表すフィールド　登録ボタンが押される度に＋1
    int playerId = 0;
    //選手名を表示するListViewのフィード
    ListView playerMenu;
    //登録ボタンのフィード
    Button entryButton;
    //入力ボタンのフィード
    Button inputButton;
    //ランキングボタンのフィード
    Button rankingButton;
    //選手を入力するEditTextのフィード
    EditText nameEditText;
    //ListViewに項目がないとき表示するビューのフィード
    TextView emptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);

        //登録ボタンを所得
        entryButton = findViewById(R.id.enterButton);
        //選手を入力するEditTextを取得
        nameEditText = findViewById(R.id.nameEditText);
        //選手名を表示するListViewを取得
        playerMenu = findViewById(R.id.playerList);
        //ListViewに項目がない時に表示するビューを取得
        emptyTextView = findViewById(R.id.emptyTextView);
        playerMenu.setEmptyView(emptyTextView);
        //nameEditTextにリスナを登録
        nameEditText.addTextChangedListener(new EditEventListener());
    }

    //登録ボタンがタップされた時の処理メソッド
    public void onEnterButtonClick(View view) {
        //IDを取得
        playerId += 1;
        //入力された選手名を取得
        nameEditText = findViewById(R.id.nameEditText);
        String name = nameEditText.getText().toString();

        //データベースヘルパーオブジェクトを作成
        DatabaseHelper helper = new DatabaseHelper(Home.this);
        //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            //インサート用のSQL文字列の用意
            String sqlInsert = "INSERT INTO baseballscore (_id, name) VALUES (?, ?)";
            //SQL文字列をもとにプリペアドステートメントを取得
            SQLiteStatement stmt = db.compileStatement(sqlInsert);
            //変数バインド
            stmt.bindLong(1,playerId);
            stmt.bindString(2,name);
            //インサートSQLの実行
            stmt.executeInsert();
        }
        finally {
            db.close();
        }
        //入力値を削除
        nameEditText.setText("");
        //登録ボタンをタップできないように変更
        entryButton.setEnabled(false);

        //選手名を表示するListViewを取得
        playerMenu = findViewById(R.id.playerList);
        //データベースヘルパーオブジェクトを作成
        DatabaseHelper dHelper = new DatabaseHelper(Home.this);
        //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
        SQLiteDatabase database = dHelper.getWritableDatabase();

        //ArrayListを作成
        ArrayList<String> item = new ArrayList<>();

        try {
            //SQL文の用意
            String sql = "SELECT * FROM baseballscore";
            //SQLの実行
            Cursor cursor = database.rawQuery(sql, null);
            //データを取得
            if (cursor.moveToFirst()) {
                do {
                    item.add(cursor.getString(1));
                } while (cursor.moveToNext());
            }
        }
        finally {
            database.close();
        }

        //ArrayAdapterのコンストラクタ
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Home.this, android.R.layout.simple_list_item_1, item);
        //ListViewにアダプターをセット
        playerMenu.setAdapter(adapter);
    }

    //入力ボタンがタップされた時の処理メソッド
    public void onInputButtonClick (View view) {
        //インテントオブジェクトを生成
        Intent intent = new Intent(Home.this, Input.class);
        //遷移
        startActivity(intent);
    }

    //ランキングボタンがタップされた時の処理メソッド
    public void onRankingButtonClick(View view) {
        //インテントオブジェクトを生成
        Intent intent = new Intent(Home.this, Ranking.class);
        //遷移
        startActivity(intent);
    }

    //EditText選手名が入力された時の処理が記述されたメンバクラス
    private class EditEventListener implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            //登録ボタンをタップできるように設定
            entryButton.setEnabled(true);
        }
    }
}
