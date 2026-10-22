package com.bytedance.securityserver.trustcircle;

import android.util.Log;
import com.bytedance.securityserver.network.ChallengeManager;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.nio.charset.StandardCharsets;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class DataConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Gson f65a = null;

    static {
        f65a = new Gson();
    }

    public static boolean a(JsonArray r2, int r3, int r4, Consumer r5, Consumer r6) {
        byte[] r7 = r2.get(r3).getAsString().getBytes(StandardCharsets.UTF_8);
        if (r7.length <= r4) goto L6;
        StringBuilder r8 = a.a.p(r3, "cert at index ", " is too long: ");
        r8.append(r7.length);
        Log.e("SecurityServer-DataConverter", r8.toString());
        return false;
    L6:
        byte[] r9 = new byte[r4];
        System.arraycopy(r7, 0, r9, 0, r7.length);
        r5.accept(r9);
        r6.accept(Integer.valueOf(r7.length));
        return true;
    }

    public static byte[] b() {
        String r0 = ChallengeManager.b();
        if (r0 != null) goto L5;
    L9:
        Log.e("SecurityServer-DataConverter", "requestChallenge failed");
        return new byte[0];
    L5:
        if (r0.isEmpty() == true) goto L9;
        JsonObject r1 = new JsonObject();
        r1.addProperty("challenge", r0);
        return r1.toString().getBytes(StandardCharsets.UTF_8);
    }

    public static JsonObject c(String r2) {
        return (JsonObject) f65a.fromJson(r2, JsonObject.class);
    L4:
        e = move-exception;
        a.a.C(e, new StringBuilder("parseStringToGson failed, exception: "), "SecurityServer-DataConverter");
        return null;
    }
}
