package kotlin.internal;

import kotlin.Metadata;
import kotlin.internal.jdk7.JDK7PlatformImplementations;
import kotlin.internal.jdk8.JDK8PlatformImplementations;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PlatformImplementationsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PlatformImplementations f340a = null;

    static {
        String r0 = System.getProperty("java.specification.version");
        int r2 = 65542;
        if (r0 == null) goto L16;
        int r3 = StringsKt.r(r0, '.', 0, false, 6);
        if (r3 < 0) goto L8;
        int r6 = r3 + 1;
        int r4 = StringsKt.r(r0, '.', r6, false, 4);
        if (r4 >= 0) goto L12;
        r4 = r0.length();
    L12:
        String r5 = r0.substring(0, r3);
        Intrinsics.e(r5, "this as java.lang.String…ing(startIndex, endIndex)");
        String r1 = r0.substring(r6, r4);
        Intrinsics.e(r1, "this as java.lang.String…ing(startIndex, endIndex)");
        r2 = (Integer.parseInt(r5) * 65536) + Integer.parseInt(r1);
    L65:
        goto L16
    L8:
        r2 = Integer.parseInt(r0) * 65536;
    L16:
        if (r2 >= 65544) goto L68;
        if (r2 < 65536) goto L68;
    L37:
        if (r2 >= 65543) goto L73;
        if (r2 < 65536) goto L73;
    L57:
        PlatformImplementations r7 = new PlatformImplementations();
    L58:
        f340a = r7;
        return;
    L73:
        Object r8 = JDK7PlatformImplementations.class.newInstance();     // Catch: ClassNotFoundException -> L48
        Intrinsics.e(r8, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L48
        r7 = (PlatformImplementations) r8;     // Catch: ClassCastException -> L42 ClassNotFoundException -> L48
    L42:
        e = move-exception;
        ClassLoader r9 = r8.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L48
        ClassLoader r10 = PlatformImplementations.class.getClassLoader();     // Catch: ClassNotFoundException -> L48
        if (Intrinsics.a(r9, r10) == false) goto L46;
        throw e;     // Catch: ClassNotFoundException -> L48
    L46:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r9 + ", base type classloader: " + r10, e);     // Catch: ClassNotFoundException -> L48
    L48:
        Object r11 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();     // Catch: ClassNotFoundException -> L62
        Intrinsics.e(r11, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L62
        r7 = (PlatformImplementations) r11;     // Catch: ClassCastException -> L51 ClassNotFoundException -> L62
    L51:
        e = move-exception;
        ClassLoader r12 = r11.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L62
        ClassLoader r13 = PlatformImplementations.class.getClassLoader();     // Catch: ClassNotFoundException -> L62
        if (Intrinsics.a(r12, r13) == false) goto L55;
        throw e;     // Catch: ClassNotFoundException -> L62
    L55:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r12 + ", base type classloader: " + r13, e);     // Catch: ClassNotFoundException -> L62
    L68:
        Object r14 = JDK8PlatformImplementations.class.newInstance();     // Catch: ClassNotFoundException -> L27
        Intrinsics.e(r14, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L27
        r7 = (PlatformImplementations) r14;     // Catch: ClassCastException -> L21 ClassNotFoundException -> L27
    L21:
        e = move-exception;
        ClassLoader r15 = r14.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L27
        ClassLoader r16 = PlatformImplementations.class.getClassLoader();     // Catch: ClassNotFoundException -> L27
        if (Intrinsics.a(r15, r16) == false) goto L25;
        throw e;     // Catch: ClassNotFoundException -> L27
    L25:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r15 + ", base type classloader: " + r16, e);     // Catch: ClassNotFoundException -> L27
    L27:
        Object r17 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();     // Catch: ClassNotFoundException -> L61
        Intrinsics.e(r17, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L61
        r7 = (PlatformImplementations) r17;     // Catch: ClassCastException -> L30 ClassNotFoundException -> L61
    L30:
        e = move-exception;
        ClassLoader r18 = r17.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L61
        ClassLoader r19 = PlatformImplementations.class.getClassLoader();     // Catch: ClassNotFoundException -> L61
        if (Intrinsics.a(r18, r19) == false) goto L34;
        throw e;     // Catch: ClassNotFoundException -> L61
    L34:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r18 + ", base type classloader: " + r19, e);     // Catch: ClassNotFoundException -> L61
    }
}
