package com.bytedance.apm.q.j;

import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.q.j.m.b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class c<T extends com.bytedance.apm.q.j.m.b> implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile long f1777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile boolean f1778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile boolean f1779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ConcurrentHashMap<Integer, T> f1780e;

    c(String r3) {
        this.f1780e = new ConcurrentHashMap();
        this.f1776a = r3;
        this.f1778c = ActivityLifeObserver.getInstance().isForeground();
        this.f1777b = System.currentTimeMillis();
        this.f1779d = com.bytedance.apm.q.k.a.f(com.bytedance.apm.d.h());
    }

    @Override // com.bytedance.apm.q.j.l
    public void a(boolean r9) {
        long r6 = System.currentTimeMillis();
        if (this.f1780e.size() == 0) goto L5;
        i(this.f1777b, r6, r9);
    L5:
        this.f1777b = r6;
    }

    @Override // com.bytedance.apm.q.j.l
    public void b(boolean r1) {
        this.f1778c = false;
    }

    @Override // com.bytedance.apm.q.j.l
    public void f(boolean r1) {
        this.f1778c = true;
    }

    protected abstract void g(T r1, long r2, long r4);

    public String h() {
        return this.f1776a;
    }

    protected void i(long r8, long r10, boolean r12) {
        Iterator<Map.Entry<Integer, T>> r13 = this.f1780e.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L19;
        T r2 = r13.next().getValue();
        long r0 = r2.f1806b;
        if (0 >= r0) goto L11;
        if (r0 >= r2.f1805a) goto L11;
    L9:
        r13.remove();
    L11:
        if (0 >= r0) goto L16;
        if (r0 < r8) goto L9;
    L16:
        if (r10 < r2.f1805a) goto L4;
        g(r2, r8, r10);
        goto L4
    }
}
