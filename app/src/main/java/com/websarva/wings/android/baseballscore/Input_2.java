package com.websarva.wings.android.baseballscore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class Input_2 extends Fragment {
    //フラグメントで表示する画面のフィード
    View view;
    //選手名のフィード
    String playerName;
    //単打を入力するEditTextのフィード
    EditText tandaEditText;
    //二塁打を入力するEditTextのフィード
    EditText niruidaEditText;
    //三塁打を入力するEditTextのフィード
    EditText sanruidaEditText;
    //本塁打を入力するEditTextのフィード
    EditText honruidaEditText;
    //打数を入力するEditTextのフィード
    EditText dasuuEditText;
    //打席数を入力するEditTextのフィード
    EditText dasekisuuEditText;
    //打点を入力するEditTextのフィード
    EditText datennEditText;
    //得点を入力するEditTextのフィード
    EditText tokutennEditText;
    //三振を入力するEditTextのフィード
    EditText sansinnEditText;
    //四球を入力するEditTextのフィード
    EditText foabooruEditText;
    //死球を入力するEditTextのフィード
    EditText dettobooruEditText;
    //盗塁を入力するEditTextのフィード
    EditText touruiEditText;
    //盗塁死を入力するEditTextのフィード
    EditText touruisasareruEditText;
    //犠打を入力するEditTextのフィード
    EditText gidaEditText;
    //犠飛を入力するEditTextのフィード
    EditText gihiEditText;
    //投球回を入力するEditTextのフィード
    EditText toukyuukaiEditText;
    //失点を入力するEditTextのフィード
    EditText sittennEditText;
    //自責点を入力するEditTextのフィード
    EditText jisekitennEditText;
    //奪三振を入力するEditTextのフィード
    EditText datusansinnEditText;
    //盗塁刺を入力するEditTextのフィード
    EditText touruisasuEditText;
    //守備機会を入力するEditTextのフィード
    EditText syubikikaiEditText;
    //失策を入力するEditTextのフィード
    EditText sissakuEditText;
    //出席を入力するEditTextのフィード
    EditText syussekiEditText;
    //遅刻を入力するEditTextのフィード
    EditText tikokuEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //フラグメントで表示する画面をxmlファイルからインフレートする
        view = inflater.inflate(R.layout.input_2, container, false);

        //引継ぎデータを所得
        Bundle extras = getArguments();
        playerName = extras.getString("playerName");

        //選手名を表示させるTextViewを取得
        TextView tvPlayerName = view.findViewById(R.id.playerName);
        //TextViewに選手名を表示
        tvPlayerName.setText(playerName);
        //インフレートされた画面を戻り値として返す
        return view;
    }

    public void onEnterButtonClick_2() {
        //入力されたデータを取得
        tandaEditText = view.findViewById(R.id.etTanda);
        String tanda =tandaEditText.getText().toString();
        niruidaEditText = view.findViewById(R.id.etNiruida);
        String niruida = niruidaEditText.getText().toString();
        sanruidaEditText = view.findViewById(R.id.etSanruida);
        String sanruida = sanruidaEditText.getText().toString();
        honruidaEditText = view.findViewById(R.id.etHonruida);
        String honruida = honruidaEditText.getText().toString();
        dasuuEditText = view.findViewById(R.id.etDasuu);
        String dasuu = dasuuEditText.getText().toString();
        dasekisuuEditText = view.findViewById(R.id.etDasekisuu);
        String dasekisuu = dasekisuuEditText.getText().toString();
        datennEditText = view.findViewById(R.id.etDatenn);
        String datenn = datennEditText.getText().toString();
        tokutennEditText = view.findViewById(R.id.etTokutenn);
        String tokutenn = tokutennEditText.getText().toString();
        sansinnEditText = view.findViewById(R.id.etSansinn);
        String sansinn = sansinnEditText.getText().toString();
        foabooruEditText = view.findViewById(R.id.etFoabooru);
        String foabooru = foabooruEditText.getText().toString();
        dettobooruEditText = view.findViewById(R.id.etDettobooru);
        String dettobooru = dettobooruEditText.getText().toString();
        touruiEditText = view.findViewById(R.id.etTourui);
        String tourui = touruiEditText.getText().toString();
        touruisasareruEditText = view.findViewById(R.id.etTouruisasareru);
        String touruisasareru = touruisasareruEditText.getText().toString();
        gidaEditText = view.findViewById(R.id.etGida);
        String gida = gidaEditText.getText().toString();
        gihiEditText = view.findViewById(R.id.etGihi);
        String gihi = gihiEditText.getText().toString();
        toukyuukaiEditText = view.findViewById(R.id.etToukyuukai);
        String toukyuukai = toukyuukaiEditText.getText().toString();
        sittennEditText = view.findViewById(R.id.etSittenn);
        String sittenn = sittennEditText.getText().toString();
        jisekitennEditText = view.findViewById(R.id.etJisekitenn);
        String jisekitenn = jisekitennEditText.getText().toString();
        datusansinnEditText = view.findViewById(R.id.etDatusansinn);
        String datusansinn = datusansinnEditText.getText().toString();
        touruisasuEditText = view.findViewById(R.id.etTouruisasu);
        String touruisasu = touruisasuEditText.getText().toString();
        syubikikaiEditText = view.findViewById(R.id.etSyubikikai);
        String syubikikai = syubikikaiEditText.getText().toString();
        sissakuEditText = view.findViewById(R.id.etSissaku);
        String sissaku = sissakuEditText.getText().toString();
        syussekiEditText = view.findViewById(R.id.etSyusseki);
        String syusseki = syussekiEditText.getText().toString();
        tikokuEditText = view.findViewById(R.id.etTikoku);
        String tikoku = tikokuEditText.getText().toString();

        //データベースに登録
        DatabaseOperation.updateTanda(playerName, tanda, getActivity());
        DatabaseOperation.updateNiruida(playerName, niruida, getActivity());
        DatabaseOperation.updateSanruida(playerName, sanruida, getActivity());
        DatabaseOperation.updateHonnruida(playerName, honruida, getActivity());
        DatabaseOperation.updateDasuu(playerName, dasuu, getActivity());
        DatabaseOperation.updateDasekisuu(playerName, dasekisuu, getActivity());
        DatabaseOperation.updateDatenn(playerName, datenn, getActivity());
        DatabaseOperation.updateTokutenn(playerName, tokutenn, getActivity());
        DatabaseOperation.updateSansinn(playerName, sansinn, getActivity());
        DatabaseOperation.updateFoabooru(playerName, foabooru, getActivity());
        DatabaseOperation.updateDettobooru(playerName, dettobooru, getActivity());
        DatabaseOperation.updateTourui(playerName, tourui, getActivity());
        DatabaseOperation.updateTouruisasareru(playerName, touruisasareru, getActivity());
        DatabaseOperation.updateGida(playerName, gida, getActivity());
        DatabaseOperation.updateGihi(playerName, gihi, getActivity());
        DatabaseOperation.updateToukyuukai(playerName, toukyuukai, getActivity());
        DatabaseOperation.updateSittenn(playerName, sittenn, getActivity());
        DatabaseOperation.updateJisekitenn(playerName, jisekitenn, getActivity());
        DatabaseOperation.updateDatusansinn(playerName, datusansinn, getActivity());
        DatabaseOperation.updateTouruisasu(playerName, touruisasu, getActivity());
        DatabaseOperation.updateSyubikikai(playerName, syubikikai, getActivity());
        DatabaseOperation.updateSissaku(playerName, sissaku, getActivity());
        DatabaseOperation.updateSyusseki(playerName, syusseki, getActivity());
        DatabaseOperation.updateTikoku(playerName, tikoku, getActivity());

        //安打を計算しデータベースに登録
        DatabaseOperation.calculateAndRegistrationAnda(playerName,tanda,niruida,sanruida,honruida,getActivity());
        //打率を計算しデータベースに登録
        DatabaseOperation.calculateAndRegistrationDariut(playerName,tanda,niruida,sanruida,honruida,dasuu,getActivity());
        //出塁率を計算しデータベースに登録
        DatabaseOperation.calculateAndRegistrationSyuturuiritu(playerName,tanda,niruida,sanruida,honruida,foabooru,dettobooru,dasuu,gihi,getActivity());
        //長打率を計算しデータベースに登録
        DatabaseOperation.calculateAndRegistrationChoudaritu(playerName,tanda,niruida,sanruida,honruida,dasuu,getActivity());
        //OPSを計算しデータベースに登録
        DatabaseOperation.calculateAndRegistrationOPS(playerName,tanda,niruida,sanruida,honruida,foabooru,dettobooru,dasuu,gihi,getActivity());
        //防御率を計算しデータベースに登録
        DatabaseOperation.calculateAndRegistrationBougyoritu(playerName,jisekitenn,toukyuukai,getActivity());
        //守備率を計算しデータベースに登録
        DatabaseOperation.calculateAndRegistrationSyubiritu(playerName,syubikikai,sissaku,getActivity());
    }

}
