package cn.cookiemouse.dialogutils;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.Window;

/**
 * Created by tianyi on 18-4-2.
 */

public class ViewDialog extends ADialogBuilder {

    private static final String TAG = "ViewDialog";

    private static Dialog mDialog;

    private static ViewDialog mViewDialog;

    public static ViewDialog with(Context context) {
        Log.i(TAG, "with: ");

        mDialog = new Dialog(context, R.style.DialogTranslate);

        if (mViewDialog == null) {
            synchronized (LoadingDialog.class) {
                if (mViewDialog == null) {
                    mViewDialog = new ViewDialog();
                }
            }
        }

        return mViewDialog;
    }

    @Override
    public ViewDialog show() {
        mDialog.show();
        return this;
    }

    @Override
    public void dismiss() {
        if (null == mDialog) {
            throw new NullPointerException("AlertDialog is Null");
        }
        mDialog.dismiss();
    }

    @Override
    public ViewDialog setCancelable(boolean cancelable) {
        mDialog.setCancelable(cancelable);
        return this;
    }

    public ViewDialog setView(View view) {
        mDialog.setContentView(view);
        return this;
    }

    @Override
    public ViewDialog setDimAmount(float amount) {
        Window window = mDialog.getWindow();
        if (null != window) {
            window.setDimAmount(amount);
        }
        return this;
    }
}
