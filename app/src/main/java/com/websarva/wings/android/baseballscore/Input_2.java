package com.websarva.wings.android.baseballscore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Input_2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //フラグメントで表示する画面をxmlファイルからインフレーとする
        View view = inflater.inflate(R.layout.input_2, container, false);

        //引継ぎデータを所得
        Bundle extras = getArguments();
        String playerName = extras.getString("playerName");

        //選手名を表示させるTextViewを取得
        TextView tvPlayerName = view.findViewById(R.id.playerName);
        //TextViewに選手名を表示
        tvPlayerName.setText(playerName);
        //インフレートされた画面を戻り値として返す
        return view;
    }

}
