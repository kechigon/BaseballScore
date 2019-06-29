package com.websarva.wings.android.baseballscore;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Input extends AppCompatActivity {
     //選手を選択するSpinnerのフィード
    Spinner  pSelectSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);

        //選手を選択するSpinnerを取得
        pSelectSpinner = findViewById(R.id.playerSelectSpinner);

        //ArrayListを作成
        ArrayList<String> item = new ArrayList<>();
        //データベースから選手名を取得
        DatabaseOperation.returnItem(item, Input.this);
        //ArrayAdapterのコンストラクタ
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, item);
        //リストに表示するレイアウトを指定
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Spinnerにアダプターをセット
        pSelectSpinner.setAdapter(adapter);
    }

    //戻るボタンがタップされた時の処理メソッド
    public void onBackButtonClick(View view) {
        //このActivityを終了
        finish();
    }
}
