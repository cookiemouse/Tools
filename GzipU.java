package cn.cookiemouse.dialogu;

import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 * Created by tianyi on 18-5-23.
 */

public class GzipU {
    /**
     * 解压Gzip
     **/
    public static String getStrFromGzip(String string) {
        String strOut = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64.decode(string, Base64.DEFAULT));
            GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
            byte[] buffer = new byte[256];
            int n = 0;
            while ((n = gzipInputStream.read(buffer)) >= 0) {
                outputStream.write(buffer, 0, n);
            }
            strOut = outputStream.toString("GB2312");

            gzipInputStream.close();
            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Tag", "exception-->" + e);
        }


        return strOut;
    }
}
