package com.bytedance.privacy.pcc.network;

import a.a;
import com.bytedance.privacy.network.NetworkConfig;
import com.bytedance.privacy.pcc.network.model.UploadChannelRetResponse;
import com.bytedance.privacy.utils.LogUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class PccNetworkManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OkHttpClient f16a = null;
    public static volatile PccNetworkManager b;

    static {
        f16a = new OkHttpClient();
    }

    public static void a(Request.Builder r2) {
        if (NetworkConfig.a().b() == true) goto L6;
        r2.addHeader("x-use-ppe", "1").addHeader("x-tt-env", "ppe_opcc_omni_2");
        return;
    }

    public static PccNetworkManager b() {
        if (b != null) goto L16;
        monitor-enter(PccNetworkManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L11;
        b = new PccNetworkManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(PccNetworkManager.class);     // Catch: Throwable -> L9
    L16:
        return b;
    }

    public static String c(String r6, String r7, String r8) {
        if (NetworkConfig.a().b() == false) goto L5;
        String r1 = "https://opcc-gateway-boe.bytedance.net";
    L6:
        String r2 = r1.concat("/opcc/v2/auth/upload/channelRet");
        Request.Builder r9 = new Request.Builder().url(r2).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), r8)).addHeader("Content-Type", "application/json").addHeader("x-requestId", r6).addHeader("x-timestamp", r7);
        a(r9);
        Request r10 = r9.build();
        LogUtils.a("PccNetworkManager", "PCC UploadChannelRet request: " + r2);
        LogUtils.a("PccNetworkManager", "PCC UploadChannelRet body: " + r8);
        int r11 = 1;
    L7:
        String r12 = "";
        if (r11 > 3) goto L45;
        Response r3 = f16a.newCall(r10).execute();     // Catch: Exception -> L20 IOException -> L22 ConnectException -> L24 SocketTimeoutException -> L26
    L13:
        th = move-exception;
        if (r3 != null) goto L47;
    L36:
        throw th;     // Catch: Exception -> L20 IOException -> L22 ConnectException -> L24 SocketTimeoutException -> L26
    L47:
        r3.close();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L20 IOException -> L22 ConnectException -> L24 SocketTimeoutException -> L26
        goto L36
    L11:
        if (r3.body() == null) goto L16;
        r12 = r3.body().string();     // Catch: Throwable -> L13
    L16:
        if (r3.isSuccessful() == true) goto L17;
        LogUtils.b("PccNetworkManager", "PCC UploadChannelRet attempt " + r11 + ": HTTP " + r3.code() + " body=" + r12);     // Catch: Throwable -> L13
        r3.close();     // Catch: Exception -> L20 IOException -> L22 ConnectException -> L24 SocketTimeoutException -> L26
    L41:
        if (r11 >= 3) goto L44;
        Thread.sleep(500);     // Catch: InterruptedException -> L46
    L44:
        r11 = r11 + 1;
        goto L7
    L17:
        LogUtils.a("PccNetworkManager", "PCC UploadChannelRet response: " + r12);     // Catch: Throwable -> L13
        String r13 = UploadChannelRetResponse.a(r12).f22a;     // Catch: Throwable -> L13
        r3.close();     // Catch: Exception -> L20 IOException -> L22 ConnectException -> L24 SocketTimeoutException -> L26
        return r13;
    L24:
        e = move-exception;
        StringBuilder r4 = a.p(r11, "PCC UploadChannelRet attempt ", ": ConnectException: ");
        r4.append(e.getMessage());
        LogUtils.b("PccNetworkManager", r4.toString());
    L26:
        e = move-exception;
        StringBuilder r5 = a.p(r11, "PCC UploadChannelRet attempt ", ": SocketTimeoutException: ");
        r5.append(e.getMessage());
        LogUtils.b("PccNetworkManager", r5.toString());
    L22:
        e = move-exception;
        StringBuilder r14 = a.p(r11, "PCC UploadChannelRet attempt ", ": IOException: ");
        r14.append(e.getMessage());
        LogUtils.b("PccNetworkManager", r14.toString());
    L20:
        e = move-exception;
        LogUtils.c("PccNetworkManager", "PCC UploadChannelRet attempt " + r11 + ": unexpected exception: ", e);
        goto L41
    L45:
        return "";
    L5:
        r1 = "https://opcc-gateway.obriccloud.com";
        goto L6
    }
}
