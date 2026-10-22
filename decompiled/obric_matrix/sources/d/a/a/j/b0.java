package d.a.a.j;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class b0 implements t, d.a.a.i.q.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b0 f12473a;

    static {
        f12473a = new b0();
    }

    private b0() {
    }

    @Override // d.a.a.i.q.f
    public <T> T a(d.a.a.i.b r1, Type r2, Object r3) {
        return (T) r1.h0();
    }

    @Override // d.a.a.j.t
    public void b(m r1, Object r2, Object r3, Type r4) {
        String r5 = (String) r2;
        z r0 = r1.f12492b;
        if (r5 != null) goto L6;
        r0.Q();
        return;
    L6:
        r0.S(r5);
    }
}
