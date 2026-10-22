package l.b.h.i.c;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f22305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f22306b;

    private int a(String r1) {
        if (r1 != null) goto L6;
        return 1;
    L6:
        return r1.hashCode();
    }

    private boolean d(String r1, String r2) {
        if (r1 != r2) goto L5;
        return true;
    L5:
        if (r1 == null) goto L10;
        if (r2 != null) goto L9;
        return false;
    L9:
        return r1.equals(r2);
    L10:
        return false;
    }

    public String b() {
        return this.f22305a;
    }

    public String c() {
        return this.f22306b;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof a) == true) goto L5;
        return false;
    L5:
        a r5 = (a) r4;
        if (r5 != this) goto L8;
    L11:
        return true;
    L8:
        if (d(this.f22305a, r5.f22305a) == true) goto L10;
        return false;
    L10:
        if (d(this.f22306b, r5.f22306b) == true) goto L11;
        return false;
    }

    public int hashCode() {
        return a(this.f22305a) + (a(this.f22306b) * 31);
    }
}
