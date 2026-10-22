package com.obric.oui.segmentedtab;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import java.util.Objects;
import kotlin.f0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends RelativeLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0298a f11360i = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f11361f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ValueAnimator f11362g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ValueAnimator f11363h;

    /* JADX INFO: renamed from: com.obric.oui.segmentedtab.a$a, reason: collision with other inner class name */
    public static final class C0298a {
        private C0298a() {
        }

        public /* synthetic */ C0298a(g r1) {
            this();
        }

        public final float a(float r2) {
            return 1 - (r2 * 0.5f);
        }
    }

    static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f11364a;

        b(a r1) {
            this.f11364a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            o.f(r3, "animator");
            a r0 = this.f11364a;
            Object r4 = r3.getAnimatedValue();
            Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Float");
            a.b(r0, ((Float) r4).floatValue());
            a r2 = this.f11364a;
            r2.d(a.a(r2), "press_anim");
        }
    }

    static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f11365a;

        c(a r1) {
            this.f11365a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r3) {
            o.f(r3, "animator");
            a r0 = this.f11365a;
            Object r4 = r3.getAnimatedValue();
            Objects.requireNonNull(r4, "null cannot be cast to non-null type kotlin.Float");
            a.b(r0, ((Float) r4).floatValue());
            a r2 = this.f11365a;
            r2.d(a.a(r2), "release_anim");
        }
    }

    static {
        f11360i = new C0298a(null);
    }

    public a(Context r7, AttributeSet r8) {
        this(r7, r8, 0, 4, null);
    }

    public a(Context r2, AttributeSet r3, int r4) {
        o.f(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ a(Context r1, AttributeSet r2, int r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public static final /* synthetic */ float a(a r0) {
        return r0.f11361f;
    }

    public static final /* synthetic */ void b(a r0, float r1) {
        r0.f11361f = r1;
    }

    private final void e() {
        if (c() == true) goto L5;
        return;
    L5:
        ValueAnimator r0 = this.f11363h;
        if (r0 == null) goto L8;
        r0.removeAllUpdateListeners();
    L8:
        ValueAnimator r1 = this.f11363h;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        ValueAnimator r2 = this.f11362g;
        if (r2 == null) goto L14;
        r2.cancel();
    L14:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{this.f11361f, 1.0f});
        r3.setDuration(50);
        r3.setInterpolator(new DecelerateInterpolator());
        r3.addUpdateListener(new b(this));
        f0 r4 = f0.f18324a;
        r3.start();
        this.f11362g = r3;
    }

    private final void f() {
        if (c() == true) goto L5;
        return;
    L5:
        ValueAnimator r0 = this.f11362g;
        if (r0 == null) goto L8;
        r0.removeAllUpdateListeners();
    L8:
        ValueAnimator r1 = this.f11362g;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        ValueAnimator r2 = this.f11363h;
        if (r2 == null) goto L14;
        r2.cancel();
    L14:
        ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{this.f11361f, 0.0f});
        r3.setDuration(200);
        r3.setInterpolator(new DecelerateInterpolator());
        r3.addUpdateListener(new c(this));
        f0 r4 = f0.f18324a;
        r3.start();
        this.f11363h = r3;
    }

    public abstract boolean c();

    public abstract void d(float r1, String r2);

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        o.f(r3, NotificationCompat.CATEGORY_EVENT);
        int r0 = r3.getAction();
        if (r0 != 0) goto L5;
        e();
    L12:
        return super.dispatchTouchEvent(r3);
    L5:
        if (r0 != 1) goto L7;
    L9:
        f();
        goto L12
    L7:
        if (r0 == 3) goto L9;
        goto L9
    }
}
