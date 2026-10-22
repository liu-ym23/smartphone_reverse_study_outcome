package kotlin.n0.d;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object[] f18441a = null;

    static {
        f18441a = new Object[0];
    }

    public static final Object[] a(Collection<?> r4) {
        o.f(r4, "collection");
        int r0 = r4.size();
        if (r0 == 0) goto L31;
        Iterator<?> r5 = r4.iterator();
        if (r5.hasNext() == false) goto L31;
        Object[] r1 = new Object[r0];
        int r2 = 0;
    L9:
        int r3 = r2 + 1;
        r1[r2] = r5.next();
        if (r3 < r1.length) goto L22;
        if (r5.hasNext() == false) goto L32;
        int r6 = ((r3 * 3) + 1) >>> 1;
        if (r6 > r3) goto L20;
        if (r3 >= 2147483645) goto L19;
        r6 = 2147483645;
        goto L20
    L19:
        throw new OutOfMemoryError();
    L20:
        r1 = Arrays.copyOf(r1, r6);
        o.e(r1, "copyOf(result, newSize)");
    L25:
        r2 = r3;
        goto L9
    L32:
        return r1;
    L22:
        if (r5.hasNext() == true) goto L25;
        Object[] r7 = Arrays.copyOf(r1, r3);
        o.e(r7, "copyOf(result, size)");
        return r7;
    L31:
        return f18441a;
    }

    public static final Object[] b(Collection<?> r5, Object[] r6) {
        o.f(r5, "collection");
        Objects.requireNonNull(r6);
        int r0 = r5.size();
        int r2 = 0;
        if (r0 == 0) goto L5;
        Iterator<?> r7 = r5.iterator();
        if (r7.hasNext() == true) goto L13;
        if (r6.length <= 0) goto L43;
        r6[0] = null;
        return r6;
    L43:
        return r6;
    L13:
        if (r0 > r6.length) goto L15;
        Object[] r1 = r6;
    L16:
        int r3 = r2 + 1;
        r1[r2] = r7.next();
        if (r3 < r1.length) goto L29;
        if (r7.hasNext() == false) goto L45;
        int r4 = ((r3 * 3) + 1) >>> 1;
        if (r4 > r3) goto L27;
        if (r3 >= 2147483645) goto L26;
        r4 = 2147483645;
        goto L27
    L26:
        throw new OutOfMemoryError();
    L27:
        r1 = Arrays.copyOf(r1, r4);
        o.e(r1, "copyOf(result, newSize)");
    L34:
        r2 = r3;
        goto L16
    L45:
        return r1;
    L29:
        if (r7.hasNext() == true) goto L34;
        if (r1 != r6) goto L32;
        r6[r3] = null;
        return r6;
    L32:
        Object[] r8 = Arrays.copyOf(r1, r3);
        o.e(r8, "copyOf(result, size)");
        return r8;
    L15:
        Object r9 = Array.newInstance(r6.getClass().getComponentType(), r0);
        o.d(r9, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r1 = (Object[]) r9;
        goto L16
    L5:
        if (r6.length <= 0) goto L41;
        r6[0] = null;
        return r6;
    L41:
        return r6;
    }
}
