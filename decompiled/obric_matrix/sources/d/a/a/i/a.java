package d.a.a.i;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a extends d.a.a.i.q.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected d.a.a.i.q.f f12383d;

    public a(m r1, Class<?> r2, d.a.a.k.a r3) {
        super(r2, r3, 2);
    }

    @Override // d.a.a.i.q.d
    public void b(b r4, Object r5, Type r6, Map<String, Object> r7) {
        if (this.f12383d != null) goto L6;
        m r0 = r4.f12385g;
        d.a.a.k.a r1 = this.f12460a;
        this.f12383d = r0.b(r1.f12534l, r1.m);
    L6:
        if ((r6 instanceof ParameterizedType) == false) goto L8;
        r4.f12389k.f12442d = r6;
    L8:
        d.a.a.k.a r8 = this.f12460a;
        String r2 = r8.s;
        if (r2 == null) goto L13;
        d.a.a.i.q.f r3 = this.f12383d;
        if ((r3 instanceof d.a.a.j.h) == false) goto L13;
        Object r9 = ((d.a.a.j.h) r3).d(r4, r8.m, r8.f12528f, r2);
    L15:
        if (r4.o != 1) goto L17;
        b.a r10 = r4.C();
        r10.f12393c = this;
        r10.f12394d = r4.f12389k;
        r4.o = 0;
        return;
    L17:
        if (r5 != null) goto L19;
        r7.put(this.f12460a.f12528f, r9);
        return;
    L19:
        if (r9 != null) goto L29;
        Class<?> r11 = this.f12460a.f12534l;
        if (r11 != Byte.TYPE) goto L23;
        return;
    L23:
        if (r11 != Short.TYPE) goto L25;
        return;
    L25:
        if (r11 != Float.TYPE) goto L27;
        return;
    L27:
        if (r11 != Double.TYPE) goto L29;
        return;
    L29:
        g(r5, r9);
        return;
    L13:
        r9 = this.f12383d.a(r4, r8.m, r8.f12528f);
        goto L15
    }

    public d.a.a.i.q.f h(m r3) {
        if (this.f12383d != null) goto L6;
        d.a.a.k.a r0 = this.f12460a;
        this.f12383d = r3.b(r0.f12534l, r0.m);
    L6:
        return this.f12383d;
    }
}
