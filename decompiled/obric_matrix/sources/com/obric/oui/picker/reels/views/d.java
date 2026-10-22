package com.obric.oui.picker.reels.views;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import androidx.core.app.NotificationCompat;
import com.obric.common.oui.h;
import d.g.d.b.b.l;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends OverScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f11282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VelocityTracker f11284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f11286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final WheelView f11288h;

    static {
    }

    public d(Context r2, WheelView r3) {
        o.f(r3, "mWheelView");
        super(r2, new LinearInterpolator());
        this.f11288h = r3;
        c.f11280e.d();
        this.f11287g = -1;
    }

    private final void b(int r4, String r5) {
        this.f11281a += r4;
        if (this.f11288h.h() == true) goto L10;
        int r6 = (this.f11288h.getItemSize() - 1) * this.f11288h.getItemHeightPx();
        int r0 = this.f11288h.getItemHeightPx() * 0;
        int r1 = this.f11281a;
        int r2 = -r0;
        if (r1 >= r2) goto L7;
        this.f11281a = r2;
        goto L10
    L7:
        int r7 = r6 + r0;
        if (r1 <= r7) goto L10;
        this.f11281a = r7;
    L10:
        i(r5);
    }

    private final void g(int r12) {
        int r0 = this.f11288h.getItemHeightPx();
        int r1 = this.f11281a % r0;
        if (r1 != 0) goto L8;
        a r2 = this.f11286f;
        if (r2 == null) goto L8;
        r2.a(this.f11287g);
    L8:
        if (r1 <= 0) goto L13;
        if (r1 >= (r0 / 2)) goto L13;
    L11:
        this.f11283c = true;
        int r5 = 0;
        int r6 = this.f11281a;
        int r7 = 0;
        int r8 = -r1;
    L15:
        p(r5, r6, r7, r8, r12, "justify");
        this.f11288h.invalidate();
        return;
    L13:
        if (r1 < (r0 / 2)) goto L16;
    L14:
        this.f11283c = true;
        r5 = 0;
        r6 = this.f11281a;
        r7 = 0;
        r8 = r0 - r1;
        goto L15
    L16:
        if (r1 < 0) goto L18;
    L20:
        r0 = -r0;
        if (r1 <= (r0 / 2)) goto L14;
        return;
    L18:
        if (r1 <= ((-r0) / 2)) goto L20;
        goto L20
    }

    static /* synthetic */ void h(d r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 200;
    L5:
        r0.g(r1);
    }

    private final void i(String r4) {
        int r0 = this.f11287g;
        int r1 = c();
        if (r0 == r1) goto L8;
        this.f11287g = r1;
        l(this.f11288h.getContext(), r4);
        a r3 = this.f11286f;
        if (r3 == null) goto L9;
        r3.b(r0, r1);
        return;
    L9:
        return;
    }

    private final void l(Context r3, String r4) {
        d.g.d.f.f.b.a("WheelScroller", "performVibrateEffect, scene: [" + r4 + ']');
        int r0 = r4.hashCode();
        if (r0 == (-1621011813)) goto L11;
        if (r0 == 530781668) goto L8;
        return;
    L8:
        if (r4.equals("computeScroll") == false) goto L16;
    L12:
        d.g.d.d.a.f16932c.a(this.f11288h, 26);
        if (Build.VERSION.SDK_INT < 24) goto L18;
        l.f16798e.f(r3, h.f8263a);
        return;
    L18:
        return;
    L16:
        return;
    L11:
        if (r4.equals("touchEvent") == true) goto L12;
    }

    private final void p(int r3, int r4, int r5, int r6, int r7, String r8) {
        d.g.d.f.f.b.a("WheelScroller", "startScrollInternal, startX: " + r3 + ", startY: " + r4 + ", dx: " + r5 + ", dy: " + r6 + ", duration: " + r7 + ", scene: " + r8);
        startScroll(r3, r4, r5, r6, r7);
    }

    public final void a() {
        if (this.f11283c == false) goto L9;
        this.f11283c = computeScrollOffset();
        b(getCurrY() - this.f11281a, "computeScroll");
        if (this.f11283c == false) goto L7;
        this.f11288h.postInvalidate();
        return;
    L7:
        h(this, 0, 1, null);
        return;
    }

    public final int c() {
        int r0 = this.f11288h.getItemHeightPx();
        int r1 = this.f11288h.getItemSize();
        if (r1 != 0) goto L6;
        return -1;
    L6:
        int r2 = this.f11281a;
        int r3 = r0 / 2;
        if (r2 >= 0) goto L9;
        int r4 = r2 - r3;
    L10:
        int r5 = r4 / r0;
        int r6 = r5 % r1;
        if (this.f11288h.h() == true) goto L14;
        if (r5 < r1) goto L14;
        r6 = r1 - 1;
    L14:
        if (r6 < 0) goto L16;
        return r6;
    L16:
        return r6 + r1;
    L9:
        r4 = r2 + r3;
        goto L10
    }

    public final int d() {
        if (this.f11288h.getItemHeightPx() != 0) goto L6;
        return 0;
    L6:
        return this.f11281a / this.f11288h.getItemHeightPx();
    }

    public final int e() {
        if (this.f11288h.getItemHeightPx() != 0) goto L6;
        return 0;
    L6:
        return this.f11281a % this.f11288h.getItemHeightPx();
    }

    public final a f() {
        return this.f11286f;
    }

    public final boolean j(MotionEvent r13) {
        o.f(r13, NotificationCompat.CATEGORY_EVENT);
        if (this.f11284d != null) goto L5;
        this.f11284d = VelocityTracker.obtain();
    L5:
        VelocityTracker r1 = this.f11284d;
        if (r1 == null) goto L8;
        r1.addMovement(r13);
    L8:
        int r2 = r13.getAction();
        if (r2 != 0) goto L11;
        ViewParent r3 = this.f11288h.getParent();
        if (r3 == null) goto L59;
        r3.requestDisallowInterceptTouchEvent(true);
    L59:
        this.f11282b = r13.getY();
        forceFinished(true);
        this.f11285e = false;
        this.f11283c = false;
    L60:
        return true;
    L11:
        if (r2 == 1) goto L29;
        if (r2 != 2) goto L14;
        float r0 = r13.getY();
        int r4 = (int) (r0 - this.f11282b);
        if (r4 == 0) goto L28;
        this.f11285e = true;
        b(-r4, "touchEvent");
        this.f11288h.invalidate();
    L28:
        this.f11282b = r0;
        goto L60
    L14:
        if (r2 != 3) goto L60;
        if (this.f11285e == false) goto L19;
        h(this, 0, 1, null);
    L19:
        VelocityTracker r5 = this.f11284d;
        if (r5 == null) goto L22;
        r5.recycle();
    L22:
        this.f11284d = null;
        this.f11285e = false;
        ViewParent r6 = this.f11288h.getParent();
        if (r6 == null) goto L60;
    L24:
        r6.requestDisallowInterceptTouchEvent(false);
        goto L60
    L29:
        VelocityTracker r7 = this.f11284d;
        if (r7 == null) goto L32;
        r7.computeCurrentVelocity(1000);
    L32:
        VelocityTracker r8 = this.f11284d;
        if (r8 == null) goto L35;
        float r9 = r8.getYVelocity();
    L37:
        if (Math.abs(r9) <= 0) goto L44;
        int r10 = (this.f11288h.getItemSize() - 1) * this.f11288h.getItemHeightPx();
        int r11 = this.f11288h.getItemHeightPx() * 0;
        this.f11283c = true;
        if (this.f11288h.h() == false) goto L41;
        c r12 = c.f11280e;
        int r14 = this.f11288h.getItemHeightPx();
        int r15 = this.f11281a;
        int r16 = ((int) (-r9)) / 2;
        int r17 = Integer.MIN_VALUE;
        r10 = Integer.MAX_VALUE;
        r11 = 0;
    L42:
        r12.f(this, r14, r15, r16, r17, r10, r11);
    L48:
        this.f11288h.invalidate();
    L50:
        VelocityTracker r18 = this.f11284d;
        if (r18 == null) goto L53;
        r18.recycle();
    L53:
        this.f11284d = null;
        r6 = this.f11288h.getParent();
        if (r6 == null) goto L60;
    L41:
        r12 = c.f11280e;
        r14 = this.f11288h.getItemHeightPx();
        r15 = this.f11281a;
        r16 = ((int) (-r9)) / 2;
        r17 = 0;
        goto L42
    L44:
        if (this.f11285e == true) goto L49;
        float r19 = r13.getY() - (this.f11288h.getHeight() / 2.0f);
        if (Math.abs(r19) <= 1) goto L50;
        this.f11283c = true;
        p(0, this.f11281a, 0, (int) r19, 200, "ACTION_UP");
        goto L48
    L49:
        h(this, 0, 1, null);
        goto L50
    L35:
        r9 = 0.0f;
        goto L37
    }

    public final void k(Context r4) {
        o.f(r4, "context");
        if (Build.VERSION.SDK_INT < 24) goto L6;
        l.f16798e.e(r4, new int[]{h.f8263a});
        return;
    }

    public final void m() {
        this.f11283c = false;
        this.f11281a = 0;
        this.f11287g = -1;
        i("reset");
        forceFinished(true);
    }

    public final void n(int r8, boolean r9) {
        int r10 = r8 * this.f11288h.getItemHeightPx();
        int r2 = this.f11281a;
        int r4 = r10 - r2;
        if (r4 != 0) goto L5;
        return;
    L5:
        if (r9 == false) goto L7;
        this.f11283c = true;
        p(0, r2, 0, r4, 200, "setCurrentIndex");
    L8:
        this.f11288h.invalidate();
        return;
    L7:
        b(r4, "setCurrentIndex");
        goto L8
    }

    public final void o(a r1) {
        this.f11286f = r1;
    }
}
