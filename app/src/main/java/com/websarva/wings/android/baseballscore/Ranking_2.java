package com.websarva.wings.android.baseballscore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ranking_2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //フラグメントで表示する画面をxmlファイルからインフレーとする
        View view = inflater.inflate(R.layout.ranking_2, container, false);
        //ランキングを表示するListを取得
        ListView rankingMenu = view.findViewById(R.id.rankingList);
        TextView emptyTextView = view.findViewById(R.id.emptyTextView_2);

        //rankingMenuに項目がなかった時のTextView
        rankingMenu.setEmptyView(emptyTextView);

        //引継ぎデータを取得
        Bundle extras = getArguments();
        String rankingName = extras.getString("rankingName");

        //ランキング名を表示させるTextViewを取得
        TextView tvPlayerName = view.findViewById(R.id.rankingName);
        //TextViewにランキング名を表示
        tvPlayerName.setText(rankingName);

        //ランキングを表示するListViewを表示

        //データベースオペレーションオブジェクトを生成
        DatabaseOperation dbo = new DatabaseOperation();

        //選択された項目が投球回だったら昇順、それ以外だったら降順
        if (rankingName == "防御率") {
            //SimpleAdapterで使用するListオブジェクトを用意
            List<Map<String, String>> rankingList = new ArrayList<>();
            //データベースから選択された項目を降順に取得
            rankingList = dbo.returnBougyorituiRanking(rankingList, rankingName, getActivity());
            //SimpleAdapterの第4引数from用のデータを用意
            String[] from = {"name", "score"};
            //SimpleAdapter第4引数のto用データの用意
            int[] to = {R.id.tvPlayerName, R.id.tvScore};
            //SimpleAdapterを生成
            SimpleAdapter adapter = new SimpleAdapter(getActivity(), rankingList, R.layout.row, from, to);
            //ListViewにアダプターをセット
            rankingMenu.setAdapter(adapter);
        } else {
            //SimpleAdapterで使用するListオブジェクトを用意
            List<Map<String, String>> rankingList = new ArrayList<>();
            //データベースから選択された項目を降順に取得
            rankingList = dbo.returnRanking(rankingList, rankingName, getActivity());
            //SimpleAdapterの第4引数from用のデータを用意
            String[] from = {"name", "score"};
            //SimpleAdapter第4引数のto用データの用意
            int[] to = {R.id.tvPlayerName, R.id.tvScore};
            //SimpleAdapterを生成
            SimpleAdapter adapter = new SimpleAdapter(getActivity(), rankingList, R.layout.row, from, to);
            //ListViewにアダプターをセット
            rankingMenu.setAdapter(adapter);
        }

        //インフレートされた画面を戻り値として返す
        return view;
    }

}
