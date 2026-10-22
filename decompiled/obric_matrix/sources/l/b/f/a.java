package l.b.f;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l.b.a.r2.b f21904a;

    static {
    }

    public a(l.b.a.r2.b r2) {
        Objects.requireNonNull(r2, "certificationRequest cannot be null");
        this.f21904a = r2;
    }

    public byte[] a() {
        return this.f21904a.getEncoded();
    }

    public l.b.a.r2.b b() {
        return this.f21904a;
    }

    public boolean equals(Object r2) {
        if (r2 != this) goto L6;
        return true;
    L6:
        if ((r2 instanceof a) == true) goto L10;
        return false;
    L10:
        return b().equals(((a) r2).b());
    }

    public int hashCode() {
        return b().hashCode();
    }
}
