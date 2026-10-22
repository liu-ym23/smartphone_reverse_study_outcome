package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u001aø\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004\"\b\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000628\b\u0006\u0010\u0007\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b2%\b\u0006\u0010\r\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u000e2d\b\u0006\u0010\u000f\u001a^\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00150\u0010H\u0086\b¨\u0006\u0016"}, d2 = {"lruCache", "Landroidx/collection/LruCache;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "maxSize", "", "sizeOf", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "create", "Lkotlin/Function1;", "onEntryRemoved", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "", "collection-ktx"}, k = 2, mv = {1, 1, 13})
public final class LruCacheKt {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.collection.LruCacheKt$lruCache$4, reason: invalid class name */
    /* JADX INFO: compiled from: LruCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u0017\u0010\u0002\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0004J/\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u00012\b\u0010\n\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"androidx/collection/LruCacheKt$lruCache$4", "Landroidx/collection/LruCache;", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "", "evicted", "", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", "", "value", "(Ljava/lang/Object;Ljava/lang/Object;)I", "collection-ktx"}, k = 1, mv = {1, 1, 13})
    public static final class AnonymousClass4<K, V> extends LruCache<K, V> {
        final /* synthetic */ Function1 $create;
        final /* synthetic */ int $maxSize;
        final /* synthetic */ Function4 $onEntryRemoved;
        final /* synthetic */ Function2 $sizeOf;

        public AnonymousClass4(Function2 r1, Function1 r2, Function4 r3, int r4, int r5) {
            this.$sizeOf = r1;
            this.$create = r2;
            this.$onEntryRemoved = r3;
            this.$maxSize = r4;
            super(r5);
        }

        @Override // androidx.collection.LruCache
        protected int sizeOf(K r2, V r3) {
            Intrinsics.checkParameterIsNotNull(r2, "key");
            Intrinsics.checkParameterIsNotNull(r3, "value");
            return ((Number) this.$sizeOf.invoke(r2, r3)).intValue();
        }

        @Override // androidx.collection.LruCache
        protected V create(K r2) {
            Intrinsics.checkParameterIsNotNull(r2, "key");
            return (V) this.$create.invoke(r2);
        }

        @Override // androidx.collection.LruCache
        protected void entryRemoved(boolean r2, K r3, V r4, V r5) {
            Intrinsics.checkParameterIsNotNull(r3, "key");
            Intrinsics.checkParameterIsNotNull(r4, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(r2), r3, r4, r5);
        }
    }

    public static /* synthetic */ LruCache lruCache$default(int r6, AnonymousClass1 r7, AnonymousClass2 r8, AnonymousClass3 r9, int r10, Object r11) {
        if ((r10 & 2) == 0) goto L5;
        r7 = AnonymousClass1.INSTANCE;
    L5:
        Function2 r1 = r7;
        if ((r10 & 4) == 0) goto L8;
        r8 = AnonymousClass2.INSTANCE;
    L8:
        Function1 r2 = r8;
        if ((r10 & 8) == 0) goto L11;
        r9 = AnonymousClass3.INSTANCE;
    L11:
        Function4 r3 = r9;
        Intrinsics.checkParameterIsNotNull(r1, "sizeOf");
        Intrinsics.checkParameterIsNotNull(r2, "create");
        Intrinsics.checkParameterIsNotNull(r3, "onEntryRemoved");
        return new AnonymousClass4(r1, r2, r3, r6, r6);
    }

    public static final <K, V> LruCache<K, V> lruCache(int r7, Function2<? super K, ? super V, Integer> r8, Function1<? super K, ? extends V> r9, Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> r10) {
        Intrinsics.checkParameterIsNotNull(r8, "sizeOf");
        Intrinsics.checkParameterIsNotNull(r9, "create");
        Intrinsics.checkParameterIsNotNull(r10, "onEntryRemoved");
        return new AnonymousClass4(r8, r9, r10, r7, r7);
    }
}
