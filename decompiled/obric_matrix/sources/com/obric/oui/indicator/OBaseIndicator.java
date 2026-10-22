package com.obric.oui.indicator;

import android.database.DataSetObserver;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.oui.common.util.j;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.l;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001:\u0003vwxJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u000f\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\u0004J\u001b\u0010\u000e\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\tJ\u0017\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0012\u0010\tJ\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H&¢\u0006\u0004\b\u0013\u0010\tJ\u000f\u0010\u0014\u001a\u00020\u0002H&¢\u0006\u0004\b\u0014\u0010\u0004J\u000f\u0010\u0016\u001a\u00020\u0015H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0018\u0010\u0004J\r\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u0004J\u0017\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\u001a\u0010\tJ\u000f\u0010\u001b\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u001b\u0010\u0004J\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u001d\u0010!\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0006¢\u0006\u0004\b!\u0010\"J#\u0010$\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060#¢\u0006\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b'\u0010(R*\u0010/\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010\tR\"\u00106\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R&\u0010;\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`98\u0004@\u0005X\u0085\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010:R*\u0010>\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010+\u001a\u0004\b<\u0010-\"\u0004\b=\u0010\tR*\u0010E\u001a\u00020?2\u0006\u0010*\u001a\u00020?8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010F\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u00101R*\u0010I\u001a\u00020?2\u0006\u0010*\u001a\u00020?8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010@\u001a\u0004\bG\u0010B\"\u0004\bH\u0010DR\u0016\u0010J\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u00101R*\u0010M\u001a\u00020?2\u0006\u0010*\u001a\u00020?8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010@\u001a\u0004\bK\u0010B\"\u0004\bL\u0010DR*\u0010P\u001a\u00020?2\u0006\u0010*\u001a\u00020?8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010@\u001a\u0004\bN\u0010B\"\u0004\bO\u0010DR\"\u0010T\u001a\u0002008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bQ\u00101\u001a\u0004\bR\u00103\"\u0004\bS\u00105R*\u0010W\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00068\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010+\u001a\u0004\bU\u0010-\"\u0004\bV\u0010\tR\u0016\u0010X\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u00101R*\u0010[\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010+\u001a\u0004\bY\u0010-\"\u0004\bZ\u0010\tR*\u0010^\u001a\u00020?2\u0006\u0010*\u001a\u00020?8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010@\u001a\u0004\b\\\u0010B\"\u0004\b]\u0010DR\"\u0010b\u001a\u0002008\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b_\u00101\u001a\u0004\b`\u00103\"\u0004\ba\u00105R.\u0010i\u001a\u0004\u0018\u00010c2\b\u0010*\u001a\u0004\u0018\u00010c8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR(\u0010n\u001a\u0004\u0018\u00010j2\b\u0010*\u001a\u0004\u0018\u00010j8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b$\u0010k\"\u0004\bl\u0010mR\u0016\u0010r\u001a\u00020o8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR*\u0010u\u001a\u00020?2\u0006\u0010*\u001a\u00020?8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010@\u001a\u0004\bs\u0010B\"\u0004\bt\u0010D¨\u0006y"}, d2 = {"Lcom/obric/oui/indicator/OBaseIndicator;", "Landroid/widget/FrameLayout;", "Lkotlin/f0;", "m", "()V", "p", "", "count", "w", "(I)V", "r", "t", "s", "num", "l", "(II)I", "index", "i", BaseSwitches.V, "n", "u", "Lcom/obric/oui/indicator/d;", "k", "()Lcom/obric/oui/indicator/d;", "onAttachedToWindow", "o", "j", "q", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "pageCount", "x", "(Landroidx/viewpager/widget/ViewPager;I)V", "Lkotlin/Function0;", "y", "(Landroidx/viewpager/widget/ViewPager;Lkotlin/n0/c/a;)V", "", "f", "Ljava/lang/String;", "TAG", "value", "I", "getDotsColor", "()I", "setDotsColor", "dotsColor", "", "Z", "getDotsClickable", "()Z", "setDotsClickable", "(Z)V", "dotsClickable", "Ljava/util/ArrayList;", "Lcom/obric/oui/indicator/b;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "dots", "getType", "setType", WsConstants.KEY_CONNECTION_TYPE, "", "F", "getDotsSpacing", "()F", "setDotsSpacing", "(F)V", "dotsSpacing", "pendingRefreshDotsDraws", "getDotsCornerRadius", "setDotsCornerRadius", "dotsCornerRadius", "pendingRefreshDotsSize", "getDotsHeight", "setDotsHeight", "dotsHeight", "getDotsWidth", "setDotsWidth", "dotsWidth", "h", "getPendingRefreshParentLayout", "setPendingRefreshParentLayout", "pendingRefreshParentLayout", "getSidePadding", "setSidePadding", "sidePadding", "pendingRefreshDotsSpacing", "getDotsStrokeColor", "setDotsStrokeColor", "dotsStrokeColor", "getDotsStrokeWidth", "setDotsStrokeWidth", "dotsStrokeWidth", "g", "getInitialized", "setInitialized", "initialized", "Lcom/obric/oui/indicator/OBaseIndicator$b;", "Lcom/obric/oui/indicator/OBaseIndicator$b;", "getPager", "()Lcom/obric/oui/indicator/OBaseIndicator$b;", "setPager", "(Lcom/obric/oui/indicator/OBaseIndicator$b;)V", "pager", "Lcom/obric/oui/indicator/OBaseIndicator$c;", "Lcom/obric/oui/indicator/OBaseIndicator$c;", "setPagerDataSetObserver", "(Lcom/obric/oui/indicator/OBaseIndicator$c;)V", "pagerDataSetObserver", "Lcom/obric/oui/indicator/OBaseIndicator$a;", "getCustom", "()Lcom/obric/oui/indicator/OBaseIndicator$a;", "custom", "getLayoutHeight", "setLayoutHeight", "layoutHeight", "a", "b", "c", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public abstract class OBaseIndicator extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f11081f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11082g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11083h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11084i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11085j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f11086k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected final ArrayList<com.obric.oui.indicator.b> f11087l;
    private float m;
    private float n;
    private float o;
    private int p;
    private float q;
    private int r;

    @ColorInt
    private int s;
    private float t;
    private boolean u;

    @ColorInt
    private int v;
    private float w;
    private b x;
    private c y;

    public static final class a {
    }

    public interface b {
        int a();

        void b();

        void c(com.obric.oui.indicator.d r1);

        boolean d();

        int getCount();
    }

    public interface c {
        l<c, f0> a();
    }

    static final class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f11088f;

        d(OBaseIndicator r1) {
            this.f11088f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f11088f.getPendingRefreshParentLayout() == false) goto L6;
            this.f11088f.u();
        L6:
            if (OBaseIndicator.a(this.f11088f) == false) goto L9;
            this.f11088f.q();
        L9:
            if (OBaseIndicator.c(this.f11088f) == false) goto L12;
            OBaseIndicator.g(this.f11088f);
        L12:
            if (OBaseIndicator.b(this.f11088f) == false) goto L15;
            OBaseIndicator.f(this.f11088f);
            return;
        }
    }

    static final class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f11089f;

        e(OBaseIndicator r1) {
            this.f11089f = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OBaseIndicator.e(this.f11089f);
            this.f11089f.q();
            OBaseIndicator.f(this.f11089f);
            OBaseIndicator.h(this.f11089f);
            b r0 = this.f11089f.getPager();
            if (r0 != null) goto L5;
        L7:
            j.g(this.f11089f);
            return;
        L5:
            if (r0.getCount() != 1) goto L7;
            j.f(this.f11089f);
        }
    }

    static final class f extends q implements kotlin.n0.c.a<Integer> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f11090f;

        f(int r1) {
            this.f11090f = r1;
            super(0);
        }

        public final int a() {
            return this.f11090f;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(a());
        }
    }

    public static final class g extends DataSetObserver implements c {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f11091f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ ViewPager f11092g;

        static final class a extends q implements l<c, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ g f11093f;

            a(g r1) {
                this.f11093f = r1;
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void a(c r2) {
                o.f(r2, "it");
                PagerAdapter r1 = this.f11093f.f11092g.getAdapter();
                o.c(r1);
                r1.unregisterDataSetObserver((DataSetObserver) r2);
            }

            @Override // kotlin.n0.c.l
            public /* bridge */ /* synthetic */ f0 invoke(c r1) {
                a(r1);
                return f0.f18324a;
            }
        }

        g(OBaseIndicator r1, ViewPager r2) {
            this.f11091f = r1;
            this.f11092g = r2;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.c
        public l<c, f0> a() {
            return new a(this);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            this.f11091f.o();
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.OBaseIndicator$setViewPager$3, reason: invalid class name */
    public static final class AnonymousClass3 implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewPager.OnPageChangeListener f11094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ OBaseIndicator f11095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewPager f11096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ kotlin.n0.c.a f11097d;

        AnonymousClass3(OBaseIndicator r1, ViewPager r2, kotlin.n0.c.a r3) {
            this.f11095b = r1;
            this.f11096c = r2;
            this.f11097d = r3;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.b
        public int a() {
            return OBaseIndicator.d(this.f11095b, this.f11096c.getCurrentItem(), getCount());
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.b
        public void b() {
            ViewPager.OnPageChangeListener r0 = this.f11094a;
            if (r0 == null) goto L6;
            this.f11096c.removeOnPageChangeListener(r0);
            return;
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.b
        public void c(final com.obric.oui.indicator.d r2) {
            o.f(r2, "onPageChangeListenerHelper");
            ViewPager.OnPageChangeListener r0 = new OBaseIndicator$setViewPager$3$addOnPageChangeListener$1(this, r2);
            this.f11094a = r0;
            ViewPager r1 = this.f11096c;
            o.c(r0);
            r1.addOnPageChangeListener(r0);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.b
        public boolean d() {
            return com.obric.oui.indicator.a.a(this.f11096c);
        }

        @Override // com.obric.oui.indicator.OBaseIndicator.b
        public int getCount() {
            return ((Number) this.f11097d.invoke()).intValue();
        }
    }

    public static final /* synthetic */ boolean a(OBaseIndicator r0) {
        return r0.f11084i;
    }

    public static final /* synthetic */ boolean b(OBaseIndicator r0) {
        return r0.f11086k;
    }

    public static final /* synthetic */ boolean c(OBaseIndicator r0) {
        return r0.f11085j;
    }

    public static final /* synthetic */ int d(OBaseIndicator r0, int r1, int r2) {
        return r0.l(r1, r2);
    }

    public static final /* synthetic */ void e(OBaseIndicator r0) {
        r0.p();
    }

    public static final /* synthetic */ void f(OBaseIndicator r0) {
        r0.r();
    }

    public static final /* synthetic */ void g(OBaseIndicator r0) {
        r0.s();
    }

    public static final /* synthetic */ void h(OBaseIndicator r0) {
        r0.t();
    }

    private final int l(int r3, int r4) {
        if (r4 != 0) goto L14;
        d.g.d.f.f.b.j(this.f11081f, "mod num is 0");
        return r3;
    L14:
        return r3 % r4;
    L7:
        e = move-exception;
        boolean r0 = e instanceof ArithmeticException;
        String r2 = this.f11081f;
        if (r0 == false) goto L11;
        StringBuilder r1 = new StringBuilder();
        String r5 = "不要乱除0呀 ";
    L12:
        r1.append(r5);
        r1.append(e.getMessage());
        d.g.d.f.f.b.j(r2, r1.toString());
        return r3;
    L11:
        r1 = new StringBuilder();
        r5 = "抓住了一个Exception并ignore, ";
        goto L12
    }

    private final void m() {
        post(new d(this));
    }

    private final void p() {
        if (this.x != null) goto L5;
        return;
    L5:
        int r0 = this.f11087l.size();
        b r1 = this.x;
        o.c(r1);
        if (r0 >= r1.getCount()) goto L8;
        b r2 = this.x;
        o.c(r2);
        j(r2.getCount() - this.f11087l.size());
        return;
    L8:
        int r3 = this.f11087l.size();
        b r4 = this.x;
        o.c(r4);
        if (r3 <= r4.getCount()) goto L13;
        int r5 = this.f11087l.size();
        b r6 = this.x;
        o.c(r6);
        w(r5 - r6.getCount());
        return;
    }

    private final void r() {
        if (this.f11082g == true) goto L6;
        this.f11086k = true;
        return;
    L6:
        int r0 = 0;
        this.f11086k = false;
        b r1 = this.x;
        if (r1 != null) goto L9;
        return;
    L9:
        o.c(r1);
        int r2 = r1.getCount();
    L10:
        if (r0 >= r2) goto L15;
        b r3 = this.x;
        o.c(r3);
        if (r0 == r3.a()) goto L14;
        this.f11087l.get(r0).b((int) this.m);
    L14:
        r0 = r0 + 1;
        goto L10
    }

    private final void s() {
        if (this.f11082g == true) goto L6;
        this.f11085j = true;
        return;
    L6:
        int r0 = 0;
        this.f11085j = false;
        b r1 = this.x;
        if (r1 != null) goto L9;
        return;
    L9:
        o.c(r1);
        int r2 = r1.a();
    L10:
        if (r0 >= r2) goto L12;
        this.f11087l.get(r0).a((int) this.q);
        r0 = r0 + 1;
        goto L10
    }

    private final void setPagerDataSetObserver(c r3) {
        c r0 = this.y;
        if (r0 == null) goto L5;
        o.c(r0);
        l<c, f0> r1 = r0.a();
        c r2 = this.y;
        o.c(r2);
        r1.invoke(r2);
    L5:
        this.y = r3;
    }

    private final void t() {
        b r0 = this.x;
        if (r0 != null) goto L5;
        return;
    L5:
        o.c(r0);
        if (r0.d() == true) goto L8;
        return;
    L8:
        b r1 = this.x;
        o.c(r1);
        r1.b();
        com.obric.oui.indicator.d r2 = k();
        b r3 = this.x;
        o.c(r3);
        r3.c(r2);
        b r4 = this.x;
        o.c(r4);
        r2.a(r4.a(), 0.0f);
        throw null;
    }

    private final void w(int r4) {
        int r0 = this.f11087l.size();
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        v(r1 + r0);
        r1 = r1 + 1;
        goto L3
    }

    public abstract a getCustom();

    public final boolean getDotsClickable() {
        return this.u;
    }

    public final int getDotsColor() {
        return this.s;
    }

    public final float getDotsCornerRadius() {
        return this.t;
    }

    public final float getDotsHeight() {
        return this.n;
    }

    public final float getDotsSpacing() {
        return this.q;
    }

    public final int getDotsStrokeColor() {
        return this.v;
    }

    public final float getDotsStrokeWidth() {
        return this.w;
    }

    public final float getDotsWidth() {
        return this.m;
    }

    protected final boolean getInitialized() {
        return this.f11082g;
    }

    public final float getLayoutHeight() {
        return this.o;
    }

    public final b getPager() {
        return this.x;
    }

    protected final boolean getPendingRefreshParentLayout() {
        return this.f11083h;
    }

    public final int getSidePadding() {
        return this.p;
    }

    public final int getType() {
        return this.r;
    }

    public abstract void i(int r1);

    protected final void j(int r4) {
        int r0 = this.f11087l.size();
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L5;
        i(r1 + r0);
        r1 = r1 + 1;
        goto L3
    }

    public abstract com.obric.oui.indicator.d k();

    public abstract void n(int r1);

    public final void o() {
        if (this.x != null) goto L5;
        return;
    L5:
        post(new e(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        o();
        m();
    }

    protected final void q() {
        if (this.f11082g == true) goto L6;
        this.f11084i = true;
        return;
    L6:
        int r0 = 0;
        this.f11084i = false;
        int r1 = this.f11087l.size();
    L7:
        if (r0 >= r1) goto L9;
        n(r0);
        r0 = r0 + 1;
        goto L7
    }

    public final void setDotsClickable(boolean r1) {
        this.u = r1;
    }

    public final void setDotsColor(int r3) {
        if (this.r != 1) goto L5;
        r3 = 872415231;
    L8:
        this.s = r3;
        q();
        return;
    L5:
        if (this.s != r3) goto L8;
    }

    public final void setDotsCornerRadius(float r2) {
        if (this.t == r2) goto L6;
        this.t = r2;
        q();
        return;
    }

    public final void setDotsHeight(float r2) {
        if (this.n == r2) goto L6;
        this.n = r2;
        r();
        return;
    }

    public final void setDotsSpacing(float r2) {
        if (this.q == r2) goto L6;
        this.q = r2;
        s();
        return;
    }

    public final void setDotsStrokeColor(int r2) {
        if (this.v == r2) goto L6;
        this.v = r2;
        q();
        return;
    }

    public final void setDotsStrokeWidth(float r2) {
        if (this.w == r2) goto L6;
        this.w = r2;
        q();
        return;
    }

    public final void setDotsWidth(float r2) {
        if (this.m == r2) goto L6;
        this.m = r2;
        r();
        return;
    }

    protected final void setInitialized(boolean r1) {
        this.f11082g = r1;
    }

    public final void setLayoutHeight(float r2) {
        if (this.o == r2) goto L6;
        this.o = r2;
        u();
        return;
    }

    public final void setPager(b r2) {
        b r0 = this.x;
        if (r0 == null) goto L5;
        o.c(r0);
        r0.b();
    L5:
        this.x = r2;
    }

    protected final void setPendingRefreshParentLayout(boolean r1) {
        this.f11083h = r1;
    }

    public final void setSidePadding(int r2) {
        if (this.p == r2) goto L6;
        this.p = r2;
        u();
        return;
    }

    public final void setType(int r2) {
        if (this.r == r2) goto L6;
        this.r = r2;
        u();
        q();
        return;
    }

    public final void setViewPager(ViewPager r2) {
        o.f(r2, "viewPager");
        PagerAdapter r0 = r2.getAdapter();
        if (r0 == null) goto L5;
        int r1 = r0.getCount();
    L6:
        x(r2, r1);
        return;
    L5:
        r1 = 1;
        goto L6
    }

    public abstract void u();

    public abstract void v(int r1);

    public final void x(ViewPager r2, int r3) {
        o.f(r2, "viewPager");
        y(r2, new f(r3));
    }

    public final void y(ViewPager r4, kotlin.n0.c.a<Integer> r5) {
        o.f(r4, "viewPager");
        o.f(r5, "pageCount");
        if (r4.getAdapter() == null) goto L7;
        setPagerDataSetObserver(new g(this, r4));
        PagerAdapter r0 = r4.getAdapter();
        o.c(r0);
        Object r1 = this.y;
        Objects.requireNonNull(r1, "null cannot be cast to non-null type android.database.DataSetObserver");
        r0.registerDataSetObserver((DataSetObserver) r1);
        setPager(new AnonymousClass3(this, r4, r5));
        o();
        return;
    L7:
        throw new IllegalStateException("Set an adapter to the view pager before initializing the dots indicator ~");
    }
}
