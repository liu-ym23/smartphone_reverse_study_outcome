package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LongSparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.core.util.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata
    public static final class C00201<T> implements Iterator<T>, KMappedMarker {
        final /* synthetic */ LongSparseArray $this_valueIterator;
        private int index;

        public C00201(LongSparseArray<T> r1) {
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
            LongSparseArray r0 = this.$this_valueIterator;
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

    @RequiresApi(16)
    public static final <T> boolean contains(@NotNull LongSparseArray<T> r1, long r2) {
        Intrinsics.g(r1, "$this$contains");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(@NotNull LongSparseArray<T> r1, long r2) {
        Intrinsics.g(r1, "$this$containsKey");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(@NotNull LongSparseArray<T> r1, T r2) {
        Intrinsics.g(r1, "$this$containsValue");
        if (r1.indexOfValue(r2) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(16)
    public static final <T> void forEach(@NotNull LongSparseArray<T> r4, @NotNull Function2<? super Long, ? super T, Unit> r5) {
        Intrinsics.g(r4, "$this$forEach");
        Intrinsics.g(r5, "action");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.mo7invoke(Long.valueOf(r4.keyAt(r1)), r4.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> r1, long r2, T r4) {
        Intrinsics.g(r1, "$this$getOrDefault");
        T r3 = r1.get(r2);
        if (r3 != null) goto L5;
        return r4;
    L5:
        return r3;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(@NotNull LongSparseArray<T> r1, long r2, @NotNull Function0<? extends T> r4) {
        Intrinsics.g(r1, "$this$getOrElse");
        Intrinsics.g(r4, "defaultValue");
        T r3 = r1.get(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return (T) r4.invoke();
    }

    @RequiresApi(16)
    public static final <T> int getSize(@NotNull LongSparseArray<T> r1) {
        Intrinsics.g(r1, "$this$size");
        return r1.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(@NotNull LongSparseArray<T> r1) {
        Intrinsics.g(r1, "$this$isEmpty");
        if (r1.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> r1) {
        Intrinsics.g(r1, "$this$isNotEmpty");
        if (r1.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> LongIterator keyIterator(@NotNull final LongSparseArray<T> r1) {
        Intrinsics.g(r1, "$this$keyIterator");
        return new AnonymousClass1(r1);
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> r3, @NotNull LongSparseArray<T> r4) {
        Intrinsics.g(r3, "$this$plus");
        Intrinsics.g(r4, "other");
        int r1 = r3.size();
        LongSparseArray<T> r0 = new LongSparseArray(r4.size() + r1);
        putAll(r0, r3);
        putAll(r0, r4);
        return r0;
    }

    @RequiresApi(16)
    public static final <T> void putAll(@NotNull LongSparseArray<T> r5, @NotNull LongSparseArray<T> r6) {
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

    @RequiresApi(16)
    public static final <T> boolean remove(@NotNull LongSparseArray<T> r1, long r2, T r4) {
        Intrinsics.g(r1, "$this$remove");
        int r3 = r1.indexOfKey(r2);
        if (r3 != (-1)) goto L5;
        return false;
    L5:
        if (Intrinsics.a(r4, r1.valueAt(r3)) == false) goto L10;
        r1.removeAt(r3);
        return true;
    L10:
        return false;
    }

    @RequiresApi(16)
    public static final <T> void set(@NotNull LongSparseArray<T> r1, long r2, T r4) {
        Intrinsics.g(r1, "$this$set");
        r1.put(r2, r4);
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> r1) {
        Intrinsics.g(r1, "$this$valueIterator");
        return new C00201(r1);
    }
}
