package l.b.a;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
class n0 extends InputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final y f21627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f21628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private InputStream f21629h;

    n0(y r2) {
        this.f21628g = true;
        this.f21627f = r2;
    }

    private q a() {
        e r3 = this.f21627f.b();
        if (r3 != null) goto L7;
        return null;
    L7:
        if ((r3 instanceof q) == false) goto L11;
        return (q) r3;
    L11:
        throw new IOException("unknown object encountered: " + r3.getClass());
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f21629h != null) goto L11;
        if (this.f21628g == true) goto L7;
        return -1;
    L7:
        q r0 = a();
        if (r0 != null) goto L10;
        return -1;
    L10:
        this.f21628g = false;
        this.f21629h = r0.a();
    L11:
        int r1 = this.f21629h.read();
        if (r1 >= 0) goto L13;
        q r2 = a();
        if (r2 == null) goto L16;
        this.f21629h = r2.a();
        goto L11
    L16:
        this.f21629h = null;
        return -1;
    L13:
        return r1;
    }

    @Override // java.io.InputStream
    public int read(byte[] r6, int r7, int r8) {
        int r1 = 0;
        if (this.f21629h != null) goto L12;
        if (this.f21628g == true) goto L7;
        return -1;
    L7:
        q r0 = a();
        if (r0 != null) goto L10;
        return -1;
    L10:
        this.f21628g = false;
        this.f21629h = r0.a();
    L12:
        int r2 = this.f21629h.read(r6, r7 + r1, r8 - r1);
        if (r2 >= 0) goto L14;
        q r3 = a();
        if (r3 == null) goto L19;
        this.f21629h = r3.a();
        goto L12
    L19:
        this.f21629h = null;
        if (r1 >= 1) goto L23;
        return -1;
    L23:
        return r1;
    L14:
        r1 = r1 + r2;
        if (r1 != r8) goto L12;
        return r1;
    }
}
