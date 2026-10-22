package l.b.c;

import java.security.PrivateKey;
import java.util.List;
import l.b.a.c1;
import l.b.a.f;
import l.b.a.r2.e;

/* JADX INFO: loaded from: classes2.dex */
public class a implements PrivateKey {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<PrivateKey> f21867f;

    public List<PrivateKey> a() {
        return this.f21867f;
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof a) == true) goto L8;
        return false;
    L8:
        return this.f21867f.equals(((a) r2).f21867f);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "Composite";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        f r0 = new f();
        int r1 = 0;
    L4:
        if (r1 == this.f21867f.size()) goto L11;
        r0.a(e.o(this.f21867f.get(r1).getEncoded()));
        r1 = r1 + 1;
        goto L4
    L11:
        return new e(new l.b.a.v2.a(l.b.a.n2.a.f21639h), new c1(r0)).m("DER");
    L8:
        e = move-exception;
        throw new IllegalStateException("unable to encode composite key: " + e.getMessage());
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public int hashCode() {
        return this.f21867f.hashCode();
    }
}
