package com.bytedance.memory.g;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class h extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final OutputStream f5039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ByteArrayOutputStream f5041d;

    private class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f5042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f5043b;

        a(h r1, int r2, int r3, long r4) {
            this.f5043b = r1;
            super(null);
            this.f5042a = r2;
        }

        @Override // com.bytedance.memory.g.d
        public void a() {
            h.k(this.f5043b).write(this.f5042a);     // Catch: Throwable -> L4
            h.k(this.f5043b).write(h.i(this.f5043b).toByteArray());     // Catch: Throwable -> L4
            h.i(this.f5043b).reset();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void b(int r3, e r4) {
            h.i(this.f5043b).write(r3);     // Catch: Throwable -> L6
            h.i(this.f5043b).write(r4.a());     // Catch: Throwable -> L6
            if (r3 != 1) goto L11;
            i.j(h.i(this.f5043b), h.j(this.f5043b));     // Catch: Throwable -> L6
            return;
        L11:
            return;
        L6:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void c(e r2, int r3, e r4, e r5, int r6, c[] r7, c[] r8) {
            h.i(this.f5043b).write(32);     // Catch: Throwable -> L10
            h.i(this.f5043b).write(r2.a());     // Catch: Throwable -> L10
            h.i(this.f5043b).write(r4.a());     // Catch: Throwable -> L10
            h.i(this.f5043b).write(r5.a());     // Catch: Throwable -> L10
            i.j(h.i(this.f5043b), h.j(this.f5043b) << 1);     // Catch: Throwable -> L10
            i.m(h.i(this.f5043b), r6);     // Catch: Throwable -> L10
            int r9 = 0;
            i.m(h.i(this.f5043b), 0);     // Catch: Throwable -> L10
            i.m(h.i(this.f5043b), r7.length);     // Catch: Throwable -> L10
            int r10 = r7.length;     // Catch: Throwable -> L10
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            c r12 = r7[r11];     // Catch: Throwable -> L10
            i.n(h.i(this.f5043b), r12.f5033b);     // Catch: Throwable -> L10
            h.i(this.f5043b).write(r12.f5032a);     // Catch: Throwable -> L10
            i.p(h.i(this.f5043b), r12.f5034c);     // Catch: Throwable -> L10
            r11 = r11 + 1;     // Catch: Throwable -> L10
            goto L3
        L5:
            i.m(h.i(this.f5043b), r8.length);     // Catch: Throwable -> L10
            int r13 = r8.length;     // Catch: Throwable -> L10
        L6:
            if (r9 >= r13) goto L9;
            c r14 = r8[r9];     // Catch: Throwable -> L10
            i.n(h.i(this.f5043b), r14.f5033b);     // Catch: Throwable -> L10
            h.i(this.f5043b).write(r14.f5032a);     // Catch: Throwable -> L10
            r9 = r9 + 1;
            goto L6
        L9:
            return;
        L10:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void d(int r3, e r4) {
            h.i(this.f5043b).write(254);     // Catch: Throwable -> L4
            i.k(h.i(this.f5043b), r3);     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r4.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void e(e r2, int r3, e r4, byte[] r5) {
            h.i(this.f5043b).write(33);     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r2.a());     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r4.a());     // Catch: Throwable -> L4
            i.k(h.i(this.f5043b), r5.length);     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r5);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void f(e r1, int r2, int r3) {
            h.i(this.f5043b).write(3);     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r1.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void g(e r1, int r2, int r3) {
            h.i(this.f5043b).write(2);     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r1.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void h(e r1, int r2, int r3) {
            h.i(this.f5043b).write(142);     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r1.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void i(e r2, int r3) {
            h.i(this.f5043b).write(4);     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r2.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void j(e r2, int r3, int r4, e r5, byte[] r6) {
            h.i(this.f5043b).write(34);     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r2.a());     // Catch: Throwable -> L4
            i.k(h.i(this.f5043b), r4);     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r5.a());     // Catch: Throwable -> L4
            int r7 = r4 * h.j(this.f5043b);     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r6, 0, r7);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void k(int r1, e r2, int r3, int r4, int r5, byte[] r6) {
            h.i(this.f5043b).write(r1);     // Catch: Throwable -> L8
            h.i(this.f5043b).write(r2.a());     // Catch: Throwable -> L8
            i.k(h.i(this.f5043b), r4);     // Catch: Throwable -> L8
            h.i(this.f5043b).write(r5);     // Catch: Throwable -> L8
            com.bytedance.memory.g.a r7 = com.bytedance.memory.g.a.b(r5);     // Catch: Throwable -> L8
            if (r7 != com.bytedance.memory.g.a.f5027j) goto L5;
            return;
        L5:
            if (r7 == com.bytedance.memory.g.a.m) goto L14;
            i.j(h.i(this.f5043b), r4 * com.bytedance.memory.g.a.b(r5).a(h.j(this.f5043b)));     // Catch: Throwable -> L8
            return;
        L14:
            return;
        L8:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void l(e r2, int r3) {
            h.i(this.f5043b).write(6);     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r2.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }

        @Override // com.bytedance.memory.g.d
        public void m(e r1, int r2, int r3) {
            h.i(this.f5043b).write(8);     // Catch: Throwable -> L4
            h.i(this.f5043b).write(r1.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            throw new RuntimeException(th);
        }
    }

    public h(OutputStream r2) {
        super(null);
        this.f5040c = 0;
        this.f5041d = new ByteArrayOutputStream();
        this.f5039b = r2;
    }

    static /* synthetic */ ByteArrayOutputStream i(h r0) {
        return r0.f5041d;
    }

    static /* synthetic */ int j(h r0) {
        return r0.f5040c;
    }

    static /* synthetic */ OutputStream k(h r0) {
        return r0.f5039b;
    }

    @Override // com.bytedance.memory.g.g
    public void a() {
        this.f5039b.flush();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // com.bytedance.memory.g.g
    public void b(String r1, int r2, long r3) {
        this.f5040c = r2;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // com.bytedance.memory.g.g
    public /* bridge */ /* synthetic */ d c(int r1, int r2, long r3) {
        return l(r1, r2, r3);
    }

    @Override // com.bytedance.memory.g.g
    public void d(int r1, e r2, int r3, e r4, int r5, long r6) {
        this.f5039b.write(2);     // Catch: Throwable -> L4
        this.f5039b.write(r2.a());     // Catch: Throwable -> L4
        this.f5039b.write(r4.a());     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // com.bytedance.memory.g.g
    public void e(e r1, e r2, e r3, e r4, int r5, int r6, int r7, long r8) {
    }

    @Override // com.bytedance.memory.g.g
    public void f(int r1, int r2, e[] r3, int r4, long r5) {
    }

    @Override // com.bytedance.memory.g.g
    public void g(e r2, String r3, int r4, long r5) {
        this.f5039b.write(1);     // Catch: Throwable -> L4
        i.m(this.f5039b, (int) r5);     // Catch: Throwable -> L4
        this.f5039b.write(r2.a());     // Catch: Throwable -> L4
        i.o(this.f5039b, r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }

    @Override // com.bytedance.memory.g.g
    public void h(int r1, int r2, long r3, byte[] r5) {
        if (r1 == 44) goto L10;
        return;
    L10:
        this.f5039b.write(r1);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw new RuntimeException(th);
    }

    public a l(int r8, int r9, long r10) {
        return new a(this, r8, r9, r10);
    L4:
        th = move-exception;
        throw new RuntimeException(th);
    }
}
