package com.gumi.dms.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.gumi.dms.R;

/**
 * Created by tianyi on 18-3-27.
 */

public class DialogU {

    private static DialogBuilder mDialogBuilder;
    private static AlertDialog.Builder mBuilder;

    public static DialogBuilder with(Context context) {
        mDialogBuilder = new DialogBuilder();
        mBuilder = new AlertDialog.Builder(context);
        return mDialogBuilder;
    }

    public static class DialogBuilder implements IDialogBuilder {

        private AlertDialog mAlertDialog;
        private boolean mTransparent = false;

        @Override
        public IDialogBuilder with(Context context) {
            return this;
        }

        @Override
        public IDialogBuilder setView(View view) {
            if (null == mBuilder) {
                throw new IllegalArgumentException("DialogU need with Context");
            }
            mBuilder.setView(view);
            return this;
        }

        @Override
        public IDialogBuilder setCancelable(boolean cancelable) {
            if (null == mBuilder) {
                throw new IllegalArgumentException("DialogU need with Context");
            }
            mBuilder.setCancelable(cancelable);
            return this;
        }

        @Override
        public IDialogBuilder setMessage(String msg) {
            if (null == mBuilder) {
                throw new IllegalArgumentException("DialogU need with Context");
            }
            mBuilder.setMessage(msg);
            return this;
        }

        @Override
        public IDialogBuilder setMessage(int msgId) {
            if (null == mBuilder) {
                throw new IllegalArgumentException("DialogU need with Context");
            }
            mBuilder.setMessage(msgId);
            return this;
        }

        @Override
        public IDialogBuilder setPositiveClickListener(String text, DialogInterface.OnClickListener listener) {
            if (null == mBuilder) {
                throw new IllegalArgumentException("DialogU need with Context");
            }
            mBuilder.setPositiveButton(text, listener);
            return this;
        }

        @Override
        public IDialogBuilder setNegativeClickListener(String text, DialogInterface.OnClickListener listener) {
            if (null == mBuilder) {
                throw new IllegalArgumentException("DialogU need with Context");
            }
            mBuilder.setNegativeButton(text, listener);
            return this;
        }

        @Override
        public IDialogBuilder showLoading(Context context, boolean loading) {
            if (null == mBuilder) {
                throw new IllegalArgumentException("DialogU need with Context");
            }
            View mLoadingView = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
            SwipeRefreshLayout swipeRefreshLayout = mLoadingView.findViewById(R.id.srl_dialog_fragment);
            swipeRefreshLayout.setColorSchemeColors(0xff3cabfa);
            swipeRefreshLayout.setRefreshing(true);
            this.setView(mLoadingView);
            this.setBackgroundTransparent(true);
            return this;
        }

        @Override
        public IDialogBuilder setBackgroundTransparent(boolean transparent) {
            this.mTransparent = transparent;
            return this;
        }

        @Override
        public AlertDialog build() {
            if (null == mBuilder) {
                throw new IllegalArgumentException("DialogU need with Context");
            }
            mAlertDialog = mBuilder.create();
            if (mTransparent) {
                Window window = mAlertDialog.getWindow();
                if (null != window) {
                    window.setBackgroundDrawableResource(android.R.color.transparent);
                }
            }

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
    }
}
