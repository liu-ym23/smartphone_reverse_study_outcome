package androidx.core.view;

import a.a;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ViewGroupKt {

    /* JADX INFO: renamed from: androidx.core.view.ViewGroupKt$iterator$1, reason: invalid class name */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<View>, KMutableIterator {
        final /* synthetic */ ViewGroup $this_iterator;
        private int index;

        public AnonymousClass1(ViewGroup r1) {
            this.$this_iterator = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_iterator.getChildCount()) goto L5;
            return true;
        L5:
            return false;
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

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @NotNull
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
    }

    public static final boolean contains(@NotNull ViewGroup r1, @NotNull View r2) {
        Intrinsics.g(r1, "$this$contains");
        Intrinsics.g(r2, "view");
        if (r1.indexOfChild(r2) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void forEach(@NotNull ViewGroup r4, @NotNull Function1<? super View, Unit> r5) {
        Intrinsics.g(r4, "$this$forEach");
        Intrinsics.g(r5, "action");
        int r0 = r4.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        View r2 = r4.getChildAt(r1);
        Intrinsics.b(r2, "getChildAt(index)");
        r5.invoke(r2);
        r1 = r1 + 1;
        goto L3
    }

    public static final void forEachIndexed(@NotNull ViewGroup r5, @NotNull Function2<? super Integer, ? super View, Unit> r6) {
        Intrinsics.g(r5, "$this$forEachIndexed");
        Intrinsics.g(r6, "action");
        int r0 = r5.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Integer r2 = Integer.valueOf(r1);
        View r3 = r5.getChildAt(r1);
        Intrinsics.b(r3, "getChildAt(index)");
        r6.mo7invoke(r2, r3);
        r1 = r1 + 1;
        goto L3
    }

    @NotNull
    public static final View get(@NotNull ViewGroup r3, int r4) {
        Intrinsics.g(r3, "$this$get");
        View r0 = r3.getChildAt(r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        StringBuilder r5 = a.p(r4, "Index: ", ", Size: ");
        r5.append(r3.getChildCount());
        throw new IndexOutOfBoundsException(r5.toString());
    }

    @NotNull
    public static final Sequence<View> getChildren(@NotNull final ViewGroup r1) {
        Intrinsics.g(r1, "$this$children");
        return new ViewGroupKt$children$1(r1);
    }

    public static final int getSize(@NotNull ViewGroup r1) {
        Intrinsics.g(r1, "$this$size");
        return r1.getChildCount();
    }

    public static final boolean isEmpty(@NotNull ViewGroup r1) {
        Intrinsics.g(r1, "$this$isEmpty");
        if (r1.getChildCount() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(@NotNull ViewGroup r1) {
        Intrinsics.g(r1, "$this$isNotEmpty");
        if (r1.getChildCount() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NotNull
    public static final Iterator<View> iterator(@NotNull ViewGroup r1) {
        Intrinsics.g(r1, "$this$iterator");
        return new AnonymousClass1(r1);
    }

    public static final void minusAssign(@NotNull ViewGroup r1, @NotNull View r2) {
        Intrinsics.g(r1, "$this$minusAssign");
        Intrinsics.g(r2, "view");
        r1.removeView(r2);
    }

    public static final void plusAssign(@NotNull ViewGroup r1, @NotNull View r2) {
        Intrinsics.g(r1, "$this$plusAssign");
        Intrinsics.g(r2, "view");
        r1.addView(r2);
    }

    public static final void setMargins(@NotNull ViewGroup.MarginLayoutParams r1, @Px int r2) {
        Intrinsics.g(r1, "$this$setMargins");
        r1.setMargins(r2, r2, r2, r2);
    }

    public static final void updateMargins(@NotNull ViewGroup.MarginLayoutParams r1, @Px int r2, @Px int r3, @Px int r4, @Px int r5) {
        Intrinsics.g(r1, "$this$updateMargins");
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
        Intrinsics.g(r0, "$this$updateMargins");
        r0.setMargins(r1, r2, r3, r4);
    }

    @RequiresApi(17)
    public static final void updateMarginsRelative(@NotNull ViewGroup.MarginLayoutParams r1, @Px int r2, @Px int r3, @Px int r4, @Px int r5) {
        Intrinsics.g(r1, "$this$updateMarginsRelative");
        r1.setMarginStart(r2);
        r1.topMargin = r3;
        r1.setMarginEnd(r4);
        r1.bottomMargin = r5;
    }

    @RequiresApi(17)
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
        Intrinsics.g(r0, "$this$updateMarginsRelative");
        r0.setMarginStart(r1);
        r0.topMargin = r2;
        r0.setMarginEnd(r3);
        r0.bottomMargin = r4;
    }
}
