package ms.bd.c;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseArray<a> f22317a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f22318b = 0;

    public static abstract class a {
        public a() {
        }

        public Object a(int r7, int r8, long r9, String r11, Object r12) {
            return b(r8, r9, r11, r12);
        }

        protected Object b(int r1, long r2, String r4, Object r5) {
            return null;
        }
    }

    static {
        f22317a = new SparseArray();
    }

    private static Object a(int r4, int r5, long r6, String r8, Object r9) {
        boolean r0 = true;
        if (r4 > 268435456) goto L5;
    L7:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L27;
        switch(r4) {
            case 268435457: goto L26;
            case 268435458: goto L24;
            case 268435459: goto L24;
            case 268435460: goto L70;
            case 268435461: goto L69;
            case 268435462: goto L68;
            case 268435463: goto L67;
            case 268435464: goto L66;
            case 268435465: goto L65;
            case 268435466: goto L72;
            case 268435467: goto L17;
            case 268435468: goto L63;
            case 268435469: goto L62;
            case 268435470: goto L13;
            case 268435471: goto L12;
            default: goto L72;
        };
    L12:
        long r7 = com.bytedance.mobsec.metasec.ml.a.b();
    L61:
        return Long.valueOf(r7);
    L13:
        r7 = com.bytedance.mobsec.metasec.ml.a.a();
        goto L61
    L17:
        c3.c(ms.bd.c.a.a().c());
        return null;
    L24:
        return "np";
    L72:
        return null;
    L62:
        return b3.e(ms.bd.c.a.a().c());
    L63:
        return c3.c(ms.bd.c.a.a().c()).a();
    L65:
        return b3.d(ms.bd.c.a.a().c());
    L66:
        return b3.a();
    L67:
        return b3.b(ms.bd.c.a.a().c());
    L68:
        return i4.e();
    L69:
        return r4.a(null);
    L70:
        return r4.a("");
    L26:
        return a3.a(ms.bd.c.a.a().c());
    L27:
        int r3 = c.f22321c;
        if (r4 <= 65536) goto L33;
        if (r4 >= 65545) goto L33;
    L41:
        boolean r10 = true;
    L43:
        if (r10 == true) goto L45;
        int r11 = j0.f22406d;
        if (r4 <= 16777216) goto L52;
        if (r4 >= 16777279) goto L52;
    L57:
        if (r0 == true) goto L59;
        return null;
    L59:
        return j0.c(r4, r5, r6, r8, r9);
    L52:
        if (r4 > 33554432) goto L54;
    L56:
        r0 = false;
        goto L57
    L54:
        if (r4 >= 33554435) goto L56;
    L45:
        return c.a(r4, r5, r6, r8, r9);
    L33:
        if (r4 <= 196608) goto L38;
        if (r4 < 196612) goto L41;
    L38:
        if (r4 > 131072) goto L40;
    L42:
        r10 = false;
        goto L43
    L40:
        if (r4 >= 131075) goto L42;
    L5:
        if (r4 >= 268435472) goto L7;
        r2 = true;
        goto L9
    }

    public static Object b(int r6, String r7) {
        return m.a(r6, 0, 0, r7, null);
    }

    public static void c(int r8, a r9) {
        SparseArray<a> r0 = f22317a;
        a r1 = r0.get(r8);
        if (r1 != null) goto L7;
        r0.put(r8, r9);
        return;
    L7:
        throw new RuntimeException(String.format((String) m.a(16777217, 0, 0, "8f0e43", new byte[]{108, 119, 3, 25, 10, 32, 123, 69, 100, 48, 39, 36, 81, 20, 12, 45, 40, 83, 100, 39, 103}), new Object[]{r1.toString()}));
    }

    public static Object d(int r6, int r7, long r8, String r10, Object r11) {
        return m.a(r6, r7, r8, null, null);
    }

    private static Object e(int r8, int r9, long r10, String r12, Object r13) {
        a r1 = f22317a.get(r8);
        if (r1 == null) goto L11;
        return r1.a(r8, r9, r10, r12, r13);
    L7:
        th = move-exception;
        throw new RuntimeException(th);
    L11:
        throw new RuntimeException(String.format((String) m.a(16777217, 0, 0, "a5432a", new byte[]{127, 39, 7, 68, 2, 114, 103, 84, 32, 103, 48, 62, 84, 7, 4, 120, 116, 21, 105, 106, 116}), new Object[]{Integer.valueOf(r8)}));
    }

    public static Object f(int r1, int r2, long r3, String r5, Object r6) {
    L7:
        th = move-exception;
        throw new RuntimeException(th);
    L3:
        if (com.bytedance.mobsec.metasec.ml.a.c() == false) goto L6;
        return a(r1, r2, r3, r5, r6);
    L6:
        return e(r1, r2, r3, r5, r6);
    }
}
