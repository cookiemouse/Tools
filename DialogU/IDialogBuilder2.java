package com.gumi.dms.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 * Created by tianyi on 18-3-27.
 */

public interface IDialogBuilder2 {

    IDialogBuilder2 setView(View view);

    IDialogBuilder2 setMessage(String msg);

    IDialogBuilder2 setMessage(int msgId);

    IDialogBuilder2 setCancelable(boolean cancelable);

    IDialogBuilder2 setPositiveClickListener(String text, DialogInterface.OnClickListener listener);

    IDialogBuilder2 setNegativeClickListener(String text, DialogInterface.OnClickListener listener);
}
