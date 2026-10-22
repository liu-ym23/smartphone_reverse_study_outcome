package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0015\u0010\u0010\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\n\u001a3\u0010\u0013\u001a\u00020\u0014*\u00020\u00032!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00140\u0016H\u0086\bø\u0001\u0000\u001aH\u0010\u0019\u001a\u00020\u0014*\u00020\u000326\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00140\u001aH\u0086\bø\u0001\u0000\u001a\u0015\u0010\u001c\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\rH\u0086\u0002\u001a\r\u0010\u001d\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\r\u0010\u001e\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 *\u00020\u0003H\u0086\u0002\u001a\u0015\u0010!\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\"\u001a\u00020\u0014*\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0086\n\u001a\u0017\u0010#\u001a\u00020\u0014*\u00020$2\b\b\u0001\u0010\f\u001a\u00020\rH\u0086\b\u001a5\u0010%\u001a\u00020\u0014*\u00020$2\b\b\u0003\u0010&\u001a\u00020\r2\b\b\u0003\u0010'\u001a\u00020\r2\b\b\u0003\u0010(\u001a\u00020\r2\b\b\u0003\u0010)\u001a\u00020\rH\u0086\b\u001a5\u0010*\u001a\u00020\u0014*\u00020$2\b\b\u0003\u0010+\u001a\u00020\r2\b\b\u0003\u0010'\u001a\u00020\r2\b\b\u0003\u0010,\u001a\u00020\r2\b\b\u0003\u0010)\u001a\u00020\rH\u0087\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\"\u0016\u0010\b\u001a\u00020\t*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0016\u0010\f\u001a\u00020\r*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006-"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "Landroid/view/ViewGroup;", "getChildren", "(Landroid/view/ViewGroup;)Lkotlin/sequences/Sequence;", "descendants", "getDescendants", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Landroid/view/ViewGroup;)Lkotlin/ranges/IntRange;", "size", "", "getSize", "(Landroid/view/ViewGroup;)I", "contains", "", "view", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "plusAssign", "setMargins", "Landroid/view/ViewGroup$MarginLayoutParams;", "updateMargins", "left", "top", "right", "bottom", "updateMarginsRelative", "start", "end", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ViewGroupKt {

    /* JADX INFO: renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<View>, Object {
        final /* synthetic */ ViewGroup $this_iterator;
        private int index;

        AnonymousClass1(ViewGroup r1) {
            this.$this_iterator = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_iterator.getChildCount()) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public View next() {
            ViewGroup r0 = this.$this_iterator;
            int r1 = this.index;
            this.index = r1 + 1;
            View r3 = r0.getChildAt(r1);
            if (r3 == null) goto L6;
            return r3;
        L6:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ View next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup r0 = this.$this_iterator;
            int r1 = this.index - 1;
            this.index = r1;
            r0.removeViewAt(r1);
        }
    }

    public static final boolean contains(ViewGroup r1, View r2) {
        o.f(r1, "<this>");
        o.f(r2, "view");
        if (r1.indexOfChild(r2) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(ViewGroup r4, l<? super View, f0> r5) {
        o.f(r4, "<this>");
        o.f(r5, "action");
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        View r2 = r4.getChildAt(r1);
        o.e(r2, "getChildAt(index)");
        r5.invoke(r2);
        r1 = r1 + 1;
        goto L3
    }

    public static final void forEachIndexed(ViewGroup r5, p<? super Integer, ? super View, f0> r6) {
        o.f(r5, "<this>");
        o.f(r6, "action");
        int r0 = r5.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Integer r2 = Integer.valueOf(r1);
        View r3 = r5.getChildAt(r1);
        o.e(r3, "getChildAt(index)");
        r6.invoke(r2, r3);
        r1 = r1 + 1;
        goto L3
    }

    public static final View get(ViewGroup r3, int r4) {
        o.f(r3, "<this>");
        View r0 = r3.getChildAt(r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IndexOutOfBoundsException("Index: " + r4 + ", Size: " + r3.getChildCount());
    }

    public static final kotlin.t0.h<View> getChildren(final ViewGroup r1) {
        o.f(r1, "<this>");
        return new ViewGroupKt$children$1(r1);
    }

    public static final kotlin.t0.h<View> getDescendants(ViewGroup r2) {
        o.f(r2, "<this>");
        return kotlin.t0.k.b(new ViewGroupKt$descendants$1(r2, null));
    }

    public static final kotlin.r0.d getIndices(ViewGroup r1) {
        o.f(r1, "<this>");
        return kotlin.r0.e.m(0, r1.getChildCount());
    }

    public static final int getSize(ViewGroup r1) {
        o.f(r1, "<this>");
        return r1.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup r1) {
        o.f(r1, "<this>");
        if (r1.getChildCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(ViewGroup r1) {
        o.f(r1, "<this>");
        if (r1.getChildCount() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Iterator<View> iterator(ViewGroup r1) {
        o.f(r1, "<this>");
        return new AnonymousClass1(r1);
    }

    public static final void minusAssign(ViewGroup r1, View r2) {
        o.f(r1, "<this>");
        o.f(r2, "view");
        r1.removeView(r2);
    }

    public static final void plusAssign(ViewGroup r1, View r2) {
        o.f(r1, "<this>");
        o.f(r2, "view");
        r1.addView(r2);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams r1, @Px int r2) {
        o.f(r1, "<this>");
        r1.setMargins(r2, r2, r2, r2);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams r1, @Px int r2, @Px int r3, @Px int r4, @Px int r5) {
        o.f(r1, "<this>");
        r1.setMargins(r2, r3, r4, r5);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.leftMargin;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.topMargin;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.rightMargin;
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = r0.bottomMargin;
    L14:
        o.f(r0, "<this>");
        r0.setMargins(r1, r2, r3, r4);
    }

    @RequiresApi(17)
    @SuppressLint({"ClassVerificationFailure"})
    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams r1, @Px int r2, @Px int r3, @Px int r4, @Px int r5) {
        o.f(r1, "<this>");
        r1.setMarginStart(r2);
        r1.topMargin = r3;
        r1.setMarginEnd(r4);
        r1.bottomMargin = r5;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.getMarginStart();
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.topMargin;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.getMarginEnd();
    L12:
        if ((r5 & 8) == 0) goto L14;
        r4 = r0.bottomMargin;
    L14:
        o.f(r0, "<this>");
        r0.setMarginStart(r1);
        r0.topMargin = r2;
        r0.setMarginEnd(r3);
        r0.bottomMargin = r4;
    }
}
