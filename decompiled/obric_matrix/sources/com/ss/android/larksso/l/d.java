package com.ss.android.larksso.l;

import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.obric.matrix.common_api.INetworkApi;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f12076a;

    static {
    }

    public d(e r1) {
        this.f12076a = r1;
    }

    private static String a(InputStream r5, String r6) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[1024];
        String r2 = "";
        if (r5 == null) goto L20;
    L17:
        int r3 = r5.read(r1);     // Catch: Throwable -> L12
        if (r3 == (-1)) goto L7;
        r1.toString();     // Catch: Throwable -> L12
        r0.write(r1, 0, r3);     // Catch: Throwable -> L12
        goto L17
    L7:
        String r7 = new String(r0.toByteArray(), r6);     // Catch: Throwable -> L12
        r0.flush();     // Catch: Throwable -> L10
        return r7;
    L10:
        th = move-exception;
        r2 = r7;
        th = th;
    L13:
        th.printStackTrace();
        return r2;
    L12:
        th = th;
        goto L13
    L20:
        return "";
    }

    public void b(URL r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        HttpURLConnection r0 = null;
        byte[] r5 = d.a.a.a.q(this.f12076a).getBytes();     // Catch: Throwable -> L14
        HttpURLConnection r7 = (HttpURLConnection) r6.openConnection();     // Catch: Throwable -> L14
        r7.setConnectTimeout(PathInterpolatorCompat.MAX_NUM_POINTS);     // Catch: Throwable -> L12
        r7.setDoInput(true);     // Catch: Throwable -> L12
        r7.setDoOutput(true);     // Catch: Throwable -> L12
        r7.setRequestMethod("POST");     // Catch: Throwable -> L12
        r7.setUseCaches(false);     // Catch: Throwable -> L12
        r7.setRequestProperty("Connection", "Keep-Alive");     // Catch: Throwable -> L12
        r7.setRequestProperty("Locale", "zh_CN");     // Catch: Throwable -> L12
        r7.setRequestProperty("X-Request-ID", UUID.randomUUID().toString().replace("-", ""));     // Catch: Throwable -> L12
        r7.setRequestProperty("X-Terminal-Type", "3");     // Catch: Throwable -> L12
        r7.setRequestProperty("X-Api-Version", "3-10");     // Catch: Throwable -> L12
        r7.setRequestProperty(INetworkApi.CONTENT_TYPE, "application/json;charset=utf-8");     // Catch: Throwable -> L12
        r7.setRequestProperty("X-Passport-Unit", "eu_nc");     // Catch: Throwable -> L12
        r7.getOutputStream().write(r5, 0, r5.length);     // Catch: Throwable -> L12
        if (r7.getResponseCode() != 200) goto L10;
        a(r7.getInputStream(), "utf-8");     // Catch: Throwable -> L12
    L10:
        if (r7 == null) goto L29;
        r7.disconnect();
        return;
    L29:
        return;
    L12:
        th = th;
        r0 = r7;
    L23:
        th.printStackTrace();     // Catch: Throwable -> L19
        if (r0 == null) goto L31;
        r0.disconnect();
        return;
    L31:
        return;
    L19:
        th = move-exception;
        if (r0 == null) goto L22;
        r0.disconnect();
    L22:
        throw th;
    L14:
        th = th;
        goto L23
    }
}
