package u;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.Choreographer;
import com.airbnb.lottie.h;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public final class c extends ValueAnimator implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArraySet f22182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet f22183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f22184c;
    public boolean d;
    public long e;
    public float f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f22185h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f22186i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h f22187j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f22188k;

    public c() {
        this.f22182a = new CopyOnWriteArraySet();
        this.f22183b = new CopyOnWriteArraySet();
        this.f22184c = 1.0f;
        this.d = false;
        this.e = 0;
        this.f = 0.0f;
        this.g = 0;
        this.f22185h = -2.1474836E9f;
        this.f22186i = 2.1474836E9f;
        this.f22188k = false;
    }

    public final float a() {
        h r5 = this.f22187j;
        if (r5 != null) goto L6;
        return 0.0f;
    L6:
        float r10 = this.f;
        float r11 = r5.f1266k;
        return (r10 - r11) / (r5.f1267l - r11);
    }

    @Override // android.animation.Animator
    public final void addListener(Animator.AnimatorListener r5) {
        this.f22183b.add(r5);
    }

    @Override // android.animation.ValueAnimator
    public final void addUpdateListener(ValueAnimator.AnimatorUpdateListener r5) {
        this.f22182a.add(r5);
    }

    public final float b() {
        h r5 = this.f22187j;
        if (r5 != null) goto L6;
        return 0.0f;
    L6:
        float r10 = this.f22186i;
        if (r10 == 2.1474836E9f) goto L9;
        return r10;
    L9:
        return r5.f1267l;
    }

    public final float c() {
        h r5 = this.f22187j;
        if (r5 != null) goto L6;
        return 0.0f;
    L6:
        float r10 = this.f22185h;
        if (r10 == (-2.1474836E9f)) goto L9;
        return r10;
    L9:
        return r5.f1266k;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        Iterator r5 = this.f22183b.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((Animator.AnimatorListener) r5.next()).onAnimationCancel(this);
        goto L4
    L6:
        f(true);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r10) {
        boolean r5 = false;
        if (this.f22188k == false) goto L5;
        f(false);
        Choreographer.getInstance().postFrameCallback(this);
    L5:
        h r11 = this.f22187j;
        if (r11 != null) goto L8;
        return;
    L8:
        if (this.f22188k == false) goto L67;
        long r12 = this.e;
        long r13 = 0;
        if (r12 == 0) goto L14;
        r13 = r10 - r12;
    L14:
        float r14 = r13 / ((1.0E9f / r11.f1268m) / Math.abs(this.f22184c));
        float r15 = this.f;
        if (e() == false) goto L17;
        r14 = -r14;
    L17:
        float r16 = r15 + r14;
        this.f = r16;
        float r17 = c();
        float r18 = b();
        PointF r19 = e.f22190a;
        if (r16 >= r17) goto L20;
    L22:
        this.f = e.b(this.f, c(), b());
        this.e = r10;
        Iterator r20 = this.f22182a.iterator();
    L24:
        if (r20.hasNext() == false) goto L26;
        ((ValueAnimator.AnimatorUpdateListener) r20.next()).onAnimationUpdate(this);
        goto L24
    L26:
        if (r5 == true) goto L53;
        int r21 = getRepeatCount();
        CopyOnWriteArraySet r22 = this.f22183b;
        if (r21 != (-1)) goto L30;
    L39:
        Iterator r23 = r22.iterator();
    L41:
        if (r23.hasNext() == false) goto L43;
        ((Animator.AnimatorListener) r23.next()).onAnimationRepeat(this);
        goto L41
    L43:
        this.g++;
        if (getRepeatMode() != 2) goto L47;
        this.d = !this.d;
        this.f22184c = -this.f22184c;
    L51:
        this.e = r10;
        goto L53
    L47:
        if (e() == false) goto L49;
        float r24 = b();
    L50:
        this.f = r24;
        goto L51
    L49:
        r24 = c();
        goto L50
    L30:
        if (this.g < getRepeatCount()) goto L39;
        if (this.f22184c >= 0.0f) goto L34;
        float r25 = c();
    L35:
        this.f = r25;
        f(true);
        boolean r26 = e();
        Iterator r27 = r22.iterator();
    L37:
        if (r27.hasNext() == false) goto L53;
        ((Animator.AnimatorListener) r27.next()).onAnimationEnd(this, r26);
        goto L37
    L34:
        r25 = b();
    L53:
        if (this.f22187j == null) goto L59;
        float r28 = this.f;
        if (r28 < this.f22185h) goto L62;
        if (r28 <= this.f22186i) goto L59;
    L62:
        throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.f22185h), Float.valueOf(this.f22186i), Float.valueOf(this.f)}));
    L59:
        com.airbnb.lottie.c.a();
        return;
    L20:
        if (r16 > r18) goto L22;
        r5 = true;
        goto L22
    }

    public final boolean e() {
        if (this.f22184c >= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public final void f(boolean r5) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (r5 == false) goto L6;
        this.f22188k = false;
        return;
    }

    public final void g(float r5) {
        if (this.f != r5) goto L5;
        return;
    L5:
        this.f = e.b(r5, c(), b());
        this.e = 0;
        Iterator r10 = this.f22182a.iterator();
    L7:
        if (r10.hasNext() == false) goto L9;
        ((ValueAnimator.AnimatorUpdateListener) r10.next()).onAnimationUpdate(this);
        goto L7
    }

    @Override // android.animation.ValueAnimator
    public final float getAnimatedFraction() {
        if (this.f22187j != null) goto L7;
        return 0.0f;
    L7:
        if (e() == false) goto L11;
        float r5 = b() - this.f;
        float r10 = b();
        float r11 = c();
    L10:
        return r5 / (r10 - r11);
    L11:
        r5 = this.f - c();
        r10 = b();
        r11 = c();
        goto L10
    }

    @Override // android.animation.ValueAnimator
    public final Object getAnimatedValue() {
        return Float.valueOf(a());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getDuration() {
        h r5 = this.f22187j;
        if (r5 != null) goto L6;
        return 0;
    L6:
        return (long) r5.b();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    public final void h(float r5, float r10) {
        if (r5 > r10) goto L14;
        h r11 = this.f22187j;
        if (r11 != null) goto L7;
        float r12 = -3.4028235E38f;
    L8:
        if (r11 != null) goto L10;
        float r13 = Float.MAX_VALUE;
    L11:
        this.f22185h = e.b(r5, r12, r13);
        this.f22186i = e.b(r10, r12, r13);
        g((int) e.b(this.f, r5, r10));
        return;
    L10:
        r13 = r11.f1267l;
        goto L11
    L7:
        r12 = r11.f1266k;
        goto L8
    L14:
        throw new IllegalArgumentException("minFrame (" + r5 + ") must be <= maxFrame (" + r10 + ")");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final boolean isRunning() {
        return this.f22188k;
    }

    @Override // android.animation.Animator
    public final void removeAllListeners() {
        this.f22183b.clear();
    }

    @Override // android.animation.ValueAnimator
    public final void removeAllUpdateListeners() {
        this.f22182a.clear();
    }

    @Override // android.animation.Animator
    public final void removeListener(Animator.AnimatorListener r5) {
        this.f22183b.remove(r5);
    }

    @Override // android.animation.ValueAnimator
    public final void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r5) {
        this.f22182a.remove(r5);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final /* bridge */ /* synthetic */ Animator setDuration(long r5) {
        setDuration(r5);
        throw null;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setInterpolator(TimeInterpolator r5) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public final void setRepeatMode(int r5) {
        super.setRepeatMode(r5);
        if (r5 != 2) goto L5;
        return;
    L5:
        if (this.d == false) goto L9;
        this.d = false;
        this.f22184c = -this.f22184c;
        return;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setStartDelay(long r5) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final ValueAnimator setDuration(long r5) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
