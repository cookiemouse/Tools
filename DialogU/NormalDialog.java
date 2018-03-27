package com.gumi.dms.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 * Created by tianyi on 18-3-27.
 */

public class NormalDialog extends ADialogBuilder {

    private static final String TAG = "NormalDialog";

    private static AlertDialog.Builder mDialogBuilder;
    private static AlertDialog mAlertDialog;

    private static NormalDialog mNormalDialog;

    public static NormalDialog with(Context context) {

        mDialogBuilder = new AlertDialog.Builder(context);

        if(mNormalDialog == null) {
            synchronized(NormalDialog.class) {
                if(mNormalDialog == null) {
                    mNormalDialog = new NormalDialog();
                }
            }
        }
        return mNormalDialog;
    }

    @Override
    public AlertDialog build() {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mAlertDialog = mDialogBuilder.create();

        return mAlertDialog;
    }

    @Override
    public void show() {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mAlertDialog = this.build();
        mAlertDialog.show();
    }

    @Override
    public void dismiss() {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mAlertDialog.dismiss();
    }

    @Override
    public NormalDialog setView(View view) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mDialogBuilder.setView(view);
        return mNormalDialog;
    }

    @Override
    public NormalDialog setMessage(String msg) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mDialogBuilder.setMessage(msg);
        return mNormalDialog;
    }

    @Override
    public NormalDialog setMessage(int msgId) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mDialogBuilder.setMessage(msgId);
        return mNormalDialog;
    }

    @Override
    public NormalDialog setCancelable(boolean cancelable) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mDialogBuilder.setCancelable(cancelable);
        return mNormalDialog;
    }

    @Override
    public NormalDialog setPositiveClickListener(String text, DialogInterface.OnClickListener listener) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mDialogBuilder.setPositiveButton(text, listener);
        return mNormalDialog;
    }

    @Override
    public NormalDialog setNegativeClickListener(String text, DialogInterface.OnClickListener listener) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mDialogBuilder.setNegativeButton(text, listener);
        return mNormalDialog;
    }
}
