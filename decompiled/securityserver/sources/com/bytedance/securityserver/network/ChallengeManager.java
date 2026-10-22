package com.bytedance.securityserver.network;

import a.a;
import android.util.Log;
import com.bytedance.securityserver.trustcircle.account.EnvBridgeImpl;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ChallengeManager {
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
        a.C(e, new StringBuilder("getChallenge exception:"), "ChallengeManager");     // Catch: Exception -> L16
        r5 = "";
    L16:
        e = move-exception;
        a.C(e, new StringBuilder("parseChallenge exception:"), "ChallengeManager");
        return "";
    L26:
        return "";
    L5:
        e = move-exception;
        a.C(e, new StringBuilder("getResponseCode exception:"), "ChallengeManager");
        r1 = 400;
        goto L8
    }

    public static String b() {
        OkHttpClient.Builder r2 = new OkHttpClient.Builder();
        TimeUnit r3 = TimeUnit.SECONDS;
        OkHttpClient r4 = r2.connectTimeout(10, r3).readTimeout(30, r3).build();
        Request.Builder r5 = new Request.Builder();
        EnvBridgeImpl r6 = NetworkConfig.a().f55a;
        if (r6 != null) goto L5;
    L7:
        String r7 = "https://ocean-secret.oceancloudapi.com/api/auth/challenge";
    L8:
        Request r8 = r5.url(r7).get().build();
        r8.toString();
        Objects.toString(r8.body());
        String r9 = "";
        Response r10 = r4.newCall(r8).execute();     // Catch: Exception -> L18
    L13:
        th = move-exception;
        if (r10 != null) goto L29;
    L25:
        throw th;     // Catch: Exception -> L18
    L29:
        r10.close();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L18
        goto L25
    L11:
        if (r10.isSuccessful() == false) goto L15;
        r9 = a(r10.body().string());     // Catch: Throwable -> L13
    L16:
        r10.close();     // Catch: Exception -> L18
    L27:
        return r9;
    L15:
        Log.i("ChallengeManager", "newCall failed!! response body:" + r10.body().string());     // Catch: Throwable -> L13
    L18:
        e = move-exception;
        a.C(e, new StringBuilder("getChallengeFromServer failed, exception: "), "ChallengeManager");
        goto L27
    L5:
        if (r6.a() == false) goto L7;
        r7 = "https://ocean-secret-boe.bytedance.net/api/auth/challenge";
        goto L8
    }
}
