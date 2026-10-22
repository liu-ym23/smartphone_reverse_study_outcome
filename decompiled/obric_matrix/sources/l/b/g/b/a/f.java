package l.b.g.b.a;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class f implements l.b.h.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f22003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f22004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f22005h;

    public f(e r1, byte[] r2, byte[] r3) {
        this.f22003f = r1;
        this.f22004g = r2;
        this.f22005h = r3;
    }

    public static f a(Object r4) {
        if ((r4 instanceof f) == false) goto L7;
        return (f) r4;
    L7:
        if ((r4 instanceof DataInputStream) == false) goto L11;
        DataInputStream r5 = (DataInputStream) r4;
        e r0 = e.e(r5.readInt());
        byte[] r1 = new byte[r0.c()];
        r5.readFully(r1);
        byte[] r2 = new byte[r0.d() * r0.c()];
        r5.readFully(r2);
        return new f(r0, r1, r2);
    L11:
        if ((r4 instanceof byte[]) == false) goto L24;
        DataInputStream r3 = null;
        DataInputStream r6 = new DataInputStream(new ByteArrayInputStream((byte[]) r4));     // Catch: Throwable -> L19
        f r7 = a(r6);     // Catch: Throwable -> L17
        r6.close();
        return r7;
    L17:
        th = th;
        r3 = r6;
    L20:
        if (r3 == null) goto L22;
        r3.close();
    L22:
        throw th;
    L19:
        th = th;
        goto L20
    L24:
        if ((r4 instanceof InputStream) == false) goto L28;
        return a(l.b.h.i.a.b((InputStream) r4));
    L28:
        throw new IllegalArgumentException("cannot parse " + r4);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L23:
        return false;
    L8:
        if (f.class != r4.getClass()) goto L23;
        f r5 = (f) r4;
        e r1 = this.f22003f;
        if (r1 == null) goto L16;
        if (r1.equals(r5.f22003f) == true) goto L19;
    L17:
        return false;
    L19:
        if (Arrays.equals(this.f22004g, r5.f22004g) == true) goto L22;
        return false;
    L22:
        return Arrays.equals(this.f22005h, r5.f22005h);
    L16:
        if (r5.f22003f == null) goto L19;
        goto L17
    }

    @Override // l.b.h.c
    public byte[] getEncoded() {
        a r0 = a.f();
        r0.i(this.f22003f.f());
        r0.d(this.f22004g);
        r0.d(this.f22005h);
        return r0.b();
    }

    public int hashCode() {
        e r0 = this.f22003f;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((r1 * 31) + Arrays.hashCode(this.f22004g)) * 31) + Arrays.hashCode(this.f22005h);
    L5:
        r1 = 0;
        goto L7
    }
}
