package cn.cookiemouse.dialogutils;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

/**
 * Created by tianyi on 18-3-27.
 */

public class LoadingDialog extends ADialogBuilder {

    private static final String TAG = "LoadingDialog";

    private static Dialog mDialog;

    private static LoadingDialog mLoadingDialog;

    public static LoadingDialog with(Context context) {
        Log.i(TAG, "with: ");
        View mLoadingView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        SwipeRefreshLayout swipeRefreshLayout = mLoadingView.findViewById(R.id.srl_dialog);
        swipeRefreshLayout.setColorSchemeColors(0xff3cabfa);
        swipeRefreshLayout.setRefreshing(true);

        mDialog = new Dialog(context, R.style.DialogTranslate);
//        mDialog.setCancelable(false);
        mDialog.setContentView(mLoadingView);

        if (mLoadingDialog == null) {
            synchronized (LoadingDialog.class) {
                if (mLoadingDialog == null) {
                    mLoadingDialog = new LoadingDialog();
                }
            }
        }

        return mLoadingDialog;
    }

    @Override
    public LoadingDialog setCancelable(boolean cancelable) {
        Log.i(TAG, "setCancelable: ");
        mDialog.setCancelable(cancelable);
        return this;
    }

    @Override
    public LoadingDialog show() {
        Log.i(TAG, "show: ");
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
    public LoadingDialog setDimAmount(float amount) {
        Window window = mDialog.getWindow();
        if (null != window) {
            window.setDimAmount(amount);
        }
        return this;
    }
}
