package d.a.a;

import d.a.a.i.m;
import d.a.a.j.a0;
import d.a.a.j.c0;
import d.a.a.j.r;
import d.a.a.j.u;
import d.a.a.j.v;
import d.a.a.j.x;
import d.a.a.j.y;
import d.a.a.j.z;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements f, c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static TimeZone f12369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Locale f12370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f12371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f12372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f12373j;

    static {
        f12369f = TimeZone.getDefault();
        f12370g = Locale.getDefault();
        f12371h = ((d.a.a.i.d.n.f12403f | 0) | d.a.a.i.d.p.f12403f) | d.a.a.i.d.o.f12403f;
        f12372i = "yyyy-MM-dd HH:mm:ss";
        f12373j = (((a0.f12465g.f12471f | 0) | a0.p.f12471f) | a0.f12468j.f12471f) | a0.q.f12471f;
    }

    public a() {
    }

    public static final <T> T m(String r1, Class<T> r2) {
        return (T) n(r1, r2, new d.a.a.i.d[0]);
    }

    public static final <T> T n(String r2, Class<T> r3, d.a.a.i.d... r4) {
        return (T) o(r2, r3, m.f12444e, f12371h, r4);
    }

    public static final <T> T o(String r6, Type r7, m r8, int r9, d.a.a.i.d... r10) {
        return (T) p(r6, r7, r8, null, r9, r10);
    }

    public static final <T> T p(String r3, Type r4, m r5, d.a.a.i.q.g r6, int r7, d.a.a.i.d... r8) {
        if (r3 != null) goto L5;
        return null;
    L5:
        int r0 = r8.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L8;
        r7 = r7 | r8[r1].f12403f;
        r1 = r1 + 1;
        goto L6
    L8:
        d.a.a.i.b r9 = new d.a.a.i.b(r3, r5, r7);
        if ((r6 instanceof d.a.a.i.q.c) == false) goto L12;
        r9.A().add((d.a.a.i.q.c) r6);
    L12:
        if ((r6 instanceof d.a.a.i.q.b) == false) goto L15;
        r9.x().add((d.a.a.i.q.b) r6);
    L15:
        if ((r6 instanceof d.a.a.i.q.e) == false) goto L17;
        r9.r = (d.a.a.i.q.e) r6;
    L17:
        T r10 = (T) r9.X(r4);
        r9.E(r10);
        r9.close();
        return r10;
    }

    public static final String q(Object r6) {
        return r(r6, x.f12517d, null, null, f12373j, new a0[0]);
    }

    public static String r(Object r5, x r6, y[] r7, String r8, int r9, a0... r10) {
        z r0 = new z(null, r9, r10);
        d.a.a.j.m r11 = new d.a.a.j.m(r0, r6);     // Catch: Throwable -> L39
        int r12 = r10.length;     // Catch: Throwable -> L39
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r2 >= r12) goto L7;
        r11.c(r10[r2], true);     // Catch: Throwable -> L39
        r2 = r2 + 1;     // Catch: Throwable -> L39
        goto L5
    L7:
        if (r8 != null) goto L9;
    L11:
        if (r7 == null) goto L36;
        int r13 = r7.length;     // Catch: Throwable -> L39
    L13:
        if (r1 >= r13) goto L36;
        y r14 = r7[r1];     // Catch: Throwable -> L39
        if (r14 != null) goto L18;
    L35:
        r1 = r1 + 1;     // Catch: Throwable -> L39
        goto L13
    L18:
        if ((r14 instanceof v) == false) goto L21;
        r11.j().add((v) r14);     // Catch: Throwable -> L39
    L21:
        if ((r14 instanceof r) == false) goto L24;
        r11.h().add((r) r14);     // Catch: Throwable -> L39
    L24:
        if ((r14 instanceof c0) == false) goto L27;
        r11.k().add((c0) r14);     // Catch: Throwable -> L39
    L27:
        if ((r14 instanceof u) == false) goto L30;
        r11.i().add((u) r14);     // Catch: Throwable -> L39
    L30:
        if ((r14 instanceof d.a.a.j.d) == false) goto L33;
        r11.f().add((d.a.a.j.d) r14);     // Catch: Throwable -> L39
    L33:
        if ((r14 instanceof d.a.a.j.a) == false) goto L35;
        r11.e().add((d.a.a.j.a) r14);     // Catch: Throwable -> L39
    L36:
        r11.r(r5);     // Catch: Throwable -> L39
        String r15 = r0.toString();     // Catch: Throwable -> L39
        r0.close();
        return r15;
    L9:
        if (r8.length() == 0) goto L11;
        r11.q(r8);     // Catch: Throwable -> L39
        r11.c(a0.x, true);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        r0.close();
        throw th;
    }

    @Override // d.a.a.f
    public void a(Appendable r5) {
        z r0 = new z(null, f12373j, a0.D);
        new d.a.a.j.m(r0, x.f12517d).r(this);     // Catch: Throwable -> L6 IOException -> L8
        r5.append(r0.toString());     // Catch: Throwable -> L6 IOException -> L8
        r0.close();
        return;
    L8:
        e = move-exception;
        throw new d(e.getMessage(), e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    @Override // d.a.a.c
    public String c() {
        z r0 = new z(null, f12373j, a0.D);
        new d.a.a.j.m(r0, x.f12517d).r(this);     // Catch: Throwable -> L6
        String r4 = r0.toString();     // Catch: Throwable -> L6
        r0.close();
        return r4;
    L6:
        th = move-exception;
        r0.close();
        throw th;
    }

    public String toString() {
        return c();
    }
}
