package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class CollectionToArray {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f342a = null;

    static {
        f342a = new Object[0];
    }

    public static final Object[] a(Collection r5) {
        Intrinsics.f(r5, "collection");
        int r0 = r5.size();
        Object[] r1 = f342a;
        if (r0 == 0) goto L32;
        Iterator r6 = r5.iterator();
        if (r6.hasNext() == false) goto L33;
        Object[] r2 = new Object[r0];
        int r3 = 0;
    L9:
        int r4 = r3 + 1;
        r2[r3] = r6.next();
        if (r4 < r2.length) goto L24;
        if (r6.hasNext() == false) goto L34;
        int r7 = ((r4 * 3) + 1) >>> 1;
        if (r7 > r4) goto L21;
        r7 = 2147483645;
        if (r4 < 2147483645) goto L21;
        throw new OutOfMemoryError();
    L21:
        r2 = Arrays.copyOf(r2, r7);
        Intrinsics.e(r2, "copyOf(result, newSize)");
    L22:
        r3 = r4;
        goto L9
    L34:
        return r2;
    L24:
        if (r6.hasNext() == true) goto L22;
        Object[] r8 = Arrays.copyOf(r2, r4);
        Intrinsics.e(r8, "copyOf(result, size)");
        return r8;
    L33:
        return r1;
    L32:
        return r1;
    }

    public static final Object[] b(Collection r5, Object[] r6) {
        Intrinsics.f(r5, "collection");
        r6.getClass();
        int r0 = r5.size();
        int r2 = 0;
        if (r0 == 0) goto L5;
        Iterator r7 = r5.iterator();
        if (r7.hasNext() == true) goto L13;
        if (r6.length <= 0) goto L44;
        r6[0] = null;
        return r6;
    L44:
        return r6;
    L13:
        if (r0 > r6.length) goto L15;
        Object[] r1 = r6;
    L16:
        int r3 = r2 + 1;
        r1[r2] = r7.next();
        if (r3 < r1.length) goto L31;
        if (r7.hasNext() == false) goto L46;
        int r4 = ((r3 * 3) + 1) >>> 1;
        if (r4 > r3) goto L28;
        r4 = 2147483645;
        if (r3 < 2147483645) goto L28;
        throw new OutOfMemoryError();
    L28:
        r1 = Arrays.copyOf(r1, r4);
        Intrinsics.e(r1, "copyOf(result, newSize)");
    L29:
        r2 = r3;
        goto L16
    L46:
        return r1;
    L31:
        if (r7.hasNext() == true) goto L29;
        if (r1 != r6) goto L34;
        r6[r3] = null;
        return r6;
    L34:
        Object[] r8 = Arrays.copyOf(r1, r3);
        Intrinsics.e(r8, "copyOf(result, size)");
        return r8;
    L15:
        Object r9 = Array.newInstance(r6.getClass().getComponentType(), r0);
        Intrinsics.d(r9, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r1 = (Object[]) r9;
        goto L16
    L5:
        if (r6.length <= 0) goto L42;
        r6[0] = null;
        return r6;
    L42:
        return r6;
    }
}
