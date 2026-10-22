package com.obric.netdetect.Modules.HttpProbe;

import android.net.Network;
import android.os.SystemClock;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.obric.netdetect.Utils.NetDetectLog;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Optional;

/* JADX INFO: loaded from: classes3.dex */
public class HttpConnectionProbe {
    private static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.32 Safari/537.36";
    private static final String TAG = "HttpConnectionProbe";
    private int mHttpProbeTimeout;
    private HttpProbeListener mListener;
    private Network mNetwork;
    private String mUrl;

    public interface HttpProbeListener {
        void onProbeFailure(int r1, int r2);

        void onProbePortal(int r1, String r2);

        void onProbeSuccess(int r1, int r2);
    }

    public HttpConnectionProbe(HttpProbeListener r1) {
        this.mListener = r1;
    }

    public HttpConnectionProbe(HttpProbeListener r1, Network r2, int r3) {
        this.mListener = r1;
        this.mNetwork = r2;
        this.mHttpProbeTimeout = r3;
    }

    public void executeHttpProbe(String r3) {
        this.mUrl = r3;
        URL r0 = makeURL(r3);
        if (r0 != null) goto L6;
        this.mListener.onProbeFailure(HttpProbeResult.FAILED_RESPONSE_CODE, 2);
        NetDetectLog.e(TAG, "url is invalid: " + r3);
        return;
    L6:
        sendHttpProbe(r0);
    }

    private void sendHttpProbe(URL r12) {
        HttpURLConnection r4 = null;
        r4 = makeProbeConnection(r12);     // Catch: Throwable -> L14 IOException -> L16
        String r13 = r4.getRequestProperties().toString();     // Catch: Throwable -> L14 IOException -> L16
        long r6 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L14 IOException -> L16
        int r5 = r4.getResponseCode();     // Catch: Throwable -> L14 IOException -> L16
        String r8 = r4.getHeaderField(BatteryTypeInf.BATTERY_LOC_API);     // Catch: Throwable -> L14 IOException -> L16
        int r7 = (int) (SystemClock.elapsedRealtime() - r6);     // Catch: Throwable -> L14 IOException -> L16
        NetDetectLog.d(TAG, "time=" + r7 + "ms ret=" + r5 + " request=" + r13 + " headers=" + r4.getHeaderFields());     // Catch: Throwable -> L14 IOException -> L16
        if (HttpProbeResult.isSuccessCode(r5) == false) goto L7;
        this.mListener.onProbeSuccess(r5, r7);     // Catch: Throwable -> L14 IOException -> L16
    L12:
        if (r4 == null) goto L32;
    L25:
        r4.disconnect();
        return;
    L32:
        return;
    L7:
        if (HttpProbeResult.isPortalCode(r5) == false) goto L10;
        this.mListener.onProbePortal(r5, (String) Optional.ofNullable(r8).orElse(this.mUrl));     // Catch: Throwable -> L14 IOException -> L16
        goto L12
    L10:
        if (HttpProbeResult.isFailedCode(r5) == false) goto L12;
        this.mListener.onProbeFailure(r5, 0);     // Catch: Throwable -> L14 IOException -> L16
    L16:
        e = move-exception;
        NetDetectLog.e(TAG, "http probe failed: " + e.getMessage());     // Catch: Throwable -> L14
        if ((e instanceof UnknownHostException) == false) goto L21;
        this.mListener.onProbeFailure(HttpProbeResult.FAILED_RESPONSE_CODE, 3);     // Catch: Throwable -> L14
    L24:
        if (0 != 0) goto L25;
        return;
    L21:
        if ((e instanceof SocketTimeoutException) == false) goto L23;
        this.mListener.onProbeFailure(HttpProbeResult.FAILED_RESPONSE_CODE, 4);     // Catch: Throwable -> L14
        goto L24
    L23:
        this.mListener.onProbeFailure(HttpProbeResult.FAILED_RESPONSE_CODE, 0);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (0 == 0) goto L29;
        r4.disconnect();
    L29:
        throw th;
    }

    private URL makeURL(String r2) {
        if (r2 == null) goto L10;
        return new URL(r2);
    L5:
        NetDetectLog.e(TAG, "Bad URL: " + r2);
        return null;
    L10:
        return null;
    }

    private HttpURLConnection makeProbeConnection(URL r2) throws IOException {
        HttpURLConnection r3 = (HttpURLConnection) this.mNetwork.openConnection(r2);
        r3.setConnectTimeout(this.mHttpProbeTimeout);
        r3.setReadTimeout(this.mHttpProbeTimeout);
        r3.setRequestProperty(HTTP.CONN_DIRECTIVE, "close");
        r3.setUseCaches(false);
        r3.setRequestProperty("User-Agent", DEFAULT_USER_AGENT);
        return r3;
    }
}
