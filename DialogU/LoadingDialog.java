package com.gumi.dms.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.gumi.dms.R;

/**
 * Created by tianyi on 18-3-27.
 */

public class LoadingDialog extends ADialogBuilder {

    private static final String TAG = "LoadingDialog";

    private static AlertDialog.Builder mBuilder;
    private static AlertDialog mAlertDialog;

    private static LoadingDialog mLoadingDialog;

    public static LoadingDialog with(Context context) {
        Log.i(TAG, "with: ");
        mBuilder = new AlertDialog.Builder(context);
        View mLoadingView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
        SwipeRefreshLayout swipeRefreshLayout = mLoadingView.findViewById(R.id.srl_dialog_fragment);
        swipeRefreshLayout.setColorSchemeColors(0xff3cabfa);
        swipeRefreshLayout.setRefreshing(true);
        mBuilder.setView(mLoadingView);

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
        mBuilder.setCancelable(cancelable);
        return this;
    }

    @Override
    public LoadingDialog show() {
        Log.i(TAG, "show: ");
        if (null == mBuilder) {
            throw new IllegalArgumentException("LoadingDialog need with Context");
        }
        mAlertDialog = mBuilder.create();
        Window window = mAlertDialog.getWindow();
        if (null != window) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        mAlertDialog.show();
        return this;
    }

    @Override
    public void dismiss() {
        if (null == mAlertDialog) {
            throw new NullPointerException("AlertDialog is Null");
        }
        mAlertDialog.dismiss();
    }
}
