package cn.cookiemouse.distinguish.Utils;

import android.content.Context;
import android.content.Intent;

public class JumpU {
    public static void toActivity(Context context, Class activity){
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }
}
