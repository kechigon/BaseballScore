package com.websarva.wings.android.baseballscore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    //与四球を入力するEditTextのフィード
    EditText foabooruAtaeruEditText;
    //奪三振を入力するEditTextのフィード
    EditText dettobooruAtaeruEditText;
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

        //EditTextに初期値を設定
        tandaEditText = view.findViewById(R.id.etTanda);
        tandaEditText.setText("0");
        niruidaEditText = view.findViewById(R.id.etNiruida);
        niruidaEditText.setText("0");
        sanruidaEditText = view.findViewById(R.id.etSanruida);
        sanruidaEditText.setText("0");
        honruidaEditText = view.findViewById(R.id.etHonruida);
        honruidaEditText.setText("0");
        dasuuEditText = view.findViewById(R.id.etDasuu);
        dasuuEditText.setText("0");
        dasekisuuEditText = view.findViewById(R.id.etDasekisuu);
        dasekisuuEditText.setText("0");
        datennEditText = view.findViewById(R.id.etDatenn);
        datennEditText.setText("0");
        tokutennEditText = view.findViewById(R.id.etTokutenn);
        tokutennEditText.setText("0");
        sansinnEditText = view.findViewById(R.id.etSansinn);
        sansinnEditText.setText("0");
        foabooruEditText = view.findViewById(R.id.etFoabooru);
        foabooruEditText.setText("0");
        dettobooruEditText = view.findViewById(R.id.etDettobooru);
        dettobooruEditText.setText("0");
        touruiEditText = view.findViewById(R.id.etTourui);
        touruiEditText.setText("0");
        touruisasareruEditText = view.findViewById(R.id.etTouruisasareru);
        touruisasareruEditText.setText("0");
        gidaEditText = view.findViewById(R.id.etGida);
        gidaEditText.setText("0");
        gihiEditText = view.findViewById(R.id.etGihi);
        gihiEditText.setText("0");
        toukyuukaiEditText = view.findViewById(R.id.etToukyuukai);
        toukyuukaiEditText.setText("0");
        sittennEditText = view.findViewById(R.id.etSittenn);
        sittennEditText.setText("0");
        jisekitennEditText = view.findViewById(R.id.etJisekitenn);
        jisekitennEditText.setText("0");
        datusansinnEditText = view.findViewById(R.id.etDatusansinn);
        datusansinnEditText.setText("0");
        foabooruAtaeruEditText = view.findViewById(R.id.etFoabooruAtaeru);
        foabooruAtaeruEditText.setText("0");
        dettobooruAtaeruEditText = view.findViewById(R.id.etDettobooruAtaeru);
        dettobooruAtaeruEditText.setText("0");
        touruisasuEditText = view.findViewById(R.id.etTouruisasu);
        touruisasuEditText.setText("0");
        syubikikaiEditText = view.findViewById(R.id.etSyubikikai);
        syubikikaiEditText.setText("0");
        sissakuEditText = view.findViewById(R.id.etSissaku);
        sissakuEditText.setText("0");
        syussekiEditText = view.findViewById(R.id.etSyusseki);
        syussekiEditText.setText("0");
        tikokuEditText = view.findViewById(R.id.etTikoku);
        tikokuEditText.setText("0");

        //登録ボタンを取得
        Button entryButton = view.findViewById(R.id.enterButton_2);
        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //入力されたデータを取得
                String tanda =tandaEditText.getText().toString();
                String niruida = niruidaEditText.getText().toString();
                String sanruida = sanruidaEditText.getText().toString();
                String honruida = honruidaEditText.getText().toString();
                String dasuu = dasuuEditText.getText().toString();
                String dasekisuu = dasekisuuEditText.getText().toString();
                String datenn = datennEditText.getText().toString();
                String tokutenn = tokutennEditText.getText().toString();
                String sansinn = sansinnEditText.getText().toString();
                String foabooru = foabooruEditText.getText().toString();
                String dettobooru = dettobooruEditText.getText().toString();
                String tourui = touruiEditText.getText().toString();
                String touruisasareru = touruisasareruEditText.getText().toString();
                String gida = gidaEditText.getText().toString();
                String gihi = gihiEditText.getText().toString();
                String toukyuukai = toukyuukaiEditText.getText().toString();
                String sittenn = sittennEditText.getText().toString();
                String jisekitenn = jisekitennEditText.getText().toString();
                String datusansinn = datusansinnEditText.getText().toString();
                String foabooruataeru = foabooruAtaeruEditText.getText().toString();
                String dettobooruataeru = dettobooruAtaeruEditText.getText().toString();
                String touruisasu = touruisasuEditText.getText().toString();
                String syubikikai = syubikikaiEditText.getText().toString();
                String sissaku = sissakuEditText.getText().toString();
                String syusseki = syussekiEditText.getText().toString();
                String tikoku = tikokuEditText.getText().toString();

                //

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
                DatabaseOperation.updateFoabooruataeru(playerName,foabooruataeru,getActivity());
                DatabaseOperation.updateDettobooruataeru(playerName,dettobooruataeru,getActivity());
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
        });
        //インフレートされた画面を戻り値として返す
        return view;
    }

}
