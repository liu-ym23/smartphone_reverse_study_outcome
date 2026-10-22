package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.l0.a;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a3\u0010\b\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0086\bø\u0001\u0000\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", "", "p", "Landroid/graphics/Point;", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "iterator", "", "minus", "not", "or", "plus", "unaryMinus", "xor", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RegionKt {

    /* JADX INFO: renamed from: androidx.core.graphics.RegionKt$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\b\u001a\u00020\u0004H\u0096\u0002J\t\u0010\t\u001a\u00020\u0002H\u0096\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/graphics/RegionKt$iterator$1", "", "Landroid/graphics/Rect;", "hasMore", "", "iterator", "Landroid/graphics/RegionIterator;", "rect", "hasNext", "next", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<Rect>, a {
        private boolean hasMore;
        private final RegionIterator iterator;
        private final Rect rect;

        AnonymousClass1(Region r2) {
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

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Rect next() {
            if (this.hasMore == false) goto L7;
            Rect r0 = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return r0;
        L7:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Rect next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final Region and(Region r1, Rect r2) {
        o.f(r1, "<this>");
        o.f(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.INTERSECT);
        return r0;
    }

    public static final Region and(Region r1, Region r2) {
        o.f(r1, "<this>");
        o.f(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.INTERSECT);
        return r0;
    }

    public static final boolean contains(Region r1, Point r2) {
        o.f(r1, "<this>");
        o.f(r2, "p");
        return r1.contains(r2.x, r2.y);
    }

    public static final void forEach(Region r2, l<? super Rect, f0> r3) {
        o.f(r2, "<this>");
        o.f(r3, "action");
        RegionIterator r0 = new RegionIterator(r2);
    L3:
        Rect r4 = new Rect();
        if (r0.next(r4) == false) goto L5;
        r3.invoke(r4);
        goto L3
    }

    public static final Iterator<Rect> iterator(Region r1) {
        o.f(r1, "<this>");
        return new AnonymousClass1(r1);
    }

    public static final Region minus(Region r1, Rect r2) {
        o.f(r1, "<this>");
        o.f(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.DIFFERENCE);
        return r0;
    }

    public static final Region minus(Region r1, Region r2) {
        o.f(r1, "<this>");
        o.f(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.DIFFERENCE);
        return r0;
    }

    public static final Region not(Region r2) {
        o.f(r2, "<this>");
        Region r0 = new Region(r2.getBounds());
        r0.op(r2, Region.Op.DIFFERENCE);
        return r0;
    }

    public static final Region or(Region r1, Rect r2) {
        o.f(r1, "<this>");
        o.f(r2, "r");
        Region r0 = new Region(r1);
        r0.union(r2);
        return r0;
    }

    public static final Region or(Region r1, Region r2) {
        o.f(r1, "<this>");
        o.f(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.UNION);
        return r0;
    }

    public static final Region plus(Region r1, Rect r2) {
        o.f(r1, "<this>");
        o.f(r2, "r");
        Region r0 = new Region(r1);
        r0.union(r2);
        return r0;
    }

    public static final Region plus(Region r1, Region r2) {
        o.f(r1, "<this>");
        o.f(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.UNION);
        return r0;
    }

    public static final Region unaryMinus(Region r2) {
        o.f(r2, "<this>");
        Region r0 = new Region(r2.getBounds());
        r0.op(r2, Region.Op.DIFFERENCE);
        return r0;
    }

    public static final Region xor(Region r1, Rect r2) {
        o.f(r1, "<this>");
        o.f(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.XOR);
        return r0;
    }

    public static final Region xor(Region r1, Region r2) {
        o.f(r1, "<this>");
        o.f(r2, "r");
        Region r0 = new Region(r1);
        r0.op(r2, Region.Op.XOR);
        return r0;
    }
}
