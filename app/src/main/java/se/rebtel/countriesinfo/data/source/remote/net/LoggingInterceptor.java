/*
 *  Copyright (c) 2017 CountriesInfo. All rights reserved.
 */

package se.rebtel.countriesinfo.data.source.remote.net;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import se.rebtel.countriesinfo.R;

/**
 * Http request and response interceptor.
 */
public class LoggingInterceptor implements Interceptor {
    private static final String TAG = LoggingInterceptor.class.getSimpleName();

    private Context mContext = null;

    public LoggingInterceptor(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        long t1 = System.nanoTime();

        String requestLog = String.format("%s %s\n%s",
                request.method().toUpperCase(), request.url(), request.headers());
        String body = new String();
        if (request.method().compareToIgnoreCase("post") == 0 || request.method().compareToIgnoreCase("put") == 0) {
            body = bodyToString(request);
        }

        Log.d(TAG, "REQUEST " + requestLog);
        if (body != null && !body.isEmpty()) {
            Log.d(TAG, "body " + body);
        }

        Response response = null;
        try {
            response = chain.proceed(request);
        } catch (Exception e) {
            if (e instanceof SocketTimeoutException) {
                Log.d(TAG, "SocketTimeoutException..");
                ((Activity) mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(mContext, mContext.getString(R.string.message_no_network), Toast.LENGTH_LONG).show();
                    }
                });
            } else if (e instanceof UnknownHostException) {
                Log.d(TAG, "UnknownHostException..");
            }
        }
        long t2 = System.nanoTime();

        if (response != null) {
            String responseLog = String.format("Received response for %s in %.1fms\nStatusCodeResolver: HTTP/%s %s\n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.code(), StatusCodeResolver.getStatus(response.code()), response.headers());

            String bodyString = response.body().string();

            Log.d(TAG, "response\n" + responseLog + "\n" + bodyString);

            Response resp = response.newBuilder()
                    .body(ResponseBody.create(response.body().contentType(), bodyString))
                    .build();

            response.body().close();

            return resp;
        }

        return chain.proceed(request);
    }


    private static String bodyToString(final Request request) {
        try {
            final Request copy = request.newBuilder().build();
            final Buffer buffer = new Buffer();
            copy.body().writeTo(buffer);

            final String body = buffer.readUtf8();

            return body;
        } catch (final IOException e) {
            return "did not work";
        }
    }
}
