package com.ss.android.ugc.quota;

import android.util.Pair;
import com.obric.matrix.account.http.Resp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class BDNetworkTagManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile BDNetworkTagManager f12327g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f12328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ss.android.ugc.quota.d.a f12329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f12331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AtomicBoolean f12332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f12333f;

    private BDNetworkTagManager() {
        this.f12331d = new AtomicBoolean(false);
        this.f12332e = new AtomicBoolean(false);
        this.f12333f = Resp.CODE_UNKNOWN;
    }

    private boolean c() {
        if (this.f12332e.get() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f12331d.get() == false) goto L7;
        return true;
    }

    public static BDNetworkTagManager d() {
        if (f12327g != null) goto L15;
        monitor-enter(BDNetworkTagManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f12327g != null) goto L9;
        f12327g = new BDNetworkTagManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(BDNetworkTagManager.class);     // Catch: Throwable -> L11
    L15:
        return f12327g;
    }

    public Pair<String, String> a(b r3) {
        if (c() == true) goto L6;
        return null;
    L6:
        if (r3 == null) goto L13;
        int r0 = this.f12329b.a();
        if (this.f12333f == r0) goto L11;
        f(r0);
    L11:
        return new Pair("x-tt-request-tag", "t=" + r3.triggerType() + ";n=" + (r3.markAsNewUser() ? 1 : 0));
    L13:
        throw new IllegalArgumentException("ContextProvider is NULL");
    }

    public int b() {
        if (c() == true) goto L7;
        return Resp.CODE_UNKNOWN;
    L7:
        return this.f12333f;
    }

    public boolean e() {
        if (c() == true) goto L7;
        return false;
    L7:
        return this.f12330c;
    }

    public void f(int r2) {
        if (c() == true) goto L5;
        return;
    L5:
        this.f12333f = r2;
        c r1 = this.f12328a;
        if (r1 == null) goto L9;
        r1.a(r2);
        return;
    }
}
