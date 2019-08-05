package com.websarva.wings.android.baseballscore;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

public class RemovePlayerDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //ダイアログビルダーを生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //ダイアログのタイトルを設定
        builder.setTitle("選手を削除");
        //ダイアログのメッセージを設定
        builder.setMessage("選手を削除しますか？");
        //positive Buttonを設定
        builder.setPositiveButton("はい", new DialogButtonClickListener());
        //negative Buttonを設定
        builder.setNegativeButton("いいえ", new DialogButtonClickListener());
        //ダイアログオブジェクトを生成し、リターン
        AlertDialog dialog = builder.create();
        return dialog;
    }

    public class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //引継ぎデータを取得
            Bundle extras = getArguments();
            String playerName = extras.getString("playerName");

            //データベースオペレーションオブジェクトを生成
            DatabaseOperation dbo = new DatabaseOperation();
            // タップされたアクションボタンで分岐
            switch (which) {
                //positive Buttonならば
                case DialogInterface.BUTTON_POSITIVE:
                    dbo.deletePlayerName(playerName, getActivity());
                    Toast.makeText(getActivity(), "削除しました", Toast.LENGTH_LONG).show();
                    //HomeActivityを呼ぶ
                    Home callingActivity = (Home) getActivity();
                    //HomeActivityのonReturnValueを呼ぶ
                    callingActivity.deleteLine(playerName);
                    break;
                //negative Buttonならば
                case DialogInterface.BUTTON_NEGATIVE:
                    break;
            }
        }
    }
}
