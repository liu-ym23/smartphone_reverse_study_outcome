package com.bytedance.securityserver.utils;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;

    public /* synthetic */ b(int r1, Object r2) {
        this.b = r1;
        this.c = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.b) {
            case 0: goto L17;
            default: goto L4;
        };
    L4:
        NetworkMonitor r4 = (NetworkMonitor) this.c;
        r4.getClass();
        int r0 = -1;
        NetworkMonitor.NetworkTask r1 = r4.f83a;     // Catch: Exception -> L9
        if (r1 == null) goto L15;
        r0 = r1.a();     // Catch: Exception -> L9
    L15:
        r4.e.post(new c(r0, 2));
        return;
    L9:
        e = move-exception;
        if (e.getMessage() != null) goto L13;
        String r2 = e.getClass().getSimpleName();
    L14:
        Log.e("SecurityServer-NetworkMonitor", "runTask failed, exception: " + r2);
        goto L15
    L13:
        r2 = e.getMessage();
        goto L14
    L17:
        WiFiMonitor r5 = ((WiFiMonitor.AnonymousClass1) this.c).f88a;
        int r3 = -1;
        WiFiMonitor.WiFiTask r6 = r5.f86a;     // Catch: Exception -> L22
        if (r6 == null) goto L23;
        r3 = r6.a();     // Catch: Exception -> L22
    L23:
        r5.e.post(new c(r3, 0));
        return;
    L22:
        Log.e("SecurityServer-WiFiMonitor", "runTask failed, exception: ");
        goto L23
    }
}
