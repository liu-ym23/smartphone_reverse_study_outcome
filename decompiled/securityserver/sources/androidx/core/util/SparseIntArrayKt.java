package androidx.core.util;

import android.util.SparseIntArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SparseIntArrayKt {
    public static final boolean contains(@NotNull SparseIntArray r1, int r2) {
        Intrinsics.g(r1, "$this$contains");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsKey(@NotNull SparseIntArray r1, int r2) {
        Intrinsics.g(r1, "$this$containsKey");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsValue(@NotNull SparseIntArray r1, int r2) {
        Intrinsics.g(r1, "$this$containsValue");
        if (r1.indexOfValue(r2) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(@NotNull SparseIntArray r4, @NotNull Function2<? super Integer, ? super Integer, Unit> r5) {
        Intrinsics.g(r4, "$this$forEach");
        Intrinsics.g(r5, "action");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.mo7invoke(Integer.valueOf(r4.keyAt(r1)), Integer.valueOf(r4.valueAt(r1)));
        r1 = r1 + 1;
        goto L3
    }

    public static final int getOrDefault(@NotNull SparseIntArray r1, int r2, int r3) {
        Intrinsics.g(r1, "$this$getOrDefault");
        return r1.get(r2, r3);
    }

    public static final int getOrElse(@NotNull SparseIntArray r1, int r2, @NotNull Function0<Integer> r3) {
        Intrinsics.g(r1, "$this$getOrElse");
        Intrinsics.g(r3, "defaultValue");
        int r4 = r1.indexOfKey(r2);
        if (r4 == (-1)) goto L6;
        return r1.valueAt(r4);
    L6:
        return ((Number) r3.invoke()).intValue();
    }

    public static final int getSize(@NotNull SparseIntArray r1) {
        Intrinsics.g(r1, "$this$size");
        return r1.size();
    }

    public static final boolean isEmpty(@NotNull SparseIntArray r1) {
        Intrinsics.g(r1, "$this$isEmpty");
        if (r1.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(@NotNull SparseIntArray r1) {
        Intrinsics.g(r1, "$this$isNotEmpty");
        if (r1.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NotNull
    public static final IntIterator keyIterator(@NotNull final SparseIntArray r1) {
        Intrinsics.g(r1, "$this$keyIterator");
        return new AnonymousClass1(r1);
    }

    @NotNull
    public static final SparseIntArray plus(@NotNull SparseIntArray r3, @NotNull SparseIntArray r4) {
        Intrinsics.g(r3, "$this$plus");
        Intrinsics.g(r4, "other");
        int r1 = r3.size();
        SparseIntArray r0 = new SparseIntArray(r4.size() + r1);
        putAll(r0, r3);
        putAll(r0, r4);
        return r0;
    }

    public static final void putAll(@NotNull SparseIntArray r4, @NotNull SparseIntArray r5) {
        Intrinsics.g(r4, "$this$putAll");
        Intrinsics.g(r5, "other");
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r4.put(r5.keyAt(r1), r5.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final boolean remove(@NotNull SparseIntArray r1, int r2, int r3) {
        Intrinsics.g(r1, "$this$remove");
        int r4 = r1.indexOfKey(r2);
        if (r4 != (-1)) goto L5;
        return false;
    L5:
        if (r3 != r1.valueAt(r4)) goto L10;
        r1.removeAt(r4);
        return true;
    L10:
        return false;
    }

    public static final void set(@NotNull SparseIntArray r1, int r2, int r3) {
        Intrinsics.g(r1, "$this$set");
        r1.put(r2, r3);
    }

    @NotNull
    public static final IntIterator valueIterator(@NotNull final SparseIntArray r1) {
        Intrinsics.g(r1, "$this$valueIterator");
        return new C00231(r1);
    }
}
