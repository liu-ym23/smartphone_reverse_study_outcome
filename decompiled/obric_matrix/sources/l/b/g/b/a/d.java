package l.b.g.b.a;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class d extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f21991f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i f21992g;

    public d(int r2, i r3) {
        super(false);
        this.f21991f = r2;
        this.f21992g = r3;
    }

    public static d a(Object r3) {
        if ((r3 instanceof d) == false) goto L7;
        return (d) r3;
    L7:
        if ((r3 instanceof DataInputStream) == false) goto L11;
        return new d(((DataInputStream) r3).readInt(), i.a(r3));
    L11:
        if ((r3 instanceof byte[]) == false) goto L24;
        DataInputStream r0 = null;
        DataInputStream r1 = new DataInputStream(new ByteArrayInputStream((byte[]) r3));     // Catch: Throwable -> L19
        d r4 = a(r1);     // Catch: Throwable -> L17
        r1.close();
        return r4;
    L17:
        th = th;
        r0 = r1;
    L20:
        if (r0 == null) goto L22;
        r0.close();
    L22:
        throw th;
    L19:
        th = th;
        goto L20
    L24:
        if ((r3 instanceof InputStream) == false) goto L28;
        return a(l.b.h.i.a.b((InputStream) r3));
    L28:
        throw new IllegalArgumentException("cannot parse " + r3);
    }

    public int b() {
        return this.f21991f;
    }

    public i c() {
        return this.f21992g;
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L15:
        return false;
    L8:
        if (d.class != r4.getClass()) goto L15;
        d r5 = (d) r4;
        if (this.f21991f == r5.f21991f) goto L14;
        return false;
    L14:
        return this.f21992g.equals(r5.f21992g);
    }

    @Override // l.b.g.b.a.g, l.b.h.c
    public byte[] getEncoded() {
        a r0 = a.f();
        r0.i(this.f21991f);
        r0.d(this.f21992g.getEncoded());
        return r0.b();
    }

    public int hashCode() {
        return (this.f21991f * 31) + this.f21992g.hashCode();
    }
}
