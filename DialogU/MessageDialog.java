package cn.cookiemouse.dialogutils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.Window;

/**
 * Created by tianyi on 18-3-27.
 */

public class MessageDialog extends ADialogBuilder implements IDialogBuilder {

    private static final String TAG = "MessageDialog";

    private static AlertDialog.Builder mDialogBuilder;
    private static AlertDialog mAlertDialog;

    private static MessageDialog mMessageDialog;

    private float mAmount = 0.5f;

    private MessageDialog() {
    }

    public static MessageDialog with(Context context) {

        mDialogBuilder = new AlertDialog.Builder(context);

        if (mMessageDialog == null) {
            synchronized (MessageDialog.class) {
                if (mMessageDialog == null) {
                    mMessageDialog = new MessageDialog();
                }
            }
        }
        return mMessageDialog;
    }

    @Override
    public MessageDialog show() {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("MessageDialog need with Context");
        }
        mAlertDialog = mDialogBuilder.create();

        Window window = mAlertDialog.getWindow();
        if (null != window) {
            window.setDimAmount(mAmount);
        }
        mAlertDialog.show();
        return this;
    }

    @Override
    public void dismiss() {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("MessageDialog is Null");
        }
        mAlertDialog.dismiss();
    }

    @Override
    public MessageDialog setMessage(String msg) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("MessageDialog need with Context");
        }
        mDialogBuilder.setMessage(msg);
        return this;
    }

    @Override
    public MessageDialog setMessage(int msgId) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("MessageDialog need with Context");
        }
        mDialogBuilder.setMessage(msgId);
        return this;
    }

    @Override
    public MessageDialog setCancelable(boolean cancelable) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("MessageDialog need with Context");
        }
        mDialogBuilder.setCancelable(cancelable);
        return this;
    }

    @Override
    public MessageDialog setPositiveClickListener(String text, DialogInterface.OnClickListener listener) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("MessageDialog need with Context");
        }
        mDialogBuilder.setPositiveButton(text, listener);
        return this;
    }

    @Override
    public MessageDialog setNegativeClickListener(String text, DialogInterface.OnClickListener listener) {
        if (null == mDialogBuilder) {
            throw new IllegalArgumentException("MessageDialog need with Context");
        }
        mDialogBuilder.setNegativeButton(text, listener);
        return this;
    }

    @Override
    public MessageDialog setDimAmount(float amount) {
        this.mAmount = amount;
        return this;
    }
}
