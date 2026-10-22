package io.reactivex.internal.functions;

import a.a;
import io.reactivex.functions.BiPredicate;

/* JADX INFO: loaded from: classes2.dex */
public final class ObjectHelper {
    static final BiPredicate<Object, Object> EQUALS = null;

    public static final class BiObjectPredicate implements BiPredicate<Object, Object> {
        public BiObjectPredicate() {
        }

        @Override // io.reactivex.functions.BiPredicate
        public boolean test(Object r1, Object r2) {
            return ObjectHelper.equals(r1, r2);
        }
    }

    static {
        EQUALS = new BiObjectPredicate();
    }

    private ObjectHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static int compare(int r0, int r1) {
        if (r0 >= r1) goto L4;
        return -1;
    L4:
        if (r0 <= r1) goto L6;
        return 1;
    L6:
        return 0;
    }

    public static boolean equals(Object r0, Object r1) {
        if (r0 == r1) goto L8;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.equals(r1) == false) goto L7;
    L8:
        return true;
    }

    public static <T> BiPredicate<T, T> equalsPredicate() {
        return (BiPredicate<T, T>) EQUALS;
    }

    public static int hashCode(Object r0) {
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public static <T> T requireNonNull(T r0, String r1) {
        if (r0 == null) goto L5;
        return r0;
    L5:
        throw new NullPointerException(r1);
    }

    public static int verifyPositive(int r2, String r3) {
        if (r2 <= 0) goto L5;
        return r2;
    L5:
        throw new IllegalArgumentException(r3 + " > 0 required but it was " + r2);
    }

    public static int compare(long r0, long r2) {
        if (r0 >= r2) goto L5;
        return -1;
    L5:
        if (r0 <= r2) goto L7;
        return 1;
    L7:
        return 0;
    }

    @Deprecated
    public static long requireNonNull(long r0, String r2) {
        throw new InternalError(a.A("Null check on a primitive: ", r2));
    }

    public static long verifyPositive(long r2, String r4) {
        if (r2 <= 0) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException(r4 + " > 0 required but it was " + r2);
    }
}
