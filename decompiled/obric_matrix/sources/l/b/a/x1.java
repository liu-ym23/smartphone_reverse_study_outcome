package l.b.a;

import java.io.EOFException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
class x1 extends a2 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f21809h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f21810i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f21811j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f21812k;

    x1(InputStream r1, int r2) {
        super(r1, r2);
        this.f21811j = false;
        this.f21812k = true;
        this.f21809h = r1.read();
        int r3 = r1.read();
        this.f21810i = r3;
        if (r3 < 0) goto L7;
        g();
        return;
    L7:
        throw new EOFException();
    }

    private boolean g() {
        if (this.f21811j == true) goto L12;
        if (this.f21812k == false) goto L12;
        if (this.f21809h != 0) goto L12;
        if (this.f21810i != 0) goto L12;
        this.f21811j = true;
        b(true);
    L12:
        return this.f21811j;
    }

    void l(boolean r1) {
        this.f21812k = r1;
        g();
    }

    @Override // java.io.InputStream
    public int read() {
        if (g() == false) goto L6;
        return -1;
    L6:
        int r0 = this.f21512f.read();
        if (r0 < 0) goto L11;
        int r1 = this.f21809h;
        this.f21809h = this.f21810i;
        this.f21810i = r0;
        return r1;
    L11:
        throw new EOFException();
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        if (this.f21812k == true) goto L22;
        if (r5 < 3) goto L22;
        if (this.f21811j == false) goto L11;
        return -1;
    L11:
        int r6 = this.f21512f.read(r3, r4 + 2, r5 - 2);
        if (r6 < 0) goto L20;
        r3[r4] = (byte) this.f21809h;
        r3[r4 + 1] = (byte) this.f21810i;
        this.f21809h = this.f21512f.read();
        int r7 = this.f21512f.read();
        this.f21810i = r7;
        if (r7 < 0) goto L18;
        return r6 + 2;
    L18:
        throw new EOFException();
    L20:
        throw new EOFException();
    L22:
        return super.read(r3, r4, r5);
    }
}
