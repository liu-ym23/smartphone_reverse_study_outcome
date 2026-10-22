package com.bytedance.memory.g;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected g f5038a;

    public g(g r2) {
        this.f5038a = null;
        this.f5038a = r2;
    }

    public void a() {
        g r0 = this.f5038a;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public void b(String r1, int r2, long r3) {
        g r0 = this.f5038a;
        if (r0 == null) goto L6;
        r0.b(r1, r2, r3);
        return;
    }

    public d c(int r1, int r2, long r3) {
        g r0 = this.f5038a;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.c(r1, r2, r3);
    }

    public void d(int r9, e r10, int r11, e r12, int r13, long r14) {
        g r0 = this.f5038a;
        if (r0 == null) goto L6;
        r0.d(r9, r10, r11, r12, r13, r14);
        return;
    }

    public void e(e r11, e r12, e r13, e r14, int r15, int r16, int r17, long r18) {
        g r0 = this.f5038a;
        if (r0 == null) goto L6;
        r0.e(r11, r12, r13, r14, r15, r16, r17, r18);
        return;
    }

    public void f(int r8, int r9, e[] r10, int r11, long r12) {
        g r0 = this.f5038a;
        if (r0 == null) goto L6;
        r0.f(r8, r9, r10, r11, r12);
        return;
    }

    public void g(e r7, String r8, int r9, long r10) {
        g r0 = this.f5038a;
        if (r0 == null) goto L6;
        r0.g(r7, r8, r9, r10);
        return;
    }

    public void h(int r7, int r8, long r9, byte[] r11) {
        g r0 = this.f5038a;
        if (r0 == null) goto L6;
        r0.h(r7, r8, r9, r11);
        return;
    }
}
