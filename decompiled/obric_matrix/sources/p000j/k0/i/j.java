package p000j.k0.i;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import k.e;
import k.f;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
final class j implements Closeable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Logger f18060l = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final f f18061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f18062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final e f18063h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18064i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f18065j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final d.b f18066k;

    static {
        f18060l = Logger.getLogger(e.class.getName());
    }

    j(f r1, boolean r2) {
        this.f18061f = r1;
        this.f18062g = r2;
        e r3 = new e();
        this.f18063h = r3;
        this.f18066k = new d.b(r3);
        this.f18064i = 16384;
    }

    private void Q(int r7, long r8) {
    L3:
        if (r8 <= 0) goto L9;
        int r2 = (int) Math.min(this.f18064i, r8);
        long r3 = r2;
        r8 = r8 - r3;
        if (r8 != 0) goto L7;
        byte r0 = 4;
    L8:
        s(r7, r2, (byte) 9, r0);
        this.f18061f.J(this.f18063h, r3);
        goto L3
    L7:
        r0 = 0;
        goto L8
    }

    private static void S(f r1, int r2) {
        r1.w((r2 >>> 16) & 255);
        r1.w((r2 >>> 8) & 255);
        r1.w(r2 & 255);
    }

    void A(boolean r7, int r8, List<c> r9) {
        if (this.f18065j == true) goto L15;
        this.f18066k.g(r9);
        long r0 = this.f18063h.k0();
        int r10 = (int) Math.min(this.f18064i, r0);
        long r2 = r10;
        if (r0 != r2) goto L7;
        byte r5 = 4;
    L8:
        if (r7 == false) goto L10;
        r5 = (byte) (r5 | 1);
    L10:
        s(r8, r10, (byte) 1, r5);
        this.f18061f.J(this.f18063h, r2);
        if (r0 <= r2) goto L16;
        Q(r8, r0 - r2);
        return;
    L16:
        return;
    L7:
        r5 = 0;
        goto L8
    L15:
        throw new IOException("closed");
    }

    public int C() {
        return this.f18064i;
    }

    public synchronized void E(boolean r4, int r5, int r6) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f18065j == true) goto L13;
        if (r4 == false) goto L8;
        byte r7 = 1;
    L9:
        s(0, 8, (byte) 6, r7);     // Catch: Throwable -> L14
        this.f18061f.q(r5);     // Catch: Throwable -> L14
        this.f18061f.q(r6);     // Catch: Throwable -> L14
        this.f18061f.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L8:
        r7 = 0;
        goto L9
    L13:
        throw new IOException("closed");     // Catch: Throwable -> L14
    }

    public synchronized void F(int r9, int r10, List<c> r11) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f18065j == true) goto L15;
        this.f18066k.g(r11);     // Catch: Throwable -> L16
        long r0 = this.f18063h.k0();     // Catch: Throwable -> L16
        int r12 = (int) Math.min(this.f18064i - 4, r0);     // Catch: Throwable -> L16
        long r4 = r12;
        if (r0 != r4) goto L8;
        byte r7 = 4;
    L9:
        s(r9, r12 + 4, (byte) 5, r7);     // Catch: Throwable -> L16
        this.f18061f.q(r10 & Integer.MAX_VALUE);     // Catch: Throwable -> L16
        this.f18061f.J(this.f18063h, r4);     // Catch: Throwable -> L16
        if (r0 <= r4) goto L12;
        Q(r9, r0 - r4);     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L8:
        r7 = 0;
        goto L9
    L15:
        throw new IOException("closed");     // Catch: Throwable -> L16
    }

    public synchronized void L(int r4, b r5) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f18065j == true) goto L13;
        if (r5.f17932f == (-1)) goto L11;
        s(r4, 4, (byte) 3, (byte) 0);     // Catch: Throwable -> L14
        this.f18061f.q(r5.f17932f);     // Catch: Throwable -> L14
        this.f18061f.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L11:
        throw new IllegalArgumentException();     // Catch: Throwable -> L14
    L13:
        throw new IOException("closed");     // Catch: Throwable -> L14
    }

    public synchronized void M(m r5) {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L4:
        if (this.f18065j == true) goto L23;
        int r1 = 0;
        s(0, r5.j() * 6, (byte) 4, (byte) 0);     // Catch: Throwable -> L24
    L7:
        if (r1 >= 10) goto L19;
        if (r5.g(r1) == false) goto L18;
        if (r1 != 4) goto L14;
        int r0 = 3;
    L17:
        this.f18061f.p(r0);     // Catch: Throwable -> L24
        this.f18061f.q(r5.b(r1));     // Catch: Throwable -> L24
        goto L18
    L14:
        if (r1 != 7) goto L16;
        r0 = 4;
        goto L17
    L16:
        r0 = r1;
    L18:
        r1 = r1 + 1;     // Catch: Throwable -> L24
        goto L7
    L19:
        this.f18061f.flush();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L23:
        throw new IOException("closed");     // Catch: Throwable -> L24
    }

    public synchronized void N(boolean r1, int r2, int r3, List<c> r4) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f18065j == true) goto L9;
        A(r1, r2, r4);     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException("closed");     // Catch: Throwable -> L10
    }

    public synchronized void O(int r5, long r6) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f18065j == true) goto L16;
        if (r6 != 0) goto L8;
    L12:
        e.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{Long.valueOf(r6)});     // Catch: Throwable -> L17
        throw null;
    L8:
        if (r6 > 2147483647L) goto L12;
        s(r5, 4, (byte) 8, (byte) 0);     // Catch: Throwable -> L17
        this.f18061f.q((int) r6);     // Catch: Throwable -> L17
        this.f18061f.flush();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L16:
        throw new IOException("closed");     // Catch: Throwable -> L17
    }

    public synchronized void a(m r3) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f18065j == true) goto L12;
        this.f18064i = r3.f(this.f18064i);     // Catch: Throwable -> L13
        if (r3.c() == (-1)) goto L8;
        this.f18066k.e(r3.c());     // Catch: Throwable -> L13
    L8:
        s(0, 0, (byte) 4, (byte) 1);     // Catch: Throwable -> L13
        this.f18061f.flush();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L12:
        throw new IOException("closed");     // Catch: Throwable -> L13
    }

    public synchronized void b() {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.f18065j == true) goto L16;
        if (this.f18062g == true) goto L9;
        monitor-exit(this);
        return;
    L9:
        Logger r0 = f18060l;     // Catch: Throwable -> L17
        if (r0.isLoggable(Level.FINE) == false) goto L12;
        r0.fine(c.r(">> CONNECTION %s", new Object[]{e.f17961a.q()}));     // Catch: Throwable -> L17
    L12:
        this.f18061f.U(e.f17961a.E());     // Catch: Throwable -> L17
        this.f18061f.flush();     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L16:
        throw new IOException("closed");     // Catch: Throwable -> L17
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        this.f18065j = true;     // Catch: Throwable -> L7
        this.f18061f.close();     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void flush() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f18065j == true) goto L9;
        this.f18061f.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L9:
        throw new IOException("closed");     // Catch: Throwable -> L10
    }

    public synchronized void g(boolean r2, int r3, e r4, int r5) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f18065j == true) goto L12;
        byte r0 = 0;
        if (r2 == false) goto L8;
        r0 = (byte) 1;     // Catch: Throwable -> L13
    L8:
        l(r3, r0, r4, r5);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L12:
        throw new IOException("closed");     // Catch: Throwable -> L13
    }

    void l(int r2, byte r3, e r4, int r5) {
        s(r2, r5, (byte) 0, r3);
        if (r5 <= 0) goto L6;
        this.f18061f.J(r4, r5);
        return;
    }

    public void s(int r5, int r6, byte r7, byte r8) {
        Logger r0 = f18060l;
        if (r0.isLoggable(Level.FINE) == false) goto L5;
        r0.fine(e.b(false, r5, r6, r7, r8));
    L5:
        int r1 = this.f18064i;
        if (r6 <= r1) goto L8;
        e.c("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(r1), Integer.valueOf(r6)});
        throw null;
    L8:
        if ((Integer.MIN_VALUE & r5) != 0) goto L11;
        S(this.f18061f, r6);
        this.f18061f.w(r7 & 255);
        this.f18061f.w(r8 & 255);
        this.f18061f.q(r5 & Integer.MAX_VALUE);
        return;
    L11:
        e.c("reserved bit set: %s", new Object[]{Integer.valueOf(r5)});
        throw null;
    }

    public synchronized void x(int r4, b r5, byte[] r6) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.f18065j == true) goto L17;
        if (r5.f17932f == (-1)) goto L13;
        s(0, r6.length + 8, (byte) 7, (byte) 0);     // Catch: Throwable -> L18
        this.f18061f.q(r4);     // Catch: Throwable -> L18
        this.f18061f.q(r5.f17932f);     // Catch: Throwable -> L18
        if (r6.length <= 0) goto L10;
        this.f18061f.U(r6);     // Catch: Throwable -> L18
    L10:
        this.f18061f.flush();     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L13:
        e.c("errorCode.httpCode == -1", new Object[0]);     // Catch: Throwable -> L18
        throw null;
    L17:
        throw new IOException("closed");     // Catch: Throwable -> L18
    }
}
