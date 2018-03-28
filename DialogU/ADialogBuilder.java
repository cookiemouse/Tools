package com.gumi.dms.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;

/**
 * Created by tianyi on 18-3-27.
 */

public abstract class ADialogBuilder{

    private static final String TAG = "ADialogBuilder";

    public abstract void show();

    public abstract void dismiss();

    public abstract ADialogBuilder setCancelable(boolean cancelable);

    public abstract AlertDialog build();
}
