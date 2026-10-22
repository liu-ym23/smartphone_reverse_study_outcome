package com.bytedance.sdk.account.settings;

import androidx.annotation.NonNull;
import com.bytedance.sdk.account.impl.g;
import com.ss.android.i.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static JSONObject f5710a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f5711b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static InterfaceC0182b f5712c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static a f5713d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f5714a;

        public a() {
            this.f5714a = false;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.account.settings.b$b, reason: collision with other inner class name */
    public interface InterfaceC0182b {
        @NonNull
        a getConfig();
    }

    static {
        a r0 = new a();
        f5711b = r0;
        f5713d = r0;
    }

    private static void a() {
        InterfaceC0182b r0 = f5712c;
        if (r0 == null) goto L5;
        f5713d = r0.getConfig();
        return;
    L5:
        a r1 = f5711b;
        f5713d = r1;
        JSONObject r2 = b();
        if (f5710a == r2) goto L13;
        f5710a = r2;
        d.b.s.a.a0.a.a("AuthExpirationConfigMan", "auth_expiation_config = " + f5710a);
        JSONObject r3 = f5710a;
        if (r3 == null) goto L10;
        r1.f5714a = r3.optBoolean("enable", false);
        return;
    L10:
        r1.f5714a = false;
        return;
    }

    private static JSONObject b() {
        JSONObject r0 = g.b(j.k().e()).b();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.optJSONObject("auth_expiation_config");
    }

    public static boolean c() {
        a();
        return f5713d.f5714a;
    }
}
