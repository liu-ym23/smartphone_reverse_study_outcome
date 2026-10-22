package l.b.a.u2;

import java.util.Vector;
import l.b.a.o;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f21746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Vector f21747b;

    public d(e r2) {
        this.f21747b = new Vector();
        this.f21746a = r2;
    }

    public d a(o[] r7, String[] r8) {
        int r0 = r8.length;
        l.b.a.e[] r1 = new l.b.a.e[r0];
        int r2 = 0;
    L3:
        if (r2 == r0) goto L5;
        r1[r2] = this.f21746a.e(r7[r2], r8[r2]);
        r2 = r2 + 1;
        goto L3
    L5:
        b(r7, r1);
        return this;
    }

    public d b(o[] r6, l.b.a.e[] r7) {
        a[] r0 = new a[r6.length];
        int r1 = 0;
    L4:
        if (r1 == r6.length) goto L6;
        r0[r1] = new a(r6[r1], r7[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        c(r0);
        return this;
    }

    public d c(a[] r3) {
        this.f21747b.addElement(new b(r3));
        return this;
    }

    public d d(o r2, String r3) {
        e(r2, this.f21746a.e(r2, r3));
        return this;
    }

    public d e(o r3, l.b.a.e r4) {
        this.f21747b.addElement(new b(r3, r4));
        return this;
    }

    public c f() {
        int r0 = this.f21747b.size();
        b[] r1 = new b[r0];
        int r2 = 0;
    L3:
        if (r2 == r0) goto L6;
        r1[r2] = (b) this.f21747b.elementAt(r2);
        r2 = r2 + 1;
        goto L3
    L6:
        return new c(this.f21746a, r1);
    }
}
