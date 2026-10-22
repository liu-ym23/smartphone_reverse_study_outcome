package l.b.a;

import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
abstract class a2 extends InputStream {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final InputStream f21512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f21513g;

    a2(InputStream r1, int r2) {
        this.f21512f = r1;
        this.f21513g = r2;
    }

    int a() {
        return this.f21513g;
    }

    protected void b(boolean r2) {
        InputStream r1 = this.f21512f;
        if ((r1 instanceof x1) == false) goto L6;
        ((x1) r1).l(r2);
        return;
    }
}
