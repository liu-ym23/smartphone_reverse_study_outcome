package l.b.a;

/* JADX INFO: loaded from: classes2.dex */
class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final u f21630a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final w f21631b = null;

    static {
        f21630a = new p1();
        f21631b = new r1();
    }

    static u a(f r2) {
        if (r2.f() >= 1) goto L7;
        return f21630a;
    L7:
        return new p1(r2);
    }

    static w b(f r2) {
        if (r2.f() >= 1) goto L7;
        return f21631b;
    L7:
        return new r1(r2);
    }
}
