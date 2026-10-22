package androidx.collection;

import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.c.p;
import kotlin.n0.c.r;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0096\u0001\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\r\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u001a\b\u0006\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00030\u00052\u0016\b\u0006\u0010\b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00072(\b\u0006\u0010\f\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0012\u0004\u0012\u00020\u000b0\tH\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"", "K", "V", "", "maxSize", "Lkotlin/Function2;", "sizeOf", "Lkotlin/Function1;", "create", "Lkotlin/Function4;", "", "Lkotlin/f0;", "onEntryRemoved", "Landroidx/collection/LruCache;", "lruCache", "(ILkotlin/n0/c/p;Lkotlin/n0/c/l;Lkotlin/n0/c/r;)Landroidx/collection/LruCache;", "collection-ktx"}, k = 2, mv = {1, 1, 15})
public final class LruCacheKt {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00028\u0001H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "K", "V", "<anonymous parameter 0>", "<anonymous parameter 1>", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    public static final class AnonymousClass1<K, V> extends q implements p<K, V, Integer> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2(K r1, V r2) {
            o.g(r1, "<anonymous parameter 0>");
            o.g(r2, "<anonymous parameter 1>");
            return 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Integer invoke(Object r1, Object r2) {
            return Integer.valueOf(invoke2(r1, r2));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0006\u0010\u0006\u001a\u0004\u0018\u00018\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "K", "V", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    public static final class AnonymousClass2<K, V> extends q implements l<K, V> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.n0.c.l
        public final V invoke(K r1) {
            o.g(r1, "it");
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u000b\u001a\u00020\b\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0001H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "K", "V", "", "<anonymous parameter 0>", "<anonymous parameter 1>", "<anonymous parameter 2>", "<anonymous parameter 3>", "Lkotlin/f0;", "invoke", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 1, 15})
    public static final class AnonymousClass3<K, V> extends q implements r<Boolean, K, V, V, f0> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.n0.c.r
        public /* bridge */ /* synthetic */ f0 invoke(Boolean r1, Object r2, Object r3, Object r4) {
            invoke(r1.booleanValue(), r2, r3, r4);
            return f0.f18324a;
        }

        public final void invoke(boolean r1, K r2, V r3, V r4) {
            o.g(r2, "<anonymous parameter 1>");
            o.g(r3, "<anonymous parameter 2>");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$4, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\f\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/collection/LruCacheKt$lruCache$4", "Landroidx/collection/LruCache;", "key", "value", "", "sizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "create", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "evicted", "oldValue", "newValue", "Lkotlin/f0;", "entryRemoved", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "collection-ktx"}, k = 1, mv = {1, 1, 15})
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ l $create;
        final /* synthetic */ int $maxSize;
        final /* synthetic */ r $onEntryRemoved;
        final /* synthetic */ p $sizeOf;

        public AnonymousClass4(p r1, l r2, r r3, int r4, int r5) {
            this.$sizeOf = r1;
            this.$create = r2;
            this.$onEntryRemoved = r3;
            this.$maxSize = r4;
            super(r5);
        }

        @Override // androidx.collection.LruCache
        protected V create(K r2) {
            o.g(r2, "key");
            return (V) this.$create.invoke(r2);
        }

        @Override // androidx.collection.LruCache
        protected void entryRemoved(boolean r2, K r3, V r4, V r5) {
            o.g(r3, "key");
            o.g(r4, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(r2), r3, r4, r5);
        }

        @Override // androidx.collection.LruCache
        protected int sizeOf(K r2, V r3) {
            o.g(r2, "key");
            o.g(r3, "value");
            return ((Number) this.$sizeOf.invoke(r2, r3)).intValue();
        }
    }

    public static final <K, V> LruCache<K, V> lruCache(int r7, p<? super K, ? super V, Integer> r8, l<? super K, ? extends V> r9, r<? super Boolean, ? super K, ? super V, ? super V, f0> r10) {
        o.g(r8, "sizeOf");
        o.g(r9, "create");
        o.g(r10, "onEntryRemoved");
        return new AnonymousClass4(r8, r9, r10, r7, r7);
    }

    public static /* synthetic */ LruCache lruCache$default(int r6, p r7, l r8, r r9, int r10, Object r11) {
        if ((r10 & 2) == 0) goto L5;
        r7 = AnonymousClass1.INSTANCE;
    L5:
        p r1 = r7;
        if ((r10 & 4) == 0) goto L8;
        r8 = AnonymousClass2.INSTANCE;
    L8:
        l r2 = r8;
        if ((r10 & 8) == 0) goto L11;
        r9 = AnonymousClass3.INSTANCE;
    L11:
        r r3 = r9;
        o.g(r1, "sizeOf");
        o.g(r2, "create");
        o.g(r3, "onEntryRemoved");
        return new AnonymousClass4(r1, r2, r3, r6, r6);
    }
}
