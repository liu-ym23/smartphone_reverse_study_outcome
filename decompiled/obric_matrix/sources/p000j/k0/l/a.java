package p000j.k0.l;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import k.g;
import k.n;
import k.q;
import p000j.k0.c;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final byte[] f18106e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f18107f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f18108g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a f18109h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f18110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CountDownLatch f18111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f18112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f18113d;

    static {
        f18106e = new byte[]{42};
        f18107f = new String[0];
        f18108g = new String[]{"*"};
        f18109h = new a();
    }

    public a() {
        this.f18110a = new AtomicBoolean(false);
        this.f18111b = new CountDownLatch(1);
    }

    private static String a(byte[] r17, byte[][] r18, int r19) {
        int r2 = r17.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L43;
        int r5 = (r4 + r2) / 2;
    L6:
        if (r5 <= (-1)) goto L10;
        if (r17[r5] == 10) goto L10;
        r5 = r5 - 1;
    L10:
        int r6 = r5 + 1;
        int r9 = 1;
    L11:
        int r10 = r6 + r9;
        if (r17[r10] == 10) goto L14;
        r9 = r9 + 1;
        goto L11
    L14:
        int r7 = r10 - r6;
        int r11 = r19;
        boolean r12 = false;
        int r13 = 0;
        int r14 = 0;
    L15:
        if (r12 == false) goto L17;
        int r15 = 46;
        boolean r16 = false;
    L18:
        int r20 = r15 - (r17[r6 + r14] & 255);
        if (r20 != 0) goto L28;
        r14 = r14 + 1;
        r13 = r13 + 1;
        if (r14 == r7) goto L28;
        if (r18[r11].length == r13) goto L27;
        r12 = r16;
        goto L15
    L27:
        if (r11 == (r18.length - 1)) goto L28;
        r11 = r11 + 1;
        r13 = -1;
        r12 = true;
    L28:
        if (r20 < 0) goto L29;
        if (r20 > 0) goto L31;
        int r8 = r7 - r14;
        int r21 = r18[r11].length - r13;
    L33:
        r11 = r11 + 1;
        if (r11 >= r18.length) goto L36;
        r21 = r21 + r18[r11].length;
        goto L33
    L36:
        if (r21 < r8) goto L29;
        if (r21 > r8) goto L31;
        return new String(r17, r6, r7, c.f17800i);
    L31:
        r4 = r10 + 1;
    L29:
        r2 = r6 - 1;
        goto L3
    L17:
        r16 = r12;
        r15 = r18[r11][r13] & 255;
        goto L18
    L43:
        return null;
    }

    private String[] b(String[] r9) {
        int r1 = 0;
        if (this.f18110a.get() == false) goto L5;
    L66:
        this.f18111b.await();     // Catch: InterruptedException -> L9
    L10:
        monitor-enter(this);
    L62:
        th = move-exception;
        throw th;
    L12:
        if (this.f18112c == null) goto L61;
        monitor-exit(this);     // Catch: Throwable -> L62
        int r0 = r9.length;
        byte[][] r3 = new byte[r0][];
        int r4 = 0;
    L16:
        if (r4 >= r9.length) goto L18;
        r3[r4] = r9[r4].getBytes(c.f17800i);
        r4 = r4 + 1;
        goto L16
    L18:
        int r10 = 0;
    L19:
        String r5 = null;
        if (r10 >= r0) goto L25;
        String r6 = a(this.f18112c, r3, r10);
        if (r6 != null) goto L26;
        r10 = r10 + 1;
    L26:
        if (r0 <= 1) goto L34;
        byte[][] r11 = (byte[][]) r3.clone();
        int r7 = 0;
    L29:
        if (r7 >= (r11.length - 1)) goto L34;
        r11[r7] = f18106e;
        String r8 = a(this.f18112c, r11, r7);
        if (r8 != null) goto L35;
        r7 = r7 + 1;
    L35:
        if (r8 != null) goto L37;
    L42:
        if (r5 != null) goto L44;
        if (r6 != null) goto L49;
        if (r8 != null) goto L49;
        return f18108g;
    L49:
        if (r6 == null) goto L51;
        String[] r12 = r6.split("\\.");
    L52:
        if (r8 == null) goto L54;
        String[] r13 = r8.split("\\.");
    L56:
        if (r12.length <= r13.length) goto L59;
        return r12;
    L59:
        return r13;
    L54:
        r13 = f18107f;
        goto L56
    L51:
        r12 = f18107f;
        goto L52
    L44:
        return ("!" + r5).split("\\.");
    L37:
        if (r1 >= (r0 - 1)) goto L42;
        String r14 = a(this.f18113d, r3, r1);
        if (r14 != null) goto L40;
        r1 = r1 + 1;
        goto L37
    L40:
        r5 = r14;
    L34:
        r8 = null;
        goto L35
    L25:
        r6 = null;
        goto L26
    L61:
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");     // Catch: Throwable -> L62
    L9:
        Thread.currentThread().interrupt();
        goto L10
    L5:
        if (this.f18110a.compareAndSet(false, true) == false) goto L66;
        f();
        goto L10
    }

    public static a c() {
        return f18109h;
    }

    private void e() {
        InputStream r0 = a.class.getResourceAsStream("publicsuffixes.gz");
        if (r0 != null) goto L5;
        return;
    L5:
        g r1 = q.b(new n(q.j(r0)));
        byte[] r2 = new byte[r1.readInt()];     // Catch: Throwable -> L16
        r1.readFully(r2);     // Catch: Throwable -> L16
        byte[] r3 = new byte[r1.readInt()];     // Catch: Throwable -> L16
        r1.readFully(r3);     // Catch: Throwable -> L16
        c.g(r1);
        monitor-enter(this);
        this.f18112c = r2;     // Catch: Throwable -> L13
        this.f18113d = r3;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        this.f18111b.countDown();
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        c.g(r1);
        throw th;
    }

    private void f() {
        boolean r0 = false;
    L19:
        e();     // Catch: Throwable -> L7 IOException -> L9 InterruptedIOException -> L14
    L4:
        if (r0 == false) goto L23;
        Thread.currentThread().interrupt();
        return;
    L23:
        return;
    L7:
        th = move-exception;
        if (r0 == false) goto L18;
        Thread.currentThread().interrupt();
    L18:
        throw th;
    L14:
        Thread.interrupted();     // Catch: Throwable -> L7
        r0 = true;
    L9:
        e = move-exception;
        p000j.k0.j.g.m().t(5, "Failed to read public suffix list", e);     // Catch: Throwable -> L7
        if (r0 == false) goto L24;
        Thread.currentThread().interrupt();
        return;
    }

    public String d(String r7) {
        Objects.requireNonNull(r7, "domain == null");
        String[] r0 = IDN.toUnicode(r7).split("\\.");
        String[] r6 = b(r0);
        if (r0.length == r6.length) goto L5;
    L8:
        char r2 = r6[0].charAt(0);
        int r1 = r0.length;
        int r8 = r6.length;
        if (r2 == '!') goto L12;
        r8 = r8 + 1;
    L12:
        int r3 = r1 - r8;
        StringBuilder r9 = new StringBuilder();
        String[] r10 = r7.split("\\.");
    L14:
        if (r3 >= r10.length) goto L16;
        r9.append(r10[r3]);
        r9.append('.');
        r3 = r3 + 1;
        goto L14
    L16:
        r9.deleteCharAt(r9.length() - 1);
        return r9.toString();
    L5:
        if (r6[0].charAt(0) == '!') goto L8;
        return null;
    }
}
