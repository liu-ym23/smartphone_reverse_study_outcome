package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CompositePageTransformer implements ViewPager2.PageTransformer {
    private final List<ViewPager2.PageTransformer> mTransformers;

    public CompositePageTransformer() {
        this.mTransformers = new ArrayList();
    }

    public void addTransformer(@NonNull ViewPager2.PageTransformer r1) {
        this.mTransformers.add(r1);
    }

    public void removeTransformer(@NonNull ViewPager2.PageTransformer r1) {
        this.mTransformers.remove(r1);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NonNull View r2, float r3) {
        Iterator<ViewPager2.PageTransformer> r1 = this.mTransformers.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().transformPage(r2, r3);
        goto L4
    }
}
