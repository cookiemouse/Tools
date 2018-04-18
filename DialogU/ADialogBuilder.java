package cn.cookiemouse.dialogutils;

/**
 * Created by tianyi on 18-3-27.
 */

public abstract class ADialogBuilder{

    private static final String TAG = "ADialogBuilder";

    public abstract ADialogBuilder show();

    public abstract void dismiss();

    public abstract ADialogBuilder setDimAmount(float amount);

    public abstract ADialogBuilder setCancelable(boolean cancelable);
}
