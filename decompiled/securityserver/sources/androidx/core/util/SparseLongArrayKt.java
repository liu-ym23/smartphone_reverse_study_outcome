package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(@NotNull SparseLongArray r1, int r2) {
        Intrinsics.g(r1, "$this$contains");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(18)
    public static final boolean containsKey(@NotNull SparseLongArray r1, int r2) {
        Intrinsics.g(r1, "$this$containsKey");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(18)
    public static final boolean containsValue(@NotNull SparseLongArray r1, long r2) {
        Intrinsics.g(r1, "$this$containsValue");
        if (r1.indexOfValue(r2) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(18)
    public static final void forEach(@NotNull SparseLongArray r5, @NotNull Function2<? super Integer, ? super Long, Unit> r6) {
        Intrinsics.g(r5, "$this$forEach");
        Intrinsics.g(r6, "action");
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r6.mo7invoke(Integer.valueOf(r5.keyAt(r1)), Long.valueOf(r5.valueAt(r1)));
        r1 = r1 + 1;
        goto L3
    }

    @RequiresApi(18)
    public static final long getOrDefault(@NotNull SparseLongArray r1, int r2, long r3) {
        Intrinsics.g(r1, "$this$getOrDefault");
        return r1.get(r2, r3);
    }

    @RequiresApi(18)
    public static final long getOrElse(@NotNull SparseLongArray r1, int r2, @NotNull Function0<Long> r3) {
        Intrinsics.g(r1, "$this$getOrElse");
        Intrinsics.g(r3, "defaultValue");
        int r4 = r1.indexOfKey(r2);
        if (r4 == (-1)) goto L6;
        return r1.valueAt(r4);
    L6:
        return ((Number) r3.invoke()).longValue();
    }

    @RequiresApi(18)
    public static final int getSize(@NotNull SparseLongArray r1) {
        Intrinsics.g(r1, "$this$size");
        return r1.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(@NotNull SparseLongArray r1) {
        Intrinsics.g(r1, "$this$isEmpty");
        if (r1.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(@NotNull SparseLongArray r1) {
        Intrinsics.g(r1, "$this$isNotEmpty");
        if (r1.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(18)
    @NotNull
    public static final IntIterator keyIterator(@NotNull final SparseLongArray r1) {
        Intrinsics.g(r1, "$this$keyIterator");
        return new AnonymousClass1(r1);
    }

    @RequiresApi(18)
    @NotNull
    public static final SparseLongArray plus(@NotNull SparseLongArray r3, @NotNull SparseLongArray r4) {
        Intrinsics.g(r3, "$this$plus");
        Intrinsics.g(r4, "other");
        int r1 = r3.size();
        SparseLongArray r0 = new SparseLongArray(r4.size() + r1);
        putAll(r0, r3);
        putAll(r0, r4);
        return r0;
    }

    @RequiresApi(18)
    public static final void putAll(@NotNull SparseLongArray r5, @NotNull SparseLongArray r6) {
        Intrinsics.g(r5, "$this$putAll");
        Intrinsics.g(r6, "other");
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.put(r6.keyAt(r1), r6.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    @RequiresApi(18)
    public static final boolean remove(@NotNull SparseLongArray r2, int r3, long r4) {
        Intrinsics.g(r2, "$this$remove");
        int r5 = r2.indexOfKey(r3);
        if (r5 != (-1)) goto L5;
        return false;
    L5:
        if (r4 != r2.valueAt(r5)) goto L10;
        r2.removeAt(r5);
        return true;
    L10:
        return false;
    }

    @RequiresApi(18)
    public static final void set(@NotNull SparseLongArray r1, int r2, long r3) {
        Intrinsics.g(r1, "$this$set");
        r1.put(r2, r3);
    }

    @RequiresApi(18)
    @NotNull
    public static final LongIterator valueIterator(@NotNull final SparseLongArray r1) {
        Intrinsics.g(r1, "$this$valueIterator");
        return new C00241(r1);
    }
}
