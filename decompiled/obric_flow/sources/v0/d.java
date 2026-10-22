package v0;

import android.app.Activity;
import android.app.Application;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.os.HandlerCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.model.p;
import com.obric.launcher.widget.R$layout;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import s8.h;
import w0.l;

/* JADX INFO: loaded from: classes.dex */
public final class d extends com.bytedance.android.anniex.base.service.e implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f22502n = null;
    public a f;
    public FrameLayout g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f22503h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakReference f22504i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WeakReference f22505j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.ai.model.widgets.a f22506k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f22507l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f22508m;

    static {
        f22502n = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new s1.b(2));
    }

    public d() {
        this.f22503h = true;
        this.f22507l = LazyKt.lazy(new s1.b(3));
        u0.a r5 = s0.a.f21800c;
        Application r10 = null;
        if (r5 == null) goto L5;
        Application r11 = r5.f22194a;
    L6:
        if (r11 == null) goto L8;
        r10 = r11;
    L8:
        if (r10 == null) goto L10;
        r10.registerActivityLifecycleCallbacks(this);
    L10:
        this.f22508m = R$layout.layout_floating_view;
        return;
    L5:
        r11 = null;
        goto L6
    }

    public static FrameLayout t(Activity r5) {
        if (r5 != null) goto L44;
        return null;
    L44:
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L8
        if ((r5 instanceof FragmentActivity) == false) goto L10;
        FragmentActivity r11 = (FragmentActivity) r5;     // Catch: Throwable -> L8
    L11:
        if (r11 == null) goto L19;
        FragmentManager r12 = r11.getSupportFragmentManager();     // Catch: Throwable -> L8
        if (r12 == null) goto L19;
        List<Fragment> r13 = r12.getFragments();     // Catch: Throwable -> L8
        if (r13 == null) goto L19;
        Fragment r14 = (Fragment) CollectionsKt.lastOrNull(r13);     // Catch: Throwable -> L8
        if (r14 == null) goto L19;
        View r15 = r14.getView();     // Catch: Throwable -> L8
    L21:
        if ((r15 instanceof FrameLayout) == false) goto L23;
        FrameLayout r16 = (FrameLayout) r15;     // Catch: Throwable -> L8
    L24:
        Object r17 = Result.m124constructorimpl(r16);     // Catch: Throwable -> L8
    L28:
        if (Result.m130isFailureimpl(r17) == false) goto L30;
        r17 = null;
    L30:
        FrameLayout r18 = (FrameLayout) r17;
        if (r18 == null) goto L42;
        return r18;
    L42:
        View r19 = r5.getWindow().getDecorView();     // Catch: ClassCastException -> L35
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.widget.FrameLayout");     // Catch: ClassCastException -> L35
        return (FrameLayout) r19;
    L35:
        e = move-exception;
        String r20 = e.getMessage();
        if (r20 == null) goto L41;
        Intrinsics.checkNotNullParameter("WebViewFloatingPage", "tag");
        t0.d r21 = com.bytedance.ai.utils.c.f2846a;
        if (r21 == null) goto L41;
        r21.e("WebViewFloatingPage", r20);
    L41:
        return null;
    L23:
        r16 = null;
    L19:
        r15 = null;
        goto L21
    L10:
        r11 = null;
    L8:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r17 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L28
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int n(l r10, PageInfo r11, FragmentActivity r12) {
        Intrinsics.checkNotNullParameter(r10, "page");
        Intrinsics.checkNotNullParameter(r11, "pageInfo");
        double r5 = r11.getPos();
        boolean r13 = r11.getAlignLeft();
        Intrinsics.checkNotNullParameter(r10, "webViewFloatingPage");
        monitor-enter(this);
        u0.a r14 = s0.a.f21800c;     // Catch: Throwable -> L7
        if (r14 == null) goto L9;
        Application r15 = r14.f22194a;     // Catch: Throwable -> L7
    L11:
        if (this.f != null) goto L42;
        if (r15 == null) goto L42;
        a r16 = new a(r15, this.f22508m);     // Catch: Throwable -> L7
        this.f = r16;     // Catch: Throwable -> L7
        r16.setFirstPos(r5);     // Catch: Throwable -> L7
        FrameLayout.LayoutParams r17 = new FrameLayout.LayoutParams(-2, -2);     // Catch: Throwable -> L7
        if (r13 == false) goto L17;
        int r18 = GravityCompat.START;
    L18:
        r17.gravity = r18 | 48;     // Catch: Throwable -> L7
        r17.setMargins(0, r17.topMargin, 0, r17.bottomMargin);     // Catch: Throwable -> L7
        r16.setLayoutParams(r17);     // Catch: Throwable -> L7
        FrameLayout r19 = new FrameLayout(r15);     // Catch: Throwable -> L7
        this.g = r19;     // Catch: Throwable -> L7
        r19.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));     // Catch: Throwable -> L7
        FrameLayout r20 = this.g;     // Catch: Throwable -> L7
        if (r20 == null) goto L21;
        r20.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);     // Catch: Throwable -> L7
    L21:
        FrameLayout r21 = this.g;     // Catch: Throwable -> L7
        if (r21 == null) goto L26;
        Drawable r22 = r21.getBackground();     // Catch: Throwable -> L7
        if (r22 == null) goto L26;
        r22.setAlpha(40);     // Catch: Throwable -> L7
    L26:
        FrameLayout r23 = this.g;     // Catch: Throwable -> L7
        if (r23 == null) goto L29;
        r23.setVisibility(4);     // Catch: Throwable -> L7
    L29:
        FrameLayout r24 = this.g;     // Catch: Throwable -> L7
        if (r24 == null) goto L32;
        r24.setClickable(true);     // Catch: Throwable -> L7
    L32:
        FrameLayout r25 = this.g;     // Catch: Throwable -> L7
        if (r25 == null) goto L35;
        r25.setOnClickListener(new ar.a(this, 23));     // Catch: Throwable -> L7
    L35:
        monitor-exit(this);
        View r26 = r10.a();
        if (r26 == null) goto L41;
        r26.setVisibility(0);
        a r27 = this.f;
        if (r27 == null) goto L41;
        r27.f22486q.addView(r26);
    L41:
        this.f22506k = (com.bytedance.ai.model.widgets.a) r10;
        boolean r28 = true;
    L50:
        boolean r29 = p(r12);
        r10.c();
        if (r28 == false) goto L54;
        if (r29 == false) goto L54;
        return 1;
    L54:
        return 0;
    L17:
        r18 = GravityCompat.END;
    L42:
        IllegalStateException r30 = new IllegalStateException("ensureFloatingView: mFloatingView=" + this.f + ", context=" + r15);     // Catch: Throwable -> L7
        String r31 = r30.getMessage();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullParameter("WebViewFloatingPage", "tag");     // Catch: Throwable -> L7
        t0.d r32 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L7
        if (r32 == null) goto L45;
        r32.e("WebViewFloatingPage", r31, r30);     // Catch: Throwable -> L7
    L45:
        monitor-exit(this);
        Intrinsics.checkNotNullParameter("WebViewFloatingPage", "tag");
        t0.d r33 = com.bytedance.ai.utils.c.f2846a;
        if (r33 == null) goto L49;
        r33.e("WebViewFloatingPage", "floating view already exist");
    L49:
        r28 = false;
        goto L50
    L9:
        r15 = null;
    L7:
        th = move-exception;
        throw th;
    }

    public final void o(Activity r5, boolean r10) {
        FrameLayout r11 = t(r5);
        a r12 = this.f;     // Catch: IllegalArgumentException -> L12
        if (r12 != null) goto L6;
    L14:
        FrameLayout r13 = this.g;     // Catch: IllegalArgumentException -> L12
        if (r13 != null) goto L17;
    L23:
        WeakReference r14 = this.f22504i;     // Catch: IllegalArgumentException -> L12
        if (r14 == null) goto L26;
        FrameLayout r15 = (FrameLayout) r14.get();     // Catch: IllegalArgumentException -> L12
    L27:
        if (r15 != r11) goto L29;
        this.f22504i = null;     // Catch: IllegalArgumentException -> L12
    L29:
        if (r10 == false) goto L40;
        this.f = null;     // Catch: IllegalArgumentException -> L12
        this.g = null;     // Catch: IllegalArgumentException -> L12
        return;
    L40:
        return;
    L26:
        r15 = null;
        goto L27
    L17:
        if (ViewCompat.isAttachedToWindow(r13) == true) goto L20;
        r13 = null;
    L20:
        if (r13 == null) goto L23;
        if (r11 == null) goto L23;
        r11.removeView(r13);     // Catch: IllegalArgumentException -> L12
        goto L23
    L6:
        if (ViewCompat.isAttachedToWindow(r12) == true) goto L9;
        r12 = null;
    L9:
        if (r12 == null) goto L14;
        if (r11 == null) goto L14;
        r11.removeView(r12);     // Catch: IllegalArgumentException -> L12
    L12:
        e = move-exception;
        String r16 = e.getMessage();
        if (r16 == null) goto L41;
        Intrinsics.checkNotNullParameter("WebViewFloatingPage", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L42;
        r17.e("WebViewFloatingPage", r16);
        return;
    L42:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        ((Handler) this.f22507l.getValue()).removeCallbacksAndMessages(r5);
        o(r5, false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        HandlerCompat.postDelayed((Handler) this.f22507l.getValue(), new h(2, this, false, r5), r5, 100);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity r5, Bundle r10) {
        Intrinsics.checkNotNullParameter(r5, "p0");
        Intrinsics.checkNotNullParameter(r10, "p1");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "p0");
    }

    public final boolean p(Activity r10) {
        if (this.f22505j != null) goto L12;
        if (r10 == null) goto L12;
        Intrinsics.checkNotNullParameter(r10, "activity");
        this.f22505j = new WeakReference(r10);
        t0.b r5 = p.f2294c;
        if (r5 == null) goto L12;
        Pair r11 = r5.getFloatViewRestriction(r10);
        if (r11 == null) goto L12;
        a r12 = this.f;
        if (r12 == null) goto L12;
        r12.c(r11);
    L12:
        FrameLayout r13 = t(r10);
        a r14 = this.f;
        if (r14 != null) goto L17;
        if (r13 == null) goto L17;
        this.f22504i = new WeakReference(r13);
        return false;
    L17:
        ViewParent r15 = null;
        if (r14 == null) goto L20;
        ViewParent r16 = r14.getParent();
    L21:
        if (r16 != r13) goto L24;
        return false;
    L24:
        if (r13 != null) goto L29;
        Intrinsics.checkNotNullParameter("WebViewFloatingPage", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L28;
        r17.e("WebViewFloatingPage", "FloatingViewManager attach FloatingView fail, container is null");
    L28:
        return false;
    L29:
        a r18 = this.f;
        if (r18 == null) goto L32;
        ViewParent r19 = r18.getParent();
    L33:
        ViewGroup r20 = (ViewGroup) r19;
        if (r20 == null) goto L36;
        r20.removeView(this.f);
    L36:
        FrameLayout r21 = this.g;
        if (r21 == null) goto L39;
        r15 = r21.getParent();
    L39:
        ViewGroup r22 = (ViewGroup) r15;
        if (r22 == null) goto L42;
        r22.removeView(this.g);
    L42:
        this.f22504i = new WeakReference(r13);
        FrameLayout r23 = this.g;     // Catch: IllegalArgumentException -> L46 IllegalStateException -> L48
        if (r23 == null) goto L50;
        r13.addView(r23);     // Catch: IllegalArgumentException -> L46 IllegalStateException -> L48
    L50:
        a r24 = this.f;     // Catch: IllegalArgumentException -> L46 IllegalStateException -> L48
        if (r24 != null) goto L53;
    L55:
        Intrinsics.checkNotNullParameter("WebViewFloatingPage", "tag");     // Catch: IllegalArgumentException -> L46 IllegalStateException -> L48
        t0.d r25 = com.bytedance.ai.utils.c.f2846a;     // Catch: IllegalArgumentException -> L46 IllegalStateException -> L48
        if (r25 == null) goto L69;
        r25.d("WebViewFloatingPage", "FloatingViewManager attach FloatingView success");     // Catch: IllegalArgumentException -> L46 IllegalStateException -> L48
        return true;
    L69:
        return true;
    L53:
        if (this.f22503h == false) goto L55;
        r24.b();     // Catch: IllegalArgumentException -> L46 IllegalStateException -> L48
        r13.addView(r24);     // Catch: IllegalArgumentException -> L46 IllegalStateException -> L48
        r24.setVisibility(0);     // Catch: IllegalArgumentException -> L46 IllegalStateException -> L48
    L46:
        e = move-exception;
        String r26 = "FloatingViewManager attach FloatingView fail, msg=" + e.getMessage();
        Intrinsics.checkNotNullParameter("WebViewFloatingPage", "tag");
        t0.d r27 = com.bytedance.ai.utils.c.f2846a;
        if (r27 == null) goto L66;
        r27.e("WebViewFloatingPage", r26, e);
    L66:
        return false;
    L48:
        e = move-exception;
        String r28 = "FloatingViewManager attach FloatingView fail, msg=" + e.getMessage();
        Intrinsics.checkNotNullParameter("WebViewFloatingPage", "tag");
        t0.d r29 = com.bytedance.ai.utils.c.f2846a;
        if (r29 == null) goto L66;
        r29.e("WebViewFloatingPage", r28, e);
        goto L66
    L32:
        r19 = null;
        goto L33
    L20:
        r16 = null;
        goto L21
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [com.bytedance.ai.model.widgets.a, w0.l] */
    public final boolean q(String r5) {
        Intrinsics.checkNotNullParameter(r5, "viewId");
        com.bytedance.ai.model.widgets.a r10 = this.f22506k;
        if (r10 == null) goto L5;
        String r11 = r10.f2331c;
    L7:
        if (Intrinsics.areEqual(r5, r11) == true) goto L10;
        return false;
    L10:
        WeakReference r12 = this.f22505j;
        if (r12 == null) goto L15;
        Activity r13 = (Activity) r12.get();
        if (r13 == null) goto L15;
        o(r13, true);
    L15:
        ?? r14 = this.f22506k;
        if (r14 == 0) goto L18;
        r14.f();
    L18:
        this.f22506k = null;
        return true;
    L5:
        r11 = null;
        goto L7
    }

    public final boolean r(String r5, boolean r10) {
        Intrinsics.checkNotNullParameter(r5, "viewId");
        com.bytedance.ai.model.widgets.a r11 = this.f22506k;
        if (r11 == null) goto L5;
        String r12 = r11.f2331c;
    L7:
        if (Intrinsics.areEqual(r5, r12) == true) goto L9;
        return false;
    L9:
        FrameLayout r13 = this.g;
        if (r13 == null) goto L16;
        if (r10 == false) goto L13;
        r13.setVisibility(0);
        return true;
    L13:
        r13.setVisibility(8);
        return true;
    L16:
        return true;
    L5:
        r12 = null;
        goto L7
    }

    public final boolean s() {
        if (this.f22506k == null) goto L6;
        return true;
    L6:
        return false;
    }

    /* JADX WARN: Type inference failed for: r8v3, types: [com.bytedance.ai.model.widgets.a, w0.l] */
    /* JADX WARN: Type inference failed for: r8v4, types: [com.bytedance.ai.model.widgets.a, w0.l] */
    public final boolean u(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "viewId");
        com.bytedance.ai.model.widgets.a r5 = this.f22506k;
        Unit r12 = null;
        if (r5 == null) goto L5;
        String r13 = r5.f2331c;
    L7:
        if (Intrinsics.areEqual(r10, r13) == true) goto L9;
        return false;
    L9:
        WeakReference r14 = this.f22504i;
        if (r14 == null) goto L42;
        FrameLayout r15 = (FrameLayout) r14.get();
        if (r15 == null) goto L42;
        a r16 = this.f;
        if (r16 == null) goto L38;
        String r17 = "setFloatingWidgetVisible viewId=" + r10 + ", show=" + r11;
        Intrinsics.checkNotNullParameter("WebViewFloatingPage", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L19;
        r18.d("WebViewFloatingPage", r17);
    L19:
        if (r11 == true) goto L21;
        r15.removeView(r16);
        this.f22503h = false;
        ?? r19 = this.f22506k;
        if (r19 == 0) goto L35;
        r19.e();
        r12 = Unit.INSTANCE;
    L35:
        if (r12 == null) goto L38;
        return true;
    L21:
        if (r15.indexOfChild(r16) == (-1)) goto L26;
        String r20 = "floating view already show, visible=" + r16.getVisibility() + ", top=" + r16.getTop() + ", left=" + r16.getLeft() + ", right=" + r16.getRight() + ", bottom=" + r16.getBottom();
        Intrinsics.checkNotNullParameter("WebViewFloatingPage", "tag");
        t0.d r110 = com.bytedance.ai.utils.c.f2846a;
        if (r110 == null) goto L25;
        r110.d("WebViewFloatingPage", r20);
    L25:
        return true;
    L26:
        ViewGroup r111 = (ViewGroup) r16.getParent();
        if (r111 == null) goto L29;
        r111.removeView(r16);
    L29:
        r16.b();
        r15.addView(r16);
        this.f22503h = true;
        ?? r21 = this.f22506k;
        if (r21 == 0) goto L35;
        r21.c();
        r12 = Unit.INSTANCE;
    L38:
        IllegalStateException r22 = new IllegalStateException("FloatingView is null");
        String r23 = r22.getMessage();
        Intrinsics.checkNotNullParameter("WebViewFloatingPage", "tag");
        t0.d r112 = com.bytedance.ai.utils.c.f2846a;
        if (r112 == null) goto L41;
        r112.e("WebViewFloatingPage", r23, r22);
    L41:
        return false;
    L42:
        IllegalStateException r24 = new IllegalStateException("Container is null");
        String r25 = r24.getMessage();
        Intrinsics.checkNotNullParameter("WebViewFloatingPage", "tag");
        t0.d r113 = com.bytedance.ai.utils.c.f2846a;
        if (r113 == null) goto L45;
        r113.e("WebViewFloatingPage", r25, r24);
    L45:
        return false;
    L5:
        r13 = null;
        goto L7
    }
}
