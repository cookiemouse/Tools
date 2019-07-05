package com.homwee.aipont.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class DownloadU {

    private static final long TIME_OUT = 15000;

    public DownloadU() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
        builder.writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
        builder.connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
        OkHttpClient okHttpClient = builder.build();

        final Request.Builder requestBuilder = new Request.Builder();
//        requestBuilder.url("").header("RANGE", "bytes=" + "" + "-");
        requestBuilder.url("http://speedtest.tokyo.linode.com/100MB-tokyo.bin");

        Call call = okHttpClient.newCall(requestBuilder.build());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody responseBody = response.body();
                if (null == responseBody) {
                    return;
                }
                long sizeTotal = responseBody.contentLength();
                LogUtil.i("sizeTotal: " + sizeTotal);
                long sizeCurrent = 0;

                BufferedSink bufferedSink = Okio.buffer(Okio.sink(new File("/data/user/0/com.homwee.aipont/files/test.bin")));
                Buffer buffer = bufferedSink.buffer();

                BufferedSource bufferedSource = responseBody.source();
                long len;
                long size = 1024;
                while ((len = bufferedSource.read(buffer, size)) != -1) {
                    sizeCurrent += len;
                    LogUtil.i("len: " + len + "\t, progress: " + (sizeCurrent * 100 / sizeTotal));
                    bufferedSink.flush();
                }
                bufferedSource.close();
                bufferedSink.close();
            }
        });
    }

    public void startDownLoad() {
    }
}
