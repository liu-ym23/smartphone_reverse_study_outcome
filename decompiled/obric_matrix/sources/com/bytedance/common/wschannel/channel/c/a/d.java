package com.bytedance.common.wschannel.channel.c.a;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.k;
import java.util.ArrayList;
import java.util.List;
import p000j.f0;

/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f3432a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.common.wschannel.channel.c.a.f.b f3433b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3434c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3435d;

    d(List<String> r3, com.bytedance.common.wschannel.channel.c.a.f.b r4) {
        this.f3434c = 0;
        ArrayList r0 = new ArrayList();
        this.f3432a = r0;
        if (r3 == null) goto L5;
        r0.addAll(r3);
    L5:
        Logger.d("WsChannelSdk_ok", "urls : " + r0);
        this.f3433b = r4;
        d();
    }

    synchronized String a() {
        monitor-enter(this);
        int r0 = this.f3434c + 1;     // Catch: Throwable -> L11
        this.f3434c = r0;     // Catch: Throwable -> L11
        if (this.f3432a.size() <= r0) goto L9;
        String r1 = this.f3432a.get(r0);     // Catch: Throwable -> L11
        this.f3435d = r1;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L9:
        monitor-exit(this);
        return "";
    L11:
        th = move-exception;
        throw th;
    }

    synchronized Pair<String, Long> b(f0 r6) {
        monitor-enter(this);
        String r0 = c();     // Catch: Throwable -> L11
        long r1 = this.f3433b.b(r6);     // Catch: Throwable -> L11
        if (r1 != (-1)) goto L8;
        this.f3433b.reset();     // Catch: Throwable -> L11
        r0 = a();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r0) == true) goto L8;
        r1 = this.f3433b.a();     // Catch: Throwable -> L11
    L8:
        Pair<String, Long> r7 = new Pair(r0, Long.valueOf(r1));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r7;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized String c() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (k.c(this.f3435d) == false) goto L8;
        int r0 = this.f3432a.size();     // Catch: Throwable -> L11
        int r1 = this.f3434c;     // Catch: Throwable -> L11
        if (r0 <= r1) goto L8;
        this.f3435d = this.f3432a.get(r1);     // Catch: Throwable -> L11
    L8:
        String r2 = this.f3435d;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }

    synchronized void d() {
        monitor-enter(this);
        this.f3433b.reset();     // Catch: Throwable -> L6
        this.f3435d = null;     // Catch: Throwable -> L6
        this.f3434c = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
