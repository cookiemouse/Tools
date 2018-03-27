package com.gumi.dms.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;

/**
 * Created by tianyi on 18-3-27.
 */

public abstract class ADialogBuilder implements IDialogBuilder2{

    private static final String TAG = "ADialogBuilder";

    public abstract void show();

    public abstract void dismiss();

    public abstract AlertDialog build();

    @Override
    public IDialogBuilder2 setView(View view) {
        Log.i(TAG, "setView: ");
        return null;
    }

    @Override
    public IDialogBuilder2 setMessage(String msg) {
        Log.i(TAG, "setMessage: ");
        return null;
    }

    @Override
    public IDialogBuilder2 setMessage(int msgId) {
        Log.i(TAG, "setMessage: ");
        return null;
    }

    @Override
    public IDialogBuilder2 setCancelable(boolean cancelable) {
        Log.i(TAG, "setCancelable: ");
        return null;
    }

    @Override
    public IDialogBuilder2 setPositiveClickListener(String text, DialogInterface.OnClickListener listener) {
        Log.i(TAG, "setPositiveClickListener: ");
        return null;
    }

    @Override
    public IDialogBuilder2 setNegativeClickListener(String text, DialogInterface.OnClickListener listener) {
        Log.i(TAG, "setNegativeClickListener: ");
        return null;
    }
}
