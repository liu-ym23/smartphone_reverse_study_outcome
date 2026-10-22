package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public final class MarginPageTransformer implements ViewPager2.PageTransformer {
    private final int mMarginPx;

    public MarginPageTransformer(int r2) {
        Preconditions.checkArgumentNonnegative(r2, "Margin must be non-negative");
        this.mMarginPx = r2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(View r2, float r3) {
        ViewPager2 r0 = requireViewPager(r2);
        float r1 = this.mMarginPx * r3;
        if (r0.getOrientation() == 0) goto L5;
        r2.setTranslationY(r1);
        return;
    L5:
        if (r0.isRtl() == false) goto L7;
        r1 = -r1;
    L7:
        r2.setTranslationX(r1);
    }

    private ViewPager2 requireViewPager(View r1) {
        ViewParent r0 = r1.getParent();
        ViewParent r2 = r0.getParent();
        if ((r0 instanceof RecyclerView) == false) goto L9;
        if ((r2 instanceof ViewPager2) == false) goto L9;
        return (ViewPager2) r2;
    L9:
        throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
    }
}
