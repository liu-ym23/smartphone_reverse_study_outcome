package com.obric.oui.banner;

import a.a;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.lifecycle.LiveData;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.obric.oui.banner.interfaces.BannerOperator;
import com.obric.oui.banner.interfaces.OnBannerItemClickListener;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBanner extends RadiusLayout implements BannerOperator {
    public static final /* synthetic */ int s = 0;
    public long m;
    public long n;
    public OnBannerItemClickListener o;
    public int p;
    public BannerStyle q;
    public float r;

    @Metadata
    public final class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {

        @Metadata
        public final /* synthetic */ class WhenMappings {
            static {
                new int[BannerStyle.values().length][2] = 1;
                new int[BannerStyle.values().length][2] = 1;
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrollStateChanged(int r1) {
            if (r1 != 0) goto L5;
            throw null;
        L5:
            throw null;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageScrolled(int r1, float r2, int r3) {
            throw null;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public final void onPageSelected(int r1) {
            throw null;
        }
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            new int[BannerStyle.values().length][2] = 1;
            new int[BannerStyle.values().length][2] = 1;
            int[] r0 = new int[BannerStyle.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[2] = 3;
            int[] r1 = new int[BannerStyle.values().length];
            r1[0] = 1;
            r1[1] = 2;
            r1[2] = 3;
        }
    }

    private final BannerAdapter getAdapter() {
        throw null;
    }

    private final CompositePageTransformer getCompositePageTransformer() {
        throw null;
    }

    public final void a(int r3, boolean r4) {
        if (getViewPager2().getScrollState() == 0) goto L10;
        Log.w("OBanner", "viewPager2 scrollState: " + getViewPager2().getScrollState() + ", ban setCurrentItem");
        return;
    L10:
        getViewPager2().setCurrentItem(r3, r4);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        a.C(e, new StringBuilder("setCurrentItem error, msg: "), "OBanner");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r4) {
        if (r4 == null) goto L4;
        Integer r0 = Integer.valueOf(r4.getAction());
    L5:
        if (r0 != null) goto L8;
    L10:
        if (r0 != null) goto L13;
    L15:
        if (r0 != null) goto L18;
    L21:
        return super.dispatchTouchEvent(r4);
    L18:
        if (r0.intValue() != 3) goto L21;
    L19:
        this.n = SystemClock.uptimeMillis();
        Log.d("debugging", "检查换页：开关 false，不换页");
        goto L21
    L13:
        if (r0.intValue() != 1) goto L15;
    L8:
        if (r0.intValue() != 0) goto L10;
    L4:
        r0 = null;
        goto L5
    }

    public long getAutoSwitchIntervalMs() {
        return this.m;
    }

    public final int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public final int getCurrentRealPos() {
        boolean r0 = getAdapter().i;
        int r1 = getCurrentItem();
        int r2 = getRealCount();
        if (r0 == false) goto L10;
        if (r2 > 0) goto L9;
        r2 = 1;
    L9:
        return r1 % r2;
    L10:
        return r1;
    }

    public final long getDelayAfterUserTouch() {
        return this.m;
    }

    public final int getItemCount() {
        return getAdapter().getItemCount();
    }

    public final long getLastUserTouchTime() {
        return this.n;
    }

    public final float getProportion() {
        return this.r;
    }

    public final int getRealCount() {
        return getAdapter().f.size();
    }

    @Override // com.obric.oui.banner.interfaces.BannerOperator
    @NotNull
    public LiveData<Integer> getSelectedPosition() {
        return null;
    }

    public final int getStartPosition() {
        return this.p;
    }

    @NotNull
    public final ViewPager2 getViewPager2() {
        throw null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d("debugging", "检查换页：开关 false，不换页");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        if (this.r > 0) goto L6;
        super.onMeasure(r3, r4);
        return;
    L6:
        int r5 = View.MeasureSpec.getSize(r3);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r5, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((int) Math.floor(r5 / this.r), BasicMeasure.EXACTLY));
    }

    public final void setBannerItemClickListener(@NotNull OnBannerItemClickListener r2) {
        Intrinsics.f(r2, "listener");
        this.o = r2;
    }

    public final void setBannerStyle(@NotNull BannerStyle r2) {
        Intrinsics.f(r2, "style");
        this.q = r2;
    }

    public final void setData(@NotNull List<? extends BannerData> r4) {
        Intrinsics.f(r4, "dataSet");
        BannerAdapter r0 = getAdapter();
        r0.getClass();
        r0.f = r4;
        r0.notifyDataSetChanged();
        int r1 = 1;
        if (r4.size() != 1) goto L9;
        Handler r5 = getHandler();
        if (r5 == null) goto L7;
        r5.removeCallbacks(null);
    L7:
        setInfiniteSwitchEnabled(false);
    L9:
        if (getAdapter().i == false) goto L12;
        r1 = getRealCount() * 100;
    L14:
        this.p = r1;
        a(r1, false);
        getViewPager2().requestTransform();
        return;
    L12:
        if (this.q.ordinal() == 2) goto L14;
        r1 = 0;
        goto L14
    }

    public final void setDelayAfterUserTouch(long r1) {
        this.m = r1;
    }

    public final void setInfiniteSwitchEnabled(boolean r2) {
        getAdapter().i = r2;
        getAdapter().notifyDataSetChanged();
    }

    public final void setOnPageChangeListener(@NotNull ViewPager2.OnPageChangeCallback r1) {
        Intrinsics.f(r1, "onPageChangeListener");
    }

    public final void setProportion(float r2) {
        if (r2 >= 0) goto L5;
        this.r = 0.0f;
        return;
    L5:
        this.r = r2;
        invalidate();
    }
}
