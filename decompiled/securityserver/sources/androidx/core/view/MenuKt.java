package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
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
public final class MenuKt {

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<MenuItem>, KMutableIterator {
        final /* synthetic */ Menu $this_iterator;
        private int index;

        public AnonymousClass1(Menu r1) {
            this.$this_iterator = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_iterator.size()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ MenuItem next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Menu r0 = this.$this_iterator;
            int r1 = this.index - 1;
            this.index = r1;
            r0.removeItem(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        @NotNull
        public MenuItem next() {
            Menu r0 = this.$this_iterator;
            int r1 = this.index;
            this.index = r1 + 1;
            MenuItem r3 = r0.getItem(r1);
            if (r3 == null) goto L6;
            return r3;
        L6:
            throw new IndexOutOfBoundsException();
        }
    }

    public static final boolean contains(@NotNull Menu r4, @NotNull MenuItem r5) {
        Intrinsics.g(r4, "$this$contains");
        Intrinsics.g(r5, "item");
        int r0 = r4.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (Intrinsics.a(r4.getItem(r2), r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static final void forEach(@NotNull Menu r4, @NotNull Function1<? super MenuItem, Unit> r5) {
        Intrinsics.g(r4, "$this$forEach");
        Intrinsics.g(r5, "action");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        MenuItem r2 = r4.getItem(r1);
        Intrinsics.b(r2, "getItem(index)");
        r5.invoke(r2);
        r1 = r1 + 1;
        goto L3
    }

    public static final void forEachIndexed(@NotNull Menu r5, @NotNull Function2<? super Integer, ? super MenuItem, Unit> r6) {
        Intrinsics.g(r5, "$this$forEachIndexed");
        Intrinsics.g(r6, "action");
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Integer r2 = Integer.valueOf(r1);
        MenuItem r3 = r5.getItem(r1);
        Intrinsics.b(r3, "getItem(index)");
        r6.mo7invoke(r2, r3);
        r1 = r1 + 1;
        goto L3
    }

    @NotNull
    public static final MenuItem get(@NotNull Menu r1, int r2) {
        Intrinsics.g(r1, "$this$get");
        MenuItem r3 = r1.getItem(r2);
        Intrinsics.b(r3, "getItem(index)");
        return r3;
    }

    @NotNull
    public static final Sequence<MenuItem> getChildren(@NotNull final Menu r1) {
        Intrinsics.g(r1, "$this$children");
        return new MenuKt$children$1(r1);
    }

    public static final int getSize(@NotNull Menu r1) {
        Intrinsics.g(r1, "$this$size");
        return r1.size();
    }

    public static final boolean isEmpty(@NotNull Menu r1) {
        Intrinsics.g(r1, "$this$isEmpty");
        if (r1.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(@NotNull Menu r1) {
        Intrinsics.g(r1, "$this$isNotEmpty");
        if (r1.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @NotNull
    public static final Iterator<MenuItem> iterator(@NotNull Menu r1) {
        Intrinsics.g(r1, "$this$iterator");
        return new AnonymousClass1(r1);
    }

    public static final void minusAssign(@NotNull Menu r1, @NotNull MenuItem r2) {
        Intrinsics.g(r1, "$this$minusAssign");
        Intrinsics.g(r2, "item");
        r1.removeItem(r2.getItemId());
    }
}
