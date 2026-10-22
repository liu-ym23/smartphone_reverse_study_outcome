package androidx.core.util;

import android.util.SparseBooleanArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.BooleanIterator;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SparseBooleanArrayKt {
    public static final boolean contains(@NotNull SparseBooleanArray r1, int r2) {
        Intrinsics.g(r1, "$this$contains");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsKey(@NotNull SparseBooleanArray r1, int r2) {
        Intrinsics.g(r1, "$this$containsKey");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsValue(@NotNull SparseBooleanArray r1, boolean r2) {
        Intrinsics.g(r1, "$this$containsValue");
        if (r1.indexOfValue(r2) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(@NotNull SparseBooleanArray r4, @NotNull Function2<? super Integer, ? super Boolean, Unit> r5) {
        Intrinsics.g(r4, "$this$forEach");
        Intrinsics.g(r5, "action");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.mo7invoke(Integer.valueOf(r4.keyAt(r1)), Boolean.valueOf(r4.valueAt(r1)));
        r1 = r1 + 1;
        goto L3
    }

    public static final boolean getOrDefault(@NotNull SparseBooleanArray r1, int r2, boolean r3) {
        Intrinsics.g(r1, "$this$getOrDefault");
        return r1.get(r2, r3);
    }

    public static final boolean getOrElse(@NotNull SparseBooleanArray r1, int r2, @NotNull Function0<Boolean> r3) {
        Intrinsics.g(r1, "$this$getOrElse");
        Intrinsics.g(r3, "defaultValue");
        int r4 = r1.indexOfKey(r2);
        if (r4 == (-1)) goto L6;
        return r1.valueAt(r4);
    L6:
        return ((Boolean) r3.invoke()).booleanValue();
    }

    public static final int getSize(@NotNull SparseBooleanArray r1) {
        Intrinsics.g(r1, "$this$size");
        return r1.size();
    }

    public static final boolean isEmpty(@NotNull SparseBooleanArray r1) {
        Intrinsics.g(r1, "$this$isEmpty");
        if (r1.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(@NotNull SparseBooleanArray r1) {
        Intrinsics.g(r1, "$this$isNotEmpty");
        if (r1.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NotNull
    public static final IntIterator keyIterator(@NotNull final SparseBooleanArray r1) {
        Intrinsics.g(r1, "$this$keyIterator");
        return new AnonymousClass1(r1);
    }

    @NotNull
    public static final SparseBooleanArray plus(@NotNull SparseBooleanArray r3, @NotNull SparseBooleanArray r4) {
        Intrinsics.g(r3, "$this$plus");
        Intrinsics.g(r4, "other");
        int r1 = r3.size();
        SparseBooleanArray r0 = new SparseBooleanArray(r4.size() + r1);
        putAll(r0, r3);
        putAll(r0, r4);
        return r0;
    }

    public static final void putAll(@NotNull SparseBooleanArray r4, @NotNull SparseBooleanArray r5) {
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

    public static final boolean remove(@NotNull SparseBooleanArray r2, int r3, boolean r4) {
        Intrinsics.g(r2, "$this$remove");
        int r0 = r2.indexOfKey(r3);
        if (r0 != (-1)) goto L5;
        return false;
    L5:
        if (r4 != r2.valueAt(r0)) goto L10;
        r2.delete(r3);
        return true;
    L10:
        return false;
    }

    public static final void set(@NotNull SparseBooleanArray r1, int r2, boolean r3) {
        Intrinsics.g(r1, "$this$set");
        r1.put(r2, r3);
    }

    @NotNull
    public static final BooleanIterator valueIterator(@NotNull final SparseBooleanArray r1) {
        Intrinsics.g(r1, "$this$valueIterator");
        return new C00221(r1);
    }
}
