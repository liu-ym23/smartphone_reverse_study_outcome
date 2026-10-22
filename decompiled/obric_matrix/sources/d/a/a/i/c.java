package d.a.a.i;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public class c implements d.a.a.i.q.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f12395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Enum[] f12396b;

    public c(Class<?> r1) {
        this.f12395a = r1;
        this.f12396b = (Enum[]) r1.getEnumConstants();
    }

    @Override // d.a.a.i.q.f
    public <T> T a(b r6, Type r7, Object r8) {
        e r9 = r6.f12388j;     // Catch: Exception -> L26 d.a.a.d -> L29
        int r10 = r9.f12404a;     // Catch: Exception -> L26 d.a.a.d -> L29
        if (r10 != 2) goto L14;
        int r11 = r9.j();     // Catch: Exception -> L26 d.a.a.d -> L29
        r9.t(16);     // Catch: Exception -> L26 d.a.a.d -> L29
        if (r11 < 0) goto L12;
        Object[] r12 = this.f12396b;     // Catch: Exception -> L26 d.a.a.d -> L29
        if (r11 > r12.length) goto L12;
        return (T) r12[r11];
    L12:
        throw new d.a.a.d("parse enum " + this.f12395a.getName() + " error, value : " + r11);     // Catch: Exception -> L26 d.a.a.d -> L29
    L14:
        if (r10 != 4) goto L21;
        String r13 = r9.X();     // Catch: Exception -> L26 d.a.a.d -> L29
        r9.t(16);     // Catch: Exception -> L26 d.a.a.d -> L29
        if (r13.length() != 0) goto L19;
        return null;
    L19:
        return (T) Enum.valueOf(this.f12395a, r13);
    L21:
        if (r10 != 8) goto L25;
        r9.t(16);     // Catch: Exception -> L26 d.a.a.d -> L29
        return null;
    L25:
        throw new d.a.a.d("parse enum " + this.f12395a.getName() + " error, value : " + r6.F());     // Catch: Exception -> L26 d.a.a.d -> L29
    L29:
        e = move-exception;
        throw e;
    L26:
        e = move-exception;
        throw new d.a.a.d(e.getMessage(), e);
    }
}
