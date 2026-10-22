package com.obric.oui.banner;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import kotlin.Metadata;
import kotlin.h;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001yJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0005J\u001b\u0010\u0015\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u001d\u0010\u0005J\u0015\u0010 \u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u001d\u0010$\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u000e¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\r\u0010*\u001a\u00020\u0017¢\u0006\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R$\u00105\u001a\u00020/2\u0006\u00100\u001a\u00020/8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R$\u0010:\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u00010\u00170\u0017068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u001d\u0010?\u001a\u00020;8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010<\u001a\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010-R*\u0010J\u001a\u00020B2\u0006\u0010C\u001a\u00020B8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001d\u0010O\u001a\u00020K8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010<\u001a\u0004\bM\u0010NR\u0013\u0010Q\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\bP\u0010+R$\u0010U\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u000e8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u0010R\"\u0004\bS\u0010TR\"\u0010Y\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u00102\u001a\u0004\bV\u00104\"\u0004\bW\u0010XR\u0013\u0010[\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\bZ\u0010+R\u0013\u0010]\u001a\u00020\u00178F@\u0006¢\u0006\u0006\u001a\u0004\b\\\u0010+R\u0016\u0010_\u001a\u00020/8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u00104R\u0016\u0010b\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010-R\u001c\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00170e8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bf\u0010gR$\u0010l\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00178\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bi\u0010j\u001a\u0004\bk\u0010+R\u0018\u0010o\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010q\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010-R\u001d\u0010u\u001a\u00020r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010<\u001a\u0004\bs\u0010tR\u0016\u0010x\u001a\u00020v8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010w¨\u0006z"}, d2 = {"Lcom/obric/oui/banner/OBanner;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "Lcom/obric/oui/banner/i/a;", "Lkotlin/f0;", "l", "()V", "m", "Lcom/obric/oui/banner/i/b;", "listener", "setBannerItemClickListener", "(Lcom/obric/oui/banner/i/b;)V", "n", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "q", "", "Lcom/obric/oui/banner/a;", "dataSet", "setData", "(Ljava/util/List;)V", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "onAttachedToWindow", "onDetachedFromWindow", "Lcom/obric/oui/banner/b;", "style", "setBannerStyle", "(Lcom/obric/oui/banner/b;)V", "position", "smoothScroll", "p", "(IZ)Lcom/obric/oui/banner/OBanner;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "onPageChangeListener", "setOnPageChangeListener", "(Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;)V", "getCurrentRealPos", "()I", "r", "Z", "isUserDragging", "", "<set-?>", "o", "J", "getLastUserTouchTime", "()J", "lastUserTouchTime", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "u", "Landroidx/lifecycle/MutableLiveData;", "_selectedPosition", "Landroidx/viewpager2/widget/ViewPager2;", "Lkotlin/h;", "getViewPager2", "()Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "z", "haveVibratedAfterUserDragging", "", "value", "A", "F", "getProportion", "()F", "setProportion", "(F)V", "proportion", "Landroidx/viewpager2/widget/CompositePageTransformer;", BaseSwitches.V, "getCompositePageTransformer", "()Landroidx/viewpager2/widget/CompositePageTransformer;", "compositePageTransformer", "getRealCount", "realCount", "()Z", "setInfiniteSwitchEnabled", "(Z)V", "isInfiniteSwitchEnabled", "getDelayAfterUserTouch", "setDelayAfterUserTouch", "(J)V", "delayAfterUserTouch", "getCurrentItem", "currentItem", "getItemCount", "itemCount", "getAutoSwitchIntervalMs", "autoSwitchIntervalMs", "y", "Lcom/obric/oui/banner/b;", "mBannerStyle", "t", "isAutoSwitchEnabled", "Landroidx/lifecycle/LiveData;", "getSelectedPosition", "()Landroidx/lifecycle/LiveData;", "selectedPosition", "x", "I", "getStartPosition", "startPosition", "w", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "mOnPageChangeListener", "s", "pageInvalid", "Lcom/obric/oui/banner/BannerAdapter;", "getAdapter", "()Lcom/obric/oui/banner/BannerAdapter;", "adapter", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "checkAutoPlayRunnable", "BannerOnPageChangeCallback", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public final class OBanner extends RadiusLayout implements com.obric.oui.banner.i.a {
    private float A;
    private long m;
    private final h n;
    private long o;
    private final h p;
    private final Runnable q;
    private boolean r;
    private boolean s;
    private boolean t;
    private MutableLiveData<Integer> u;
    private final h v;
    private ViewPager2.OnPageChangeCallback w;
    private int x;
    private b y;
    private boolean z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0080\u0004\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/obric/oui/banner/OBanner$BannerOnPageChangeCallback;", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "positionOffset", "positionOffsetPixels", "Lkotlin/f0;", "onPageScrolled", "(IFI)V", "onPageSelected", "(I)V", WsConstants.KEY_CONNECTION_STATE, "onPageScrollStateChanged", "a", "I", "tempPosition", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
    public final class BannerOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OBanner f10785b;

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int r5) {
            if (r5 != 0) goto L30;
            if (this.f10784a == (-1)) goto L30;
            if (e.f10805b[OBanner.g(this.f10785b).ordinal()] != 1) goto L8;
            int r0 = this.f10784a;
            if (r0 != 0) goto L21;
        L19:
            OBanner r1 = this.f10785b;
            int r2 = r1.getStartPosition();
        L20:
            r1.p(r2, false);
            goto L30
        L21:
            if (r0 != 1) goto L24;
            r1 = this.f10785b;
            r2 = r1.getStartPosition() + 1;
            goto L20
        L24:
            if (r0 != (this.f10785b.getItemCount() - 1)) goto L27;
            r1 = this.f10785b;
            r2 = r1.getStartPosition() - 1;
            goto L20
        L27:
            if (r0 != (this.f10785b.getItemCount() - 2)) goto L30;
        L8:
            if (this.f10784a == (-1)) goto L30;
            if (this.f10785b.o() == false) goto L30;
            int r3 = this.f10784a;
            if (r3 != 0) goto L15;
            r1 = this.f10785b;
            r2 = r1.getRealCount();
            goto L20
        L15:
            if (r3 != (this.f10785b.getItemCount() - 1)) goto L30;
            this.f10785b.p(1, false);
        L30:
            if (OBanner.h(this.f10785b) == null) goto L35;
            ViewPager2.OnPageChangeCallback r4 = OBanner.h(this.f10785b);
            if (r4 == null) goto L36;
            r4.onPageScrollStateChanged(r5);
            return;
        L36:
            return;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int r5, float r6, int r7) {
            int r8 = com.obric.oui.banner.j.a.f10810a.a(this.f10785b.o(), r5, this.f10785b.getRealCount());
            boolean r1 = false;
            if (e.f10804a[OBanner.g(this.f10785b).ordinal()] == 1) goto L8;
            if (r8 != (this.f10785b.getCurrentItem() - 1)) goto L11;
        L9:
            r1 = true;
        L11:
            if (OBanner.h(this.f10785b) == null) goto L17;
            if (r1 == false) goto L18;
            ViewPager2.OnPageChangeCallback r4 = OBanner.h(this.f10785b);
            if (r4 == null) goto L19;
            r4.onPageScrolled(r8, r6, r7);
            return;
        L19:
            return;
        L18:
            return;
        L17:
            return;
        L8:
            if (r8 != (((this.f10785b.getCurrentItem() - 2) + this.f10785b.getRealCount()) % this.f10785b.getRealCount())) goto L11;
            goto L9
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int r4) {
            int r0 = com.obric.oui.banner.j.a.f10810a.a(this.f10785b.o(), r4, this.f10785b.getRealCount());
            this.f10784a = r4;
            if (OBanner.h(this.f10785b) == null) goto L7;
            ViewPager2.OnPageChangeCallback r1 = OBanner.h(this.f10785b);
            if (r1 == null) goto L7;
            r1.onPageSelected(r0);
        L7:
            OBanner.k(this.f10785b, false);
            OBanner.i(this.f10785b).setValue(Integer.valueOf(r0));
            if (OBanner.f(this.f10785b) == true) goto L11;
            d.g.d.f.f.b.a("OBanner", "onPageSelected, position: " + r4 + ", realPosition: " + r0);
            d.g.d.d.a.b(this.f10785b.getContext(), 3);
            OBanner.j(this.f10785b, true);
            return;
        }
    }

    static {
    }

    public static final /* synthetic */ BannerAdapter e(OBanner r0) {
        return r0.getAdapter();
    }

    public static final /* synthetic */ boolean f(OBanner r0) {
        return r0.z;
    }

    public static final /* synthetic */ b g(OBanner r0) {
        return r0.y;
    }

    private final BannerAdapter getAdapter() {
        return (BannerAdapter) this.p.getValue();
    }

    private final CompositePageTransformer getCompositePageTransformer() {
        return (CompositePageTransformer) this.v.getValue();
    }

    public static final /* synthetic */ ViewPager2.OnPageChangeCallback h(OBanner r0) {
        return r0.w;
    }

    public static final /* synthetic */ MutableLiveData i(OBanner r0) {
        return r0.u;
    }

    public static final /* synthetic */ void j(OBanner r0, boolean r1) {
        r0.z = r1;
    }

    public static final /* synthetic */ void k(OBanner r0, boolean r1) {
        r0.s = r1;
    }

    private final void l() {
        if (this.t == true) goto L5;
    L26:
        String r6 = "检查换页：开关 false，不换页";
    L10:
        com.obric.oui.common.util.e.a(r6);
        return;
    L5:
        if (this.m <= 0) goto L26;
        if (this.r == false) goto L13;
        r6 = "检查换页：正在拖动，不换页";
        goto L10
    L13:
        if (isAttachedToWindow() == true) goto L15;
        r6 = "剥离window，不换页";
        goto L10
    L15:
        long r0 = SystemClock.uptimeMillis() - this.o;
        if (r0 >= this.m) goto L22;
        com.obric.oui.common.util.e.a("检查换页: 刚松手" + r0 + " ms，delay换页");
        Handler r2 = getHandler();
        if (r2 == null) goto L27;
        r2.postDelayed(this.q, this.m - r0);
        return;
    L27:
        return;
    L22:
        if (this.s == false) goto L24;
        q();
        return;
    L24:
        com.obric.oui.common.util.e.a("检查换页：不是业务触发的，不换页");
    }

    private final void m() {
        Handler r0 = getHandler();
        if (r0 == null) goto L6;
        r0.removeCallbacks(this.q);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r5) {
        if (r5 == null) goto L4;
        Integer r0 = Integer.valueOf(r5.getAction());
    L6:
        if (r0 != null) goto L9;
    L11:
        if (r0 == null) goto L17;
        if (r0.intValue() != 1) goto L17;
    L21:
        this.r = false;
        this.o = SystemClock.uptimeMillis();
        l();
    L23:
        return super.dispatchTouchEvent(r5);
    L17:
        if (r0 == null) goto L23;
        if (r0.intValue() != 3) goto L23;
    L9:
        if (r0.intValue() != 0) goto L11;
        this.r = true;
        this.z = false;
        goto L23
    L4:
        r0 = null;
        goto L6
    }

    public long getAutoSwitchIntervalMs() {
        return this.m;
    }

    public final int getCurrentItem() {
        return getViewPager2().getCurrentItem();
    }

    public final int getCurrentRealPos() {
        return com.obric.oui.banner.j.a.f10810a.a(o(), getCurrentItem(), getRealCount());
    }

    public final long getDelayAfterUserTouch() {
        return this.m;
    }

    public final int getItemCount() {
        return getAdapter().getItemCount();
    }

    public final long getLastUserTouchTime() {
        return this.o;
    }

    public final float getProportion() {
        return this.A;
    }

    public final int getRealCount() {
        return getAdapter().e();
    }

    @Override // com.obric.oui.banner.i.a
    public LiveData<Integer> getSelectedPosition() {
        return this.u;
    }

    public final int getStartPosition() {
        return this.x;
    }

    public final ViewPager2 getViewPager2() {
        return (ViewPager2) this.n.getValue();
    }

    public final void n() {
        m();
        this.t = false;
    }

    public final boolean o() {
        return getAdapter().f();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r3, int r4) {
        if (this.A > 0) goto L6;
        super.onMeasure(r3, r4);
        return;
    L6:
        int r5 = View.MeasureSpec.getSize(r3);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r5, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec((int) Math.floor(r5 / this.A), BasicMeasure.EXACTLY));
    }

    public final OBanner p(int r3, boolean r4) {
        if (getViewPager2().getScrollState() == 0) goto L10;
        Log.w("OBanner", "viewPager2 scrollState: " + getViewPager2().getScrollState() + ", ban setCurrentItem");
    L9:
        return this;
    L10:
        getViewPager2().setCurrentItem(r3, r4);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        Log.e("OBanner", "setCurrentItem error, msg: " + e.getMessage());
        goto L9
    }

    public final void q() {
        getViewPager2().setCurrentItem(getViewPager2().getCurrentItem() + 1, true);
    }

    public final void setBannerItemClickListener(com.obric.oui.banner.i.b r1) {
        o.f(r1, "listener");
    }

    public final void setBannerStyle(b r2) {
        o.f(r2, "style");
        this.y = r2;
    }

    public final void setData(List<? extends a> r4) {
        o.f(r4, "dataSet");
        getAdapter().l(r4);
        int r1 = 1;
        if (r4.size() != 1) goto L6;
        n();
        setInfiniteSwitchEnabled(false);
    L6:
        if (o() == false) goto L9;
        r1 = getRealCount() * 100;
    L11:
        this.x = r1;
        p(r1, false);
        getViewPager2().requestTransform();
        return;
    L9:
        if (f.f10807b[this.y.ordinal()] == 1) goto L11;
        r1 = 0;
        goto L11
    }

    public final void setDelayAfterUserTouch(long r1) {
        this.m = r1;
    }

    public final void setInfiniteSwitchEnabled(boolean r2) {
        getAdapter().m(r2);
        getAdapter().notifyDataSetChanged();
    }

    public final void setOnPageChangeListener(ViewPager2.OnPageChangeCallback r2) {
        o.f(r2, "onPageChangeListener");
        this.w = r2;
    }

    public final void setProportion(float r2) {
        if (r2 >= 0) goto L5;
        this.A = 0.0f;
        return;
    L5:
        this.A = r2;
        invalidate();
    }
}
