package com.bytedance.securityserver.trustcircle.network;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.constant.ReportProtocal;
import com.bytedance.securityserver.trustcircle.DataConverter;
import com.bytedance.securityserver.trustcircle.TrustCircleException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class NetworkManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile NetworkManager f76a;

    public static NetworkResponse a(String r5) {
        JsonObject r0 = DataConverter.c(r5);
        if (r0 != null) goto L5;
        int r1 = 2000;
    L6:
        JsonObject r2 = DataConverter.c(r5);
        String r3 = "Convert response body string to JsonObject failed";
        if (r2 != null) goto L9;
        String r4 = "Convert response body string to JsonObject failed";
    L10:
        JsonObject r6 = DataConverter.c(r5);
        if (r6 == null) goto L14;
        r3 = r6.get(ReportProtocal.KEY_LOG_ID).getAsString();
    L14:
        JsonObject r7 = DataConverter.c(r5);
        JsonObject r8 = null;
        if (r7 == null) goto L24;
        JsonElement r9 = r7.get("data");
        if (r9 == null) goto L24;
        if (r9.isJsonObject() == false) goto L24;
        r8 = r9.getAsJsonObject();
    L24:
        return new NetworkResponse(r1, r4, r3, r8);
    L9:
        r4 = r2.get(NotificationCompat.CATEGORY_MESSAGE).getAsString();
        goto L10
    L5:
        r1 = r0.get("code").getAsInt();
        goto L6
    }

    public static NetworkResponse b(NetworkRequest r7) {
        OkHttpClient.Builder r3 = new OkHttpClient.Builder();     // Catch: IOException -> L6
        TimeUnit r4 = TimeUnit.SECONDS;     // Catch: IOException -> L6
        Response r8 = r3.connectTimeout(10, r4).readTimeout(30, r4).build().newCall(new Request.Builder().url(r7.b).method(r7.f77a, RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r7.c)).addHeader(r7.e, r7.f78d).build()).execute();     // Catch: IOException -> L6
        if (r8.isSuccessful() == false) goto L8;
        String r0 = r8.body().string();     // Catch: IOException -> L6
        r8.toString();     // Catch: IOException -> L6
        return a(r0);
    L8:
        Log.e("SecurityServer-NetworkManager", "newCall failed!! response:" + r8.toString());     // Catch: IOException -> L6
        Log.e("SecurityServer-NetworkManager", "newCall failed!! response body:" + r8.body().string());     // Catch: IOException -> L6
        return new NetworkResponse(r8.code(), r8.message(), "", null);
    L6:
        e = move-exception;
        throw new TrustCircleException(NetError.ERR_INVALID_URL, e.getMessage());
    }

    public static NetworkManager c() {
        if (f76a != null) goto L16;
        monitor-enter(NetworkManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f76a != null) goto L11;
        f76a = new NetworkManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(NetworkManager.class);     // Catch: Throwable -> L9
    L16:
        return f76a;
    }
}
