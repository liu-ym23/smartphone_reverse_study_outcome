package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010)\n\u0002\b\u0003\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\u0002\u001a3\u0010\r\u001a\u00020\u000e*\u00020\u00032!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0010H\u0086\bø\u0001\u0000\u001aH\u0010\u0013\u001a\u00020\u000e*\u00020\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\u0014H\u0086\bø\u0001\u0000\u001a\u0015\u0010\u0016\u001a\u00020\u0002*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\n\u001a\r\u0010\u0017\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u000b*\u00020\u0003H\u0086\b\u001a\u0013\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u001a*\u00020\u0003H\u0086\u0002\u001a\u0015\u0010\u001b\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u001c\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\b\"\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u0007*\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"children", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "Landroid/view/Menu;", "getChildren", "(Landroid/view/Menu;)Lkotlin/sequences/Sequence;", "size", "", "getSize", "(Landroid/view/Menu;)I", "contains", "", "item", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "forEachIndexed", "Lkotlin/Function2;", "index", "get", "isEmpty", "isNotEmpty", "iterator", "", "minusAssign", "removeItemAt", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MenuKt {

    /* JADX INFO: renamed from: androidx.core.view.MenuKt$iterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0096\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/view/MenuKt$iterator$1", "", "Landroid/view/MenuItem;", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 implements Iterator<MenuItem>, Object {
        final /* synthetic */ Menu $this_iterator;
        private int index;

        AnonymousClass1(Menu r1) {
            this.$this_iterator = r1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.index >= this.$this_iterator.size()) goto L5;
            return true;
        L5:
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
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

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ MenuItem next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Menu r0 = this.$this_iterator;
            int r1 = this.index - 1;
            this.index = r1;
            MenuItem r2 = r0.getItem(r1);
            if (r2 == null) goto L5;
            o.e(r2, "getItem(index)");
            r0.removeItem(r2.getItemId());
            f0 r3 = f0.f18324a;
        L6:
            if (r3 == null) goto L9;
            return;
        L9:
            throw new IndexOutOfBoundsException();
        L5:
            r3 = null;
            goto L6
        }
    }

    public static final boolean contains(Menu r4, MenuItem r5) {
        o.f(r4, "<this>");
        o.f(r5, "item");
        int r0 = r4.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (o.a(r4.getItem(r2), r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public static final void forEach(Menu r4, l<? super MenuItem, f0> r5) {
        o.f(r4, "<this>");
        o.f(r5, "action");
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        MenuItem r2 = r4.getItem(r1);
        o.e(r2, "getItem(index)");
        r5.invoke(r2);
        r1 = r1 + 1;
        goto L3
    }

    public static final void forEachIndexed(Menu r5, p<? super Integer, ? super MenuItem, f0> r6) {
        o.f(r5, "<this>");
        o.f(r6, "action");
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Integer r2 = Integer.valueOf(r1);
        MenuItem r3 = r5.getItem(r1);
        o.e(r3, "getItem(index)");
        r6.invoke(r2, r3);
        r1 = r1 + 1;
        goto L3
    }

    public static final MenuItem get(Menu r1, int r2) {
        o.f(r1, "<this>");
        MenuItem r3 = r1.getItem(r2);
        o.e(r3, "getItem(index)");
        return r3;
    }

    public static final kotlin.t0.h<MenuItem> getChildren(final Menu r1) {
        o.f(r1, "<this>");
        return new MenuKt$children$1(r1);
    }

    public static final int getSize(Menu r1) {
        o.f(r1, "<this>");
        return r1.size();
    }

    public static final boolean isEmpty(Menu r1) {
        o.f(r1, "<this>");
        if (r1.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(Menu r1) {
        o.f(r1, "<this>");
        if (r1.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Iterator<MenuItem> iterator(Menu r1) {
        o.f(r1, "<this>");
        return new AnonymousClass1(r1);
    }

    public static final void minusAssign(Menu r1, MenuItem r2) {
        o.f(r1, "<this>");
        o.f(r2, "item");
        r1.removeItem(r2.getItemId());
    }

    public static final void removeItemAt(Menu r1, int r2) {
        o.f(r1, "<this>");
        MenuItem r3 = r1.getItem(r2);
        if (r3 == null) goto L5;
        r1.removeItem(r3.getItemId());
        f0 r4 = f0.f18324a;
    L6:
        if (r4 == null) goto L9;
        return;
    L9:
        throw new IndexOutOfBoundsException();
    L5:
        r4 = null;
        goto L6
    }
}
