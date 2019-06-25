package com.websarva.wings.android.baseballscore;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Home extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);

        //選手を入力するEditTextを取得
        nameEditText = findViewById(R.id.nameEditText);
        //nameEditTextにリスナを登録
        nameEditText.addTextChangedListener(new EditEventListener());
    }

    //登録ボタンがタップされた時の処理メソッド
    public void onEnterButtonClick(View view) {
        //入力された選手名を取得
        nameEditText = findViewById(R.id.nameEditText);
        String name = nameEditText.getText().toString();

        //データベースヘルパーオブジェクトを作成
        DatabaseHelper helper = new DatabaseHelper(Home.this);
        //データベースヘルパーオブジェクトからデータベース接続オブジェクトを取得
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            //インサート用のSQL文字列の用意
            String sqlInsert = "INSERT INTO baseballscore (name) VALUES (?)";
            //SQL文字列をもとにプリペアドステートメントを取得
            SQLiteStatement stmt = db.compileStatement(sqlInsert);
            //変数バインド
            stmt.bindString(1,name);
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
