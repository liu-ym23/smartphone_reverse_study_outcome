package com.bytedance.common.wschannel.channel.c.a.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.bytedance.common.utility.Logger;
import p000j.f0;

/* JADX INFO: loaded from: classes.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f3438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3439b;

    a(Context r2) {
        this.f3439b = 0;
        this.f3438a = r2;
    }

    private static boolean d(Context r2) {
        NetworkInfo r3 = ((ConnectivityManager) r2.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r3 == null) goto L12;
        if (r3.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.f.b
    public long a() {
        return (long) ((Math.random() * 4500.0d) + 500.0d);
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.f.b
    public long b(f0 r9) {
        long r1 = c();
        if (r1 != (-1)) goto L5;
        return -1;
    L5:
        if (r9 != null) goto L30;
    L28:
        return r1;
    L30:
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L7:
        if (r9.M() == true) goto L28;
        int r8 = r9.s();     // Catch: Exception -> L26
        if (r8 != 414) goto L11;
    L14:
        String r10 = r9.A("Handshake-Options");     // Catch: Exception -> L26
        if (r10 == null) goto L28;
        String[] r11 = r10.split(";");     // Catch: Exception -> L26
        int r12 = r11.length;     // Catch: Exception -> L26
        int r4 = 0;
    L17:
        if (r4 >= r12) goto L28;
        String r5 = r11[r4];     // Catch: Exception -> L26
        if (TextUtils.isEmpty(r5) == true) goto L25;
        String[] r6 = r5.split("=");     // Catch: Exception -> L26
        if ("reconnect-interval".equals(r6[0]) == false) goto L25;
        String r7 = r6[1];     // Catch: Exception -> L26
        Logger.d("WsChannelSdk_ok", "override retry interval");     // Catch: Exception -> L26
        r1 = Long.parseLong(r7) * 1000;     // Catch: NumberFormatException -> L29 Exception -> L26
        Logger.d("WsChannelSdk_ok", "read response hand shake option : reconnect-interval:" + r1 + " ms");     // Catch: NumberFormatException -> L29 Exception -> L26
    L25:
        r4 = r4 + 1;
        goto L17
    L11:
        if (r8 == 511) goto L14;
        if (r8 != 512) goto L28;
        goto L14
    }

    public long c() {
        if (d(this.f3438a) == true) goto L6;
        return -1;
    L6:
        int r0 = this.f3439b + 1;
        this.f3439b = r0;
        return (long) (Math.min(((long) (1 << r0)) * CoroutineLiveDataKt.DEFAULT_TIMEOUT, 120000) + ((Math.random() * 10.0d) * 1000.0d));
    }

    @Override // com.bytedance.common.wschannel.channel.c.a.f.b
    public void reset() {
        this.f3439b = 0;
    }
}
