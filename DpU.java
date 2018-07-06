import android.content.res.Resources;
import android.util.DisplayMetrics;

public static float dpToPixel(float dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * metrics.density;
}
