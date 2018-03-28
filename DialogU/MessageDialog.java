package com.gumi.dms.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

/**
 * Created by tianyi on 18-3-27.
 */

public class MessageDialog extends ADialogBuilder implements IDialogBuilder {

    private static final String TAG = "MessageDialog";

    private static AlertDialog.Builder mDialogBuilder;
    private static AlertDialog mAlertDialog;

    private static MessageDialog mMessageDialog;

    public static MessageDialog with(Context context) {

        mDialogBuilder = new AlertDialog.Builder(context);

        if(mMessageDialog == null) {
            synchronized(MessageDialog.class) {
                if(mMessageDialog == null) {
                    mMessageDialog = new MessageDialog();
                }
            }
        }
        return mMessageDialog;
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
    public MessageDialog setView(View view) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mDialogBuilder.setView(view);
        return mMessageDialog;
    }

    @Override
    public MessageDialog setMessage(String msg) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mDialogBuilder.setMessage(msg);
        return mMessageDialog;
    }

    @Override
    public MessageDialog setMessage(int msgId) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mDialogBuilder.setMessage(msgId);
        return mMessageDialog;
    }

    @Override
    public MessageDialog setCancelable(boolean cancelable) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mDialogBuilder.setCancelable(cancelable);
        return mMessageDialog;
    }

    @Override
    public MessageDialog setPositiveClickListener(String text, DialogInterface.OnClickListener listener) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mDialogBuilder.setPositiveButton(text, listener);
        return mMessageDialog;
    }

    @Override
    public MessageDialog setNegativeClickListener(String text, DialogInterface.OnClickListener listener) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("DialogU need with Context");
        }
        mDialogBuilder.setNegativeButton(text, listener);
        return mMessageDialog;
    }
}
