package kotlin.l0;

import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18422a = null;

    static {
        int r1 = a();
        if (r1 >= 65544) goto L64;
        if (r1 < 65536) goto L64;
    L30:
        if (r1 >= 65543) goto L66;
        if (r1 < 65536) goto L66;
    L56:
        a r7 = new a();
    L57:
        f18422a = r7;
        return;
    L66:
        Object r2 = Class.forName("kotlin.l0.d.a").newInstance();     // Catch: ClassNotFoundException -> L44
        o.e(r2, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L44
        if (r2 == null) goto L38;
        r7 = (a) r2;     // Catch: ClassCastException -> L35 ClassNotFoundException -> L44
        goto L57
    L38:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");     // Catch: ClassCastException -> L35 ClassNotFoundException -> L44
    L35:
        e = move-exception;
        ClassLoader r3 = r2.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L44
        ClassLoader r8 = a.class.getClassLoader();     // Catch: ClassNotFoundException -> L44
        if (o.a(r3, r8) == false) goto L42;
        throw e;     // Catch: ClassNotFoundException -> L44
    L42:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r3 + ", base type classloader: " + r8, e);     // Catch: ClassNotFoundException -> L44
    L44:
        Object r4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();     // Catch: ClassNotFoundException -> L60
        o.e(r4, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L60
        if (r4 == null) goto L50;
        r7 = (a) r4;     // Catch: ClassCastException -> L47 ClassNotFoundException -> L60
        goto L57
    L50:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");     // Catch: ClassCastException -> L47 ClassNotFoundException -> L60
    L47:
        e = move-exception;
        ClassLoader r5 = r4.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L60
        ClassLoader r0 = a.class.getClassLoader();     // Catch: ClassNotFoundException -> L60
        if (o.a(r5, r0) == false) goto L54;
        throw e;     // Catch: ClassNotFoundException -> L60
    L54:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r5 + ", base type classloader: " + r0, e);     // Catch: ClassNotFoundException -> L60
    L64:
        Object r9 = Class.forName("kotlin.l0.e.a").newInstance();     // Catch: ClassNotFoundException -> L17
        o.e(r9, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L17
        if (r9 == null) goto L11;
        r7 = (a) r9;     // Catch: ClassCastException -> L8 ClassNotFoundException -> L17
        goto L57
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");     // Catch: ClassCastException -> L8 ClassNotFoundException -> L17
    L8:
        e = move-exception;
        ClassLoader r10 = r9.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L17
        ClassLoader r11 = a.class.getClassLoader();     // Catch: ClassNotFoundException -> L17
        if (o.a(r10, r11) == false) goto L15;
        throw e;     // Catch: ClassNotFoundException -> L17
    L15:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r10 + ", base type classloader: " + r11, e);     // Catch: ClassNotFoundException -> L17
    L17:
        Object r12 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();     // Catch: ClassNotFoundException -> L59
        o.e(r12, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L59
        if (r12 == null) goto L23;
        r7 = (a) r12;     // Catch: ClassCastException -> L20 ClassNotFoundException -> L59
        goto L57
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");     // Catch: ClassCastException -> L20 ClassNotFoundException -> L59
    L20:
        e = move-exception;
        ClassLoader r13 = r12.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L59
        ClassLoader r14 = a.class.getClassLoader();     // Catch: ClassNotFoundException -> L59
        if (o.a(r13, r14) == false) goto L27;
        throw e;     // Catch: ClassNotFoundException -> L59
    L27:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r13 + ", base type classloader: " + r14, e);     // Catch: ClassNotFoundException -> L59
    }

    private static final int a() {
        String r0 = System.getProperty("java.specification.version");
        if (r0 != null) goto L5;
        return 65542;
    L5:
        int r8 = k.P(r0, '.', 0, false, 6, null);
        if (r8 < 0) goto L21;
        int r10 = r8 + 1;
        int r1 = k.P(r0, '.', r10, false, 4, null);
        if (r1 >= 0) goto L13;
        r1 = r0.length();
    L13:
        String r2 = r0.substring(0, r8);
        o.e(r2, "this as java.lang.String…ing(startIndex, endIndex)");
        String r3 = r0.substring(r10, r1);
        o.e(r3, "this as java.lang.String…ing(startIndex, endIndex)");
        return (Integer.parseInt(r2) * 65536) + Integer.parseInt(r3);
    L24:
        return 65542;
    L21:
        return Integer.parseInt(r0) * 65536;
    L23:
        return 65542;
    }
}
