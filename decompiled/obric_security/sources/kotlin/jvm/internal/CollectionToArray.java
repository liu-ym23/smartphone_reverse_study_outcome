package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: CollectionToArray.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a#\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007¢\u0006\u0004\b\t\u0010\n\u001a5\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\t\u0010\f\u001a~\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u000f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u00112(\u0010\u0012\u001a$\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00010\u0013H\u0082\b¢\u0006\u0002\u0010\u0014\"\u0018\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"EMPTY", "", "", "[Ljava/lang/Object;", "MAX_SIZE", "", "collectionToArray", "collection", "", "toArray", "(Ljava/util/Collection;)[Ljava/lang/Object;", "a", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "toArrayImpl", "empty", "Lkotlin/Function0;", "alloc", "Lkotlin/Function1;", "trim", "Lkotlin/Function2;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)[Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CollectionToArray {
    private static final Object[] EMPTY = null;
    private static final int MAX_SIZE = 2147483645;

    static {
        EMPTY = new Object[0];
    }

    public static final Object[] toArray(Collection<?> r5, Object[] r6) {
        Intrinsics.checkNotNullParameter(r5, "collection");
        r6.getClass();
        int r0 = r5.size();
        int r2 = 0;
        if (r0 == 0) goto L5;
        Iterator<?> r7 = r5.iterator();
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
        if (r3 < r1.length) goto L30;
        if (r7.hasNext() == false) goto L46;
        int r4 = ((r3 * 3) + 1) >>> 1;
        if (r4 > r3) goto L28;
        r4 = MAX_SIZE;
        if (r3 < MAX_SIZE) goto L28;
        throw new OutOfMemoryError();
    L28:
        r1 = Arrays.copyOf(r1, r4);
        Intrinsics.checkNotNullExpressionValue(r1, "copyOf(result, newSize)");
    L35:
        r2 = r3;
        goto L16
    L46:
        return r1;
    L30:
        if (r7.hasNext() == true) goto L35;
        if (r1 != r6) goto L33;
        r6[r3] = null;
        return r6;
    L33:
        Object[] r8 = Arrays.copyOf(r1, r3);
        Intrinsics.checkNotNullExpressionValue(r8, "copyOf(result, size)");
        return r8;
    L15:
        Object r9 = Array.newInstance(r6.getClass().getComponentType(), r0);
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        r1 = (Object[]) r9;
        goto L16
    L5:
        if (r6.length <= 0) goto L42;
        r6[0] = null;
        return r6;
    L42:
        return r6;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private static final Object[] toArrayImpl(Collection<?> r2, Function0<Object[]> r3, Function1<? super Integer, Object[]> r4, Function2<? super Object[], ? super Integer, Object[]> r5) {
        int r0 = r2.size();
        if (r0 == 0) goto L5;
        Iterator<?> r6 = r2.iterator();
        if (r6.hasNext() == false) goto L9;
        Object[] r7 = r4.invoke(Integer.valueOf(r0));
        int r8 = 0;
        ?? r9 = r7;
    L11:
        int r1 = r8 + 1;
        r9[r8] = r6.next();
        if (r1 < r9.length) goto L25;
        if (r6.hasNext() == false) goto L15;
        int r10 = ((r1 * 3) + 1) >>> 1;
        if (r10 > r1) goto L23;
        r10 = MAX_SIZE;
        if (r1 < MAX_SIZE) goto L23;
        throw new OutOfMemoryError();
    L23:
        r9 = Arrays.copyOf(r9, r10);
        Intrinsics.checkNotNullExpressionValue(r9, "copyOf(result, newSize)");
    L28:
        r8 = r1;
        r9 = r9;
        goto L11
    L15:
        return r9;
    L25:
        if (r6.hasNext() == true) goto L28;
        return r5.invoke(r9, Integer.valueOf(r1));
    L9:
        return r3.invoke();
    L5:
        return r3.invoke();
    }

    public static final Object[] toArray(Collection<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "collection");
        int r0 = r4.size();
        if (r0 == 0) goto L32;
        Iterator<?> r5 = r4.iterator();
        if (r5.hasNext() == false) goto L32;
        Object[] r1 = new Object[r0];
        int r2 = 0;
    L9:
        int r3 = r2 + 1;
        r1[r2] = r5.next();
        if (r3 < r1.length) goto L23;
        if (r5.hasNext() == false) goto L33;
        int r6 = ((r3 * 3) + 1) >>> 1;
        if (r6 > r3) goto L21;
        r6 = MAX_SIZE;
        if (r3 < MAX_SIZE) goto L21;
        throw new OutOfMemoryError();
    L21:
        r1 = Arrays.copyOf(r1, r6);
        Intrinsics.checkNotNullExpressionValue(r1, "copyOf(result, newSize)");
    L26:
        r2 = r3;
        goto L9
    L33:
        return r1;
    L23:
        if (r5.hasNext() == true) goto L26;
        Object[] r7 = Arrays.copyOf(r1, r3);
        Intrinsics.checkNotNullExpressionValue(r7, "copyOf(result, size)");
        return r7;
    L32:
        return EMPTY;
    }
}
