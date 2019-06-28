package com.websarva.wings.android.baseballscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Ranking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking);
    }

    //戻るボタンがタップされた時の処理メソッド
    public void onBackButton_2Click(View view) {
        //このActivityを終了
        finish();
    }
}
