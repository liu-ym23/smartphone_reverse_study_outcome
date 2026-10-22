package com.bytedance.memory.i;

import androidx.annotation.NonNull;
import com.bytedance.memory.b.c;
import d.b.l.a.h.d;
import d.b.l.a.h.e;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile a f5070h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f5071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f5072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile boolean f5073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.memory.b.a f5074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f5075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.bytedance.memory.f.a f5076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private e f5077g;

    /* JADX INFO: renamed from: com.bytedance.memory.i.a$a, reason: collision with other inner class name */
    class C0160a implements e {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f5078f;

        C0160a(a r1) {
            this.f5078f = r1;
        }

        @Override // d.b.l.a.h.e
        public d.b.l.a.h.b S() {
            return d.b.l.a.h.b.f14112f;
        }

        @Override // d.b.l.a.h.e
        public String X() {
            return "mDumpHeapTask-MC";
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.a(this.f5078f) == true) goto L9;
            a r0 = this.f5078f;
            if (a.c(r0, a.b(r0)) == false) goto L10;
            a.d(this.f5078f, true);
            a.e(this.f5078f).d();
            c.c("begin dumpHeap", new Object[0]);
            return;
        L10:
            return;
        }
    }

    static {
    }

    private a() {
        this.f5071a = false;
        this.f5072b = false;
        this.f5073c = false;
        this.f5077g = new C0160a(this);
        this.f5075e = d.b.l.a.h.c.a();
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.g();
    }

    static /* synthetic */ com.bytedance.memory.f.a b(a r0) {
        return r0.f5076f;
    }

    static /* synthetic */ boolean c(a r0, com.bytedance.memory.f.a r1) {
        return r0.f(r1);
    }

    static /* synthetic */ boolean d(a r0, boolean r1) {
        r0.f5073c = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.memory.b.a e(a r0) {
        return r0.f5074d;
    }

    private boolean f(@NonNull com.bytedance.memory.f.a r1) {
        if (com.bytedance.memory.b.d.c() < r1.c()) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean g() {
        boolean r0 = this.f5074d.c();
        if (r0 == true) goto L5;
    L7:
        if (r0 == true) goto L15;
        if (this.f5073c == true) goto L15;
        if (this.f5072b == true) goto L15;
        if (this.f5074d.b() == true) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (this.f5075e == null) goto L7;
        c.c("canAnalyse, so cancel check", new Object[0]);
        this.f5075e.e(this.f5077g);
        this.f5071a = true;
        goto L7
    }

    public static a i() {
        if (f5070h != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5070h != null) goto L9;
        f5070h = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f5070h;
    }

    public void h() {
        c.c("finish dumpHeap", new Object[0]);
        this.f5073c = false;
    }

    public void j(boolean r1) {
        this.f5071a = r1;
    }

    public void k(@NonNull com.bytedance.memory.f.a r7, @NonNull com.bytedance.memory.b.a r8) {
        if (this.f5071a == false) goto L6;
        c.c("startCheck canAnalyse", new Object[0]);
        return;
    L6:
        this.f5072b = false;
        this.f5076f = r7;
        if (this.f5075e == null) goto L14;
        c.c("enter startCheck", new Object[0]);
        this.f5074d = r8;
        if (r8.a() == false) goto L11;
        int r9 = 1;
    L12:
        long r4 = r9 * 1000;
        this.f5075e.g(this.f5077g, r4, r4);
        return;
    L11:
        r9 = 30;
        goto L12
    }

    public void l() {
        c.c("stopCheck", new Object[0]);
        this.f5072b = true;
        d r0 = this.f5075e;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.e(this.f5077g);
    }
}
