package d.a.a.i.q;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.a.a.k.a f12460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Enum[] f12461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected long[] f12462c;

    public d(Class<?> r9, d.a.a.k.a r10, int r11) {
        this.f12460a = r10;
        if (r10 != null) goto L5;
        return;
    L5:
        Class<?> r12 = r10.f12534l;
        if (r12.isEnum() == false) goto L25;
        Enum[] r13 = (Enum[]) r12.getEnumConstants();
        int r14 = r13.length;
        long[] r15 = new long[r14];
        this.f12462c = new long[r13.length];
        int r1 = 0;
    L9:
        if (r1 >= r13.length) goto L15;
        String r2 = r13[r1].name();
        long r3 = -2128831035;
        int r5 = 0;
    L12:
        if (r5 >= r2.length()) goto L14;
        r3 = (r3 ^ ((long) r2.charAt(r5))) * 16777619;
        r5 = r5 + 1;
        goto L12
    L14:
        r15[r1] = r3;
        this.f12462c[r1] = r3;
        r1 = r1 + 1;
        goto L9
    L15:
        Arrays.sort(this.f12462c);
        this.f12461b = new Enum[r13.length];
        int r4 = 0;
    L17:
        if (r4 >= this.f12462c.length) goto L32;
        int r6 = 0;
    L19:
        if (r6 >= r14) goto L24;
        if (this.f12462c[r4] == r15[r6]) goto L22;
        r6 = r6 + 1;
        goto L19
    L22:
        this.f12461b[r4] = r13[r6];
    L24:
        r4 = r4 + 1;
        goto L17
    L32:
        return;
    }

    public Enum a(long r3) {
        if (this.f12461b != null) goto L5;
        return null;
    L5:
        int r4 = Arrays.binarySearch(this.f12462c, r3);
        if (r4 != (-1)) goto L9;
        return null;
    L9:
        return this.f12461b[r4];
    }

    public abstract void b(d.a.a.i.b r1, Object r2, Type r3, Map<String, Object> r4);

    public void c(Object r1, double r2) {
        this.f12460a.f12530h.setDouble(r1, r2);
    }

    public void d(Object r1, float r2) {
        this.f12460a.f12530h.setFloat(r1, r2);
    }

    public void e(Object r1, int r2) {
        this.f12460a.f12530h.setInt(r1, r2);
    }

    public void f(Object r1, long r2) {
        this.f12460a.f12530h.setLong(r1, r2);
    }

    public void g(Object r5, Object r6) {
        if (r6 == null) goto L4;
    L6:
        d.a.a.k.a r0 = this.f12460a;
        Field r1 = r0.f12530h;
        Method r2 = r0.f12529g;
    L34:
        e = move-exception;
        throw new d.a.a.d("set property error, " + this.f12460a.f12528f, e);
    L8:
        if (r0.f12531i == false) goto L23;
        if (r0.o == true) goto L12;
        r1.set(r5, r6);     // Catch: Exception -> L34
        return;
    L12:
        if (Map.class.isAssignableFrom(r0.f12534l) == false) goto L17;
        Map r7 = (Map) r1.get(r5);     // Catch: Exception -> L34
        if (r7 == null) goto L38;
        Map r8 = (Map) r6;     // Catch: Exception -> L34
    L16:
        r7.putAll(r8);     // Catch: Exception -> L34
        return;
    L38:
        return;
    L17:
        Collection r9 = (Collection) r1.get(r5);     // Catch: Exception -> L34
        if (r9 == null) goto L40;
        Collection r10 = (Collection) r6;     // Catch: Exception -> L34
    L20:
        r9.addAll(r10);     // Catch: Exception -> L34
        return;
    L40:
        return;
    L23:
        if (r0.o == true) goto L25;
        r2.invoke(r5, new Object[]{r6});     // Catch: Exception -> L34
        return;
    L25:
        if (Map.class.isAssignableFrom(r0.f12534l) == false) goto L29;
        r7 = (Map) r2.invoke(r5, new Object[0]);     // Catch: Exception -> L34
        if (r7 == null) goto L43;
        r8 = (Map) r6;     // Catch: Exception -> L34
        goto L16
    L43:
        return;
    L29:
        r9 = (Collection) r2.invoke(r5, new Object[0]);     // Catch: Exception -> L34
        if (r9 == null) goto L44;
        r10 = (Collection) r6;     // Catch: Exception -> L34
        goto L20
    L44:
        return;
    L4:
        if (this.f12460a.f12534l.isPrimitive() == false) goto L6;
    }
}
