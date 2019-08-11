package com.websarva.wings.android.baseballscore;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);

        //選手を選択するSpinnerを取得
        Spinner pSelectSpinner = findViewById(R.id.playerSelectSpinner);
        //選手が登録されていない場合表示するTextViewを取得
        TextView playerEmpty = findViewById(R.id.playerEmpty);

        //ArrayListを作成
        ArrayList<String> item = new ArrayList<>();
        //データベースから選手名を取得
        DatabaseOperation dbo = new DatabaseOperation();
        dbo.returnPlayerName(item, Input.this);
        //ArrayAdapterのコンストラクタ
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, item);
        //リストに表示するレイアウトを指定
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Spinnerにアダプターをセット
        pSelectSpinner.setAdapter(adapter);
        //Spinnerにリスナを登録
        pSelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //タップされた行のデータを取得
                String playerName = (String) parent.getItemAtPosition(position);
                //引継ぎデータをまとめて格納できるbundleオブジェクト生成
                Bundle bundle = new Bundle();
                //bundleオブジェクト引継ぎデータを格納
                bundle.putString("playerName", playerName);

                //フラグメントマネージャーの取得
                FragmentManager manager = getSupportFragmentManager();
                //フラグメンテーションの開始
                FragmentTransaction transaction = manager.beginTransaction();
                //Input_2を生成
                Input_2 input_2 = new Input_2();
                //引継ぎデータをInput_2に格納
                input_2.setArguments(bundle);
                //生成したInput_2をinput_2Fragmentレイアウト部品に追加または切り替え
                transaction.replace(R.id.input_2Fragment, input_2);
                //フラグメントトランザクションのコミット
                transaction.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //選手が登録されていなかったら「選手が登録されていません」を表示
        if (!item.isEmpty()) {
            playerEmpty.setVisibility(View.INVISIBLE);
        }
    }

    //戻るボタンがタップされた時の処理メソッド
    public void onBackButtonClick(View view) {
        //このActivityを終了
        finish();
    }

}
