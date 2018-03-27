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

    public static DialogBuilder with(Context context) {
        mDialogBuilder = new DialogBuilder();
        mDialogBuilder.with(context);
        return mDialogBuilder;
    }

    public static DialogBuilder setView(View view) {
        mDialogBuilder.setView(view);
        return mDialogBuilder;
    }

    public static DialogBuilder setCancelable(boolean cancelable) {
        mDialogBuilder.setCancelable(cancelable);
        return mDialogBuilder;
    }

    public void show() {
        mDialogBuilder.show();
    }

    public static class DialogBuilder implements IDialogBuilder {

        private static AlertDialog.Builder mBuilder;
        private AlertDialog mAlertDialog;
        private boolean mTransparent = false;
        private View mContentView;
        private Context mContext;

        @Override
        public IDialogBuilder with(Context context) {
            this.mContext = context;
            mBuilder = new AlertDialog.Builder(context);
            return this;
        }

        @Override
        public IDialogBuilder setView(View view) {
            if (null == mBuilder) {
                throw new IllegalArgumentException("DialogU need with Context");
            }
            this.mContentView = view;
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
        public IDialogBuilder showLoading(boolean loading) {
            if (null == mBuilder) {
                throw new IllegalArgumentException("DialogU need with Context");
            }
            mContentView = LayoutInflater.from(mContext).inflate(R.layout.dialog_loading, null);
            SwipeRefreshLayout swipeRefreshLayout = mContentView.findViewById(R.id.srl_dialog_fragment);
            swipeRefreshLayout.setColorSchemeColors(0xff3cabfa);
            swipeRefreshLayout.setRefreshing(true);
            this.setView(mContentView);
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
            mAlertDialog = mDialogBuilder.build();
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
