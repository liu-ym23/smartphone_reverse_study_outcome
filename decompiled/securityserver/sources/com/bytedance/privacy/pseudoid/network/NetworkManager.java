package com.bytedance.privacy.pseudoid.network;

import a.a;
import androidx.core.app.NotificationCompat;
import okhttp3.OkHttpClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class NetworkManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OkHttpClient f24a = null;
    public static volatile NetworkManager b;

    static {
        f24a = new OkHttpClient();
    }

    public static NetworkResponse a(String r6) {
        int r1 = new JSONObject(r6).getInt("code");     // Catch: Exception -> L5
    L23:
        String r2 = new JSONObject(r6).getString(NotificationCompat.CATEGORY_MESSAGE);     // Catch: Exception -> L9
    L11:
        PseudoID r4 = null;
        if (r1 < 200) goto L20;
        if (r1 >= 300) goto L20;
        r4 = b(r6);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        a.w(e, new StringBuilder("buildNetworkResponse exception: "), "NetworkManager");
    L20:
        return new NetworkResponse(r1, r2, r4);
    L9:
        e = move-exception;
        a.w(e, new StringBuilder("getResponseMsg exception: "), "NetworkManager");
        r2 = "";
    L5:
        e = move-exception;
        a.w(e, new StringBuilder("getResponseCode exception: "), "NetworkManager");
        r1 = 400;
        goto L23
    }

    public static PseudoID b(String r3) {
        JSONObject r1 = new JSONObject(new JSONObject(r3).getString("data"));     // Catch: Exception -> L5
        return new PseudoID(r1.optString("rpdid", ""), r1.optString("rpuid", ""));
    L5:
        e = move-exception;
        a.w(e, new StringBuilder("getPseudoID exception: "), "NetworkManager");
        return null;
    }
}
