package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.k0;
import kotlin.n0.c.p;
import kotlin.n0.d.l0.a;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a(\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u0005\u0010\u0006\u001a0\u0010\t\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\n¢\u0006\u0004\b\t\u0010\n\u001a4\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¢\u0006\u0004\b\f\u0010\r\u001a0\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a6\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a \u0010\u0014\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a/\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a:\u0010\u001a\u001a\u00020\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0018H\u0086\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001d\u0010\u001d\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b \u0010!\"$\u0010%\u001a\u00020\"\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006&"}, d2 = {"T", "Landroidx/collection/LongSparseArray;", "", "key", "", "contains", "(Landroidx/collection/LongSparseArray;J)Z", "value", "Lkotlin/f0;", "set", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)V", "other", "plus", "(Landroidx/collection/LongSparseArray;Landroidx/collection/LongSparseArray;)Landroidx/collection/LongSparseArray;", "defaultValue", "getOrDefault", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroidx/collection/LongSparseArray;JLkotlin/n0/c/a;)Ljava/lang/Object;", "isNotEmpty", "(Landroidx/collection/LongSparseArray;)Z", "remove", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Z", "Lkotlin/Function2;", "action", "forEach", "(Landroidx/collection/LongSparseArray;Lkotlin/n0/c/p;)V", "Lkotlin/i0/k0;", "keyIterator", "(Landroidx/collection/LongSparseArray;)Lkotlin/i0/k0;", "", "valueIterator", "(Landroidx/collection/LongSparseArray;)Ljava/util/Iterator;", "", "getSize", "(Landroidx/collection/LongSparseArray;)I", "size", "collection-ktx"}, k = 2, mv = {1, 1, 15})
public final class LongSparseArrayKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.collection.LongSparseArrayKt$valueIterator$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00018\u00008\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"androidx/collection/LongSparseArrayKt$valueIterator$1", "", "", "hasNext", "()Z", "kotlin.jvm.PlatformType", "next", "()Ljava/lang/Object;", "", "index", "I", "getIndex", "()I", "setIndex", "(I)V", "collection-ktx"}, k = 1, mv = {1, 1, 15})
    public static final class C06041<T> implements Iterator<T>, a {
        final /* synthetic */ LongSparseArray $this_valueIterator;
        private int index;

        C06041(LongSparseArray<T> r1) {
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

    public static final <T> boolean contains(LongSparseArray<T> r1, long r2) {
        o.g(r1, "receiver$0");
        return r1.containsKey(r2);
    }

    public static final <T> void forEach(LongSparseArray<T> r4, p<? super Long, ? super T, f0> r5) {
        o.g(r4, "receiver$0");
        o.g(r5, "action");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.invoke(Long.valueOf(r4.keyAt(r1)), r4.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }

    public static final <T> T getOrDefault(LongSparseArray<T> r1, long r2, T r4) {
        o.g(r1, "receiver$0");
        return r1.get(r2, r4);
    }

    public static final <T> T getOrElse(LongSparseArray<T> r1, long r2, kotlin.n0.c.a<? extends T> r4) {
        o.g(r1, "receiver$0");
        o.g(r4, "defaultValue");
        T r3 = r1.get(r2);
        if (r3 == null) goto L6;
        return r3;
    L6:
        return r4.invoke();
    }

    public static final <T> int getSize(LongSparseArray<T> r1) {
        o.g(r1, "receiver$0");
        return r1.size();
    }

    public static final <T> boolean isNotEmpty(LongSparseArray<T> r1) {
        o.g(r1, "receiver$0");
        return !r1.isEmpty();
    }

    public static final <T> k0 keyIterator(final LongSparseArray<T> r1) {
        o.g(r1, "receiver$0");
        return new AnonymousClass1(r1);
    }

    public static final <T> LongSparseArray<T> plus(LongSparseArray<T> r3, LongSparseArray<T> r4) {
        o.g(r3, "receiver$0");
        o.g(r4, "other");
        LongSparseArray<T> r0 = new LongSparseArray(r3.size() + r4.size());
        r0.putAll(r3);
        r0.putAll(r4);
        return r0;
    }

    public static final <T> boolean remove(LongSparseArray<T> r1, long r2, T r4) {
        o.g(r1, "receiver$0");
        return r1.remove(r2, r4);
    }

    public static final <T> void set(LongSparseArray<T> r1, long r2, T r4) {
        o.g(r1, "receiver$0");
        r1.put(r2, r4);
    }

    public static final <T> Iterator<T> valueIterator(LongSparseArray<T> r1) {
        o.g(r1, "receiver$0");
        return new C06041(r1);
    }
}
