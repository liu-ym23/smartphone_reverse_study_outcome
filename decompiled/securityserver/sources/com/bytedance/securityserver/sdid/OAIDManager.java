package com.bytedance.securityserver.sdid;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class OAIDManager {
    public static volatile OAIDManager c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f61a;
    public volatile boolean b;

    public static OAIDManager b() {
        if (c != null) goto L16;
        monitor-enter(OAIDManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L11;
        OAIDManager r1 = new OAIDManager();     // Catch: Throwable -> L9
        r1.f61a = false;     // Catch: Throwable -> L9
        r1.b = true;     // Catch: Throwable -> L9
        c = r1;     // Catch: Throwable -> L9
    L11:
        monitor-exit(OAIDManager.class);     // Catch: Throwable -> L9
    L16:
        return c;
    }

    public final void a(Context r5) {
        if (this.f61a == false) goto L21;
        return;
    L21:
        String r6 = Settings.Secure.getString(r5.getContentResolver(), "enable_oaid");     // Catch: Throwable -> L11 Exception -> L16
        Log.i("SecurityServer-OAIDManager", "ensureOAIDStateSynced get enable_oaid = " + r6);     // Catch: Throwable -> L11 Exception -> L16
        if (r6 != null) goto L8;
    L13:
        boolean r7 = true;
    L14:
        this.b = r7;     // Catch: Throwable -> L11 Exception -> L16
    L15:
        this.f61a = true;
        return;
    L8:
        if ("0".equals(r6) == true) goto L13;
        r7 = false;
    L16:
        Log.e("SecurityServer-OAIDManager", "Failed to read enable_oaid from Settings");     // Catch: Throwable -> L11
        this.b = true;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.f61a = true;
        throw th;
    }
}
