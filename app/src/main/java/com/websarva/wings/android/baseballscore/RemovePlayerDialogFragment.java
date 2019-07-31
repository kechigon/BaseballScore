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
        builder.setTitle(R.string.dialog_title);
        //ダイアログのメッセージを設定
        builder.setMessage(R.string.dialog_msg);
        //positive Buttonを設定
        builder.setPositiveButton(R.string.dialog_yes, new DialogButtonClickListener());
        //negative Buttonを設定
        builder.setNegativeButton(R.string.dialog_no, new  DialogButtonClickListener());
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
            //タップされたアクションボタンで分岐
            switch (which) {
                //positive Buttonならば
                case DialogInterface.BUTTON_POSITIVE:
                    DatabaseOperation.deletePlayerName(playerName, getActivity());
                    Toast.makeText(getActivity(), "削除しました", Toast.LENGTH_LONG).show();
                    //HomeActivityを呼ぶ
                    Home callingActivity = (Home)getActivity();
                    //HomeActivityのonReturnValueを呼ぶ
                    callingActivity.onReturnValue(playerName);
                    break;
                //negative Buttonならば
                case  DialogInterface.BUTTON_NEGATIVE:
                    break;
            }
        }
    }
}
