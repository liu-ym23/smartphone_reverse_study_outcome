package l.b.a.v2;

import java.util.Hashtable;
import java.util.Vector;
import l.b.a.o;
import l.b.a.y0;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Hashtable f21779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Vector f21780b;

    public e() {
        this.f21779a = new Hashtable();
        this.f21780b = new Vector();
    }

    public void a(o r2, boolean r3, l.b.a.e r4) {
        b(r2, r3, r4.b().m("DER"));
    }

    public void b(o r3, boolean r4, byte[] r5) {
        if (this.f21779a.containsKey(r3) == true) goto L7;
        this.f21780b.addElement(r3);
        this.f21779a.put(r3, new c(r3, r4, new y0(r5)));
        return;
    L7:
        throw new IllegalArgumentException("extension " + r3 + " already added");
    }

    public d c() {
        c[] r0 = new c[this.f21780b.size()];
        int r1 = 0;
    L4:
        if (r1 == this.f21780b.size()) goto L7;
        r0[r1] = (c) this.f21779a.get(this.f21780b.elementAt(r1));
        r1 = r1 + 1;
        goto L4
    L7:
        return new d(r0);
    }
}
