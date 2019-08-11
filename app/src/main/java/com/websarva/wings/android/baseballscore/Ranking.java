package com.websarva.wings.android.baseballscore;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking);

        //ランキング項目を選択するSpinnerを取得
        Spinner rSelectSpinner = findViewById(R.id.rankingSelectSpinner);

        //ArrayListを作成
        ArrayList<String> item = new ArrayList<>();
        item.add("安打");
        item.add("打率");
        item.add("打点");
        item.add("得点");
        item.add("単打");
        item.add("二塁打");
        item.add("三塁打");
        item.add("本塁打");
        item.add("三振");
        item.add("四球");
        item.add("死球");
        item.add("出塁率");
        item.add("OPS");
        item.add("長打率");
        item.add("盗塁");
        item.add("盗塁死");
        item.add("犠打");
        item.add("犠飛");
        item.add("投球回");
        item.add("失点");
        item.add("自責点");
        item.add("与四球");
        item.add("与死球");
        item.add("奪三振");
        item.add("防御率");
        item.add("盗塁刺");
        item.add("守備率");
        item.add("失策");
        item.add("出席");
        item.add("遅刻");
        //Adapterのコンストラクタ
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, item);
        //リストに表示するレイアウトを指定
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Spinnerにアダプターをセット
        rSelectSpinner.setAdapter(adapter);
        //スピナーにリスナを登録
        rSelectSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //タップされた行のデータを取得
                String rankingName = (String) parent.getItemAtPosition(position);
                //引継ぎデータをまとめて格納できるbundleオブジェクト生成
                Bundle bundle = new Bundle();
                //bundleオブジェクト引継ぎデータを格納
                bundle.putString("rankingName", rankingName);

                //フラグメントマネージャーの取得
                FragmentManager manager = getSupportFragmentManager();
                //フラグメンテーションの開始
                FragmentTransaction transaction = manager.beginTransaction();
                //Ranking_2を生成
                Ranking_2 ranking_2 = new Ranking_2();
                //引継ぎデータをRanking_2に格納
                ranking_2.setArguments(bundle);
                //生成したRanking_2をranking_2Fragmentレイアウト部品に追加または切り替え
                transaction.replace(R.id.ranking_2Fragment, ranking_2);
                //フラグメントトランザクションのコミット
                transaction.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    //戻るボタンがタップされた時の処理メソッド
    public void onBackButton_2Click(View view) {
        //このActivityを終了
        finish();
    }

}
