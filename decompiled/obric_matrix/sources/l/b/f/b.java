package l.b.f;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l.b.a.d1;
import l.b.a.e;
import l.b.a.o;
import l.b.a.p0;
import l.b.a.u2.c;
import l.b.a.v2.f;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f21905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f21906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f21907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f21908d;

    public b(c r2, f r3) {
        this.f21907c = new ArrayList();
        this.f21908d = false;
        this.f21906b = r2;
        this.f21905a = r3;
    }

    public b a(o r4, e r5) {
        this.f21907c.add(new l.b.a.r2.a(r4, new d1(r5)));
        return this;
    }

    public a b(l.b.e.a r5) {
        if (this.f21907c.isEmpty() == true) goto L5;
        l.b.a.f r0 = new l.b.a.f();
        Iterator r1 = this.f21907c.iterator();
    L10:
        if (r1.hasNext() == false) goto L12;
        r0.a(l.b.a.r2.a.p(r1.next()));
        goto L10
    L12:
        l.b.a.r2.c r2 = new l.b.a.r2.c(this.f21906b, this.f21905a, new d1(r0));
    L17:
        OutputStream r4 = r5.b();     // Catch: IOException -> L15
        r4.write(r2.m("DER"));     // Catch: IOException -> L15
        r4.close();     // Catch: IOException -> L15
        return new a(new l.b.a.r2.b(r2, r5.c(), new p0(r5.a())));
    L16:
        throw new IllegalStateException("cannot produce certification request signature");
    L5:
        if (this.f21908d == false) goto L7;
        r2 = new l.b.a.r2.c(this.f21906b, this.f21905a, null);
        goto L17
    L7:
        r2 = new l.b.a.r2.c(this.f21906b, this.f21905a, new d1());
        goto L17
    }
}
