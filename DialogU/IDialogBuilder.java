package cn.cookiemouse.dialogutils;

import android.content.DialogInterface;
import android.view.View;

/**
 * Created by tianyi on 18-3-27.
 */

public interface IDialogBuilder {

    IDialogBuilder setView(View view);

    IDialogBuilder setMessage(String msg);

    IDialogBuilder setMessage(int msgId);

    IDialogBuilder setPositiveClickListener(String text, DialogInterface.OnClickListener listener);

    IDialogBuilder setNegativeClickListener(String text, DialogInterface.OnClickListener listener);

    IDialogBuilder setBackgroundTranslate(boolean translate);
}
