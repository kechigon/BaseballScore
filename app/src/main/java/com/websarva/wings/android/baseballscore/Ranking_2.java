package com.websarva.wings.android.baseballscore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

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

        //選択された項目が投球回だったら昇順、それ以外だったら降順
        if (rankingName == "投球回") {
            //ArrayListを作成
            ArrayList<String> item = new ArrayList<>();
            //データベースから投球を昇順に取得
            DatabaseOperation.returnToukyuukaiRanking(item, rankingName, getContext());
            //ArrayAdapterのコンストラクタ
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, item);
            //ListViewにアダプターをセット
            rankingMenu.setAdapter(adapter);
        }else {
            //ArrayListを作成
            ArrayList<String> item = new ArrayList<>();
            //データベースから選択された項目を降順に取得
            DatabaseOperation.returnRanking(item, rankingName, getContext());
            //ArrayAdapterのコンストラクタ
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, item);
            //ListViewにアダプターをセット
            rankingMenu.setAdapter(adapter);
        }

        //インフレートされた画面を戻り値として返す
        return view;
    }

}
