package com.bytedance.privacy.network;

import a.a;
import com.bytedance.privacy.utils.LogUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ChallengeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OkHttpClient f11a = null;

    static {
        f11a = new OkHttpClient();
    }

    public static String a(String r4) {
        int r1 = new JSONObject(r4).getInt("code");     // Catch: Exception -> L5
    L8:
        if (r1 >= 200) goto L10;
        return "";
    L10:
        if (r1 >= 300) goto L26;
        String r5 = new JSONObject(new JSONObject(r4).getString("data")).getString("nonce");     // Catch: Exception -> L13
    L27:
        return r5;
    L13:
        e = move-exception;
        a.w(e, new StringBuilder("getChallenge exception: "), "ChallengeManager");     // Catch: Exception -> L16
        r5 = "";
    L16:
        e = move-exception;
        a.w(e, new StringBuilder("parseChallenge exception: "), "ChallengeManager");
        return "";
    L26:
        return "";
    L5:
        e = move-exception;
        a.w(e, new StringBuilder("getResponseCode exception: "), "ChallengeManager");
        r1 = 400;
        goto L8
    }

    public static String b() {
        Request.Builder r1 = new Request.Builder();
        if (NetworkConfig.a().b() == false) goto L5;
        String r2 = "https://ocean-secret-boe.bytedance.net/api/auth/challenge";
    L6:
        Request r3 = r1.url(r2).get().build();
        LogUtils.a("ChallengeManager", "Challenge Request:" + r3.toString());
        LogUtils.a("ChallengeManager", "Challenge Request body:" + r3.body());
        int r4 = 1;
        String r5 = "";
    L8:
        if (r4 > 3) goto L47;
        Response r7 = f11a.newCall(r3).execute();     // Catch: Exception -> L22 IOException -> L24 ConnectException -> L26 SocketTimeoutException -> L28
    L13:
        th = move-exception;
        if (r7 != null) goto L51;
    L38:
        throw th;     // Catch: Exception -> L22 IOException -> L24 ConnectException -> L26 SocketTimeoutException -> L28
    L51:
        r7.close();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L22 IOException -> L24 ConnectException -> L26 SocketTimeoutException -> L28
        goto L38
    L11:
        if (r7.body() == null) goto L15;
        String r8 = r7.body().string();     // Catch: Throwable -> L13
    L18:
        if (r7.isSuccessful() == true) goto L19;
        LogUtils.b("ChallengeManager", "Challenge Attempt " + r4 + ": Response failed, code = " + r7.code());     // Catch: Throwable -> L13
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L13
        r9.append("Challenge Response body:");     // Catch: Throwable -> L13
        r9.append(r8);     // Catch: Throwable -> L13
        LogUtils.b("ChallengeManager", r9.toString());     // Catch: Throwable -> L13
        r7.close();     // Catch: Exception -> L22 IOException -> L24 ConnectException -> L26 SocketTimeoutException -> L28
    L43:
        if (r4 >= 3) goto L46;
        Thread.sleep(500);     // Catch: InterruptedException -> L48
    L46:
        r4 = r4 + 1;
        goto L8
    L19:
        LogUtils.a("ChallengeManager", "Challenge Response received successfully");     // Catch: Throwable -> L13
        LogUtils.a("ChallengeManager", "Challenge Response body:" + r8);     // Catch: Throwable -> L13
        r5 = a(r8);     // Catch: Throwable -> L13
        r7.close();     // Catch: Exception -> L22 IOException -> L24 ConnectException -> L26 SocketTimeoutException -> L28
        goto L47
    L15:
        r8 = "";
    L26:
        e = move-exception;
        StringBuilder r10 = a.p(r4, "Challenge Attempt ", ": ConnectException (connect timeout): ");
        r10.append(e.getMessage());
        LogUtils.b("ChallengeManager", r10.toString());
    L28:
        e = move-exception;
        StringBuilder r11 = a.p(r4, "Challenge Attempt ", ": SocketTimeoutException (read/write timeout): ");
        r11.append(e.getMessage());
        LogUtils.b("ChallengeManager", r11.toString());
    L24:
        e = move-exception;
        StringBuilder r12 = a.p(r4, "Challenge Attempt ", ": IOException: ");
        r12.append(e.getMessage());
        LogUtils.b("ChallengeManager", r12.toString());
    L22:
        e = move-exception;
        LogUtils.c("ChallengeManager", "Challenge Attempt " + r4 + ": Unexpected exception: ", e);
        e.printStackTrace();
    L47:
        return r5;
    L5:
        r2 = "https://ocean-secret.oceancloudapi.com/api/auth/challenge";
        goto L6
    }
}
