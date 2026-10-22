package v0;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.Window;
import android.widget.FrameLayout;
import com.bytedance.ai.model.p;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;
import s8.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends FrameLayout {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f22490p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f22491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f22492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f22493c;
    public float d;
    public final b e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f22495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f22496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f22497k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f22498l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f22499m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public double f22500n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f22501o;

    public c(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 0);
        this.g = com.bytedance.ai.utils.c.k(null);
        this.f22494h = UIUtils.getStatusBarHeight(r5);
        this.f22495i = true;
        this.f22496j = new h(this);
        this.f22497k = ViewConfiguration.get(r5).getScaledTouchSlop();
        this.f22498l = true;
        this.f22500n = 0.5d;
        this.e = new b(this);
        setClickable(true);
        setLongClickable(true);
        c(null);
    }

    public static /* synthetic */ void a(c r5) {
        setRealWidth$lambda$0(r5);
    }

    public static void d(c r5, boolean r10, int r11) {
        boolean r12 = true;
        int r13 = 0;
        if ((r11 & 1) == 0) goto L10;
        if (r5.getX() >= (r5.f / 2)) goto L7;
        r10 = true;
    L8:
        r5.f22495i = r10;
        goto L10
    L7:
        r10 = false;
    L10:
        if ((r11 & 2) == 0) goto L12;
        r12 = false;
    L12:
        if (r10 == true) goto L15;
        r13 = r5.f;
    L15:
        float r14 = r13;
        b r15 = r5.e;
        if (r15 == null) goto L19;
        float r16 = r5.getY();
        r15.f22488b = r14;
        r15.f22489c = r16;
        r15.d = System.currentTimeMillis();
        r15.e = r12;
        r15.f22487a.post(r15);
        return;
    }

    private static final void setRealWidth$lambda$0(c r5) {
        r5.requestLayout();
    }

    public final void b() {
        float r5 = getY() + getHeight();
        int r10 = this.g;
        if (r5 > r10) goto L5;
        return;
    L5:
        if (r10 <= getHeight()) goto L9;
        setY(this.g - getHeight());
        return;
    }

    public final void c(Pair r5) {
        t0.b r10 = p.f2294c;
        if (r10 == null) goto L7;
        Activity r11 = r10.currentActivity();
        if (r11 == null) goto L7;
        Window r12 = r11.getWindow();
    L8:
        if (r12 == null) goto L10;
        int r13 = com.bytedance.ai.utils.c.f(r12).widthPixels;
    L11:
        this.f = r13 - getWidth();
        if (r5 != null) goto L15;
        return;
    L15:
        if (((Number) r5.first).intValue() <= 0) goto L18;
        this.f22494h = ((Number) r5.first).intValue();
    L18:
        if (((Number) r5.second).intValue() <= 0) goto L21;
        this.g = ((Number) r5.second).intValue();
        return;
    L21:
        return;
    L10:
        r13 = Resources.getSystem().getDisplayMetrics().widthPixels;
    L7:
        r12 = null;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        int r5 = r10.getAction();
        h r11 = this.f22496j;
        if (r5 != 0) goto L8;
        this.f22493c = getX();
        this.d = getY();
        this.f22491a = r10.getRawX();
        this.f22492b = r10.getRawY();
        System.currentTimeMillis();
        ((Handler) r11.f21853b).postDelayed(r11, ViewConfiguration.getLongPressTimeout());
        c(null);
        b r12 = this.e;
        if (r12 == null) goto L31;
        r12.f22487a.removeCallbacks(r12);
    L31:
        return super.dispatchTouchEvent(r10);
    L8:
        if (r5 != 1) goto L10;
        ((Handler) r11.f21853b).removeCallbacks(r11);
        if (this.f22498l == false) goto L26;
        d(this, false, 3);
    L26:
        System.currentTimeMillis();
        goto L31
    L10:
        if (r5 != 2) goto L31;
        setX((r10.getRawX() + this.f22493c) - this.f22491a);
        float r13 = (r10.getRawY() + this.d) - this.f22492b;
        float r14 = this.f22494h;
        if (r13 >= r14) goto L16;
        r13 = r14;
    L16:
        if (r13 <= (this.g - getHeight())) goto L18;
        r13 = this.g - getHeight();
    L18:
        setY(r13);
        float r15 = Math.abs(r10.getRawX() - this.f22491a);
        int r16 = this.f22497k;
        if (r15 <= r16) goto L21;
    L22:
        ((Handler) r11.f21853b).removeCallbacks(r11);
        goto L31
    L21:
        if (Math.abs(r10.getRawY() - this.f22492b) <= r16) goto L31;
        goto L22
    }

    public final boolean getAutoToEdge() {
        return this.f22498l;
    }

    public final double getFirstPos() {
        return this.f22500n;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        super.onConfigurationChanged(r5);
        c(null);
        d(this, this.f22495i, 2);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        if (getX() >= (this.f / 2)) goto L5;
        boolean r14 = true;
    L6:
        this.f22495i = r14;
        if (r14 == false) goto L10;
        setX(0.0f);
        return;
    L10:
        t0.b r15 = p.f2294c;
        if (r15 == null) goto L15;
        Activity r16 = r15.currentActivity();
        if (r16 == null) goto L15;
        Window r17 = r16.getWindow();
    L16:
        if (r17 == null) goto L18;
        int r18 = com.bytedance.ai.utils.c.f(r17).widthPixels;
    L19:
        setX((r18 - this.f22501o) - 0.0f);
        if (getX() >= 0.0f) goto L23;
        setX(0.0f);
        return;
    L23:
        return;
    L18:
        r18 = Resources.getSystem().getDisplayMetrics().widthPixels;
    L15:
        r17 = null;
        goto L16
    L5:
        r14 = false;
        goto L6
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        setMeasuredDimension(this.f22501o, getMeasuredHeight());
    }

    @Override // android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        super.onSizeChanged(r5, r10, r11, r12);
        c(null);
        if (this.f22499m == true) goto L6;
        this.f22499m = true;
        int r13 = this.g;
        int r14 = this.f22494h;
        setY(((1 - ((float) this.f22500n)) * ((r13 - r14) - r10)) + r14);
    L6:
        if (getX() >= (this.f / 2)) goto L8;
        boolean r15 = true;
    L9:
        this.f22495i = r15;
        if (r15 == false) goto L13;
        setX(0.0f);
        return;
    L13:
        b r16 = this.e;
        if (r16 == null) goto L16;
        r16.f22487a.removeCallbacks(r16);
    L16:
        d(this, false, 1);
        return;
    L8:
        r15 = false;
        goto L9
    }

    public final void setAutoToEdge(boolean r5) {
        this.f22498l = r5;
    }

    public final void setFirstPos(double r5) {
        this.f22500n = r5;
    }

    public final void setRealWidth(int r5) {
        this.f22501o = r5;
        post(new com.obric.oui.lisitem.a(this, 28));
    }

    @Override // android.view.View
    public void setVisibility(int r5) {
        super.setVisibility(0);
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        getChildAt(r11).setVisibility(0);
        r11 = r11 + 1;
        goto L3
    }
}
