package com.ss.android.i.n.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static InterfaceC0307a f11914a;

    /* JADX INFO: renamed from: com.ss.android.i.n.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0307a {
        void onEvent(String r1, JSONObject r2);
    }

    public static void a(String r1, JSONObject r2) {
        InterfaceC0307a r0 = f11914a;
        if (r0 == null) goto L6;
        r0.onEvent(r1, r2);
        return;
    }
}
