package com.websarva.wings.android.baseballscore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    //選手名を表示するListViewのフィード
    ListView playerMenu;
    //登録ボタンのフィード
    Button entryButton;
    //選手を入力するEditTextのフィード
    EditText nameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);

        //登録ボタンを取得
        entryButton = findViewById(R.id.enterButton);
        //選手を入力するEditTextを取得
        nameEditText = findViewById(R.id.nameEditText);
        //選手名を表示するListViewを取得
        playerMenu = findViewById(R.id.playerList);

        //登録ボタンをタップできないように変更
        entryButton.setEnabled(false);

        //nameEditTextにリスナを登録
        nameEditText.addTextChangedListener(new EditEventListener());

        //ArrayListを作成
        ArrayList<String> item = new ArrayList<>();
        //データベースから選手名を取得
        DatabaseOperation dbo = new DatabaseOperation();
        dbo.returnPlayerName(item, Home.this);
        //ArrayAdapterのコンストラクタ
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Home.this, android.R.layout.simple_list_item_1, item);
        //ListViewにアダプターをセット
        playerMenu.setAdapter(adapter);

        //ListViewに項目がない時に表示するビューを取得
        TextView emptyTextView = findViewById(R.id.emptyTextView);
        playerMenu.setEmptyView(emptyTextView);

        //playerMenuに長押しした時のリスナを登録
        playerMenu.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //長押しした行の選手名を取得
                String playerName = (String) parent.getItemAtPosition(position);
                //引継ぎデータをまとめて格納できるBundleオブジェクトを生成
                Bundle bundle = new Bundle();
                //Bundleオブジェクトに引継ぎデータを格納
                bundle.putString("playerName", playerName);

                //選手削除ダイアログフラグメントを生成
                RemovePlayerDialogFragment dialogFragment = new RemovePlayerDialogFragment();
                //引継ぎデータを選手削除ダイアログフラグメントに格納
                dialogFragment.setArguments(bundle);
                //ダイアログを表示
                dialogFragment.show(getSupportFragmentManager(), "RemovePlayerDialogFragment");
                return true;
            }
        });
    }

    //選手が削除された行を削除
    public void deleteLine(String name) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) playerMenu.getAdapter();
        adapter.remove(name);
    }

    //登録ボタンがタップされた時の処理メソッド
    public void onEnterButtonClick(View view) {
        //入力された選手名を取得
        String name = nameEditText.getText().toString();

        //データベースに選手名を登録
        DatabaseOperation dbo = new DatabaseOperation();
        dbo.insertPlayerName(name, Home.this);
        //入力値を削除
        nameEditText.setText("");
        //登録ボタンをタップできないように変更
        entryButton.setEnabled(false);

        //ArrayListを作成
        ArrayList<String> item = new ArrayList<>();
        //データベースから選手名を取得
        dbo.returnPlayerName(item, Home.this);
        //ArrayAdapterのコンストラクタ
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Home.this, android.R.layout.simple_list_item_1, item);
        //ListViewにアダプターをセット
        playerMenu.setAdapter(adapter);
    }

    //入力ボタンがタップされた時の処理メソッド
    public void onInputButtonClick(View view) {
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

    //EditTextに選手名が入力された時の処理が記述されたメンバクラス
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
