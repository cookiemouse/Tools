package com.gumi.dms.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 * Created by tianyi on 18-3-27.
 */

public interface IDialogBuilder {

    IDialogBuilder with(Context context);

    IDialogBuilder setView(View view);

    IDialogBuilder setMessage(String msg);

    IDialogBuilder setMessage(int msgId);

    IDialogBuilder setCancelable(boolean cancelable);

    IDialogBuilder setPositiveClickListener(String text, DialogInterface.OnClickListener listener);

    IDialogBuilder setNegativeClickListener(String text, DialogInterface.OnClickListener listener);

    IDialogBuilder setBackgroundTransparent(boolean transparent);

    IDialogBuilder showLoading(boolean loading);

    AlertDialog build();

    void show();

    void dismiss();
}
