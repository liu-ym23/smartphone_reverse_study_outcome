package l.b.a.v2;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import l.b.a.c1;
import l.b.a.n;
import l.b.a.o;
import l.b.a.t;

/* JADX INFO: loaded from: classes2.dex */
public class d extends n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Hashtable f21777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Vector f21778g;

    public d(c[] r5) {
        this.f21777f = new Hashtable();
        this.f21778g = new Vector();
        int r0 = 0;
    L4:
        if (r0 == r5.length) goto L6;
        c r1 = r5[r0];
        this.f21778g.addElement(r1.n());
        this.f21777f.put(r1.n(), r1);
        r0 = r0 + 1;
        goto L4
    }

    @Override // l.b.a.n, l.b.a.e
    public t b() {
        l.b.a.f r0 = new l.b.a.f(this.f21778g.size());
        Enumeration r1 = this.f21778g.elements();
    L4:
        if (r1.hasMoreElements() == false) goto L7;
        o r2 = (o) r1.nextElement();
        r0.a((c) this.f21777f.get(r2));
        goto L4
    L7:
        return new c1(r0);
    }
}
