package androidx.core.util;

import android.util.SparseArray;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.SparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata
    public static final class C00211<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ SparseArray $this_valueIterator;
        private int index;

        public C00211(SparseArray<T> r1) {
            this.$this_valueIterator = r1;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_valueIterator.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            SparseArray r0 = this.$this_valueIterator;
            int r1 = this.index;
            this.index = r1 + 1;
            return (T) r0.valueAt(r1);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public final void setIndex(int r1) {
            this.index = r1;
        }
    }

    public static final <T> boolean contains(@NotNull SparseArray<T> r1, int r2) {
        Intrinsics.g(r1, "$this$contains");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> boolean containsKey(@NotNull SparseArray<T> r1, int r2) {
        Intrinsics.g(r1, "$this$containsKey");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> boolean containsValue(@NotNull SparseArray<T> r1, T r2) {
        Intrinsics.g(r1, "$this$containsValue");
        if (r1.indexOfValue(r2) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> void forEach(@NotNull SparseArray<T> r4, @NotNull Function2<? super Integer, ? super T, Unit> r5) {
        Intrinsics.g(r4, "$this$forEach");
        Intrinsics.g(r5, "action");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.mo7invoke(Integer.valueOf(r4.keyAt(r1)), r4.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final <T> T getOrDefault(@NotNull SparseArray<T> r1, int r2, T r3) {
        Intrinsics.g(r1, "$this$getOrDefault");
        T r4 = r1.get(r2);
        if (r4 != null) goto L5;
        return r3;
    L5:
        return r4;
    }

    public static final <T> T getOrElse(@NotNull SparseArray<T> r1, int r2, @NotNull Function0<? extends T> r3) {
        Intrinsics.g(r1, "$this$getOrElse");
        Intrinsics.g(r3, "defaultValue");
        T r4 = r1.get(r2);
        if (r4 == null) goto L6;
        return r4;
    L6:
        return (T) r3.invoke();
    }

    public static final <T> int getSize(@NotNull SparseArray<T> r1) {
        Intrinsics.g(r1, "$this$size");
        return r1.size();
    }

    public static final <T> boolean isEmpty(@NotNull SparseArray<T> r1) {
        Intrinsics.g(r1, "$this$isEmpty");
        if (r1.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArray<T> r1) {
        Intrinsics.g(r1, "$this$isNotEmpty");
        if (r1.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NotNull
    public static final <T> IntIterator keyIterator(@NotNull final SparseArray<T> r1) {
        Intrinsics.g(r1, "$this$keyIterator");
        return new AnonymousClass1(r1);
    }

    @NotNull
    public static final <T> SparseArray<T> plus(@NotNull SparseArray<T> r3, @NotNull SparseArray<T> r4) {
        Intrinsics.g(r3, "$this$plus");
        Intrinsics.g(r4, "other");
        int r1 = r3.size();
        SparseArray<T> r0 = new SparseArray(r4.size() + r1);
        putAll(r0, r3);
        putAll(r0, r4);
        return r0;
    }

    public static final <T> void putAll(@NotNull SparseArray<T> r4, @NotNull SparseArray<T> r5) {
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

    public static final <T> boolean remove(@NotNull SparseArray<T> r1, int r2, T r3) {
        Intrinsics.g(r1, "$this$remove");
        int r4 = r1.indexOfKey(r2);
        if (r4 != (-1)) goto L5;
        return false;
    L5:
        if (Intrinsics.a(r3, r1.valueAt(r4)) == false) goto L10;
        r1.removeAt(r4);
        return true;
    L10:
        return false;
    }

    public static final <T> void set(@NotNull SparseArray<T> r1, int r2, T r3) {
        Intrinsics.g(r1, "$this$set");
        r1.put(r2, r3);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull SparseArray<T> r1) {
        Intrinsics.g(r1, "$this$valueIterator");
        return new C00211(r1);
    }
}
