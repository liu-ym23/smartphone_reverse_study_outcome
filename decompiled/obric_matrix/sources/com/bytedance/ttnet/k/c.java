package com.bytedance.ttnet.k;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c extends Observable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile c f6466c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f6467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CopyOnWriteArrayList<Integer> f6468b;

    public c() {
        this.f6468b = new CopyOnWriteArrayList();
    }

    public static c a() {
        if (f6466c != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6466c != null) goto L9;
        f6466c = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f6466c;
    }

    private void b(Map<String, Object> r1) {
        setChanged();
        notifyObservers(r1);
    }

    public void c(boolean r2, List<Integer> r3) {
        this.f6467a = r2;
        this.f6468b.clear();
        this.f6468b.addAll(r3);
        HashMap r4 = new HashMap();
        r4.put("user_blocked_state", Boolean.valueOf(this.f6467a));
        r4.put("drop_reason_list", this.f6468b);
        b(r4);
    }
}
