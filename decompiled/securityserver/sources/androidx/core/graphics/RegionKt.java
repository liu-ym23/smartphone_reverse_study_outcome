package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RegionKt {

    /* JADX INFO: renamed from: androidx.core.graphics.RegionKt$iterator$1, reason: invalid class name */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<Rect>, KMappedMarker {
        final /* synthetic */ Region $this_iterator;
        private boolean hasMore;
        private final RegionIterator iterator;
        private final Rect rect;

        public AnonymousClass1(Region r2) {
            this.$this_iterator = r2;
            RegionIterator r0 = new RegionIterator(r2);
            this.iterator = r0;
            Rect r3 = new Rect();
            this.rect = r3;
            this.hasMore = r0.next(r3);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasMore;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Rect next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @NotNull
        public Rect next() {
            if (this.hasMore == false) goto L7;
            Rect r0 = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return r0;
        L7:
            throw new IndexOutOfBoundsException();
        }
    }

    @NotNull
    public static final Region and(@NotNull Region r1, @NotNull Rect r2) {
        Intrinsics.g(r1, "$this$and");
        Intrinsics.g(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.INTERSECT);
        return r0;
    }

    public static final boolean contains(@NotNull Region r1, @NotNull Point r2) {
        Intrinsics.g(r1, "$this$contains");
        Intrinsics.g(r2, "p");
        return r1.contains(r2.x, r2.y);
    }

    public static final void forEach(@NotNull Region r2, @NotNull Function1<? super Rect, Unit> r3) {
        Intrinsics.g(r2, "$this$forEach");
        Intrinsics.g(r3, "action");
        RegionIterator r0 = new RegionIterator(r2);
    L3:
        Rect r4 = new Rect();
        if (r0.next(r4) == false) goto L5;
        r3.invoke(r4);
        goto L3
    }

    @NotNull
    public static final Iterator<Rect> iterator(@NotNull Region r1) {
        Intrinsics.g(r1, "$this$iterator");
        return new AnonymousClass1(r1);
    }

    @NotNull
    public static final Region minus(@NotNull Region r1, @NotNull Rect r2) {
        Intrinsics.g(r1, "$this$minus");
        Intrinsics.g(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.DIFFERENCE);
        return r0;
    }

    @NotNull
    public static final Region not(@NotNull Region r2) {
        Intrinsics.g(r2, "$this$not");
        Region r0 = new Region(r2.getBounds());
        r0.op(r2, Region.Op.DIFFERENCE);
        return r0;
    }

    @NotNull
    public static final Region or(@NotNull Region r1, @NotNull Rect r2) {
        Intrinsics.g(r1, "$this$or");
        Intrinsics.g(r2, "r");
        Region r0 = new Region(r1);
        r0.union(r2);
        return r0;
    }

    @NotNull
    public static final Region plus(@NotNull Region r1, @NotNull Rect r2) {
        Intrinsics.g(r1, "$this$plus");
        Intrinsics.g(r2, "r");
        Region r0 = new Region(r1);
        r0.union(r2);
        return r0;
    }

    @NotNull
    public static final Region unaryMinus(@NotNull Region r2) {
        Intrinsics.g(r2, "$this$unaryMinus");
        Region r0 = new Region(r2.getBounds());
        r0.op(r2, Region.Op.DIFFERENCE);
        return r0;
    }

    @NotNull
    public static final Region xor(@NotNull Region r1, @NotNull Rect r2) {
        Intrinsics.g(r1, "$this$xor");
        Intrinsics.g(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.XOR);
        return r0;
    }

    @NotNull
    public static final Region and(@NotNull Region r1, @NotNull Region r2) {
        Intrinsics.g(r1, "$this$and");
        Intrinsics.g(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.INTERSECT);
        return r0;
    }

    @NotNull
    public static final Region minus(@NotNull Region r1, @NotNull Region r2) {
        Intrinsics.g(r1, "$this$minus");
        Intrinsics.g(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.DIFFERENCE);
        return r0;
    }

    @NotNull
    public static final Region or(@NotNull Region r1, @NotNull Region r2) {
        Intrinsics.g(r1, "$this$or");
        Intrinsics.g(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.UNION);
        return r0;
    }

    @NotNull
    public static final Region plus(@NotNull Region r1, @NotNull Region r2) {
        Intrinsics.g(r1, "$this$plus");
        Intrinsics.g(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.UNION);
        return r0;
    }

    @NotNull
    public static final Region xor(@NotNull Region r1, @NotNull Region r2) {
        Intrinsics.g(r1, "$this$xor");
        Intrinsics.g(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.XOR);
        return r0;
    }
}
