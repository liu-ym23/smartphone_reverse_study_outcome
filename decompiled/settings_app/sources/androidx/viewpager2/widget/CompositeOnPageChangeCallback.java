package androidx.viewpager2.widget;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class CompositeOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
    private final List<ViewPager2.OnPageChangeCallback> mCallbacks;

    CompositeOnPageChangeCallback(int r2) {
        this.mCallbacks = new ArrayList(r2);
    }

    void addOnPageChangeCallback(ViewPager2.OnPageChangeCallback r1) {
        this.mCallbacks.add(r1);
    }

    void removeOnPageChangeCallback(ViewPager2.OnPageChangeCallback r1) {
        this.mCallbacks.remove(r1);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrolled(int r3, float r4, int r5) {
        Iterator<ViewPager2.OnPageChangeCallback> r0 = this.mCallbacks.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r0.hasNext() == false) goto L14;
        r0.next().onPageScrolled(r3, r4, r5);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        throwCallbackListModifiedWhileInUse(e);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int r3) {
        Iterator<ViewPager2.OnPageChangeCallback> r0 = this.mCallbacks.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r0.hasNext() == false) goto L14;
        r0.next().onPageSelected(r3);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        throwCallbackListModifiedWhileInUse(e);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageScrollStateChanged(int r3) {
        Iterator<ViewPager2.OnPageChangeCallback> r0 = this.mCallbacks.iterator();     // Catch: ConcurrentModificationException -> L7
    L4:
        if (r0.hasNext() == false) goto L14;
        r0.next().onPageScrollStateChanged(r3);     // Catch: ConcurrentModificationException -> L7
        goto L4
    L14:
        return;
    L7:
        e = move-exception;
        throwCallbackListModifiedWhileInUse(e);
    }

    private void throwCallbackListModifiedWhileInUse(ConcurrentModificationException r2) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", r2);
    }
}
