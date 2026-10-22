package d.a.a.j;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class f implements t, d.a.a.i.q.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f12479a = null;

    static {
        f12479a = new f();
    }

    private f() {
    }

    @Override // d.a.a.i.q.f
    public <T> T a(d.a.a.i.b r4, Type r5, Object r6) {
        T r3 = (T) Boolean.FALSE;
        T r7 = (T) Boolean.TRUE;
        d.a.a.i.e r8 = r4.f12388j;
        int r0 = r8.a0();
        if (r0 != 6) goto L7;
        r8.t(16);
    L20:
        return r7;
    L7:
        if (r0 != 7) goto L10;
        r8.t(16);
        return r3;
    L10:
        if (r0 != 2) goto L14;
        int r9 = r8.j();
        r8.t(16);
        if (r9 == 1) goto L20;
        return r3;
    L14:
        Object r10 = r4.F();
        if (r10 != null) goto L19;
        return null;
    L19:
        return (T) d.a.a.k.d.f(r10);
    }

    @Override // d.a.a.j.t
    public void b(m r1, Object r2, Object r3, Type r4) {
        z r0 = r1.f12492b;
        Boolean r5 = (Boolean) r2;
        String r6 = "false";
        if (r5 != null) goto L10;
        if ((r0.f12526h & a0.o.f12471f) == 0) goto L7;
        r0.write("false");
        return;
    L7:
        r0.Q();
        return;
    L10:
        if (r5.booleanValue() == false) goto L12;
        r6 = "true";
    L12:
        r0.write(r6);
    }
}
