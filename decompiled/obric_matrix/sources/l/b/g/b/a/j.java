package l.b.g.b.a;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
class j implements l.b.h.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final f f22019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final k f22020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[][] f22021i;

    public j(int r1, f r2, k r3, byte[][] r4) {
        this.f22018f = r1;
        this.f22019g = r2;
        this.f22020h = r3;
        this.f22021i = r4;
    }

    public static j a(Object r7) {
        if ((r7 instanceof j) == false) goto L7;
        return (j) r7;
    L7:
        if ((r7 instanceof DataInputStream) == false) goto L14;
        DataInputStream r0 = (DataInputStream) r7;
        int r1 = r0.readInt();
        f r8 = f.a(r7);
        k r2 = k.e(r0.readInt());
        int r3 = r2.c();
        byte[][] r4 = new byte[r3][];
        int r5 = 0;
    L9:
        if (r5 >= r3) goto L12;
        r4[r5] = new byte[r2.d()];
        r0.readFully(r4[r5]);
        r5 = r5 + 1;
        goto L9
    L12:
        return new j(r1, r8, r2, r4);
    L14:
        if ((r7 instanceof byte[]) == false) goto L27;
        DataInputStream r6 = null;
        DataInputStream r9 = new DataInputStream(new ByteArrayInputStream((byte[]) r7));     // Catch: Throwable -> L22
        j r10 = a(r9);     // Catch: Throwable -> L20
        r9.close();
        return r10;
    L20:
        th = th;
        r6 = r9;
    L23:
        if (r6 == null) goto L25;
        r6.close();
    L25:
        throw th;
    L22:
        th = th;
        goto L23
    L27:
        if ((r7 instanceof InputStream) == false) goto L31;
        return a(l.b.h.i.a.b((InputStream) r7));
    L31:
        throw new IllegalArgumentException("cannot parse " + r7);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L31:
        return false;
    L8:
        if (j.class != r4.getClass()) goto L31;
        j r5 = (j) r4;
        if (this.f22018f == r5.f22018f) goto L13;
        return false;
    L13:
        f r1 = this.f22019g;
        if (r1 == null) goto L19;
        if (r1.equals(r5.f22019g) == false) goto L20;
    L21:
        k r2 = this.f22020h;
        if (r2 == null) goto L27;
        if (r2.equals(r5.f22020h) == true) goto L30;
    L28:
        return false;
    L30:
        return Arrays.deepEquals(this.f22021i, r5.f22021i);
    L27:
        if (r5.f22020h == null) goto L30;
    L20:
        return false;
    L19:
        if (r5.f22019g == null) goto L21;
        goto L20
    }

    @Override // l.b.h.c
    public byte[] getEncoded() {
        a r0 = a.f();
        r0.i(this.f22018f);
        r0.d(this.f22019g.getEncoded());
        r0.i(this.f22020h.f());
        r0.e(this.f22021i);
        return r0.b();
    }

    public int hashCode() {
        int r0 = this.f22018f * 31;
        f r1 = this.f22019g;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        k r5 = this.f22020h;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return ((r4 + r2) * 31) + Arrays.deepHashCode(this.f22021i);
    L5:
        r3 = 0;
        goto L6
    }
}
