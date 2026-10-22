package kotlin.internal;

import androidx.exifinterface.media.ExifInterface;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b\u0000\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0083\b¢\u0006\u0002\u0010\f\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", CloudControlInf.PATCH, "castToBaseType", ExifInterface.GPS_DIRECTION_TRUE, "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PlatformImplementationsKt {
    public static final PlatformImplementations IMPLEMENTATIONS = null;

    static {
        Object r4 = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();     // Catch: ClassNotFoundException -> L15
        Intrinsics.checkNotNullExpressionValue(r4, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L15
        if (r4 == null) goto L9;
        PlatformImplementations r5 = (PlatformImplementations) r4;     // Catch: ClassCastException -> L6 ClassNotFoundException -> L15
    L52:
        IMPLEMENTATIONS = r5;
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");     // Catch: ClassCastException -> L6 ClassNotFoundException -> L15
    L6:
        e = move-exception;
        ClassLoader r6 = r4.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L15
        ClassLoader r7 = PlatformImplementations.class.getClassLoader();     // Catch: ClassNotFoundException -> L15
        if (Intrinsics.areEqual(r6, r7) == false) goto L13;
        throw e;     // Catch: ClassNotFoundException -> L15
    L13:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r6 + ", base type classloader: " + r7, e);     // Catch: ClassNotFoundException -> L15
    L15:
        Object r8 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();     // Catch: ClassNotFoundException -> L27
        Intrinsics.checkNotNullExpressionValue(r8, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L27
        if (r8 == null) goto L21;
        r5 = (PlatformImplementations) r8;     // Catch: ClassCastException -> L18 ClassNotFoundException -> L27
        goto L52
    L21:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");     // Catch: ClassCastException -> L18 ClassNotFoundException -> L27
    L18:
        e = move-exception;
        ClassLoader r9 = r8.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L27
        ClassLoader r10 = PlatformImplementations.class.getClassLoader();     // Catch: ClassNotFoundException -> L27
        if (Intrinsics.areEqual(r9, r10) == false) goto L25;
        throw e;     // Catch: ClassNotFoundException -> L27
    L25:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r9 + ", base type classloader: " + r10, e);     // Catch: ClassNotFoundException -> L27
    L39:
        Object r11 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();     // Catch: ClassNotFoundException -> L51
        Intrinsics.checkNotNullExpressionValue(r11, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L51
        if (r11 == null) goto L45;
        r5 = (PlatformImplementations) r11;     // Catch: ClassCastException -> L42 ClassNotFoundException -> L51
        goto L52
    L45:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");     // Catch: ClassCastException -> L42 ClassNotFoundException -> L51
    L42:
        e = move-exception;
        ClassLoader r2 = r11.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L51
        ClassLoader r12 = PlatformImplementations.class.getClassLoader();     // Catch: ClassNotFoundException -> L51
        if (Intrinsics.areEqual(r2, r12) == false) goto L49;
        throw e;     // Catch: ClassNotFoundException -> L51
    L49:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r2 + ", base type classloader: " + r12, e);     // Catch: ClassNotFoundException -> L51
    L51:
        r5 = new PlatformImplementations();
    L27:
        Object r13 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();     // Catch: ClassNotFoundException -> L39
        Intrinsics.checkNotNullExpressionValue(r13, "forName(\"kotlin.internal…entations\").newInstance()");     // Catch: ClassNotFoundException -> L39
        if (r13 == null) goto L33;
        r5 = (PlatformImplementations) r13;     // Catch: ClassCastException -> L30 ClassNotFoundException -> L39
        goto L52
    L33:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");     // Catch: ClassCastException -> L30 ClassNotFoundException -> L39
    L30:
        e = move-exception;
        ClassLoader r14 = r13.getClass().getClassLoader();     // Catch: ClassNotFoundException -> L39
        ClassLoader r15 = PlatformImplementations.class.getClassLoader();     // Catch: ClassNotFoundException -> L39
        if (Intrinsics.areEqual(r14, r15) == false) goto L37;
        throw e;     // Catch: ClassNotFoundException -> L39
    L37:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r14 + ", base type classloader: " + r15, e);     // Catch: ClassNotFoundException -> L39
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final /* synthetic */ <T> T castToBaseType(Object r5) {
        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);     // Catch: ClassCastException -> L5
        Object r1 = r5;     // Catch: ClassCastException -> L5
        return r5;
    L5:
        e = move-exception;
        ClassLoader r6 = r5.getClass().getClassLoader();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ClassLoader r0 = Object.class.getClassLoader();
        if (Intrinsics.areEqual(r6, r0) == false) goto L9;
        throw e;
    L9:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r6 + ", base type classloader: " + r0, e);
    }

    public static final boolean apiVersionIsAtLeast(int r1, int r2, int r3) {
        return KotlinVersion.CURRENT.isAtLeast(r1, r2, r3);
    }
}
