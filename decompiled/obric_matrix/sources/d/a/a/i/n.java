package d.a.a.i;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class n extends d.a.a.i.q.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f12449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f12450e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final b f12451f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f12452g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f12453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Collection f12454i;

    public n(b r3, List r4, int r5) {
        super(null, null, 0);
        this.f12451f = r3;
        this.f12449d = r5;
        this.f12450e = r4;
        this.f12452g = null;
        this.f12453h = null;
        this.f12454i = null;
    }

    public n(Collection r3) {
        super(null, null, 0);
        this.f12451f = null;
        this.f12449d = -1;
        this.f12450e = null;
        this.f12452g = null;
        this.f12453h = null;
        this.f12454i = r3;
    }

    public n(Map r3, Object r4) {
        super(null, null, 0);
        this.f12451f = null;
        this.f12449d = -1;
        this.f12450e = null;
        this.f12452g = r4;
        this.f12453h = r3;
        this.f12454i = null;
    }

    @Override // d.a.a.i.q.d
    public void b(b r1, Object r2, Type r3, Map<String, Object> r4) {
    }

    @Override // d.a.a.i.q.d
    public void g(Object r4, Object r5) {
        Map r6 = this.f12453h;
        if (r6 == null) goto L6;
        r6.put(this.f12452g, r5);
        return;
    L6:
        Collection r7 = this.f12454i;
        if (r7 == null) goto L10;
        r7.add(r5);
        return;
    L10:
        this.f12450e.set(this.f12449d, r5);
        List r8 = this.f12450e;
        if ((r8 instanceof d.a.a.b) == false) goto L21;
        d.a.a.b r9 = (d.a.a.b) r8;
        Object r0 = r9.u();
        if (r0 != null) goto L15;
        return;
    L15:
        if (Array.getLength(r0) > this.f12449d) goto L17;
        return;
    L17:
        if (r9.t() == null) goto L19;
        r5 = d.a.a.k.d.c(r5, r9.t(), this.f12451f.f12385g);
    L19:
        Array.set(r0, this.f12449d, r5);
        return;
    }
}
