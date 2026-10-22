package androidx.core.util;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LruCacheKt {

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: androidx.core.util.LruCacheKt$lruCache$4, reason: invalid class name */
    @Metadata
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

        @Override // android.util.LruCache
        @Nullable
        public V create(@NotNull K r2) {
            Intrinsics.g(r2, "key");
            return (V) this.$create.invoke(r2);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean r2, @NotNull K r3, @NotNull V r4, @Nullable V r5) {
            Intrinsics.g(r3, "key");
            Intrinsics.g(r4, "oldValue");
            this.$onEntryRemoved.invoke(Boolean.valueOf(r2), r3, r4, r5);
        }

        @Override // android.util.LruCache
        public int sizeOf(@NotNull K r2, @NotNull V r3) {
            Intrinsics.g(r2, "key");
            Intrinsics.g(r3, "value");
            return ((Number) this.$sizeOf.mo7invoke(r2, r3)).intValue();
        }
    }

    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int r7, @NotNull Function2<? super K, ? super V, Integer> r8, @NotNull Function1<? super K, ? extends V> r9, @NotNull Function4<? super Boolean, ? super K, ? super V, ? super V, Unit> r10) {
        Intrinsics.g(r8, "sizeOf");
        Intrinsics.g(r9, "create");
        Intrinsics.g(r10, "onEntryRemoved");
        return new AnonymousClass4(r8, r9, r10, r7, r7);
    }

    @NotNull
    public static /* synthetic */ LruCache lruCache$default(int r6, Function2 r7, Function1 r8, Function4 r9, int r10, Object r11) {
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
        Intrinsics.g(r1, "sizeOf");
        Intrinsics.g(r2, "create");
        Intrinsics.g(r3, "onEntryRemoved");
        return new AnonymousClass4(r1, r2, r3, r6, r6);
    }
}
