package l.b.g.b.a;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class i extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k f22014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e f22015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f22016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final byte[] f22017i;

    public i(k r2, e r3, byte[] r4, byte[] r5) {
        super(false);
        this.f22014f = r2;
        this.f22015g = r3;
        this.f22016h = l.b.h.a.d(r5);
        this.f22017i = l.b.h.a.d(r4);
    }

    public static i a(Object r4) {
        if ((r4 instanceof i) == false) goto L7;
        return (i) r4;
    L7:
        if ((r4 instanceof DataInputStream) == false) goto L11;
        DataInputStream r5 = (DataInputStream) r4;
        k r0 = k.e(r5.readInt());
        e r1 = e.e(r5.readInt());
        byte[] r2 = new byte[16];
        r5.readFully(r2);
        byte[] r3 = new byte[r0.d()];
        r5.readFully(r3);
        return new i(r0, r1, r3, r2);
    L11:
        if ((r4 instanceof byte[]) == false) goto L24;
        DataInputStream r6 = null;
        DataInputStream r7 = new DataInputStream(new ByteArrayInputStream((byte[]) r4));     // Catch: Throwable -> L19
        i r8 = a(r7);     // Catch: Throwable -> L17
        r7.close();
        return r8;
    L17:
        th = th;
        r6 = r7;
    L20:
        if (r6 == null) goto L22;
        r6.close();
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

    byte[] b() {
        a r0 = a.f();
        r0.i(this.f22014f.f());
        r0.i(this.f22015g.f());
        r0.d(this.f22016h);
        r0.d(this.f22017i);
        return r0.b();
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L21:
        return false;
    L8:
        if (i.class != r4.getClass()) goto L21;
        i r5 = (i) r4;
        if (this.f22014f.equals(r5.f22014f) == true) goto L14;
        return false;
    L14:
        if (this.f22015g.equals(r5.f22015g) == true) goto L17;
        return false;
    L17:
        if (l.b.h.a.a(this.f22016h, r5.f22016h) == true) goto L20;
        return false;
    L20:
        return l.b.h.a.a(this.f22017i, r5.f22017i);
    }

    @Override // l.b.g.b.a.g, l.b.h.c
    public byte[] getEncoded() {
        return b();
    }

    public int hashCode() {
        return (((((this.f22014f.hashCode() * 31) + this.f22015g.hashCode()) * 31) + l.b.h.a.j(this.f22016h)) * 31) + l.b.h.a.j(this.f22017i);
    }
}
