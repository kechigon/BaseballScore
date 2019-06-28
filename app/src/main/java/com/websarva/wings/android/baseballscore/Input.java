package com.websarva.wings.android.baseballscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);
    }

    //戻るボタンがタップされた時の処理メソッド
    public void onBackButtonClick(View view) {
        //このActivityを終了
        finish();
    }
}
