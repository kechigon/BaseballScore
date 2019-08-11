package com.websarva.wings.android.baseballscore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
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
    //登録ボタンのフィード
    Button entryButton;

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

        //EditTextに初期値を設定し、リスナを登録
        tandaEditText = view.findViewById(R.id.etTanda);
        tandaEditText.setText("0");
        tandaEditText.addTextChangedListener(new EditEventListener());
        niruidaEditText = view.findViewById(R.id.etNiruida);
        niruidaEditText.setText("0");
        niruidaEditText.addTextChangedListener(new EditEventListener());
        sanruidaEditText = view.findViewById(R.id.etSanruida);
        sanruidaEditText.setText("0");
        sanruidaEditText.addTextChangedListener(new EditEventListener());
        honruidaEditText = view.findViewById(R.id.etHonruida);
        honruidaEditText.setText("0");
        honruidaEditText.addTextChangedListener(new EditEventListener());
        dasuuEditText = view.findViewById(R.id.etDasuu);
        dasuuEditText.setText("0");
        dasuuEditText.addTextChangedListener(new EditEventListener());
        dasekisuuEditText = view.findViewById(R.id.etDasekisuu);
        dasekisuuEditText.setText("0");
        dasekisuuEditText.addTextChangedListener(new EditEventListener());
        datennEditText = view.findViewById(R.id.etDatenn);
        datennEditText.setText("0");
        datennEditText.addTextChangedListener(new EditEventListener());
        tokutennEditText = view.findViewById(R.id.etTokutenn);
        tokutennEditText.setText("0");
        tokutennEditText.addTextChangedListener(new EditEventListener());
        sansinnEditText = view.findViewById(R.id.etSansinn);
        sansinnEditText.setText("0");
        sansinnEditText.addTextChangedListener(new EditEventListener());
        foabooruEditText = view.findViewById(R.id.etFoabooru);
        foabooruEditText.setText("0");
        foabooruEditText.addTextChangedListener(new EditEventListener());
        dettobooruEditText = view.findViewById(R.id.etDettobooru);
        dettobooruEditText.setText("0");
        dettobooruEditText.addTextChangedListener(new EditEventListener());
        touruiEditText = view.findViewById(R.id.etTourui);
        touruiEditText.setText("0");
        touruiEditText.addTextChangedListener(new EditEventListener());
        touruisasareruEditText = view.findViewById(R.id.etTouruisasareru);
        touruisasareruEditText.setText("0");
        touruisasareruEditText.addTextChangedListener(new EditEventListener());
        gidaEditText = view.findViewById(R.id.etGida);
        gidaEditText.setText("0");
        gidaEditText.addTextChangedListener(new EditEventListener());
        gihiEditText = view.findViewById(R.id.etGihi);
        gihiEditText.setText("0");
        gihiEditText.addTextChangedListener(new EditEventListener());
        toukyuukaiEditText = view.findViewById(R.id.etToukyuukai);
        toukyuukaiEditText.setText("0");
        toukyuukaiEditText.addTextChangedListener(new EditEventListener());
        sittennEditText = view.findViewById(R.id.etSittenn);
        sittennEditText.setText("0");
        sittennEditText.addTextChangedListener(new EditEventListener());
        jisekitennEditText = view.findViewById(R.id.etJisekitenn);
        jisekitennEditText.setText("0");
        jisekitennEditText.addTextChangedListener(new EditEventListener());
        datusansinnEditText = view.findViewById(R.id.etDatusansinn);
        datusansinnEditText.setText("0");
        datusansinnEditText.addTextChangedListener(new EditEventListener());
        foabooruAtaeruEditText = view.findViewById(R.id.etFoabooruAtaeru);
        foabooruAtaeruEditText.setText("0");
        foabooruAtaeruEditText.addTextChangedListener(new EditEventListener());
        dettobooruAtaeruEditText = view.findViewById(R.id.etDettobooruAtaeru);
        dettobooruAtaeruEditText.setText("0");
        dettobooruAtaeruEditText.addTextChangedListener(new EditEventListener());
        touruisasuEditText = view.findViewById(R.id.etTouruisasu);
        touruisasuEditText.setText("0");
        touruisasuEditText.addTextChangedListener(new EditEventListener());
        syubikikaiEditText = view.findViewById(R.id.etSyubikikai);
        syubikikaiEditText.setText("0");
        syubikikaiEditText.addTextChangedListener(new EditEventListener());
        sissakuEditText = view.findViewById(R.id.etSissaku);
        sissakuEditText.setText("0");
        sissakuEditText.addTextChangedListener(new EditEventListener());
        syussekiEditText = view.findViewById(R.id.etSyusseki);
        syussekiEditText.setText("0");
        syussekiEditText.addTextChangedListener(new EditEventListener());
        tikokuEditText = view.findViewById(R.id.etTikoku);
        tikokuEditText.setText("0");
        tikokuEditText.addTextChangedListener(new EditEventListener());

        //登録ボタンを取得
        entryButton = view.findViewById(R.id.enterButton_2);

        //登録ボタンをタップできないように変更
        entryButton.setEnabled(false);

        //登録ボタンがタップされた時の処理メソッド
        entryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //入力されたデータを取得
                String tanda = tandaEditText.getText().toString();
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

                //データベースに登録
                DatabaseOperation dbo = new DatabaseOperation();
                //安打を計算しデータベースに登録
                dbo.calculateAndRegistrationAnda(playerName, tanda, niruida, sanruida, honruida, getActivity());
                //打率を計算しデータベースに登録
                dbo.calculateAndRegistrationDariut(playerName, tanda, niruida, sanruida, honruida, dasuu, getActivity());
                //出塁率を計算しデータベースに登録
                dbo.calculateAndRegistrationSyuturuiritu(playerName, tanda, niruida, sanruida, honruida, foabooru, dettobooru, dasuu, gihi, getActivity());
                //長打率を計算しデータベースに登録
                dbo.calculateAndRegistrationChoudaritu(playerName, tanda, niruida, sanruida, honruida, dasuu, getActivity());
                //OPSを計算しデータベースに登録
                dbo.calculateAndRegistrationOPS(playerName, tanda, niruida, sanruida, honruida, foabooru, dettobooru, dasuu, gihi, getActivity());
                //防御率を計算しデータベースに登録
                dbo.calculateAndRegistrationBougyoritu(playerName, jisekitenn, toukyuukai, getActivity());
                //守備率を計算しデータベースに登録
                dbo.calculateAndRegistrationSyubiritu(playerName, syubikikai, sissaku, getActivity());

                dbo.updateTanda(playerName, tanda, getActivity());
                dbo.updateNiruida(playerName, niruida, getActivity());
                dbo.updateSanruida(playerName, sanruida, getActivity());
                dbo.updateHonnruida(playerName, honruida, getActivity());
                dbo.updateDasuu(playerName, dasuu, getActivity());
                dbo.updateDasekisuu(playerName, dasekisuu, getActivity());
                dbo.updateDatenn(playerName, datenn, getActivity());
                dbo.updateTokutenn(playerName, tokutenn, getActivity());
                dbo.updateSansinn(playerName, sansinn, getActivity());
                dbo.updateFoabooru(playerName, foabooru, getActivity());
                dbo.updateDettobooru(playerName, dettobooru, getActivity());
                dbo.updateTourui(playerName, tourui, getActivity());
                dbo.updateTouruisasareru(playerName, touruisasareru, getActivity());
                dbo.updateGida(playerName, gida, getActivity());
                dbo.updateGihi(playerName, gihi, getActivity());
                dbo.updateToukyuukai(playerName, toukyuukai, getActivity());
                dbo.updateSittenn(playerName, sittenn, getActivity());
                dbo.updateJisekitenn(playerName, jisekitenn, getActivity());
                dbo.updateDatusansinn(playerName, datusansinn, getActivity());
                dbo.updateFoabooruataeru(playerName, foabooruataeru, getActivity());
                dbo.updateDettobooruataeru(playerName, dettobooruataeru, getActivity());
                dbo.updateTouruisasu(playerName, touruisasu, getActivity());
                dbo.updateSyubikikai(playerName, syubikikai, getActivity());
                dbo.updateSissaku(playerName, sissaku, getActivity());
                dbo.updateSyusseki(playerName, syusseki, getActivity());
                dbo.updateTikoku(playerName, tikoku, getActivity());

                //入力値を削除
                tandaEditText.setText("0");
                niruidaEditText.setText("0");
                sanruidaEditText.setText("0");
                honruidaEditText.setText("0");
                dasuuEditText.setText("0");
                dasekisuuEditText.setText("0");
                datennEditText.setText("0");
                tokutennEditText.setText("0");
                sansinnEditText.setText("0");
                foabooruEditText.setText("0");
                dettobooruEditText.setText("0");
                touruiEditText.setText("0");
                touruisasareruEditText.setText("0");
                gidaEditText.setText("0");
                gihiEditText.setText("0");
                toukyuukaiEditText.setText("0");
                sittennEditText.setText("0");
                jisekitennEditText.setText("0");
                datusansinnEditText.setText("0");
                foabooruAtaeruEditText.setText("0");
                dettobooruAtaeruEditText.setText("0");
                touruisasuEditText.setText("0");
                syubikikaiEditText.setText("0");
                sissakuEditText.setText("0");
                syussekiEditText.setText("0");
                tikokuEditText.setText("0");

                //登録ボタンをタップできないように変更
                entryButton.setEnabled(false);
            }
        });
        //インフレートされた画面を戻り値として返す
        return view;
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


